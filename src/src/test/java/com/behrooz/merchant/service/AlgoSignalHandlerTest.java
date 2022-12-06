package com.behrooz.merchant.service;

import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@DisplayName("AlgoSignalHandler Test")
public class AlgoSignalHandlerTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private AlgoSignalHandler handler;

    @Test
    public void handleSignal_SignalCode1_CalledAlgoAppropriately() {
        //Arrange
        int signal = 1;
        doNothing().when(algo).setUp();
        doNothing().when(algo).setAlgoParam(isA(Integer.class), isA(Integer.class));
        doNothing().when(algo).performCalc();
        doNothing().when(algo).submitToMarket();
        doNothing().when(algo).doAlgo();

        //Act
        handler.handleSignal(signal);

        //Assert
        verify(algo, times(1)).setUp();
        verify(algo, times(1)).setAlgoParam(isA(Integer.class), isA(Integer.class));
        verify(algo, times(1)).performCalc();
        verify(algo, times(1)).submitToMarket();
        doNothing().when(algo).doAlgo();
    }
}
