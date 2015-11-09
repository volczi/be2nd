package com.volczi.be2nd.fileUploader;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import com.volczi.be2nd.forum.Message;
import com.volczi.be2nd.forum.Topic;

public class BlobHandlerServiceImpl implements BlobHandlerService{
	private UserService userService = UserServiceFactory.getUserService();
	
	static {
		ObjectifyService.register(Image.class);
	}

	@Override
	public Image createEntity(BlobKey key) {
		Image image = new Image();
		image.setCreatedAt(new Date());
		image.setBlobKey(key.getKeyString());
		if (userService.isUserLoggedIn() && userService.getCurrentUser()!=null){
			image.setAuthor(userService.getCurrentUser().getEmail());
		}
		else {
			image.setAuthor("volczi");
		}

		ofy().save().entity(image).now();
		return image;
		
	}

	@Override
	public List<Image> getImages() {
		int limit=20;
		Query<Image> query = ofy().load().type(Image.class)
				.order("-" + Image.CREATED_AT)
				.limit(limit);

		Date minDate=null;
		Date maxDate=null;
		
		if (minDate != null) {
			// the query is immutable the assignment is important
			query = query.filter(Image.CREATED_AT + " >", minDate);
		}
		if (maxDate != null) {
			query = query.filter(Image.CREATED_AT + " <", maxDate);
		}

		List<Image> messages = query.list();
		return messages;
	}

}
