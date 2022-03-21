package com.bext.testing;

import com.bext.testing.controller.HomeController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestingWebApplicationTest {
    @Autowired
    HomeController homeController;
    @Test
    public void contextLoads(){
        Assertions.assertThat(homeController).isNotNull();
    }
}