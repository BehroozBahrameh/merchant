package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.*;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SignalHandlerFactoryTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private SignalHandlerFactory factory;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @ParameterizedTest
    @MethodSource("signalProvider")
    public void getHandler_ValidSignal_ReturnASignalHandler(Pair<Integer, Class<?>> pair) {
        //Arrange
        var signal = pair.getFirst();
        var type = pair.getSecond();

        //Act
        var handler = factory.GetHandler(signal);

        //Assert
        assertEquals(type, handler.getClass());
    }

    static Stream<Pair<Integer, Class<?>>> signalProvider() {
        return Stream.of(
                Pair.of(1, FirstSignalHandler.class),
                Pair.of(2, SecondSignalHandler.class),
                Pair.of(3, ThirdSignalHandler.class),
                Pair.of(4, DefaultSignalHandler.class)
        );
    }

}
