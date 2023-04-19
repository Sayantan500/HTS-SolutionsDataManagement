package com.helpdesk_ticketing_system.solutions_data_management.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.LinkedList;
import java.util.List;

public class Solution
{
    @JsonProperty("message") @Field(name = "message")
    private String message;
    @JsonProperty("attachments") @Field(name = "attachments")
    private List<Attachments> attachments;

    public Solution() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Attachments> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachments> attachments) {
        this.attachments = new LinkedList<>(attachments);
    }
}
