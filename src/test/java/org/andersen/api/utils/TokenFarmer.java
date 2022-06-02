package org.andersen.api.utils;

import io.qameta.allure.Step;
import io.restassured.specification.RequestSpecification;
import org.andersen.api.entity.tokens.TokensRequest;
import org.andersen.api.entity.tokens.TokensResponse;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class TokenFarmer {

    private TokenFarmer() {
    }

    @Step("Получение токенов для юзера с валидными именем {0} и паролем {1}")
    public static TokensResponse getUserToken(String userName, String password, RequestSpecification requestSpecification) {
        return given()
                .spec(requestSpecification)
                .body(new TokensRequest(userName, password))
                .when().post().then().statusCode(HTTP_OK)
                .and().extract().as(TokensResponse.class);
    }
}
