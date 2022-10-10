package com.erayalkis.udemy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/hello")
public class HelloWorldController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);
  private final String helloFromConfig;
  private final MyService service;

  public HelloWorldController(MyService service, @Property(name="hello.world.message")   String helloFromConfig) {
    this.service = service;
    this.helloFromConfig = helloFromConfig;
  }

  @Get(produces = MediaType.TEXT_PLAIN)
  public String index() {
    LOG.debug("Called Hello World API");
    return service.helloFromService();
  }

  @Get(uri="/config", produces=MediaType.TEXT_PLAIN)
  public String helloFromConfig() {
    LOG.debug("Return hello from config message: {}", helloFromConfig);
    return helloFromConfig;
  }
}
