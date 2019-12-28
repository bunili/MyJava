package com.excel.excel;

import com.excel.excel.util.ReflectTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;

@SpringBootTest
class ExcelApplicationTests {


    @Autowired
    private ReflectTest reflectTest;

    @Test
    void contextLoads() {

        reflectTest.text();

    }

}
