package com.example.helloworld.controller;

import com.example.helloworld.dto.Result;
import com.example.helloworld.pojo.Address;
import com.example.helloworld.pojo.User;
import com.example.helloworld.util.ResultUtil;
import com.github.javafaker.Faker;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    private final Faker faker = new Faker();

    @PostMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/simpleParam", method = RequestMethod.GET)
    public String simpleParam(String name, Integer age) {
        return "name: " + name + ", age: " + age;
    }

    @RequestMapping(value = "/simpleParamV2")
    public String simpleParamV2(@RequestParam(name = "name", required = false) String username, Integer age) {
        return "name: " + username + ", age: " + age;
    }

    @RequestMapping(value = "/simplePojo")
    public String simplePojo(User user) {
        return "name: " + user.getName() + ", age: " + user.getAge();
    }

    @RequestMapping(value = "/simplePojoV2")
    public String simplePojoV2(User user) {
        return "name: " + user.getName() + ", age: " + user.getAge() + ", address: " + user.getAddress().toString();
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(@RequestParam("hobby") String[] names) {
        return Arrays.toString(names);
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        return updateTime.toString();
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/pathParam/{id}")
    public String pathParam(@PathVariable("id") Integer id) {
        return "id: " + id;
    }

    @RequestMapping("/pathParam/{id}/{name}")
    public String pathParamComplex(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return "id: " + id + " ,name: " + name;
    }

    @RequestMapping("/getAddress")
    public Address getAddress() {
        return new Address(faker.address().state(), faker.address().city());
    }

    @RequestMapping("/getUser")
    public Result<User> getUser() {
        Address adderss = new Address(faker.address().state(), faker.address().city());
        User user = new User(faker.number().numberBetween(1, 100), faker.name().fullName(), adderss);
        return ResultUtil.success(user);

    }

    @RequestMapping("/getList")
    public Result<List<String>> getList(){
        return ResultUtil.success(Arrays.asList("a", "b", "c"));
    }

}
