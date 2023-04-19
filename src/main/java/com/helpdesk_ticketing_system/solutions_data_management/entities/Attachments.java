package com.helpdesk_ticketing_system.solutions_data_management.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public class Attachments
{
    @JsonProperty("filename") @Field(name = "filename")
    private String filename;
    @JsonProperty("url") @Field(name = "url")
    private String fileUrl;

    public Attachments() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
