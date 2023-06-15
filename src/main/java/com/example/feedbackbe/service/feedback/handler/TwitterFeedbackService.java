package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;
import com.example.feedbackbe.model.feedback.metadata.TwitterFeedbackMetadata;
import com.example.feedbackbe.service.feedback.persistence.FeedbackPersistence;
import com.example.feedbackbe.service.feedback.persistence.FeedbackPersistenceToDB;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitterFeedbackService implements FeedbackHandler {

    private FeedbackPersistence feedbackPersistenceService;
    private UserDataRetrievalService userDataRetrievalService;

    @Autowired
    public TwitterFeedbackService(FeedbackPersistenceToDB feedbackPersistenceService, UserDataRetrievalService userDataRetrievalService) {
        this.feedbackPersistenceService = feedbackPersistenceService;
        this.userDataRetrievalService = userDataRetrievalService;
    }

    public String getUniqueFeedbackId(Feedback feedback) {
        TwitterFeedback twitterFeedback = (TwitterFeedback) feedback;
        return twitterFeedback.getId().concat("#").concat(twitterFeedback.getUsername()).concat(twitterFeedback.getCreatedAt());
    }

    public String getTenantId(String id) {
        return userDataRetrievalService.getTenantId(FeedbackSource.TWITTER, id);
    }

    @Override
    public FeedbackRecord processFeedback(Feedback feedback) {
        TwitterFeedback twitterFeedback = (TwitterFeedback) feedback;
        TwitterFeedbackMetadata metadata = new TwitterFeedbackMetadata(twitterFeedback.getCountry(), twitterFeedback.getPost(), twitterFeedback.getImageURL(), twitterFeedback.getShares(), twitterFeedback.getLikes());
        feedbackPersistenceService.saveFeedback(new FeedbackRecord(getUniqueFeedbackId(feedback), getTenantId(twitterFeedback.getUsername()), FeedbackType.POST, FeedbackSource.TWITTER, metadata ));
        return null;
    }
}
