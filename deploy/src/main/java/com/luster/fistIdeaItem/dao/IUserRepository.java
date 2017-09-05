package com.luster.fistIdeaItem.dao;

import com.luster.fistIdeaItem.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by dell on 2017-9-4.
 */
public interface IUserRepository extends PagingAndSortingRepository<User, Long>, CrudRepository<User, Long> {
}
