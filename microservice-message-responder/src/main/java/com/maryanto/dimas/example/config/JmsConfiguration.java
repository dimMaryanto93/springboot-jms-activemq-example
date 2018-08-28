package com.maryanto.dimas.example.config;

import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;

@Configuration
@EnableJms
public class JmsConfiguration {

    @Bean
    public JmsTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        JmsTransactionManager transactionManager = new JmsTransactionManager(connectionFactory);
        transactionManager.setDefaultTimeout(5000);
        return transactionManager;
    }

    @Bean
    public JmsTemplate jmsTemplate(MessageConverter converter, ConnectionFactory connectionFactory) {
        JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setMessageConverter(converter);
        template.setReceiveTimeout(5000);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(
            ConnectionFactory connectionFactory,
            JmsTemplate jmsTemplate) {
        JmsMessagingTemplate template = new JmsMessagingTemplate(jmsTemplate);
        template.setConnectionFactory(connectionFactory);
        template.setJmsTemplate(jmsTemplate);
        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public JmsListenerContainerFactory<?> messageFactory(
            ConnectionFactory connectionFactory,
            JmsTransactionManager transactionManager,
            DefaultJmsListenerContainerFactoryConfigurer configurer,
            MessageConverter converter) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(converter);
        factory.setTransactionManager(transactionManager);

        configurer.configure(factory, connectionFactory);
        return factory;
    }

    @Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }
}
