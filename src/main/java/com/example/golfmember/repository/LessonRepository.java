package com.example.golfmember.repository;

import com.example.golfmember.dto.LessonDto;
import com.example.golfmember.dto.TeacherDto;
import com.example.golfmember.entity.Lesson;
import com.example.golfmember.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Map;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

}
