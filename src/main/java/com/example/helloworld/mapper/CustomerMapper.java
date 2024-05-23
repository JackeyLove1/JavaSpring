package com.example.helloworld.mapper;

import com.example.helloworld.pojo.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Scope("prototype")
@Mapper
@Component
public interface CustomerMapper {

    @Delete("delete from customer where id = #{id}")
    public void deleteById(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("""
            INSERT INTO Customer (name, age, gender, phone, entry_date)
            VALUES (#{name}, #{age}, #{gender}, #{phone}, #{entryDate})""")
    public void insert(Customer customer);

    @Update("""
            update customer
            set name       = #{name},
                age        = #{age},
                gender     = #{gender},
                phone      = #{phone},
                entry_date = #{entryDate}
            where id = #{id}
            """)
    public void update(Customer customer);

    @Select("select * from customer where id = #{id}")
    public Customer getById(Integer id);

    @Select("""
            select *
            from Customer
            where name = concat('%', #{name}, '%')
              and gender = #{gender}
              and entry_date between #{begin} and #{end}
            order by update_time desc
            """)
    public List<Customer> listByName(String name, Short gender, LocalDate begin, LocalDate end);

    List<Customer> list(String name, Short gender, LocalDate begin, LocalDate end);

    void updateById(Customer customer);

    void deleteByIds(Integer[] ids);

    List<Customer> listAllCustomers();

    Long count();

    @Select("select * from customer limit #{start}, #{pageSize}")
    List<Customer> page(Integer start, Integer pageSize);

    @Select("select * from customer where username = #{username} and password = #{password}")
    Customer login(Customer customer);
}
