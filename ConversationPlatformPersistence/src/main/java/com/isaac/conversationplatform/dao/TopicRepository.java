package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by isaac on 2016/09/07.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface TopicRepository extends CrudRepository<Topic,Long> {

}
