package com.behrooz.merchant.service;

import com.behrooz.merchant.service.signalhandler.SignalHandlerFactory;
import com.behrooz.merchant.tradingalgo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgoSignalHandler implements SignalHandler {

    @Autowired
    private SignalHandlerFactory factory;

    public void handleSignal(int signal) {
        var handler = factory.GetHandler(signal);
        handler.handleSignal();
    }

}
