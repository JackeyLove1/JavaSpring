package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestStringBuilder {
    @Test
    public void TestStringBuilderBasic() {
        StringBuilder sb = new StringBuilder();
        String s = "";
        for (int i = 0; i < 100; i++) {
            sb.append(i);
            s += Integer.toString(i);
        }
        assertEquals(sb.toString(), s);

        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sf.append(i);
        }

        assertEquals(sb.toString(), sf.toString());


    }
}
