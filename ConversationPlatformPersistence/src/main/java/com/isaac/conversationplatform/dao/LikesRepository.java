package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Like;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by isaac on 2016/10/08.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface LikesRepository extends CrudRepository<Like, Long> {
}
