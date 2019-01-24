package net.proselyte.springsecurityapp.mvc.service;

import java.util.List;

/**
 * Created by 38066 on 24.01.2019.
 */
public interface GenericService<T, ID> {

    void save(T t);

    void delete(ID id);

    List<T> getAll();

    T getById(ID id);

    void update(T t);
}
