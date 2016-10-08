package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.Comment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import  com.github.springtestdbunit.DbUnitTestExecutionListener;

import javax.persistence.PersistenceContext;


/**
 * Created by isaac on 2016/10/08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceContext.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class
})
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void findbyCommentId(){
        Comment searchResults = repository.findOne(123L);
        Assert.assertNotNull(searchResults);

    }
}
