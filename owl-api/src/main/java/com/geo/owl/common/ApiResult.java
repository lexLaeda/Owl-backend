package com.geo.owl.common;

import lombok.Data;

@Data
public class ApiResult<T> {
    private T result;
    private boolean hasError;
    private String errorMsg;
}
