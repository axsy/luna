package com.alekseyorlov.luna.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`taxonomies`", indexes = {
        @Index(columnList = "name", name = "idx_taxonomies_name")
})
public class Taxonomy implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "taxonomies")
    private List<Entry> entries;

    @ManyToOne(optional = false)
    private TaxonomyType type;

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
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
