package com.weapp.service.products;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        Application.main(new String[]{});
        Assert.assertTrue("Application starts", true);
    }

}
