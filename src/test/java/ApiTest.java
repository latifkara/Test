
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import org.testng.annotations.Test;
import org.testng.util.Strings;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class ApiTest {

    @Test
    public void userTest(){
        // Get request
        when().
                get("https://generator.swagger.io/api/gen/clients/ada")
                .then()
                .statusCode(200)
                .log();



    }
    // error request
    @Test
    public void getRequest(){
        when().
                get("https://generator.swagger.io/api/gen/clients/asdda")
                .then()
                .statusCode(200)
                .log();
    }
    // Another Get request
    @Test
    public void anotherGetRequest(){
        when().
                get("https://generator.swagger.io/api/gen/clients")
                .then()
                .statusCode(200)
                .assertThat();
    }

    // Post request
    @Test
    public void postUser(){
        String jsonData = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"string\",\n" +
                "    \"additionalProp2\": \"string\",\n" +
                "    \"additionalProp3\": \"string\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\",\n" +
                "    \"urlMatcher\": {}\n" +
                "  },\n" +
                "  \"usingFlattenSpec\": true,\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}";

        given().
                contentType(ContentType.JSON).
                body(jsonData).
                when().
                post("https://generator.swagger.io/api/gen/clients/java").
                then().
                statusCode(201).
                body("additionalProp1", equalTo("string"));

    }

}
