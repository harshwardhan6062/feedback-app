package com.example.feedbackbe.service.factory;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.utils.DiscourseUtils;
import com.example.feedbackbe.utils.PlatformUtils;
import com.example.feedbackbe.utils.PlaystoreUtils;
import com.example.feedbackbe.utils.TwitterUtils;
import org.springframework.stereotype.Component;

@Component
public class PlatformUtilsFactory {

    private final PlaystoreUtils playstoreUtils;

    private final DiscourseUtils discourseUtils;

    private final TwitterUtils twitterUtils;

    public PlatformUtilsFactory(PlaystoreUtils playstoreUtils, DiscourseUtils discourseUtils, TwitterUtils twitterUtils) {
        this.playstoreUtils = playstoreUtils;
        this.discourseUtils = discourseUtils;
        this.twitterUtils = twitterUtils;
    }


    public PlatformUtils getPlatformUtilsFactory(FeedbackSource feedbackSource) {
        switch (feedbackSource) {
            case PLAYSTORE:
                return new PlaystoreUtils();
            case DISCOURSE:
                return new DiscourseUtils();
            case TWITTER:
                return new TwitterUtils();
        }
        throw new IllegalArgumentException("Invalid feedback source: " + feedbackSource);
    }


}
