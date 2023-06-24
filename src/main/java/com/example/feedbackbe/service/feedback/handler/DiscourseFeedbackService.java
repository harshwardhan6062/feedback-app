package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.feedback.PlaystoreFeedback;
import com.example.feedbackbe.model.user.FeedbackTypeRecord.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.metadata.DiscourseFeedbackMetadata;
import com.example.feedbackbe.model.user.FeedbackTypeRecord.PostFeedbackRecord;
import com.example.feedbackbe.service.feedback.persistence.FeedbackPersistence;
import com.example.feedbackbe.service.platform.info.UserDataRetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscourseFeedbackService implements FeedbackHandler {

    private FeedbackPersistence feedbackPersistence;

    private UserDataRetrievalService userDataRetrievalService;

    @Autowired
    public DiscourseFeedbackService(FeedbackPersistence feedbackPersistence, UserDataRetrievalService userDataRetrievalService) {
        this.feedbackPersistence = feedbackPersistence;
        this.userDataRetrievalService = userDataRetrievalService;
    }

    public String getUniqueFeedbackId(Feedback feedback) {
        DiscourseFeedback discourseFeedback = (DiscourseFeedback) feedback;
        return discourseFeedback.getId().concat("#").concat(discourseFeedback.getUsername()).concat(discourseFeedback.getCreatedAt());
    }

    public String getTenantId(String id) {
        return userDataRetrievalService.getTenantId(FeedbackSource.DISCOURSE, id);
    }


    @Override
    public void processFeedback(Feedback feedback) {
        DiscourseFeedback discourseFeedback = (DiscourseFeedback) feedback;
        PostFeedbackRecord postFeedbackRecord = new PostFeedbackRecord(getUniqueFeedbackId(feedback), getTenantId(discourseFeedback.getUsername()), FeedbackType.REVIEW, FeedbackSource.DISCOURSE, discourseFeedback.getContent(), discourseFeedback.getImageURL(), discourseFeedback.getLikes(), discourseFeedback.getShares(), discourseFeedback.getUsername(), discourseFeedback.getUsername(), discourseFeedback.getReads());
        feedbackPersistence.saveFeedback(postFeedbackRecord);
    }
}
