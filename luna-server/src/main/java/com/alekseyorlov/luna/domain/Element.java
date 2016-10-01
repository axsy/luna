package com.alekseyorlov.luna.domain;

import javax.persistence.*;
import java.util.Map;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "`elements`")
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
    @Lob
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        if (!getType().equals(element.getType())) return false;
        return getData() != null ? getData().equals(element.getData()) : element.getData() == null;

    }

    @Override
    public int hashCode() {
        int result = getType().hashCode();
        result = 31 * result + (getData() != null ? getData().hashCode() : 0);
        return result;
    }
}
