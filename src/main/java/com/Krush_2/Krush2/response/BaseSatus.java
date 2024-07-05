package com.Krush_2.Krush2.response;

import org.springframework.http.HttpStatus;

public interface BaseSatus {
    HttpStatus getStatus();
    String getMessage();
}
