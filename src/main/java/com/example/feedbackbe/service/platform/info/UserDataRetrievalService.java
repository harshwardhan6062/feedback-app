package com.example.feedbackbe.service.platform.info;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;

import java.util.Map;

public interface UserDataRetrievalService {

    public Map<String, PlatformUser> getPlatformUsers(FeedbackSource feedbackSource);

    public String getTenantId(FeedbackSource feedbackSource, String id);

}
