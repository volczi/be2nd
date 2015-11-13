package com.volczi.be2nd.fileUploader;

import java.util.Date;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import lombok.Data;



@Data
@Cache
@Entity
public class Image {

	/**
	 * The name of the indexed field {@link #createdAt}.<br/>
	 * Fields like this are useful when you construct queries.
	 */
	public static final String CREATED_AT = "createdAt";
	
	/**
	 * Datastore generated identifier.
	 */
	@Id
	private Long id;

	@Index
	private Date createdAt;
	private String author;
	private String content;
	private String blobKey;
	private String url;

}