package com.company.products;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
@Transactional
public class ProductResourceTest {



    @Test
    public void testGetAllProducts() {
        given()
                .when().get("/api/products?page=0&size=10")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(notNullValue());
    }
    @Test
    public void testFalseGetAllProducts() {
        given()
                .when().get("/api/products")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON)
                .body(notNullValue());
    }
    @Test
    public void testCreateProduct() {
        String newProductJson = "{ \"name\": \"Test Product\", \"description\": \"A test product\", \"price\": 9.99, \"image\": \"image.png\" }";

        given()
                .contentType(ContentType.JSON)
                .body(newProductJson)
                .when().post("/api/products")
                .then()
                .statusCode(201)
                .contentType(ContentType.JSON);

    }
    @Test
    public void testGetProductById() {
        long productId = 1L;
        given()
                .when().get("/api/products/" + productId)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(notNullValue());
    }



    @Test
    public void testUpdateProduct() {
        long productId = 1L;
        String updatedProductJson = "{ \"name\": \"Updated Product\", \"description\": \"An updated product\", \"price\": 19.99, \"image\": \"updated_image.png\" }";
        given()
                .contentType(ContentType.JSON)
                .body(updatedProductJson)
                .when().put("/api/products/" + productId)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }

    @Test
    @Transactional
    public void testDeleteProduct() {
        long productId = 1L;

        given()
                .when().delete("/api/products/" + productId)
                .then()
                .statusCode(200);
    }


    @Test
    public void testDeleteProduct2() {
        long productId = 204343L; // doesnt exist

        given()
                .when().delete("/api/products/" + productId)
                .then()
                .statusCode(404);
    }

    @Test
    public void testCreateProduct2() { //test the validation when creating the resource
        String newProductJson = "{ \"name\": \"\", \"description\": \"A test product\", \"price\": 9.999, \"image\": \"image.png\" }";

        given()
                .contentType(ContentType.JSON)
                .body(newProductJson)
                .when().post("/api/products")
                .then()
                .statusCode(400)
                .contentType(ContentType.JSON);

    }



}