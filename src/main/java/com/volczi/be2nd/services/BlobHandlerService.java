package com.volczi.be2nd.services;

import java.util.Date;
import java.util.List;

import com.google.appengine.api.blobstore.BlobKey;
import com.volczi.be2nd.fileUploader.Image;

public interface BlobHandlerService {
	
	Image createEntity(BlobKey key);
	
	List<Image> getImages(int limit, Date minDate, Date maxDate);
}
