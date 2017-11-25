package com.itla.mudat.repository;

import java.util.List;

/**
 * Created by maste on 11/20/2017.
 */

public interface Repository<T> {
    void add(T item);

    void add(Iterable<T> items);

    void update(T item);

    T get(Specification specification);

    void remove(T item);

    void remove(Specification specification);

    List<T> query(Specification specification);
}
