package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.tradingalgo.Algo;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSignalHandler {

    @Autowired
    protected Algo algo;

    abstract void process();

    public void commit() {
        algo.doAlgo();
    }

    public void handleSignal() {
        process();
        commit();
    }
}
