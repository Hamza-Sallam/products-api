package com.company.products.web;


import com.company.products.adapters.SQLProductEntity;
import com.company.products.adapters.SQLProductRepository;
import com.company.products.core.entity.Product;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.inject.*;
import jakarta.ws.rs.core.*;

import java.util.Set;
import java.util.stream.Collectors;


@Path("/api/products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ProductResource{

    @Inject
    SQLProductRepository repository;
    @Inject
    Validator validator;

    @GET
    public Response getAllProducts(@QueryParam("page") int page, @QueryParam("size") int size) {
        if (page < 0 || size < 1) {
             return Response.status(Response.Status.BAD_REQUEST).entity("Error: Page number and size must be greater than 0").build();
        }

        return Response.ok(repository.findAll(page,size)).build();
    }

    @GET
    @Path("/{id}")
    public Response getProduct(@PathParam("id") Long id) {
        Product product =repository.findById(id);
        if (product == null) {return Response.status(Response.Status.NOT_FOUND).entity("Error: Product with id " + id + " doesnt exist").build();}
        return Response.ok(product).build();
    }

    @POST
    @Transactional
    public Response createProduct(Product product) {
        try{
            Set<ConstraintViolation<Product>> validate = validator.validate(product);
            if(validate.isEmpty()){
            Product new_product=repository.create(product);
            return Response.status(Response.Status.CREATED).entity(new_product).build();
        }
            String violations = validate.stream().map(violation -> violation.getMessage()).collect(Collectors.joining("\n "));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error creating a product: \n"+e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateProduct(@PathParam("id") Long id, Product product) {
        SQLProductEntity existedproduct = (SQLProductEntity) repository.findById(id);
        if (existedproduct == null) {return Response.status(Response.Status.NOT_FOUND).entity("Error: Product with id " + id + " doesnt exist").build();}
        try {
            Set<ConstraintViolation<Product>> validate = validator.validate(product);
            if (validate.isEmpty()) {
                existedproduct.setName(product.getName());
                existedproduct.setDescription(product.getDescription());
                existedproduct.setPrice(product.getPrice());
                existedproduct.setImage(product.getImage());
                return Response.ok(existedproduct).entity("Product Updated Successfully").build();
            }
            String violations = validate.stream().map(violation -> violation.getMessage()).collect(Collectors.joining("\n "));
            return Response.status(Response.Status.BAD_REQUEST).entity(violations).build();

        }
        catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Error Updating the  product:\n"+e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteProduct(@PathParam("id") Long id) {
        Product product = repository.findById(id);
        boolean deleted = repository.deleteById(id);
        if (!deleted) {return Response.status(Response.Status.NOT_FOUND).entity("Error: Product with id " + id + " doesnt exist").build();}

        try {
            return Response.ok().entity("'"+product.getName() + "' Product with id " + id + "  Deleted Successfully").build();
        }
        catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error Deleting the  product: \n"+e.getMessage()).build();
        }
    }

}