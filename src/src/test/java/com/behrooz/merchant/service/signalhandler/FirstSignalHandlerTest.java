package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.service.signalhandler.components.FirstSignalHandler;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import static org.mockito.Mockito.*;

@Component("signal-processor-1")

public class FirstSignalHandlerTest {
    @Mock
    private Algo algo;

    @InjectMocks
    private FirstSignalHandler signalHandler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).doAlgo();
    }

    @Test
    public void handleSignal_WhenCall_CalledAlgoAppropriately() {
        //Arrange
        var param = Pair.of(1, 60);

        //Act
        signalHandler.handleSignal();

        //Assert
        verify(algo, times(1)).setAlgoParam(param.getFirst(), param.getSecond());
        verify(algo, times(1)).setUp();
        verify(algo, times(1)).performCalc();
        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).doAlgo();

        verify(algo, times(0)).cancelTrades();
        verify(algo, times(0)).reverse();
    }

    @Test
    public void Handler_decoratedByCorrectComponentValue() {
        //Arrange
        var value = "signal-processor-1";
        //Act
        //Assert
        Common.Class_decoratedByCorrectComponentValue(FirstSignalHandlerTest.class, value);
    }
}
