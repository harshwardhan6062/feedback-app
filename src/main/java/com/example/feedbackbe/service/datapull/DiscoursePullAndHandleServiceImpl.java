package com.example.feedbackbe.service.datapull;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.user.DiscourseUser;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import com.example.feedbackbe.utils.DiscourseUtils;
import com.example.feedbackbe.utils.PlaystoreUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiscoursePullAndHandleServiceImpl implements DataPullAndHandleService {

    private final UserDataRetrievalService userDataRetrievalService;
    private final DiscourseFeedbackService discourseFeedbackService;

    private final DiscourseUtils discourseUtils;

    private final FeedbackHandler feedbackHandler;

    @Autowired
    public DiscoursePullAndHandleServiceImpl(DiscourseFeedbackService discourseFeedbackService, UserDataRetrievalService userDataRetrievalService, DiscourseUtils discourseUtils) {
        this.userDataRetrievalService = userDataRetrievalService;
        this.discourseFeedbackService = discourseFeedbackService;
        this.feedbackHandler = discourseFeedbackService;
        this.discourseUtils = discourseUtils;
    }

    @Override
    public void pullAndHandleDataFromSource() {
        Map<String, PlatformUser> allUsers = userDataRetrievalService.getPlatformUsers(FeedbackSource.DISCOURSE);

        for(Map.Entry<String, PlatformUser> entry: allUsers.entrySet()) {
            PlatformUser platformUser = entry.getValue();
            List<DiscourseFeedback> allFeedbacks = discourseUtils.generateFeedback((DiscourseUser) platformUser);
            for(DiscourseFeedback feedback: allFeedbacks) {
                feedbackHandler.processFeedback(feedback);
            }
        }

    }
}
