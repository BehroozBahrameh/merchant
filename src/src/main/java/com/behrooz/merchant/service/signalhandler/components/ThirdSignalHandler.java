package com.behrooz.merchant.service.signalhandler.components;

import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component("signal-processor-3")

public class ThirdSignalHandler extends BaseSignalHandler {

    private static final Pair<Integer, Integer> THIRD_SIGNAL_PARAM_1 = Pair.of(1, 90);
    private static final Pair<Integer, Integer> THIRD_SIGNAL_PARAM_2 = Pair.of(2, 15);

    @Override
    void process() {
        algo.setAlgoParam(THIRD_SIGNAL_PARAM_1.getFirst(), THIRD_SIGNAL_PARAM_1.getSecond());
        algo.setAlgoParam(THIRD_SIGNAL_PARAM_2.getFirst(), THIRD_SIGNAL_PARAM_2.getSecond());
        algo.performCalc();
        algo.submitToMarket();
    }
}
