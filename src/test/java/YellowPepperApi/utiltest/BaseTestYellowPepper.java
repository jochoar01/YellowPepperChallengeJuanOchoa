package YellowPepperApi.utiltest;

import YellowPepperApi.model.Pet;
import YellowPepperApi.testcases.TestPet;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class BaseTestYellowPepper {
    public static Logger log = LogManager.getLogger(TestPet.class);
    protected static Response response;
    protected static final String url = "http://localhost:8080/api/v3";

    public static Response getApi() {
        response = given().get(url + "/");
        return response;
    }

    public static Response getApi(String api) {
        String test = url + "/" + api;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(url + "/" + api)
                .then()
                .extract().response();


        return response;
    }

    public static Response deleteApi(String api) {
        String test = url + "/" + api;
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .delete(url + "/" + api)
                .then()
                .extract().response();

        return response;

    }


    public static Response postApi(Pet pet, String api) {

        response = given()
                .header("Content-type", "application/json")
                .body(pet)
                .when()
                .post(api);

        return response;


    }

    public static Response putApi(Pet pet, String api) {
        response = given()
                .header("Content-type", "application/json")
                .body(pet)
                .when()
                .put(api);


        return response;
    }

    @BeforeMethod
    public static void cleaner() {

        RestAssured.baseURI = url;
    }


}
