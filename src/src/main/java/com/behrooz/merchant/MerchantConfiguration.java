package com.behrooz.merchant;

import com.behrooz.merchant.tradingalgo.Algo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MerchantConfiguration {
    @Bean
    public Algo algo() {
        return new Algo();
    }
}
