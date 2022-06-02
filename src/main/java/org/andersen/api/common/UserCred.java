package org.andersen.api.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum UserCred {

    KIRILL("kirill", "kirillqwerty"),
    MAKSIM("maksim", "maksimqwerty");

    public final String userName;
    public final String password;
}
