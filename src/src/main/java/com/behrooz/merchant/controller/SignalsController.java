package com.behrooz.merchant.controller;

import com.behrooz.merchant.tradingalgo.Algo;
import com.behrooz.merchant.tradingalgo.SignalHandler;
import com.behrooz.merchant.util.helper.ResponseHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.behrooz.merchant.util.helper.ResponseHelper.response;

@RequestMapping("signals")
@RestController
public class SignalsController {
    @Autowired
    private SignalHandler signalHandler;

    @GetMapping("/{signal}")
    public ResponseEntity Process(@PathVariable int signal) {
        signalHandler.handleSignal(signal);
        return ResponseHelper.response("signal %s received.".formatted(signal), HttpStatus.ACCEPTED);
    }
}
