package com.example.feedbackbe.utils;

import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.model.user.TwitterUser;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

// These is just a helper file and can be ignored
@Service
public class TwitterUtils implements PlatformUtils{

    public List<Feedback> generateFeedback(PlatformUser platformUser) {
        return null;
    }

}
