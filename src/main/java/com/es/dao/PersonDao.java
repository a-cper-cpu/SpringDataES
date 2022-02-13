package com.es.dao;

import com.es.DO.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author a-cper-cpu
 * @date 2022-02-01-15:43
 */
@Repository
public interface PersonDao extends ElasticsearchRepository<Person, Long>{

}
