package com.example.library.data;

import com.example.library.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class BookList {

    private static ArrayList<Book> listBook;

    public static ArrayList<Book> getBooks(){
        if(listBook == null) listBook = new ArrayList<>();
        listBook.add(new Book("1", "It",
                "Cuenta la historia, en un juego de correspondencias con el pasado y el presente, de un grupo de siete amigos que son perseguidos por una entidad sobrenatural, al que llaman «Eso», que es capaz de cambiar de forma y se alimenta principalmente del terror que produce en sus víctimas.",
                "Terror",
                700,
                40,
                "https://quelibroleo.com/images/libros/libro-1504771595.jpg"));
        listBook.add(new Book("2", "Harry Potter",
                "Harry Potter es una serie de novelas fantásticas escrita por la autora británica J. K. Rowling, en la que se describen las aventuras del joven aprendiz de magia y hechicería Harry Potter y sus amigos Hermione Granger y Ron Weasley, durante los años que pasan en el Colegio Hogwarts de Magia y Hechicería.",
                "Fantasia",
                1300,
                23,
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ51vJ4dsWhl3EmO4GfZftrwQt4Yt3wJmH6r8cWPOtDFgiw3Ne0kF04i_hDWGjRF68SVVA&usqp=CAU"));
        listBook.add(new Book("3", "El principito",
                "El principito es una narración corta del escritor francés Antoine de Saint-Exupéry, que trata de la historia de un pequeño príncipe que parte de su asteroide a una travesía por el universo, en la cual descubre la extraña forma en que los adultos ven la vida y comprende el valor del amor y la amistad.",
                "Fantasia",
                340,
                56,
                "https://canallector.com/old-thumbs/978-84-9838-234-1_g.jpg"));
        listBook.add(new Book("4", "Juego de tronos",
                "Tras el largo verano, el invierno se acerca a los Siete Reinos. Lord Eddars Stark, señor de Invernalia, deja sus dominios para unirse a la corte del rey Robert Baratheon el Usurpador, hombre díscolo y otrora guerrero audaz cuyas mayores aficiones son comer, beber y engendrar bastardos. Eddard Stark desempeñará el cargo de Mano del Rey e intentará desentrañar una maraña de intrigas que pondrá en peligro su vida... y la de los suyos. En un mundo cuyas estaciones duran décadas y en el que retazos de una magia inmemorial y olvidada surgen en los rincones más sombrios y maravillosos, la traición y la lealtad, la compasión y la sed de venganza, el amor y el poder hacen del juego de tronos una poderosa trampa que atrapa en sus fauces a los personajes... y al lector.",
                "Fantasia",
                3120,
                43,
                "https://es.web.img3.acsta.net/pictures/19/03/22/10/08/5883111.jpg?coixp=50&coiyp=40"));

        return listBook;
    }

    public static void addBook(Book book){
        if(listBook == null) listBook = new ArrayList<>();
        listBook.add(book);
    }



}
