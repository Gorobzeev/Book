package com.company;


import java.io.*;
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

    public String toString(){
        return autor+";"+title+";"+year;
    }


    public static void main(String[] args) throws IOException {
        ArrayList <String> list = new ArrayList<String>();
        BufferedReader bufferedReader;
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

        for ( Book c : books){
            System.out.println(c);
        }

        File file = new File("D:/MyProjects/Book/newtext.txt");
        try {

            if(!file.exists()){
                file.createNewFile();
            }

            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                for (int y=0; y < books.size(); y++){
                    out.print(books.get(y)+"\n");
                }

            } finally {

                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

}
