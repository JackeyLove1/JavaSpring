package com.example.helloworld.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("""
            select id, name
            from student
            """)
    List<Student> findAll();

    @Select("""
            select id, name from student where id=#{id}
            """)
    Student findById(int id);

    @Insert("""
            insert into student values (#{id}, #{name}, #{age})
            """)
    void insert(@Param("id") int id, @Param("name") String name, @Param("age") int age);

    @Update("""
            update student set name=#{name} where id=#{id}
            """)
    void update(Student student);

    @Delete("""
            delete from student where id=#{id}
            """)
    void delete(int id);
}
