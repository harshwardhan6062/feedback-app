
Models:

1. Platform -> Twitter, Playstore, Discourse
2. Tenant -> Common across the App
3. PlatformUser -> A tenant can have multiple PlatformUsers. PlatformUser is specific to platform.
4. Feedback -> DiscourseFeedback, PlaystoreFeedback (Feedback received from platform)
5. FeedbackRecord -> Unified record
6. FeedbackMetaData -> Property of FeedbackRecord (Platform related properties)
7. FeedbackSource -> Twitter, Playstore, Discourse
8. FeedbackType -> Rating, Post, Conversation



Services:

1. DataPull Service Package: Services used for pulling and handling the data
2. Feedback Service Package: Services used for handling and persisting data
3. Platform Service Package: Services used for operations of platform user (Registration, Removal, Data Retrieval)
4. Tenant Service Package: Services used for operations of tenant (Registration, Removal, Data Retrieval)


Repository:

1. FeedbackDAO: For storing feedbacks
2. PlatformUserDAO: For storing user for a platform with all details like auth_key, username
3. TenantDAO: For storing data of tenant like name, email

Client: 

1. Platform: PlatformUserClient: Client for all operation on platform user (Registration, Removal, Data Retrieval)
2. Source: Platform Specific Clients which have 2 methods (pullData, handleReceivedData)
3. Tenant: Client for operations on tenant (Registration, Removal, Data Retieval)


For adding a new tenant, all we got to do is:
1. Register the tenant if not registered or use an existing tenant (Tenant)
2. Add user to the platforms needed with all the needed information (PlatformUser)
3. Now the client can pull data and handleReceiveData as it is added to out platformUsers.


For adding a new source, all we got to do is:
1. Create a client in client/source
2. Add Source to FeedbackSource enum
3. Implement HandleFeedbackClient / PullFeedbackClient or both
4. Create SourceFeedbackService class in service/feedback/handler and implement the FeedbackHandler class
5. Write down the processFeedback function
6. For PullFeedback, create SourcePullAndHandleServiceImpl implementing DataPullAndHandleService
7. Write down the pullAndHandleDataFromSource function

How does our app:

1. Maintain idempotency: When we look at our processFeedback function from different sources, we see that the ID
                         used to save the feedback is always a combination of fields from the feedback.
                         Ex: DiscourseFeedback -> feedbackID#username#createdAt (feedbackId is the ID provided by source)
                         (Here assuming that feedbackID for 2 same feedbacks is same, in case not we can use other differentiator)

2. Supporting multiple feedback sources of the same type for a tenant:
   In our app, one tenant can have multiple platformIDs. That means, if a tenant says I want data from 2 different apps from
   playstore, we can simply create 2 different platformUsers with the same tenantID. Both of these platformUsers will have 
   app specific data (like appID, authKey etc), and so for the same tenant, we can store feedbacks from multiple sources of same type.




Changes Integrated:

1. I have removed pullFeedbackAndHandle for each source and replaced it with a common handler class.
2. I have created 2 type of feedback records: ReviewFeedbackRecord and PostFeedbackRecord (Considering there are only two feedback types for now: REVIEW and POST)





