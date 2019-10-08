package in.rbaskets.controllers.basket;

import in.rbaskets.models.AccessToken;
import in.rbaskets.models.BasketModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class BasketCommand {
    private RequestSpecification requestSpecification;

    private String id;

    public BasketCommand(String id) {

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://rbaskets.in/")
                .setBasePath("/api/baskets/" + id)
                .setContentType(ContentType.JSON)
                //.log(LogDetail.ALL)
                .build();
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                //.expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(15000L))
                .build();
        RestAssured.defaultParser = Parser.JSON;
        this.id = id;
    }

    public AccessToken createBasket(BasketModel basket) {
        Response response = given(requestSpecification)
                .body(basket)
                .post();
        Assert.assertEquals(response.getStatusCode(), 201);
        return response.as(AccessToken.class);

    }

    public BasketModel getBasket(String token) {
        return given(requestSpecification)
                .header("Authorization", token)
                .get().as(BasketModel.class);
    }


    public String updateBasket(String token, BasketModel basket) {
        return given(requestSpecification)
                .header("Authorization", token)
                .body(basket)
                .put().then().statusCode(204).extract().asString();
    }

    public String deleteBasket(String token) {
        return given(requestSpecification)
                .header("Authorization", token)
                .delete().then().statusCode(204).extract().asString();
    }

    public String getDeletedBasket(String token) {
        return given(requestSpecification)
                .header("Authorization", token)
                .get().then().statusCode(404).extract().asString();
    }

}

