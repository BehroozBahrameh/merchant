package com.behrooz.merchant.service.signalhandler.components;

import org.springframework.stereotype.Component;

@Component("signal-processor-default")
public class DefaultSignalHandler extends BaseSignalHandler {

    @Override
    void process() {
        algo.cancelTrades();
    }
}
