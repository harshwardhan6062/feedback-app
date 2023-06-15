package com.example.feedbackbe.client.source;

import com.example.feedbackbe.client.source.interfaces.PullFeedbackClient;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.service.datapull.DataPullAndHandleService;
import com.example.feedbackbe.service.datapull.DiscoursePullAndHandleServiceImpl;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DiscourseFeedbackClient implements PullFeedbackClient {

    private final FeedbackHandler feedbackService;

    private final DataPullAndHandleService dataPullAndHandleService;

    @Autowired
    DiscourseFeedbackClient(DiscourseFeedbackService feedbackService, DiscoursePullAndHandleServiceImpl discoursePullAndHandleService) {

        this.feedbackService = feedbackService;
        this.dataPullAndHandleService = discoursePullAndHandleService;
    }

    @Override
    public Feedback pullAndHandleFeedback() {
        dataPullAndHandleService.pullAndHandleDataFromSource();
        return null;
    }


}
