package com.isaac.conversationplatform.dao;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.isaac.conversationplatform.dao.model.Comment;
import org.hibernate.engine.spi.PersistenceContext;
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



/**
 * Created by isaac on 2016/10/08.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-convo-persistence-config.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class
})
//@DatabaseSetup("dataset.xml")
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void findbyCommentId(){
        Comment searchResults = repository.findOne(123L);
        Assert.assertNotNull(searchResults);

    }
}
