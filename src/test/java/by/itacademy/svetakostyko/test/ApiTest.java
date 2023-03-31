package by.itacademy.svetakostyko.test;

import org.junit.Test;

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
