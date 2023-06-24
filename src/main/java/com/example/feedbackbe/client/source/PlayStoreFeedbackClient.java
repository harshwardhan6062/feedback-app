package com.example.feedbackbe.client.source;

import com.example.feedbackbe.client.source.interfaces.PullFeedbackClient;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.service.datapull.DataPullAndHandle;
import com.example.feedbackbe.service.datapull.DataPullAndHandleImpl;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.feedback.handler.PlaystoreFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayStoreFeedbackClient implements PullFeedbackClient {

    private final FeedbackHandler feedbackService;

    private final DataPullAndHandle dataPullAndHandleService;

    @Autowired
    PlayStoreFeedbackClient(PlaystoreFeedbackService feedbackService, DataPullAndHandleImpl playstorePullAndHandleService) {
        this.dataPullAndHandleService = playstorePullAndHandleService;
        this.feedbackService = feedbackService;
    }

    @Override
    public void pullAndHandleFeedback() {
        dataPullAndHandleService.pullAndHandleDataFromSource(FeedbackSource.PLAYSTORE);
    }
}
