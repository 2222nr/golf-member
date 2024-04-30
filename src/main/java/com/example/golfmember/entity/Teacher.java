package com.example.golfmember.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="teacher")
public class Teacher {

    @Id
    @Column(name="teacher_code", length = 3, nullable = false)
    private String teacherCode;
    @Column(name="teacher_name", length = 15)
    private String teacherName;
    @Column(name="class_name", length = 20)
    private String className;
    @Column(name="class_price")
    private int classPrice;
    @Column(name="teacher_gegist_date", length = 8)
    private String teacherGegistDate;

}
