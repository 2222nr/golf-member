package com.example.golfmember.controller;

import com.example.golfmember.dto.LessonDto;
import com.example.golfmember.dto.MemberDto;
import com.example.golfmember.dto.TeacherDto;
import com.example.golfmember.repository.LessonRepository;
import com.example.golfmember.repository.TeacherRepository;
import com.example.golfmember.service.LessonManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/golf-lesson")
public class TeacherContoller {
    private final LessonManageService lessonManageService;
    public TeacherContoller(LessonManageService lessonManageService) {
        this.lessonManageService = lessonManageService;
    }

    @GetMapping("teacher")
    public String teacherView(Model model){
        List<TeacherDto> teacherDtos = lessonManageService.teachersAllList();
        model.addAttribute("TeacherDtoList",teacherDtos);
        return "golf-lesson/teacher";
    }
    @GetMapping("new")
    public String inputView(Model model){
        List<MemberDto> memberDtoList = lessonManageService.memberAllList();
        List<TeacherDto> teacherDtos = lessonManageService.teachersAllList();
        LessonDto lessonDto = new LessonDto();
        model.addAttribute("LessonDto", lessonDto);
        model.addAttribute("MemberDtoList", memberDtoList);
        model.addAttribute("TeacherDtoList", teacherDtos);
        return "golf-lesson/new-lesson";
    }

    @PostMapping("new")
    public String inputForm(@ModelAttribute("LessonDto") LessonDto lessonDto,
                            @RequestParam("memberId") String memberId){
        LessonDto lessonDto1= lessonManageService.idCheck(memberId);
        log.info(lessonDto.getTeacherCode());
        if(lessonDto1 != null) {
            lessonDto1.setRegistMonth(lessonDto.getRegistMonth());
            lessonDto1.setTeacherCode(lessonDto.getTeacherCode());
            lessonDto1.setClassArea(lessonDto.getClassArea());
            lessonDto1.setTuition(lessonDto.getTuition());
            lessonManageService.insertClass(lessonDto1);
        } else {
        lessonManageService.insertClass(lessonDto);}
        return "redirect:/";
    }

    //

    @GetMapping("lesson")
    public String lessonView(Model model){
        List<LessonDto> lessonDtoList = lessonManageService.lessonAllList();
        model.addAttribute("LessonList", lessonDtoList);
        return "golf-lesson/lesson-member";
    }
    @GetMapping("tuition")
    public String tuitionView(Model model){
        List<TeacherDto> salesDto = lessonManageService.tuition();
        model.addAttribute("SalesList", salesDto);
        log.info(salesDto.toString());
        return "golf-lesson/tuition-sales";
    }

}
