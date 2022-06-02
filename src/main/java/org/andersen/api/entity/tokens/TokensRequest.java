package org.andersen.api.entity.tokens;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokensRequest {

    private String username;
    private String password;
}
