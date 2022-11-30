package com.example.library.data;

import com.example.library.view.MainActivity;

import java.util.ArrayList;

public class Book extends MainActivity {
    private String id;
    private String titulo;
    private String descripcion;
    private String genero;
    private int pageNum;
    private int copies;
    private String urlImg;
    private ArrayList<String> characters;

    public Book() {
    }

    public Book(String id, String titulo, String descripcion, String genero, int pageNum, int copies, String urlImg, ArrayList<String> characters) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.genero = genero;
        this.pageNum = pageNum;
        this.copies = copies;
        this.urlImg = urlImg;
        this.characters =characters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public void setCharacters(ArrayList<String> characters) {
        this.characters = characters;
    }
}
