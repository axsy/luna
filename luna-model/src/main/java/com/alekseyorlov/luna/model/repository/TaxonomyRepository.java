package com.alekseyorlov.luna.model.repository;

import com.alekseyorlov.luna.model.Taxonomy;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TaxonomyRepository extends CrudRepository<Taxonomy, Long> {

    List<Taxonomy> findByTypeIdAndNameIn(String id, Collection<String> name);

}
