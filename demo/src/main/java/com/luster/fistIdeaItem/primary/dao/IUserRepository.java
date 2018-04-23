package com.luster.fistIdeaItem.primary.dao;

import com.luster.fistIdeaItem.primary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 2017-9-4.
 */
public interface IUserRepository extends JpaRepository<User, Long> {
}
