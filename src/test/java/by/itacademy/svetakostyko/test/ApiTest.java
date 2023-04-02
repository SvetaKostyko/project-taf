package by.itacademy.svetakostyko.test;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class ApiTest {

    @Test
    public void testGetRequest() {
        String URL = "https://belbazar24.by/";
        when()
                .get(URL)
                .then()
                .statusCode(200);
    }
}
