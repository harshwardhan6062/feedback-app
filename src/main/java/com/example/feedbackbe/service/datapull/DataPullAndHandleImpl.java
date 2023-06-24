package com.example.feedbackbe.service.datapull;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.service.factory.FeedbackFactory;
import com.example.feedbackbe.service.factory.FeedbackHandlerFactory;
import com.example.feedbackbe.service.factory.PlatformUtilsFactory;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class DataPullAndHandleImpl implements DataPullAndHandle {


    private final UserDataRetrievalService userDataRetrievalService;
    private final DiscourseFeedbackService discourseFeedbackService;

    private final FeedbackHandlerFactory feedbackHandlerFactory;

    private final PlatformUtilsFactory platformUtilsFactory;

    private final FeedbackFactory feedbackFactory;


    @Autowired
    public DataPullAndHandleImpl(FeedbackHandlerFactory feedbackHandlerFactory, PlatformUtilsFactory platformUtilsFactory, DiscourseFeedbackService discourseFeedbackService, UserDataRetrievalService userDataRetrievalService, FeedbackFactory feedbackFactory) {
        this.userDataRetrievalService = userDataRetrievalService;
        this.discourseFeedbackService = discourseFeedbackService;
        this.feedbackHandlerFactory = feedbackHandlerFactory;
        this.platformUtilsFactory = platformUtilsFactory;
        this.feedbackFactory = feedbackFactory;
    }

    @Override
    public void pullAndHandleDataFromSource(FeedbackSource feedbackSource) {
        Map<String, PlatformUser> allUsers = userDataRetrievalService.getPlatformUsers(feedbackSource);

        for(Map.Entry<String, PlatformUser> entry: allUsers.entrySet()) {
            PlatformUser platformUser = entry.getValue();
            List<Feedback> allFeedbacks = platformUtilsFactory.getPlatformUtilsFactory(feedbackSource).generateFeedback(platformUser);
            for(Feedback feedback: allFeedbacks) {
                feedbackHandlerFactory.getFeedbackHandler(feedbackSource).processFeedback(feedback);
            }
        }
    }
}
