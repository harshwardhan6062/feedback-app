package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;
import com.example.feedbackbe.model.feedback.FeedbackTypeRecord.PostFeedbackRecord;
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
    public void processFeedback(Feedback feedback) {
        TwitterFeedback twitterFeedback = (TwitterFeedback) feedback;
        PostFeedbackRecord feedbackRecord = new PostFeedbackRecord(getUniqueFeedbackId(feedback), getTenantId(twitterFeedback.getUsername()), FeedbackType.POST, FeedbackSource.TWITTER, twitterFeedback.getPostContent(), twitterFeedback.getImageURL(), twitterFeedback.getLikes(), twitterFeedback.getShares(), twitterFeedback.getUsername(), twitterFeedback.getCreatedAt(), twitterFeedback.getReads());
        feedbackPersistenceService.saveFeedback(feedbackRecord);
    }
}
