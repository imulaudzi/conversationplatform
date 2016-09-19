package com.isaac.conversationplatformpersistence.dao.generic;

import java.io.Serializable;

/**
 * Created by isaac on 2016/09/19.
 */
public interface GenericDao<T, P extends Serializable> {

    P create(T newInstance);

    T read(P id);

    void update(T transientObject);

    void delete(T persistentObject);

}
