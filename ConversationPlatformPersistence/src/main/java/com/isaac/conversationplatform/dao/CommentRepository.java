package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by isaac on 2016/10/08.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
