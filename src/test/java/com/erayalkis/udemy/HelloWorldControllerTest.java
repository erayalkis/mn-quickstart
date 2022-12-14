package com.erayalkis.udemy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import com.fasterxml.jackson.databind.JsonNode;
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

  @Test
  void helloWorldReturnsCorrectResponseFromConfig() {
    HttpResponse<String> response = client.toBlocking().exchange("/hello/config", String.class);

    assertEquals("Hello from application.yml!", response.body());
  }

  @Test
  void helloFromTranslationEndpointReturnsContentFromConfigFile() {
    var response = client.toBlocking().exchange("/hello/translation", JsonNode.class);
    assertEquals(200, response.code());
    assertEquals("{\"de\":\"Hallo welt!\",\"en\":\"Hello world!\"}", response.getBody().get().toString());
  }
}
