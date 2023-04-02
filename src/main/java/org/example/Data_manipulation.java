package org.example;

import java.util.ArrayList;
import java.util.Random;

public class Data_manipulation {

    ArrayList<Book> Books;
    ArrayList<Person> People;
    public ArrayList<Person> Data_manipulation(Excel_names provider) {
        generatePeople(provider);
        generateData(provider);
        GiveBooksToPeople(People, Books);
        Person person = People.get(1);
        System.out.println(person.getBooks());
        ArrayList<Book> books = person.getBooks();
        for (Book book : books) {
            System.out.println(book.getTitle());
        }
        return People;
    }

    public void generateData(Excel_names provider){
        Book_factory factory;
        ArrayList<Book> BookList = new ArrayList<Book>();
        int i = 0;
        while (i<100){
            int R = i - (int)Math.floor(i/4)*4;
            switch (R) {
                case 0: {

                    factory = new RussianBookFactory(provider);
                    Fiction book = factory.createFiction();
                    book.generate_info();
                    BookList.add((Book) book);
                    break;
                }
                case 1: {

                    factory = new RussianBookFactory(provider);
                    BookList.add((Book) factory.createTextbook());
                    break;
                }

                case 2: {
                    factory = new EnglishBookFactory(provider);
                    BookList.add((Book) factory.createTextbook());
                    break;
                }

                case 3: {
                    factory = new EnglishBookFactory(provider);
                    Fiction book = factory.createFiction();
                    book.generate_info();
                    BookList.add((Book) book);
                    break;
                }
            }
            i++;
        }

        Books = BookList;
        Bookable book = Books.get(0);
        System.out.println((((Book) book)).getTitle());
        System.out.println(((Book) book).getAuthor());
    }

    public void generatePeople(Excel_names provider) {
        PeopleFactory factory = new PeopleFactory(provider);
        ArrayList<Person> people = new ArrayList<Person>();
        int i = 0;
        while (i < 100) {
            if (i % 2 == 0) {
                Person person = factory.createPerson("professor");
                people.add(person);
            } else {

                Person person = factory.createPerson("student");
                people.add(person);
            }
            i++;
        }
        People = people;
    }

    public void GiveBooksToPeople(ArrayList<Person> people, ArrayList<Book> books) {
        Random random = new Random();
        for (Person person : people) {
            ArrayList<Book> person_books = new ArrayList<Book>();
            int book_number = random.nextInt(8) + 3;
            for (int i = 0; i <= book_number; i++) {

                int n = random.nextInt(books.size());
                while (person_books.contains(books.get(n))){
                    n = random.nextInt(books.size());
                }
                person_books.add(books.get(n));
            }
            person.setBooks(person_books);

        }
    }

}
