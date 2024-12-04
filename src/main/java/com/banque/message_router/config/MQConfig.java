package com.banque.message_router.config;

import com.ibm.mq.jms.MQQueueConnectionFactory;
import com.ibm.msg.client.wmq.WMQConstants;
import jakarta.jms.Connection;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.JMSException;

@Configuration
public class MQConfig {

    @Value("${ibm.mq.queue-manager}")
    private String queueManager;

    @Value("${ibm.mq.channel}")
    private String channel;

    @Value("${ibm.mq.connection}")
    private String connection;

    @Bean
    public ConnectionFactory connectionFactory() {
        try {
            // Configure MQQueueConnectionFactory
            MQQueueConnectionFactory mqFactory = new MQQueueConnectionFactory();
            mqFactory.setQueueManager(queueManager);
            mqFactory.setChannel(channel);
            mqFactory.setHostName(connection);
            mqFactory.setTransportType(WMQConstants.WMQ_CM_CLIENT);

            // Cast MQQueueConnectionFactory to jakarta.jms.ConnectionFactory
            return new jakarta.jms.ConnectionFactory() {
                @Override
                public jakarta.jms.Connection createConnection() throws jakarta.jms.JMSException {
                    try {
                        return (Connection) mqFactory.createConnection();
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public jakarta.jms.Connection createConnection(String userName, String password) throws jakarta.jms.JMSException {
                    try {
                        return (Connection) mqFactory.createConnection(userName, password);
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }

                @Override
                public JMSContext createContext() {
                    return null;
                }

                @Override
                public JMSContext createContext(String s, String s1) {
                    return null;
                }

                @Override
                public JMSContext createContext(String s, String s1, int i) {
                    return null;
                }

                @Override
                public JMSContext createContext(int i) {
                    return null;
                }
            };

        } catch (Exception e) {
            throw new RuntimeException("Error creating IBM MQ ConnectionFactory", e);
        }
    }
}
