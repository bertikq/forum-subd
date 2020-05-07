package ru.ulstu.model;

import java.util.Collection;

public class PageableItems<T> {
    private final long count;
    private final Collection<T> items;

    public PageableItems(long count, Collection<T> items) {
        this.count = count;
        this.items = items;
    }

    public long getCount() {
        return count;
    }

    public Collection<T> getItems() {
        return items;
    }
}
