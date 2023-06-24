package com.example.feedbackbe.utils;

import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;
import com.example.feedbackbe.model.user.PlatformUser;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PlatformUtils {

    public List<Feedback> generateFeedback(PlatformUser platformUser);

}
