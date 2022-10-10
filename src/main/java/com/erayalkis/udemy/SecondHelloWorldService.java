package com.erayalkis.udemy;

import jakarta.inject.Singleton;

@Singleton
public class SecondHelloWorldService implements MyService {
  
  @Override
  public String helloFromService() {
    return "Second Hello World!";
  }

}
