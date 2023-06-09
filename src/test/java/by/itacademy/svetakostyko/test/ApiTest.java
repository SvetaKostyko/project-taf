package by.itacademy.svetakostyko.test;

import by.itacademy.svetakostyko.api.ApiConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiTest {

    @Test
    @DisplayName("Получение ответа 200 от запроса Get")
    public void testGetRequest() {
        when()
                .get(ApiConfiguration.ENDPOINT_URL)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Вход с корректными данными")
    public void testLoginWithСorrectData() {
        given().contentType("multipart/form-data")
                .multiPart("sendform", "auth")
                .multiPart("info[login]", "123tfh123@mail.ru")
                .multiPart("info[pass]", "bh123bh")
                .get(ApiConfiguration.ENDPOINT_URL)
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Поиск товара")
    public void testSearch() {
        String response = given()
                .param("search", ApiConfiguration.CODE_OF_SEARCH)
                .get(ApiConfiguration.ENDPOINT_URL + "women/")
                .then()
                .statusCode(200)
                .extract().asString();
        Assertions.assertTrue(response.contains("Костюмы"));
    }
}
