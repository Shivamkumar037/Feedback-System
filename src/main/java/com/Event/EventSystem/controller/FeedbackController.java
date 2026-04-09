package com.Event.EventSystem.controller;

import com.Event.EventSystem.entity.Feedback;
import com.Event.EventSystem.service.FeedbackService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FeedbackController {

    private final FeedbackService service;

    public FeedbackController(FeedbackService service) {
        this.service = service;
    }

    @GetMapping("/feedback")
    public String feedbackForm(Model model) {
        model.addAttribute("feedback", new Feedback());
        return "feedback-form";
    }
//    @PostMapping("/save_feedback")
//    public String saveFeedback(@ModelAttribute Feedback feedback) {
//
//        service.saveFeedback(feedback);
//        return "redirect:/feedbacks";
//    }
    @PostMapping("/save-feedback")
    public String saveFeedback(@ModelAttribute Feedback feedback) {

        service.saveFeedback(feedback);
        return "redirect:/feedbacks";
    }

    @GetMapping("/feedbacks")
    public String allFeedback(Model model){

        model.addAttribute("feedbacks", service.getAllFeedback());
        return "feedback-list";
    }
}