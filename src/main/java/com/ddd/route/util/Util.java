package com.ddd.route.util;

import java.net.URI;

public class Util {

    public static final String base = "/route";

    public static URI createURI(String id) {
        return URI.create(base + '/' + id);
    }

}
