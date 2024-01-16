package com.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest
{
    @Test
    public void testSayHello(){
        assertEquals("Hello", App.sayHello());
    }
}
