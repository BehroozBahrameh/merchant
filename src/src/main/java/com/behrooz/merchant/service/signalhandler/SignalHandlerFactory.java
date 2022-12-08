package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.service.signalhandler.components.*;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerFactory {
    public BaseSignalHandler GetHandler(int signal) {
        switch (signal) {
            case 1:
                return new FirstSignalHandler();
            case 2:
                return new SecondSignalHandler();
            case 3:
                return new ThirdSignalHandler();
            default:
                return new DefaultSignalHandler();
        }
    }
}
