package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.DefaultSignalHandler;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DefaultSignalHandlerTest {
    @Mock
    private Algo algo;

    @InjectMocks
    private DefaultSignalHandler signalHandler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).doAlgo();
    }

    @Test
    public void handleSignal_WhenCall_CalledAlgoAppropriately() {
        //Arrange

        //Act
        signalHandler.handleSignal();

        //Assert
        verify(algo, times(1)).doAlgo();
        verify(algo, times(1)).cancelTrades();

        verify(algo, times(0)).setAlgoParam(anyInt(), anyInt());
        verify(algo, times(0)).performCalc();
        verify(algo, times(0)).submitToMarket();
        verify(algo, times(0)).setUp();
    }
}
