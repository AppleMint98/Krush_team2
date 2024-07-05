package com.Krush_2.Krush2.exception.header;

import com.Krush_2.Krush2.response.status.BaseSatus;
import lombok.Getter;

@Getter
public class HeaderInvalidException extends HeaderBadRequestException {

    private final BaseSatus errorCode;

    public HeaderInvalidException(BaseSatus errorCode) {
        super(errorCode);
        this.errorCode = errorCode;
    }
}
