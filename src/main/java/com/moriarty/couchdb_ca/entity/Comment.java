package com.moriarty.couchdb_ca.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class Comment {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_rev")
    private String revision;
    private String content;
    private int userId;
    private int postId;
    private int subredditId;
    private int parentId;
    private Date createdAt;
    private Date updatedAt;

    @JsonProperty("_id")
    public String getId() {
        return id;
    }
    @JsonProperty("_id")
    public void setId(String id) {
        this.id = id;
    }
    @JsonProperty("_rev")
    public String getRevision() {
        return revision;
    }
    @JsonProperty("_rev")
    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(int subredditId) {
        this.subredditId = subredditId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
