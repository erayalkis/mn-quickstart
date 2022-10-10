package com.erayalkis.udemy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.HttpResponse;
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
  void helloWorldRespondsWithCorrectBody() {
    String response = client.toBlocking().retrieve("/hello");
    assertEquals("Hello World!", response);
  }

  @Test
  void helloWorldRespondsWithCorrectStatusCode() {
    HttpResponse<String> response = client.toBlocking().exchange("/hello", String.class);
    
    assertEquals("Hello World!", response.body());
    assertEquals(200, response.code());
  }
}
