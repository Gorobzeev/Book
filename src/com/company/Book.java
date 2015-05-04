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



            File file = new File("D:/MyProjects/Book/newtext.txt");
            try {
                //проверяем, что если файл не существует то создаем его
                if(!file.exists()){
                    file.createNewFile();
                }

                //PrintWriter обеспечит возможности записи в файл
                PrintWriter out = new PrintWriter(file.getAbsoluteFile());

                try {
                    //Записываем текст у файл
                    for (int y=0; y < list.size(); y++){
                        out.print(list.get(y)+"\n");
                    }

                } finally {
                    //После чего мы должны закрыть файл
                    //Иначе файл не запишется
                    out.close();
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
