package com.supero.tasklist.persistencia;

/**
 * Created by christian.tusset on 12/03/2018.
 */

import java.util.List;

import com.supero.tasklist.entidade.Tasklist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ITasklist extends CrudRepository<Tasklist, Long> {

	  List<Tasklist> findByTitle(String title);

}