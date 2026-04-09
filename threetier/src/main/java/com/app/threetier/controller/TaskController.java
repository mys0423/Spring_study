package com.app.threetier.controller;

import com.app.threetier.domain.vo.ProductVO;
import com.app.threetier.domain.vo.TaskVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/tasks/*")
public class TaskController {
    @GetMapping("register")
    public void goToScores(TaskVO taskVO) {;}

    @PostMapping("register")
    public RedirectView calculate(TaskVO taskVO, RedirectAttributes redirectAttributes) {
        int total = taskVO.getKor() + taskVO.getEng() + taskVO.getMath();
        double average = total / 3.0;

        taskVO.setTotal(total);
        taskVO.setAverage(average);

        redirectAttributes.addFlashAttribute("taskVO", taskVO);

        return new RedirectView("/tasks/result");
    }

    @GetMapping("result")
    public void goToResult() {;}
}
