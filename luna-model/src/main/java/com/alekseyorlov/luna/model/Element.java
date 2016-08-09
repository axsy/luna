package com.alekseyorlov.luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "elements")
public class Element {

    private static final long serialVersionUID = 1L;

    public enum Type {
        TEXT,
        MARKDOWN,
    }

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Type type;

    @ElementCollection(fetch = EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "elements_data")
    private Map<String, String> data;

    @ManyToOne(optional = false)
    private Entry entry;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

}
