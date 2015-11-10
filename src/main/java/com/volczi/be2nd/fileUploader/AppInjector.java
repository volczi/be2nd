package com.volczi.be2nd.fileUploader;


import com.google.inject.AbstractModule;
import com.volczi.be2nd.services.BlobHandlerService;
import com.volczi.be2nd.services.BlobHandlerServiceImpl;

 
public class AppInjector extends AbstractModule {
 
    @Override
    protected void configure() {
        //bind the service to implementation class
        //bind(MessageService.class).to(EmailService.class);
         
        //bind MessageService to Facebook Message implementation
        bind(BlobHandlerService.class).to(BlobHandlerServiceImpl.class);
         
    }
 
}