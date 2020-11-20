/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextbook.domain;

/**
 *
 * @author okkokuisma
 */
public class Book extends Clue {
    private String name;
    private String author;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

}
