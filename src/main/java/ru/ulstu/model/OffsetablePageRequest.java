package ru.ulstu.model;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

public class OffsetablePageRequest implements Pageable, Serializable {
    private final int offset;
    private final int count;
    private final Sort sort;

    public OffsetablePageRequest(long offset, long count) {
        this(offset, count, Sort.by("id"));
    }

    public OffsetablePageRequest(long offset, long count, Sort.Direction direction, String... properties) {
        this(offset, count, new Sort(direction, properties));
    }

    public OffsetablePageRequest(long offset, long count, Sort sort) {
        if (offset < 0) {
            throw new IllegalArgumentException("Offset value must not be less than zero!");
        }
        if (count < 1) {
            throw new IllegalArgumentException("Count value must not be less than one!");
        }
        this.offset = (int) offset;
        this.count = (int) count;
        this.sort = sort;
    }

    @Override
    public Sort getSort() {
        return sort;
    }

    @Override
    public int getPageSize() {
        return count;
    }

    @Override
    public int getPageNumber() {
        return offset / count;
    }

    @Override
    public long getOffset() {
        return offset;
    }

    @Override
    public boolean hasPrevious() {
        return offset > 0;
    }

    @Override
    public Pageable next() {
        return new OffsetablePageRequest(getOffset() + getPageSize(), getPageSize(), getSort());
    }

    @Override
    public Pageable previousOrFirst() {
        return hasPrevious() ? previous() : first();
    }

    public Pageable previous() {
        return getOffset() == 0 ? this : new OffsetablePageRequest(getOffset() - getPageSize(), getPageSize(), getSort());
    }

    @Override
    public Pageable first() {
        return new OffsetablePageRequest(0, getPageSize(), getSort());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final OffsetablePageRequest other = (OffsetablePageRequest) obj;
        return this.offset == other.offset && this.count == other.count;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + offset;
        result = prime * result + count;
        return result;
    }
}
