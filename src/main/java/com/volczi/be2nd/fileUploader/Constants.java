package com.volczi.be2nd.fileUploader;

/**
 * Contains the client IDs and scopes for allowed clients consuming the APIs.
 */
public class Constants {

	/**
	 * Google uses this client id to identify which application asks for a permission.<br/> 
	 * You can ask for different kind of user permissions like know their identity or edit their calendar. These are called scopes.<br/> 
	 * The users have to approve this request before the application gets access to the selected scopes.
	 */
	public static final String WEB_CLIENT_ID = "144866556401-f386rpsq941dee2kd5q00d406l7k164k.apps.googleusercontent.com";

	/**
	 * This scope lets the application see the email address of the user.
	 */
	public static final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo.email";
}
