package com.example.helloworld.mapper;

import com.example.helloworld.pojo.Customer;
import org.apache.ibatis.annotations.*;

@Mapper
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
}
