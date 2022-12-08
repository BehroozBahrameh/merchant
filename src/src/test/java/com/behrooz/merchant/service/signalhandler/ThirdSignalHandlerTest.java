package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.service.signalhandler.components.ThirdSignalHandler;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.util.Pair;

import static org.mockito.Mockito.*;

public class ThirdSignalHandlerTest {
    @Mock
    private Algo algo;

    @InjectMocks
    private ThirdSignalHandler signalHandler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).doAlgo();
    }

    @Test
    public void handleSignal_WhenCall_CalledAlgoAppropriately() {
        //Arrange
        var firstParam = Pair.of(1, 90);
        var secondParam = Pair.of(2, 15);

        //Act
        signalHandler.handleSignal();

        //Assert
        verify(algo, times(2)).setAlgoParam(anyInt(), anyInt());
        verify(algo, times(1)).setAlgoParam(firstParam.getFirst(), firstParam.getSecond());
        verify(algo, times(1)).setAlgoParam(secondParam.getFirst(), secondParam.getSecond());
        verify(algo, times(1)).performCalc();
        verify(algo, times(1)).submitToMarket();
        verify(algo, times(1)).doAlgo();

        verify(algo, times(0)).setUp();
        verify(algo, times(0)).cancelTrades();
    }
}
