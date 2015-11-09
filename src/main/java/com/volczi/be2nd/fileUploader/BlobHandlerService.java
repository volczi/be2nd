package com.volczi.be2nd.fileUploader;

import java.util.List;

import com.google.appengine.api.blobstore.BlobKey;

public interface BlobHandlerService {
	
	Image createEntity(BlobKey key);
	
	List<Image> getImages();
}
