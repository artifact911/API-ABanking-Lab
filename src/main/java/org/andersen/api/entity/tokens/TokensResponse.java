package org.andersen.api.entity.tokens;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class TokensResponse {

    private String accessToken;
    private String refreshToken;
}
