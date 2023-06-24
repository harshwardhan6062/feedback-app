package com.example.feedbackbe.utils;

import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.user.DiscourseUser;
import com.example.feedbackbe.model.user.PlatformUser;
import org.springframework.stereotype.Service;

import java.util.List;


// These is just a helper file and can be ignored
@Service
public class DiscourseUtils implements PlatformUtils {

    @Override
    public List<Feedback> generateFeedback(PlatformUser platformUser) {
        return null;
    }
}
