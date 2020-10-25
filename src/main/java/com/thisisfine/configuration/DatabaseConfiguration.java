package com.thisisfine.configuration;

import io.micronaut.context.annotation.ConfigurationProperties;
import lombok.Getter;

@Getter
@ConfigurationProperties("database")
public class DatabaseConfiguration {

  private String name;
  private String url;

  public DatabaseConfiguration() {
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
