package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/mentors/list")
    public String mentor1(Model model) {

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike", "Smith", 29, Gender.MALE));
        mentorList.add(new Mentor("Ali", "Ahmed", 25, Gender.MALE));
        mentorList.add(new Mentor("Liana", "K", 22, Gender.FEMALE));

        model.addAttribute("mentors",mentorList);

//        Mentor mentor1 = new Mentor("Mike", "Smith", 29, Gender.MALE);
//        model.addAttribute("mentor1", mentor1);
//
//        Mentor mentor2 = new Mentor("Ali", "Ahmed", 25, Gender.MALE);
//        model.addAttribute("mentor2", mentor2);
//
//        Mentor mentor3 = new Mentor("Liana", "K", 22, Gender.FEMALE);
//        model.addAttribute("mentor3", mentor3);
        return "mentor/mentorInfo";
    }
}
