package com.erayalkis.udemy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;

import org.junit.jupiter.api.Test;

@MicronautTest
public class HelloWorldControllerTest {

  @Inject
  @Client("/")
  HttpClient client;

  @Test
  void helloWorldRespondsProperly() {
    String response = client.toBlocking().retrieve("/hello");
    assertEquals(response, "Hello World!");
  }
}
