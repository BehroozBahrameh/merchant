package com.behrooz.merchant.service;

import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import static org.mockito.Mockito.*;

@DisplayName("AlgoSignalHandler Test")
public class AlgoSignalHandlerTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private AlgoSignalHandler handler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).setUp();
        doNothing().when(algo).performCalc();
        doNothing().when(algo).submitToMarket();
        doNothing().when(algo).doAlgo();
    }

    @Test
    public void handleSignal_SignalCode1_CalledAlgoAppropriately() {
        //Arrange
        int signal = 1;
        var param = Pair.of(1, 60);
        doNothing().when(algo).setAlgoParam(param.getFirst(), param.getSecond());

        //Act
        handler.handleSignal(signal);

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
    public void handleSignal_SignalCode2_CalledAlgoAppropriately() {
        //Arrange
        int signal = 2;
        var param = Pair.of(1, 80);
        doNothing().when(algo).setAlgoParam(param.getFirst(), param.getSecond());

        //Act
        handler.handleSignal(signal);

        //Assert
        verify(algo, times(1)).setAlgoParam(param.getFirst(), param.getSecond());
        verify(algo, times(1)).reverse();
        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).doAlgo();

        verify(algo, times(0)).setUp();
        verify(algo, times(0)).performCalc();
        verify(algo, times(0)).cancelTrades();
    }

    @Test
    public void handleSignal_SignalCode3_CalledAlgoAppropriately() {
        //Arrange
        int signal = 3;
        var firstParam = Pair.of(1, 90);
        var secondParam = Pair.of(2, 15);

        doNothing().when(algo).setAlgoParam(firstParam.getFirst(), firstParam.getSecond());
        doNothing().when(algo).setAlgoParam(secondParam.getFirst(), secondParam.getSecond());

        //Act
        handler.handleSignal(signal);

        //Assert
        verify(algo, times(1)).setAlgoParam(firstParam.getFirst(), firstParam.getSecond());
        verify(algo, times(1)).setAlgoParam(secondParam.getFirst(), secondParam.getSecond());
        verify(algo, times(1)).performCalc();
        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).doAlgo();

        verify(algo, times(0)).setUp();
        verify(algo, times(0)).cancelTrades();
    }
}
