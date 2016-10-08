package com.isaac.conversationplatform.dao;

import com.isaac.conversationplatform.dao.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by isaac on 2016/09/19.
 */
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

}
