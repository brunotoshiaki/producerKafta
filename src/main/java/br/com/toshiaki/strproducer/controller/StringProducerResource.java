package br.com.toshiaki.strproducer.controller;

import br.com.toshiaki.strproducer.services.StringProduceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
@RequiredArgsConstructor
public class StringProducerResource {

  private final StringProduceService produceService;

  @PostMapping
  ResponseEntity<?> sendMessage(@RequestBody final String message) {
    produceService.sendToKafka(message);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

}
