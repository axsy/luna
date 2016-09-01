package com.alekseyorlov.luna.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "entry_types")
public class EntryType {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    @NotNull
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(
        name = "entry_types_element_types",
        joinColumns = @JoinColumn(name = "element_type_id", referencedColumnName = "id"),
        inverseJoinColumns= @JoinColumn(name = "entry_type_id", referencedColumnName = "id")
    )
    private List<ElementType> elementTypes;

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

    public List<ElementType> getElementTypes() {
        return elementTypes;
    }

    public void setElementTypes(List<ElementType> elementTypes) {
        this.elementTypes = elementTypes;
    }
}
