package com.Event.EventSystem.service;

import com.Event.EventSystem.entity.Feedback;
import com.Event.EventSystem.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public void saveFeedback(Feedback feedback){
        repository.save(feedback);
    }

    public List<Feedback> getAllFeedback(){
        return repository.findAll();
    }
}