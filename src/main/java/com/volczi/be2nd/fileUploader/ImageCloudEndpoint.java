package com.volczi.be2nd.fileUploader;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.google.api.server.spi.ServiceException;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.AuthLevel;
import com.google.api.server.spi.config.DefaultValue;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.users.User;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.Query;
import com.volczi.be2nd.services.BlobHandlerService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Api(
		name = "image", 
		resource = "image", 
		version = "v1", 
		scopes = { Constants.EMAIL_SCOPE }, 
		clientIds = {
			// the client id of the angular ui
				Constants.WEB_CLIENT_ID,
			// the client id of the api explorer
			com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID
		}, 
		description = "Api to manage images.",
		authLevel = AuthLevel.REQUIRED)
public class ImageCloudEndpoint {
//    private BlobHandlerService blobHandlerService;
    
    
//  constructor based injector
//    @Inject
//    public ImageCloudEndpoint(BlobHandlerService blobHandlerService) {
//        this.blobHandlerService = blobHandlerService;
//    }
    
//    //setter method injector
//    @Inject
//    public void setService(BlobHandlerService svc) {
//        this.blobHandlerService=svc;
//    }
	
	
    Injector injector = Guice.createInjector(new AppInjector());        
    
    BlobHandlerService blobHandlerService = injector.getInstance(BlobHandlerService.class);

	/**
	 * You need to register the entity classes before you use them.
	 */
	static {
		ObjectifyService.register(Image.class);
	}


	@ApiMethod(path="image")
	public List<Image> getImages(
			@Nullable @Named("limit") @DefaultValue("10") int limit,
			@Nullable @Named("minDate") Date minDate,
			@Nullable @Named("maxDate") Date maxDate)
					throws ServiceException {
	return blobHandlerService.getImages(limit, minDate, maxDate);
//		return null;
	}

	@ApiMethod(path="image/{blobKey}")
	public void createImage(
			@Named("blobKey") String blobKey,
			User user) throws ServiceException {

		log.info("blobKey: " + blobKey + " user: " + user);
		blobHandlerService.createEntity(new BlobKey(blobKey));
	}

}
