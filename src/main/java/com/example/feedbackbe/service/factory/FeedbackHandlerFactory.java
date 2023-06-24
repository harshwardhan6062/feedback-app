package com.example.feedbackbe.service.factory;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.service.feedback.handler.DiscourseFeedbackService;
import com.example.feedbackbe.service.feedback.handler.FeedbackHandler;
import com.example.feedbackbe.service.feedback.handler.PlaystoreFeedbackService;
import com.example.feedbackbe.service.feedback.handler.TwitterFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackHandlerFactory {

    private final DiscourseFeedbackService discourseFeedbackService;
    private final PlaystoreFeedbackService playstoreFeedbackService;

    private final TwitterFeedbackService twitterFeedbackService;

    @Autowired
    public FeedbackHandlerFactory(DiscourseFeedbackService discourseFeedbackService, PlaystoreFeedbackService playstoreFeedbackService, TwitterFeedbackService twitterFeedbackService) {
        this.discourseFeedbackService = discourseFeedbackService;
        this.playstoreFeedbackService = playstoreFeedbackService;
        this.twitterFeedbackService = twitterFeedbackService;
    }


    public FeedbackHandler getFeedbackHandler(FeedbackSource feedbackSource) {
        switch (feedbackSource) {
            case DISCOURSE:
                return this.discourseFeedbackService;
            case PLAYSTORE:
                return this.playstoreFeedbackService;
            case TWITTER:
                return this.twitterFeedbackService;
        }
        throw new IllegalArgumentException("Invalid feedback source: " + feedbackSource);
    }

}
