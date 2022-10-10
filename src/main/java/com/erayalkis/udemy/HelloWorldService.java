package com.erayalkis.udemy;

import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService {
  
 String helloFromService() {
    return "Hello World!";
  }

}
