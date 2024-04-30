package com.example.golfmember.repository;

import com.example.golfmember.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, String> {
    @Query(value = "select t.teacher_code, t.teacher_name, t.teacher_gegist_date, t.class_name, sum(c.tuition) as class_price from teacher t join class c on t.teacher_code = c.teacher_code group by teacher_code;", nativeQuery = true)
    List<Teacher> salesQuery();
}
