package com.behrooz.merchant.controller;

import com.behrooz.merchant.tradingalgo.Algo;
import com.behrooz.merchant.tradingalgo.SignalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("signals")
@RestController
public class SignalsController {
    @Autowired
    private SignalHandler signalHandler;

    @GetMapping("/{signal}")
    public String Process(@PathVariable int signal) {
        signalHandler.handleSignal(signal);
        return "ok";
    }
}
