package com.example.feedbackbe.service.platform.factory;

import com.example.feedbackbe.model.user.DiscourseUser;
import com.example.feedbackbe.model.user.PlatformUser;
import com.example.feedbackbe.model.user.PlaystoreUser;
import com.example.feedbackbe.model.user.TwitterUser;
import org.springframework.stereotype.Service;

@Service
public class PlatformUserFactory {

    public PlatformUser convertToSpecificUser(PlatformUser platformUser) {
        if(platformUser instanceof PlaystoreUser) return (PlaystoreUser) platformUser;
        if(platformUser instanceof TwitterUser) return (TwitterUser) platformUser;
        if(platformUser instanceof DiscourseUser) return (DiscourseUser) platformUser;
        return platformUser;
    }

}
