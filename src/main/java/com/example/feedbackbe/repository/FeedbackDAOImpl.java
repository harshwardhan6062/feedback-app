package com.example.feedbackbe.repository;

import com.example.feedbackbe.model.user.FeedbackTypeRecord.FeedbackRecord;
import com.example.feedbackbe.model.FeedbackSource;
import com.example.feedbackbe.model.FeedbackType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FeedbackDAOImpl implements FeedbackDAO{
    private List<FeedbackRecord> records;

    public FeedbackDAOImpl() {
        records = new ArrayList<>();
    }

    public void addFeedback(FeedbackRecord feedbackRecord) {
        records.add(feedbackRecord);
    }

    @Override
    public FeedbackRecord getFeedbackById(String id) {
        Optional<FeedbackRecord> feedback = records.stream().filter(record -> record.getFeedbackID() == id).findFirst();
        if(feedback.isPresent()) return feedback.get();
        return null;
    }

    @Override
    public List<FeedbackRecord> getFeedbackByTenant(String tenantId) {
        return records.stream().filter(record -> record.getTenantId() == tenantId).toList();
    }

    @Override
    public List<FeedbackRecord> getFeedbackBySource(FeedbackSource feedbackSource) {
        return records.stream().filter(record -> record.getFeedbackSource() == feedbackSource).toList();
    }

    @Override
    public List<FeedbackRecord> getFeedbackRecordByType(FeedbackType feedbackType) {
        return records.stream().filter(record -> record.getFeedbackType() == feedbackType).toList();
    }

}
