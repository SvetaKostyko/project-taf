package by.itacademy.svetakostyko.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ApiTest {

    @Test
    @DisplayName("Получение ответа 200 от запроса Get")
    public void testGetRequest() {
        String URL = "https://belbazar24.by/";
        when()
                .get(URL)
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
                .get("https://belbazar24.by/")
                .then()
                .statusCode(200);
    }
    @Test
    @DisplayName("Поиск товара")
    public void testSearch() {
        String response = given()
                .param("search", "%D0%9A%D0%BE%D1%81%D1%82%D1%8E%D0%BC%D1%8B")
                .get("https://belbazar24.by/women/")
                .then()
                .statusCode(200)
                .extract().asString();
        System.out.println(response);
        Assertions.assertTrue(response.contains("Костюмы"));
    }
}
