package com.example.helloworld;

import com.example.helloworld.mapper.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Test
    public void TestArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        var arr2 = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(arr2));

        Student[] students = new Student[]{
                new Student(1, "张三", 100),
                new Student(2, "李四", 20),
                new Student(3, "王五", 30)
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        Arrays.sort(students, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        System.out.println(Arrays.toString(students));
    }

    @Test
    public void TestRegExp() {
        String input = "Hello, my email is example@example.com and my phone number is 123-456-7890.";
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";

        // Compile the regex
        Pattern emailPattern = Pattern.compile("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b");
        Pattern phonePattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        // Create matchers
        Matcher emailMatcher = emailPattern.matcher(input);
        Matcher phoneMatcher = phonePattern.matcher(input);

        // Find email addresses
        while (emailMatcher.find()) {
            System.out.println("Found email: " + emailMatcher.group());
        }

        // Find phone numbers
        while (phoneMatcher.find()) {
            System.out.println("Found phone number: " + phoneMatcher.group());
        }

        // Replace email addresses with a placeholder
        String result = emailMatcher.replaceAll("[email protected]");
        System.out.println("After replacing email: " + result);

        System.out.println("1".matches("[0-9]+"));
        assertTrue("1".matches("[0-9]+"));
        assertTrue("1".matches("\\d"));
        assertTrue("1".matches("\\d*"));
        assertTrue("1".matches("\\d{1}"));

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        String phoneRegex = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";

    }


    public <K, V> void addElementToMap(Map<K, List<V>> m, K key, V value) {
        var list = m.computeIfAbsent(key, k -> new ArrayList<>());
        list.add(value);
    }

    @Test
    public void TestCollection() {
        Map<String, List<String>> map = new HashMap<>();

        addElementToMap(map, "group1", "A");
        addElementToMap(map, "group1", "B");
        addElementToMap(map, "group2", "C");

        map.forEach((k, v) -> System.out.println("Key: " + k + ", Values: " + Arrays.toString(v.toArray())));
        System.out.println(map);
    }

    @Test
    public void TestStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        var squared = list.stream().map(n -> n * n).toList();
        System.out.println(squared);

        var sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        var filter = list.stream().filter(n -> n % 2 == 0).toList();
        System.out.println(filter);

        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        map.entrySet().stream().filter(entry -> entry.getValue() > 20).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }

    @Test
    public void TestStreamBasic() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 10);
        map.put("banana", 20);
        map.put("cherry", 30);

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((k, v) -> System.out.println(k + ": " + v));


        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v1 - v2)).limit(2)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        var max = list.stream().max((v1, v2) -> v1 - v2).get();
        var min = list.stream().min((v1, v2) -> v1 - v2).get();
        var count = list.stream().filter(n -> n % 2 == 0).count();
        System.out.println(max);
        System.out.println(min);
        System.out.println(count);

    }
}
