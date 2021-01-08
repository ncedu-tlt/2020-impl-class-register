package com.pozhenskii.spring.mvc;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class MyController {

    @RequestMapping("/")
    public String showFirstView() {
        return "first-view";
    }

    @RequestMapping("/askDetails")
    public String askStudentDetails(Model model) {
        model.addAttribute("student", new Student());
        return "ask-student-details-view";
    }

    @RequestMapping("/showDetails")
    //@Valid - говорит о том, что student будет подвержен валидации
    public String showDetails(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult) { //без аннотации мы не получим значения во View
        //результат валидациибудет помещён в BindingResult

        //student.setName(student.getName() + "you"); //модификации в модели
        if (bindingResult.hasErrors()) {
            return "ask-student-details-view";
        } else {
            return "show-student-details-view";
        }
    }
}
