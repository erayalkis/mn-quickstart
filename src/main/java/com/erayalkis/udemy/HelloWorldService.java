package com.erayalkis.udemy;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService implements MyService {
  
  @Override
  public String helloFromService() {
    return "Hello World!";
  }

}
