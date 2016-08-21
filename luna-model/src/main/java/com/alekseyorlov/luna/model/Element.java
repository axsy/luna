package com.alekseyorlov.luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "elements")
public class Element {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(optional = false)
    private ElementType type;

    @ManyToOne(optional = false)
    private Entry entry;

    @ElementCollection(fetch = EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "value")
    @CollectionTable(name = "elements_data")
    private Map<String, String> data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
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
