package com.alekseyorlov.luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

import static javax.persistence.FetchType.EAGER;

@Entity
@Table(name = "element_types")
public class ElementType {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @ElementCollection(fetch = EAGER)
    @MapKeyColumn(name = "name")
    @Column(name = "type")
    @CollectionTable(name = "elements_allowed_data")
    private Map<String, Class> allowedData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
