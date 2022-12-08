package com.behrooz.merchant.service.signalhandler.components;

public class DefaultSignalHandler extends BaseSignalHandler {

    @Override
    void process() {
        algo.cancelTrades();
    }
}
