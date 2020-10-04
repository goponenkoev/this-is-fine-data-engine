package com.thisisfine;

import io.micronaut.http.server.netty.NettyHttpServer;
import io.micronaut.test.annotation.MicronautTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
public class ApplicationTest {

  @Inject
  private NettyHttpServer application;

  @Test
  void testItWorks() {
    Assertions.assertTrue(application.isRunning());
  }

}
