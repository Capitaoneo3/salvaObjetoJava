package salvaObjetoEclipse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Livro implements Serializable {
    // Atributos e métodos da classe
    private String nome;
    private ArrayList<Autor> autores;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public Livro(String nome, ArrayList<Autor> autores) {
        this.nome = nome;
        this.autores = autores;
    }

    public Livro() {
    }
}