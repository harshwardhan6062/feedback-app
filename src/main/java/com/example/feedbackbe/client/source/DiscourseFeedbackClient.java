package com.example.feedbackbe.client.source;

import com.example.feedbackbe.client.source.interfaces.PullFeedbackClient;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.service.datapull.DataPullAndHandle;
import com.example.feedbackbe.service.datapull.DataPullAndHandleImpl;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DiscourseFeedbackClient implements PullFeedbackClient {

    private final FeedbackHandler feedbackService;

    private final DataPullAndHandle dataPullAndHandleService;

    @Autowired
    DiscourseFeedbackClient(DiscourseFeedbackService feedbackService, DataPullAndHandleImpl dataPullAndHandleService) {

        this.feedbackService = feedbackService;
        this.dataPullAndHandleService = dataPullAndHandleService;
    }

    @Override
    public void pullAndHandleFeedback() {
        dataPullAndHandleService.pullAndHandleDataFromSource(FeedbackSource.DISCOURSE);
    }


}
