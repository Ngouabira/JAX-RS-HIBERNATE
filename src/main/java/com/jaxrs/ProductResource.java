package com.jaxrs;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductResource {


    ProductService productService = new ProductService();

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product create(Product product) {
        return productService.create(product);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> read() {
        return productService.read();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Product update(Product product) {
        return productService.update(product);
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") int id) {
         productService.delete(id);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product find(@PathParam("id") int id) {
        return productService.find(id);
    }
}
