package com.luster.fistIdeaItem.secondary.dao;

import com.luster.fistIdeaItem.secondary.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 2017-9-4.
 */
public interface IPersonRepository extends JpaRepository<Person, Long> {
}
