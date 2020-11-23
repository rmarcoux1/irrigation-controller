package com.projects.irrigationcontroller.config;

import com.projects.irrigationcontroller.model.Zone;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ryan G. Marcoux
 */
@Configuration
public class KafkaConfiguration {

    @Bean
    public ConsumerFactory<String, Zone> zoneConsumerFactory() {
        Map<String,Object> configs = new HashMap<>();

        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.1.146:9092");
        configs.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(configs, new StringDeserializer(),
                new JsonDeserializer<>(Zone.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Zone> zoneContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Zone> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(zoneConsumerFactory());
        return factory;
    }
}
