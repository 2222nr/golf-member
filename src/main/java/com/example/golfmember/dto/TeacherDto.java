package com.example.golfmember.dto;

import com.example.golfmember.entity.Teacher;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {
    private String teacherCode;
    private String teacherName;
    private String className;
    private int classPrice;
    private String teacherGegistDate;

    private int salesPrice;

    public TeacherDto(String teacherCode, String teacherName, String className, int classPrice, String teacherGegistDate) {
        this.teacherCode = teacherCode;
        this.teacherName = teacherName;
        this.className = className;
        this.classPrice = classPrice;
        this.teacherGegistDate = teacherGegistDate;
    }

    public static TeacherDto fromTeacherEntity(Teacher teacher){
        return new TeacherDto(teacher.getTeacherCode(), teacher.getTeacherName(),
                teacher.getClassName(), teacher.getClassPrice(), teacher.getTeacherGegistDate());
    }

    public static Teacher fromTeacherDto(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setTeacherCode(teacherDto.getTeacherCode());
        teacher.setTeacherName(teacherDto.getTeacherName());
        teacher.setClassName(teacherDto.getClassName());
        teacher.setClassPrice(teacherDto.getClassPrice());
        teacher.setTeacherGegistDate(teacherDto.getTeacherGegistDate());
        return teacher;
    }
}
