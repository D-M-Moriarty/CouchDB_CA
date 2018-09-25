package com.moriarty.couchdb_ca.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Date;

@JsonIgnoreProperties({"id", "revision"})
public class Post {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_rev")
    private String revision;
    private URL image;
    private String title;
    private String description;
    private String url;
    private int userId;
    private int subredditId;
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

    public URL getImage() {
        return image;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSubredditId() {
        return subredditId;
    }

    public void setSubredditId(int subredditId) {
        this.subredditId = subredditId;
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

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", revision='" + revision + '\'' +
                ", image=" + image +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", userId=" + userId +
                ", subredditId=" + subredditId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
