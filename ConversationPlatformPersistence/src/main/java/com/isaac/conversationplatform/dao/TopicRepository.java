package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by isaac on 2016/09/07.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    @Query("SELECT t from Topic t where t.duplicateHash =:duplicateHash")
    List<Topic> listByDuplicateHash(@Param("duplicateHash") String duplicateHash);

}
