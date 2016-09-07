package com.alekseyorlov.luna.model.repository;

import com.alekseyorlov.luna.model.Element;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface ElementRepository extends CrudRepository<Element, Long>{

    List<Element> findByEntryIdAndTypeIdIn(Long entryId, Collection<String> typeIds);

}
