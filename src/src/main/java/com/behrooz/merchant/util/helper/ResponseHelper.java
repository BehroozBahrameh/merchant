package com.behrooz.merchant.util.helper;


import com.behrooz.merchant.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The type Response helper.
 */
public class ResponseHelper {

    /**
     * Response response entity.
     *
     * @param <T> the type parameter
     * @param t   the t
     * @return the response entity
     */
    public static <T> ResponseEntity response(T t) {
        return response(t, "OK", HttpStatus.OK);
    }

    /**
     * Response response entity.
     *
     * @param <T>    the type parameter
     * @param t      the t
     * @param status the status
     * @return the response entity
     */
    public static <T> ResponseEntity response(T t, HttpStatus status) {
        return response(t, "OK", status);
    }

    /**
     * Response response entity.
     *
     * @param <T>    the type parameter
     * @param t      the t
     * @param msg    the msg
     * @param status the status
     * @return the response entity
     */
    public static <T> ResponseEntity response(T t, String msg, HttpStatus status) {
        return new ResponseEntity(new ResponseStructure(t, msg), status);
    }
}
