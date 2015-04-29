package com.company;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Book {
    String autor;
    String title;
    int year;

    public Book(String s, String s1, int year) {
        this.autor = s;
        this.title = s1;
        this.year = year;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList <String> list = new ArrayList<String>();
        BufferedReader bufferedReader = null;
        try{
            FileReader fileReader = new FileReader("D:/MyProjects/Book/text.txt");
            bufferedReader = new BufferedReader(fileReader);
            while( true) {
                String str = bufferedReader.readLine();
                        if (str!=null){
                            list.add(str);
                        }
                        else break;
            }
            bufferedReader.close();

        }catch(Exception e){}
        for (int x = 0; x < list.size(); x++) {
            System.out.println(list.get(x));
        }

        ArrayList <Book> books = new ArrayList<Book>();
        for (int i=0; i < list.size(); i++){
            String [] parts = list.get(i).split(";");
            int year = Integer.parseInt(parts[2]);
            Book book = new Book(parts[0],parts[1],year);
            books.add(book);




        }
    }


}
