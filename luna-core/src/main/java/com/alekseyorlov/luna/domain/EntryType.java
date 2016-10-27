package com.alekseyorlov.luna.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`entry_types`")
public class EntryType implements Serializable {

    @Id
    private String id;

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

    public List<ElementType> getElementTypes() {
        return elementTypes;
    }

    public void setElementTypes(List<ElementType> elementTypes) {
        this.elementTypes = elementTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EntryType entryType = (EntryType) o;

        if (!getTitle().equals(entryType.getTitle())) return false;
        return getElementTypes().equals(entryType.getElementTypes());

    }

    @Override
    public int hashCode() {
        int result = getTitle().hashCode();
        result = 31 * result + getElementTypes().hashCode();
        return result;
    }
}
