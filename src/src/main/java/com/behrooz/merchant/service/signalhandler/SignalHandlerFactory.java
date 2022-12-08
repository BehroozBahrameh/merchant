package com.behrooz.merchant.service.signalhandler;

import com.behrooz.merchant.service.signalhandler.components.BaseSignalHandler;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class SignalHandlerFactory {
    private static final String DefaultSignalHandler = "signal-processor-default";
    private static final String SignalHandlerPattern = "signal-processor-%s";
    private @Autowired AutowireCapableBeanFactory beanFactory;

    public BaseSignalHandler GetHandler(int signal) {
        BaseSignalHandler instance;
        try {
            instance = (BaseSignalHandler) beanFactory.getBean(getName(signal));
        } catch (NoSuchBeanDefinitionException exception) {
            instance = (BaseSignalHandler) beanFactory.getBean(DefaultSignalHandler);
        }
        return instance;
    }

    public static String getName(int signal) {
        return SignalHandlerPattern.formatted(signal);
    }
}
