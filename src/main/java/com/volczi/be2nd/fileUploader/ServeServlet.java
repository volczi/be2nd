package com.volczi.be2nd.fileUploader;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class ServeServlet extends HttpServlet {
    private BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    private BlobHandlerService blobHandlerService = new BlobHandlerServiceImpl();
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
        throws IOException {
            BlobKey blobKey = new BlobKey(req.getParameter("blob-key"));
            blobstoreService.serve(blobKey, res);
        }
}