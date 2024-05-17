package com.example.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

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

    @Test
    public void TestMathBasic() {
        assertEquals(Math.abs(-1), 1);
        assertEquals(Math.ceil(1.1), 2);
        assertEquals(Math.floor(1.2), 1);
    }

    @Test
    public void TestDateBasic() {
        System.out.println(System.currentTimeMillis());
        Date d = new Date();
        System.out.println(d.getTime());
    }

    @Test
    public void TestBigDecimal() {
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        assertEquals(bd1.add(bd2), new BigDecimal("0.3"));
        assertEquals(bd1.add(bd2).toString(), "0.3");

        BigDecimal bd3 = BigDecimal.valueOf(0.3);
    }

    @Test
    public void TestTimeBasic() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
    }
}
