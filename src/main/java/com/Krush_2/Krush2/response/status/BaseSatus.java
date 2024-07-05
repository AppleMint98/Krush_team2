package com.Krush_2.Krush2.response.status;

import org.springframework.http.HttpStatus;

public interface BaseSatus {
    HttpStatus getStatus();
    String getMessage();
}
