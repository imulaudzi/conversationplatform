package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by isaac on 2016/10/08.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
