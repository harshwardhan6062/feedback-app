package com.example.feedbackbe.service.feedback.handler;

import com.example.feedbackbe.model.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.metadata.DiscourseFeedbackMetadata;
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
    public FeedbackRecord processFeedback(Feedback feedback) {
        DiscourseFeedback discourseFeedback = (DiscourseFeedback) feedback;
        DiscourseFeedbackMetadata metadata = new DiscourseFeedbackMetadata(discourseFeedback.getName(), discourseFeedback.getUsername(), discourseFeedback.getAvatar_template(), discourseFeedback.getCreatedAt(), discourseFeedback.getCooked(), discourseFeedback.getReads(), discourseFeedback.getReaders_count(), discourseFeedback.getScore());
        feedbackPersistence.saveFeedback(new FeedbackRecord(getUniqueFeedbackId(feedback), this.getTenantId(discourseFeedback.getUsername()), FeedbackType.CONVERSATION, FeedbackSource.DISCOURSE, metadata ));
        return null;
    }
}
