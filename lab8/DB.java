package lab8;

import java.sql.*;
import java.util.LinkedList;

class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    private void connect()throws NotConnected{
        try {
            for (int i=0; i<3; ++i) {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl:3306/pnocon", "pnocon", "tCpuCWH4wsvL4d5T");
                if (conn != null) break;
            }
        }
        catch (SQLException ex) {
            throw new NotConnected();
        }
        catch (Exception e){ e.printStackTrace(); }
    }

    LinkedList<Book> listNames()throws Exception{
        try {
            LinkedList<Book> ksiazki = new LinkedList<>();
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            Book book;
            while (rs.next()){
                String ISBN = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                book = new Book(ISBN,title,author,year);
                ksiazki.add(book);
            }
            return ksiazki;
        }
        finally {
            if (rs != null){
                try {
                    rs.close();
                }
                catch(SQLException ex){}
                rs = null;
            }
            if (stmt != null){
                try {
                    stmt.close();
                }
                catch(SQLException ex){}
                stmt = null;
            }
        }
    }

    LinkedList<Book> findByISBN(String ISBN_)throws Exception{
        try {
            LinkedList<Book> ksiazki = new LinkedList<>();
            Book book;
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE ISBN='" + ISBN_ + "'");
            while (rs.next()){
                String ISBN = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                book = new Book(ISBN,title,author,year);
                ksiazki.add(book);
            }
            return ksiazki;
        }
        finally {
            if (rs != null){
                try {
                    rs.close();
                }
                catch(SQLException ex){}
                rs = null;
            }
            if (stmt != null){
                try {
                    stmt.close();
                }
                catch(SQLException ex){}
                stmt = null;
            }
        }
    }

    LinkedList<Book> findByAuthor(String aut)throws Exception{
        try {
            connect();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books WHERE AUTHOR like '% "+ aut + "'");
            LinkedList<Book> ksiazki = new LinkedList<>();
            Book book;
            while (rs.next()){
                String ISBN = rs.getString(1);
                String title = rs.getString(2);
                String author = rs.getString(3);
                String year = rs.getString(4);
                book = new Book(ISBN,title,author,year);
                ksiazki.add(book);
            }
            return ksiazki;
        }
        finally {
            if (rs != null){
                try {
                    rs.close();
                }
                catch(SQLException ex){}
                rs = null;
            }
            if (stmt != null){
                try {
                    stmt.close();
                }
                catch(SQLException ex){}
                stmt = null;
            }
        }
    }

    void addBook(Book book)throws Exception {
        try {
            connect();
            stmt = conn.createStatement();
            String added = ("'"+book.ISBN+"'"+",'"+book.title+"','"+book.author+"',"+book.year);
            stmt.executeUpdate("INSERT INTO books VALUES ("+ added +");");
        }
        finally {
            if (stmt != null) {
                try {
                    stmt.close();
                }
                catch (SQLException ex) {
                }
                stmt = null;
            }
        }
    }
}
