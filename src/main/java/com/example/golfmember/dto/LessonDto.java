package com.example.golfmember.dto;


import com.example.golfmember.constant.ClassArea;
import com.example.golfmember.entity.Lesson;
import com.example.golfmember.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class LessonDto {
    private Long classId;
    private String registMonth;
    private String memberId;
    private ClassArea classArea;
    private int tuition;
    private String teacherCode;


    private MemberDto memberDto;
    private TeacherDto teacherDto;


    public static LessonDto fromLessonEntity(Lesson lesson){
        return new LessonDto(lesson.getClassId(), lesson.getRegistMonth(),
                lesson.getMemberId(), lesson.getClassArea(), lesson.getTuition(),
                lesson.getTeacherCode(), new MemberDto(), new TeacherDto());
    }

    public LessonDto(String teacherCode, int tuition) {
        this.tuition = tuition;
        this.teacherCode = teacherCode;
    }

    public static LessonDto fromLesson(Lesson lesson){
        return new LessonDto(lesson.getTeacherCode(), lesson.getTuition());
    }
    public static Lesson fromLessonDto(LessonDto lessonDto){
        Lesson lesson = new Lesson();
        lesson.setClassId(lessonDto.getClassId());
        lesson.setRegistMonth(lessonDto.getRegistMonth());
        lesson.setMemberId(lessonDto.getMemberId());
        lesson.setClassArea(lessonDto.getClassArea());
        lesson.setTuition(lessonDto.getTuition());
        lesson.setTeacherCode(lessonDto.getTeacherCode());
        return lesson;
    }
}
