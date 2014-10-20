package com.zgt.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T,ID extends Serializable> {
    
    public long count();

    public void delete(T entity) ;

    public void delete(ID id) ;

    public void delete(Iterable<T> entities);

    public  void deleteAll();

    public boolean exists(ID id);

    public List<T> findAll();

    public Iterable<T> findAll(Iterable<ID> ids);

//    public Page<T> findAll(Pageable pageable);
//
//    public List<T> findAll(Sort sort);

    public T findOne(ID id);

    public <S extends T> List<S> save(Iterable<S> entities);

    public <S extends T> S save(S entity);

}
