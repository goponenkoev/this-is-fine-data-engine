package com.thisisfine;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Data Engine Application",
                version = "v0.1",
                description = "API for Data Engine"
        )
)
public class Application {

  public static void main(String[] args) {
    Micronaut.run(Application.class, args);
  }
}
