package by.itacademy.svetakostyko.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

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
    public void testLoginWithcorrectData() {
        given()
                .contentType("multipart/form-data")
                .multiPart("info[login]", "123tfh123@mail.ru")
                .multiPart("info[pass]", "bh123bh")
                .when()
                .post()
                .then()
                .statusCode(200);
    }
//    @Test
//    public void testPostStudentWithSpacesInFirstName() {
//        JSONObject request = new JSONObject();
//        request.put("sendform", "auth");
//        request.put("info[login]", "123tfh123@mail.ru");
//        request.put("info[pass]", "bh123bh");
//        given()
//                .contentType(ContentType.JSON)
//                .accept(ContentType.JSON)
//                .body(request.toString())
//                .when()
//                .post(String.valueOf(request))
//                .then().log().body()
//                .assertThat()
//                .statusCode(200)
//                .log().body();
//    }
}
