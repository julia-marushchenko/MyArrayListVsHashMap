package com.mycollections;

import java.util.Objects;

/**
 *  Book class.
 */
public class Book {

    private String name;
    private int published;

    public Book(String name, int published) {
        this.name = name;
        this.published = published;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return published == book.published && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, published);
    }

    @Override
    public String toString() {
        return "Book{ " + name +  ", published in " + published + '}';
    }

}
