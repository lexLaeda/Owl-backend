package com.geo.owl.common;

import com.geo.owl.common.exception.OwlBackendException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.function.Supplier;

@Slf4j
@Data
public class ApiProxy {

    private static final String OWL_EXCEPTION_MSG = "";
    private static final String UNKNOWN_EXCEPTION_MSG = "";

    public <T> ApiResult<T> proceed(Supplier<T> service) {
        val apiResult = new ApiResult<T>();
        try {
            val result = service.get();
            apiResult.setResult(result);
        } catch (Throwable t) {
            proceedException(apiResult, t);
        }
        return apiResult;
    }

    private <T> void proceedException(ApiResult<T> apiResult, Throwable t) {
        apiResult.setHasError(true);
        if (t instanceof OwlBackendException) {
            apiResult.setErrorMsg(OWL_EXCEPTION_MSG + " " + t.getMessage());
        } else {
            apiResult.setErrorMsg(UNKNOWN_EXCEPTION_MSG + " " + t.getMessage());
        }
    }
}
