package com.example.feedbackbe.service.datapull;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.feedback.PlaystoreFeedback;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.model.user.PlaystoreUser;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import com.example.feedbackbe.utils.PlaystoreUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PlaystorePullAndHandleServiceImpl implements DataPullAndHandleService {

    private final UserDataRetrievalService userDataRetrievalService;
    private final DiscourseFeedbackService discourseFeedbackService;

    private final PlaystoreUtils playstoreUtils;

    private final FeedbackHandler feedbackHandler;

    @Autowired
    public PlaystorePullAndHandleServiceImpl(DiscourseFeedbackService discourseFeedbackService, UserDataRetrievalService userDataRetrievalService, PlaystoreUtils playstoreUtils) {
        this.userDataRetrievalService = userDataRetrievalService;
        this.discourseFeedbackService = discourseFeedbackService;
        this.feedbackHandler = discourseFeedbackService;
        this.playstoreUtils = playstoreUtils;
    }


    @Override
    public void pullAndHandleDataFromSource() {
        Map<String, PlatformUser> allUsers = userDataRetrievalService.getPlatformUsers(FeedbackSource.PLAYSTORE);

        for(Map.Entry<String, PlatformUser> entry: allUsers.entrySet()) {
            PlatformUser platformUser = entry.getValue();
            List<PlaystoreFeedback> allFeedbacks = playstoreUtils.generateFeedback((PlaystoreUser) platformUser);
            for(PlaystoreFeedback feedback: allFeedbacks) {
                feedbackHandler.processFeedback(feedback);
            }
        }
    }
}
