package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.user.FeedbackTypeRecord.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.PlaystoreFeedback;
import com.example.feedbackbe.model.feedback.metadata.PlaystoreFeedbackMetadata;
import com.example.feedbackbe.model.user.FeedbackTypeRecord.PostFeedbackRecord;
import com.example.feedbackbe.model.user.FeedbackTypeRecord.ReviewFeedbackRecord;
import com.example.feedbackbe.service.feedback.persistence.FeedbackPersistence;
import com.example.feedbackbe.service.feedback.persistence.FeedbackPersistenceToDB;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaystoreFeedbackService implements FeedbackHandler {

    private FeedbackPersistence feedbackPersistenceService;
    private UserDataRetrievalService userDataRetrievalService;

    @Autowired
    public PlaystoreFeedbackService(FeedbackPersistenceToDB feedbackPersistenceService, UserDataRetrievalService userDataRetrievalService) {
        this.feedbackPersistenceService = feedbackPersistenceService;
        this.userDataRetrievalService = userDataRetrievalService;
    }

    public String getTenantId(String id) {
        return userDataRetrievalService.getTenantId(FeedbackSource.PLAYSTORE, id);
    }

    @Override
    public void processFeedback(Feedback feedback) {
        PlaystoreFeedback playstoreFeedback = (PlaystoreFeedback) feedback;
        ReviewFeedbackRecord reviewFeedbackRecord = new ReviewFeedbackRecord(getUniqueFeedbackId(feedback), getTenantId(playstoreFeedback.getUsername()), FeedbackType.REVIEW, FeedbackSource.PLAYSTORE, playstoreFeedback.getUsername(), playstoreFeedback.getFeedbackText(), playstoreFeedback.getLikes());
        feedbackPersistenceService.saveFeedback(reviewFeedbackRecord);
    }

    public String getUniqueFeedbackId(Feedback feedback) {
        PlaystoreFeedback twitterFeedback = (PlaystoreFeedback) feedback;
        return twitterFeedback.getId().concat("#").concat(twitterFeedback.getUsername()).concat(twitterFeedback.getCreatedAt());
    }
}
