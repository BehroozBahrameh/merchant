package com.behrooz.merchant.service;

import com.behrooz.merchant.tradingalgo.Algo;
import com.behrooz.merchant.tradingalgo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlgoSignalHandler implements SignalHandler {

    @Autowired
    private Algo algo;

    public void handleSignal(int signal) {

        switch (signal) {
            case 1:
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
                break;

            case 2:
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
                break;

            case 3:
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
                break;

            default:
                algo.cancelTrades();
                break;
        }

        algo.doAlgo();
    }

}
