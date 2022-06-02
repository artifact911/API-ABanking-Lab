package org.andersen.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationCreator {

    private RequestSpecificationCreator() {
    }

    public static RequestSpecification getReqSpec(String host, String path, ContentType contentType) {
        return new RequestSpecBuilder()
                .setBaseUri(host)
                .setBasePath(path)
                .setContentType(contentType)
                .build();
    }
}
