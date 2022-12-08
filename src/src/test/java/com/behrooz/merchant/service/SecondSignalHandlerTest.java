package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.SecondSignalHandler;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import static org.mockito.Mockito.*;

public class SecondSignalHandlerTest {
    @Mock
    private Algo algo;

    @InjectMocks
    private SecondSignalHandler signalHandler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).doAlgo();
    }

    @Test
    public void handleSignal_WhenCall_CalledAlgoAppropriately() {
        //Arrange
        var param = Pair.of(1, 80);

        //Act
        signalHandler.handleSignal();

        //Assert
        verify(algo, times(1)).setAlgoParam(anyInt(), anyInt());
        verify(algo, times(1)).setAlgoParam(param.getFirst(), param.getSecond());
        verify(algo, times(1)).reverse();
        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).doAlgo();

        verify(algo, times(0)).setUp();
        verify(algo, times(0)).performCalc();
        verify(algo, times(0)).cancelTrades();
    }
}
