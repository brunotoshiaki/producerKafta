package br.com.toshiaki.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class StringProduceService {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendToKafka(final String message) {
    kafkaTemplate.send("str-topic", message);
  }
}
