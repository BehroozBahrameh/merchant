package com.behrooz.merchant.service.signalhandler;

import org.springframework.data.util.Pair;

public class FirstSignalHandler extends BaseSignalHandler {

    private static final Pair<Integer, Integer> FIRST_SIGNAL_PARAM = Pair.of(1, 60);

    @Override
    void process() {
        algo.setUp();
        algo.setAlgoParam(FIRST_SIGNAL_PARAM.getFirst(), FIRST_SIGNAL_PARAM.getSecond());
        algo.performCalc();
        algo.submitToMarket();
    }
}
