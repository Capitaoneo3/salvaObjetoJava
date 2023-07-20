import java.io.Serializable;

public class Autor implements Serializable{
        private String nome;

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor(String nome) {
        this.nome = nome;
    }

}
