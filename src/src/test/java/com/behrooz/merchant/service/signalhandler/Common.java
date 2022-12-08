package com.behrooz.merchant.service.signalhandler;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Common {

    public static void Class_decoratedByCorrectComponentValue(Class<?> type, String value) {
        //Arrange

        //Act
        var annotation = type.getAnnotation(Component.class);

        //Assert
        assertEquals(value, annotation.value());
    }
}
