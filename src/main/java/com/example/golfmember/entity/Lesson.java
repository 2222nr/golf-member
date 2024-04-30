package com.example.golfmember.entity;

import com.example.golfmember.constant.ClassArea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="class")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="class_id", nullable = false)
    private Long classId;
    @Column(name="regist_month", length = 6)    // 수강월
    private String registMonth;
    @Column(name="class_no", length = 5)    // 회원번호
    private String memberId;
    @Enumerated(EnumType.STRING)
    @Column(name="class_area", length = 15) // 강의장소
    private ClassArea classArea;
    @Column(name="tuition") // 수강료
    private int tuition;
    @Column(name="teacher_code", length = 3)    // 강사코드
    private String teacherCode;

}
