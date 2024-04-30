package com.example.golfmember.service;

import com.example.golfmember.dto.LessonDto;
import com.example.golfmember.dto.MemberDto;
import com.example.golfmember.dto.TeacherDto;
import com.example.golfmember.entity.Lesson;
import com.example.golfmember.entity.Teacher;
import com.example.golfmember.repository.LessonRepository;
import com.example.golfmember.repository.MemberRepository;
import com.example.golfmember.repository.TeacherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LessonManageService {
    private final LessonRepository lessonRepository;
    private final MemberRepository memberRepository;
    private final TeacherRepository teacherRepository;

    public LessonManageService(LessonRepository lessonRepository, MemberRepository memberRepository, TeacherRepository teacherRepository) {
        this.lessonRepository = lessonRepository;
        this.memberRepository = memberRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<TeacherDto> teachersAllList() {
        return teacherRepository.findAll()
                .stream()
                .map(x -> TeacherDto.fromTeacherEntity(x))
                .toList();
    }

    public List<MemberDto> memberAllList() {
        return memberRepository.findAll()
                .stream()
                .map(x -> MemberDto.fromMemberEntity(x))
                .toList();
    }

    public void insertClass(LessonDto lessonDto) {
        Lesson lesson = LessonDto.fromLessonDto(lessonDto);
        lessonRepository.save(lesson);
    }

    public List<LessonDto> lessonList() {
        return lessonRepository.findAll()
                .stream()
                .map(x -> LessonDto.fromLessonEntity(x))
                .toList();
    }

    public TeacherDto teacherOne(String id) {
        return teacherRepository.findById(id)
                .map(x -> TeacherDto.fromTeacherEntity(x)).orElse(null);
    }

    public MemberDto memberOne(String id) {
        return memberRepository.findById(id)
                .map(x -> MemberDto.fromMemberEntity(x)).orElse(null);
    }



    public List<LessonDto> lessonAllList() {
        List<LessonDto> lessonList = lessonList();
        List<LessonDto> lessonDtoList = new ArrayList<>();
        for (int i = 0; i < lessonList.size(); i++) {
            LessonDto lesson = lessonList.get(i);
            TeacherDto teacherDto = teacherOne(lesson.getTeacherCode());
            lesson.setTeacherDto(teacherDto);
            MemberDto memberDto = memberOne(lesson.getMemberId());
            lesson.setMemberDto((memberDto));
            lessonDtoList.add(lesson);
        }
        return lessonDtoList;
    }

    public List<TeacherDto> tuition(){
        List<TeacherDto> dto = teacherRepository.salesQuery().stream().map(x -> TeacherDto.fromTeacherEntity(x)).toList();
        log.info(dto.toString());
        return dto;
    }
    public List<TeacherDto> salesAllList(){
        List<TeacherDto> teacherDtos = teachersAllList();
        List<LessonDto> lessonList = lessonList();



//        int totalPrice = lessonList.stream()
//                .filter(x -> x.getTeacherCode().equals("A")) // 특정 조건 필터링
//                .collect(Collectors.summingInt(Customer::getPrice));


//
//        for (int i = 0; i < teacherDtos.size(); i++) {
//            TeacherDto teacher = teacherDtos.get(i);
//            List<LessonDto> lessonDtos = lessonRepository.salesQuery();
//            LessonDto lesson = lessonDtos.get(i);
//            if (teacher.getTeacherCode().equals(lesson.getTeacherCode())) {
//                teacher.setSalesPrice(lesson.getTuition());
//            }
//            teacherDtos.add(teacher);
//        }


        return teacherDtos;
    }

    public LessonDto idCheck(String memberId) {
        List<LessonDto> lessonDtos = lessonList();
        LessonDto lessonDto = null;
        for (LessonDto dto : lessonDtos) {
            if (dto.getMemberId().equals(memberId)) {
                lessonDto = dto;
                break;
            }
        }
        return lessonDto;
    }
}
