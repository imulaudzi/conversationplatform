package com.isaac.conversationplatform.listener;

import com.yammer.metrics.Metrics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
import org.springframework.integration.kafka.support.KafkaConsumerContext;

/**
 * Created by isaac on 2017/01/27.
 */
public class MessageInboundListener implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private SourcePollingChannelAdapter kafkaInboundChannelAdapter;
    private KafkaConsumerContext kafkaConsumerContext;

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageInboundListener.class);

    public void initIt() throws Exception {

        kafkaInboundChannelAdapter = applicationContext.getBean("kafka-inbound-channel-adapter", SourcePollingChannelAdapter.class);
        kafkaInboundChannelAdapter.start();
        LOGGER.info("Starting Kafka Application Context");
        kafkaConsumerContext = applicationContext.getBean("consumerContext", KafkaConsumerContext.class);
    }

    public void cleanUp() throws Exception {
        if (kafkaInboundChannelAdapter != null) {
            kafkaInboundChannelAdapter.stop();
        }
        Thread.sleep(1000);
        Metrics.defaultRegistry().shutdown();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }





}