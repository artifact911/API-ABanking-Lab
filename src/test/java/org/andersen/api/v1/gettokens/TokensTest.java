package org.andersen.api.v1.gettokens;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.andersen.api.common.UserCred;
import org.andersen.api.entity.tokens.TokensResponse;
import org.andersen.api.utils.RequestSpecificationCreator;
import org.andersen.api.utils.TokenFarmer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.andersen.api.common.BaseUrl.BASE_HOST;
import static org.andersen.api.common.BaseUrl.GET_TOKEN_API;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Tag(GET_TOKEN_API)
public class TokensTest {

    private static RequestSpecification REQ_SPEC;

    @BeforeAll
    public static void setUp() {
        REQ_SPEC = RequestSpecificationCreator.getReqSpec(BASE_HOST, GET_TOKEN_API, ContentType.JSON);
    }

    @DisplayName("Получение токенов для юзеров")
    @ParameterizedTest(name = "Валидными именем {0} и паролем {1}")
    @MethodSource("getDifferentUsers")
    public void getTokenTest(String userName, String password) {

        TokensResponse rs = TokenFarmer.getUserToken(userName, password, REQ_SPEC);

        assertAll(
                () -> assertNotNull(rs.getAccessToken(), "AccessToken is null"),
                () -> assertNotNull(rs.getRefreshToken(), "RefreshToken is null")
        );
    }

    private static Stream<Arguments> getDifferentUsers() {
        return Stream.of(
                Arguments.of(UserCred.KIRILL.userName, UserCred.KIRILL.password),
                Arguments.of(UserCred.MAKSIM.userName, UserCred.MAKSIM.password)
        );
    }
}
