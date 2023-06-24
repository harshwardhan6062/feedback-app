package com.example.feedbackbe.service.factory;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.feedback.DiscourseFeedback;
import com.example.feedbackbe.model.feedback.Feedback;
import com.example.feedbackbe.model.feedback.PlaystoreFeedback;
import com.example.feedbackbe.model.feedback.TwitterFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FeedbackFactory {

    private final DiscourseFeedback discourseFeedback;
    private final PlaystoreFeedback playstoreFeedback;
    private final TwitterFeedback twitterFeedback;

    @Autowired
    public FeedbackFactory(DiscourseFeedback discourseFeedback, PlaystoreFeedback playstoreFeedback, TwitterFeedback twitterFeedback) {
        this.discourseFeedback = discourseFeedback;
        this.playstoreFeedback = playstoreFeedback;
        this.twitterFeedback = twitterFeedback;
    }


    public Feedback getFeedback(FeedbackSource feedbackSource) {
        switch (feedbackSource) {
            case DISCOURSE:
                return this.discourseFeedback;
            case PLAYSTORE:
                return this.playstoreFeedback;
            case TWITTER:
                return this.twitterFeedback;
        }
        throw new IllegalArgumentException("Invalid feedback source: " + feedbackSource);
    }

}
