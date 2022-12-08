package com.behrooz.merchant.service.signalhandler;

public class DefaultSignalHandler extends BaseSignalHandler {

    @Override
    void process() {
        algo.cancelTrades();
    }
}
