package com.alekseyorlov.luna.model;

import javax.persistence.*;

@Entity
@Table(name = "`taxonomies`")
public class Taxonomy {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private Entry entry;

    @ManyToOne(optional = false)
    private TaxonomyType type;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public TaxonomyType getType() {
        return type;
    }

    public void setType(TaxonomyType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
