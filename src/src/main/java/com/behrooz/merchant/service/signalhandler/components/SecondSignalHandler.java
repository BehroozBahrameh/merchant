package com.behrooz.merchant.service.signalhandler.components;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component("signal-processor-2")

public class SecondSignalHandler extends BaseSignalHandler {

    private static final Pair<Integer, Integer> SECOND_SIGNAL_PARAM = Pair.of(1, 80);

    @Override
    void process() {
        algo.reverse();
        algo.setAlgoParam(SECOND_SIGNAL_PARAM.getFirst(), SECOND_SIGNAL_PARAM.getSecond());
        algo.submitToMarket();
    }
}
