package com.isaac.conversationplatformpersistence.dao.generic.impl;

import java.io.Serializable;
import com.isaac.conversationplatformpersistence.dao.generic.GenericDao;

/**
 * Created by isaac on 2016/09/19.
 */
public class GenericDaoImpl<T, P extends Serializable> implements GenericDao<T, P> {

    @Override
    public P create(T newInstance) {
        return null;
    }

    @Override
    public T read(P id) {
        return null;
    }

    @Override
    public void update(T transientObject) {

    }

    @Override
    public void delete(T persistentObject) {

    }
}
