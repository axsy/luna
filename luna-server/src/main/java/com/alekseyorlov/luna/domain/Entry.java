package com.alekseyorlov.luna.domain;

import com.alekseyorlov.luna.domain.listener.PublicationListener;
import com.alekseyorlov.luna.domain.listener.SlugListener;
import com.alekseyorlov.luna.domain.listener.annotation.Slug;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "`entries`")
@EntityListeners({
        AuditingEntityListener.class,
        SlugListener.class,
        PublicationListener.class
})
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
    @CreatedBy
    private User owner;

    @NotNull
    private Status status;

    @NotNull
    private String title;

    @NotNull
    @Slug(source = "title")
    private String slug;

    @ManyToOne(optional = false)
    private EntryType type;

    @OneToMany(mappedBy = "entry", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderColumn(name = "order_id")
    private List<Element> elements;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "entries_taxonomies",
            joinColumns = @JoinColumn(name = "entry_id", referencedColumnName = "id"),
            inverseJoinColumns= @JoinColumn(name = "taxonomy_id", referencedColumnName = "id")
    )
    private List<Taxonomy> taxonomies;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    private Instant publishedAt;

    private Instant unpublishedAt;

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
        for(Element element: elements) {
            element.setEntry(this);
        }
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

    public Instant getUnpublishedAt() {
        return unpublishedAt;
    }

    public void setUnpublishedAt(Instant unpublishedAt) {
        this.unpublishedAt = unpublishedAt;
    }

}
