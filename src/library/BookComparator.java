/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.Comparator;

/**
 * BookComparator that compares books
 *
 * @author Ashwith Gundu
 */
public class BookComparator implements Comparator<Book> {

    /**
     * This method compares two books by their editions returns the value
     * depending on the result of the comparison, returns -1 if the edition of
     * the book t is less than the edition of the book t1 returns 0 if the
     * editions are equals return 1 if above both conditions are failed
     *
     * @param b1 - book object passed of Book type
     * @param b2 - book object passed of Book type
     * @return - Integer (-1/0/1)
     */
    @Override
    public int compare(Book b1, Book b2) {

        if (b1.getEdition() < b2.getEdition()) {
            return -1;
        } else if (b1.getEdition() == b2.getEdition()) {
            return 0;
        } else {
            return 1;
        }

    }

}
