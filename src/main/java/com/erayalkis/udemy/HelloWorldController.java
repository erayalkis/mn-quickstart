package com.erayalkis.udemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
  private final MyService service;

  public HelloWorldController(MyService service) {
    this.service = service;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    LOG.debug("Called Hello World API");
    return service.helloFromService();
  }
}
