package com.guigu.spring;

public class Book {
    private String bookName;
    private String author;

    public Book() {
        System.out.println("Book创建完成");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
    public void myInit(){
        System.out.println("myInit Book构造成功");
    }

    public void destory(){
        System.out.println("Book销毁");
    }
}
