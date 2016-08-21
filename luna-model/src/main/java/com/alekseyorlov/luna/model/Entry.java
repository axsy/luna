package com.alekseyorlov.luna.model;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "entries")
public class Entry {

    public enum Status {
        PUBLISHED,
        NOT_PUBLISHED,
        DRAFT,
        TIMED_PUBLISH
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private User owner;

    @NotNull
    private Status status;

    @NotNull
    private String title;

    @NotNull
    private String slug;

    @ManyToOne(optional = false)
    private EntryType type;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_id")
    private List<Element> elements;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn(name = "order_id")
    private List<Taxonomy> taxonomies;

    @NotNull
    private Instant createdAt;

    private Instant updatedAt;

    private Instant publishedAt;

    private Instant depublishedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public EntryType getType() {
        return type;
    }

    public void setType(EntryType type) {
        this.type = type;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public List<Taxonomy> getTaxonomies() {
        return taxonomies;
    }

    public void setTaxonomies(List<Taxonomy> taxonomies) {
        this.taxonomies = taxonomies;
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

    public Instant getDepublishedAt() {
        return depublishedAt;
    }

    public void setDepublishedAt(Instant depublishedAt) {
        this.depublishedAt = depublishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!owner.equals(entry.owner)) return false;
        if (!title.equals(entry.title)) return false;
        return createdAt.equals(entry.createdAt);

    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + createdAt.hashCode();
        return result;
    }
}
