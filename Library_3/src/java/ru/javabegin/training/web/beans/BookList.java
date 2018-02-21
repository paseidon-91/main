/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.javabegin.training.web.beans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.javabegin.training.web.db.Database;

/**
 *
 * @author Alexp_000
 */
public class BookList {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    private ArrayList<Book> getBooks() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from book");
            while (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("name"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setPage_count(rs.getInt("page_count"));
                book.setPub(rs.getString("publisher_id"));
                book.setPublish_year(rs.getDate("publish_year"));
                bookList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return bookList;
    }

    public ArrayList<Book> getBookList() {
        if (!bookList.isEmpty()) {
            return bookList;
        } else {
            return getBooks();
        }
    }
}
