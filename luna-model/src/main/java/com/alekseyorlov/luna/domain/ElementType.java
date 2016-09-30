package com.alekseyorlov.luna.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "`element_types`")
public class ElementType {

    @Id
    private String id;

    @NotNull
    private String title;

    @ElementCollection(fetch = EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "type")
    @CollectionTable(name = "elements_allowed_data")
    private Map<String, Class> allowedData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Class> getAllowedData() {
        return allowedData;
    }

    public void setAllowedData(Map<String, Class> allowedData) {
        this.allowedData = allowedData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementType that = (ElementType) o;

        if (!getTitle().equals(that.getTitle())) return false;
        return getAllowedData().equals(that.getAllowedData());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getAllowedData().hashCode();
        return result;
    }
}
