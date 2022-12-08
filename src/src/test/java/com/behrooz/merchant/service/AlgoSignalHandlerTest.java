package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.BaseSignalHandler;
import com.behrooz.merchant.service.signalhandler.SignalHandlerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("AlgoSignalHandler Test")
public class AlgoSignalHandlerTest {

    @Mock
    private SignalHandlerFactory signalHandlerFactory;

    @InjectMocks
    private AlgoSignalHandler algoSignalHandler;

    BaseSignalHandler handler;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);

        handler = Mockito.mock(BaseSignalHandler.class);

        Mockito
                .when(signalHandlerFactory.GetHandler(anyInt()))
                .thenReturn(handler);
    }

    @Test
    public void handleSignal_Signal_GetHandlerAndCallIt() {
        //Arrange
        var signal = anyInt();
        //Act
        algoSignalHandler.handleSignal(signal);

        //Assert
        verify(signalHandlerFactory, times(1)).GetHandler(anyInt());
        verify(signalHandlerFactory, times(1)).GetHandler(signal);
        verify(handler, times(1)).handleSignal();
    }
}
