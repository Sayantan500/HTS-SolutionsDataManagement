package com.helpdesk_ticketing_system.solutions_data_management.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

public class SolutionDocument {
    @JsonProperty("solution_id") @MongoId(value = FieldType.STRING)
    private String _id;
    @JsonProperty("ticket_id") private String ticketId;
    @JsonProperty("issue_id") private String issueId;
    @JsonProperty("solution") private Solution solution;
    @JsonProperty("posted_on") private Long postedOn;

    public SolutionDocument() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public Long getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Long postedOn) {
        this.postedOn = postedOn;
    }
}
