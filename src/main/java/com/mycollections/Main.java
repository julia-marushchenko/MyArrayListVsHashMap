/**
 *  Java program to compare how ArrayList and HashMap overwork 1_000_000 objects.
 */

package com.mycollections;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.*;

/**
 *  Main class.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) {

        // Storages.
        List<Book> booksList = new ArrayList<>();
        Map<String, Book> booksMap = new HashMap<>();

        // Generating 1_000_000 objects of Book and storing them in ArrayList and HashMap.
        for(int index = 0; index < 10; index++) {

            // Generating random name for a book.
            String generatedName = RandomStringUtils.randomAlphabetic(11);

            // Generating a random year of publishing.
            int generatedYear = (int) (Math.random() * 1000 + 500);

            // Creating a book instance.
            Book newBook = new Book(generatedName, generatedYear);

            // Adding book to storages bookList and BookMap.
            booksList.add(newBook);
            booksMap.put(generatedName, newBook);

        }

        // Printing all books from a list.
        System.out.println(booksList);

        // Printing all books from a map.
        System.out.println(booksMap);

        // Comparing time of searching for a book in two collections.

        // Book to search.
        Book book = booksList.getLast();
        String bookName = book.getName();

        // Search through the ArrayList.
        long start = System.nanoTime();
        System.out.println(get(booksList, bookName));
        long end = System.nanoTime();
        double listDuration = 1.0 * (end - start) / 1000000;

        // Search through the HashMap.
        start = System.nanoTime();
        System.out.println(booksMap.get(bookName));
        end = System.nanoTime();
        double mapDuration = 1.0 * (end - start) / 1000000;

        // Time of two searches.
        System.out.println("Search in the ArrayList was: " + listDuration + " milliseconds");
        System.out.println("Search in the HashMap was: " + mapDuration + " milliseconds");

    }

    // Method to find book in ArrayList.
    public static Book get(List<Book> list, String name) {
        for (Book book: list) {
            if(book.getName().equals(name));
            return  book;
        }

        return null;
    }
}