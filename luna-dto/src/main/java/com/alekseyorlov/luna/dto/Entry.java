package com.alekseyorlov.luna.dto;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public class Entry {

    private Long id;

    private String status;

    private String title;

    private String slug;

    private String type;

    private Map<String, List<String>> taxonomies;

    private Map<String, Map<String, String>> elements;

    private Instant createdAt;

    private Instant updatedAt;

    private Instant publishedAt;

    private Instant unpublishedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, List<String>> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(Map<String, List<String>> taxonomies) {
        this.taxonomies = taxonomies;
    }

    public Map<String, Map<String, String>> getElements() {
        return elements;
    }

    public void setElements(Map<String, Map<String, String>> elements) {
        this.elements = elements;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Instant publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Instant getUnpublishedAt() {
        return unpublishedAt;
    }

    public void setUnpublishedAt(Instant unpublishedAt) {
        this.unpublishedAt = unpublishedAt;
    }
}
