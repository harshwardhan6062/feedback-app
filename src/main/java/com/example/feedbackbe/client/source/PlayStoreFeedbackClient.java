package com.example.feedbackbe.client.source;

import com.example.feedbackbe.client.source.interfaces.PullFeedbackClient;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.PlaystoreFeedback;
import com.example.feedbackbe.service.datapull.DataPullAndHandleService;
import com.example.feedbackbe.service.datapull.PlaystorePullAndHandleServiceImpl;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.feedback.handler.PlaystoreFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlayStoreFeedbackClient implements PullFeedbackClient {

    private final FeedbackHandler feedbackService;

    private final DataPullAndHandleService dataPullAndHandleService;

    @Autowired
    PlayStoreFeedbackClient(PlaystoreFeedbackService feedbackService, PlaystorePullAndHandleServiceImpl playstorePullAndHandleService) {
        this.dataPullAndHandleService = playstorePullAndHandleService;
        this.feedbackService = feedbackService;
    }

    @Override
    public Feedback pullAndHandleFeedback() {
        dataPullAndHandleService.pullAndHandleDataFromSource();
        return null;
    }
}
