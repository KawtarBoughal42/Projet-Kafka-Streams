package com.project.systeme__gestion__location__vehicules.producteur.Config;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;

import java.util.Locale;

@Configuration
public class KafkaStreamsConfig {
    @Bean
    public StreamsBuilderFactoryBean kafkaStreamsFactory() {
        return new StreamsBuilderFactoryBean();
    }

    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream("input-topic");
        stream.mapValues(value -> value.toUpperCase(Locale.ROOT))
                .to("output-topic");
        return stream;
    }
}
