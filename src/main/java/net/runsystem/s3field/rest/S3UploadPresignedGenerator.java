package net.runsystem.s3field.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/message")
public class S3UploadPresignedGenerator {
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getMessage(@QueryParam("key") String key)
    {
        if(key!=null)
            return Response.ok(new MyRestResourceModel(key, getMessageFromKey(key))).build();
        else
            return Response.ok(new MyRestResourceModel("default","Hello World")).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("/{key}")
    public Response getMessageFromPath(@PathParam("key") String key)
    {
        return Response.ok(new MyRestResourceModel(key, getMessageFromKey(key))).build();
    }

    private String getMessageFromKey(String key) {
        // In reality, this data would come from a database or some component
        // within the hosting application, for demonstration purpopses I will
        // just return the key
        return key;
    }
}
