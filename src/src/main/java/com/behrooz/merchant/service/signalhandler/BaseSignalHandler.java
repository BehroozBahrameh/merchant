package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.tradingalgo.Algo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSignalHandler {

    @Autowired
    private Algo algo;

    abstract void process(int signal);

    public void commit() {
        algo.doAlgo();
    }

    public void handleSignal(int signal) {
        process(signal);
        commit();
    }
}
