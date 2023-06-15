package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.user.PlatformUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PlatformUserDAOImpl implements PlatformUserDAO {

    private Map<FeedbackSource, Map<String, PlatformUser>> platformUsers;

    public PlatformUserDAOImpl() {
        platformUsers = new HashMap<>();
    }

    @Override
    public void createUser(FeedbackSource feedbackSource, String platformId, PlatformUser platformUser) {
        Map<String, PlatformUser> innerMap = this.platformUsers.getOrDefault(feedbackSource, new HashMap<>());
        innerMap.put(platformId, platformUser);
        this.platformUsers.put(feedbackSource, innerMap);
    }

    @Override
    public void removeUser(FeedbackSource feedbackSource, String platformId) {
        Map<String, PlatformUser> innerMap = this.platformUsers.get(feedbackSource);
        innerMap.remove(platformId);
        this.platformUsers.put(feedbackSource, innerMap);
    }

    @Override
    public String getTenantId(FeedbackSource feedbackSource, String platformId) {
        Map<String, PlatformUser> innerMap = this.platformUsers.get(feedbackSource);
        if(innerMap != null) {
            return innerMap.get(platformId).getTenantId();
        }
        return null;
    }

    @Override
    public Map<String, PlatformUser> getPlatformUsers(FeedbackSource feedbackSource) {
        return this.platformUsers.get(feedbackSource);
    }

}
