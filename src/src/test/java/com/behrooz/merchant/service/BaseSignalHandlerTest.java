package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.components.BaseSignalHandler;
import com.behrooz.merchant.tradingalgo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BaseSignalHandlerTest {

    @Mock
    private Algo algo;

    @InjectMocks
    private BaseSignalHandler baseSignalHandler = Mockito.mock(BaseSignalHandler.class, Mockito.CALLS_REAL_METHODS);

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        doNothing().when(algo).doAlgo();
    }

    @Test
    public void commit_WhenCall_CallDoAlgo() {
        //Arrange
        //Act
        baseSignalHandler.commit();

        //Assert
        verify(algo, times(1)).doAlgo();
    }

    @Test
    public void handleSignal_WhenCall_CallDoAlgo() {
        //Arrange
        //Act
        baseSignalHandler.handleSignal();

        //Assert
        verify(algo, times(1)).doAlgo();
    }
}
