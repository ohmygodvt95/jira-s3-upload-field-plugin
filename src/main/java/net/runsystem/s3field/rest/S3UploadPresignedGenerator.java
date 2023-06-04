package net.runsystem.s3field.rest;

import net.runsystem.s3field.PresignedUrlGenerator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/upload-presigned-url")
public class S3UploadPresignedGenerator {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getUploadPresignedUrl()
    {
        String url = new PresignedUrlGenerator().generatePresignedUrl("a", "b");
        System.out.println(url);
        return Response.ok(new MyRestResourceModel("default","Hello World")).build();
    }
}
