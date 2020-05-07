package ru.ulstu.service;

import ru.ulstu.model.PageableItems;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    T create(T t);

    List<T> findAll();

    T get(Integer id);

    Optional<T> find(Integer id);

    PageableItems<T> findAll(int offset, int count);

    T update(T t);

    void delete(T t);
}
