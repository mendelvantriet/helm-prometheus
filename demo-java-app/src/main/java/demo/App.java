package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class App {

  @Value("${VALUE:World}")
  String value;

  @RestController
  class HelloController {
  
    @GetMapping("/")
    String hello() {
      return "Hello " + value + "!";
    }
    
  }

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
