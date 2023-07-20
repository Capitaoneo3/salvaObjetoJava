import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;

public class App {

    public static void main(String[] args) throws Exception {

        ArrayList<Autor> autores = criarAutores();
        String fileLocation = "C:/Users/Administrator/Documents/projetosProgamacao/salvarObjetoBinario/objetoSalvo.txt";
        File arquivo = new File(fileLocation);
        byte[] binario = lerBinario(arquivo);
        Livro objeto = new Livro("maxxewl a enciclopédia", autores);

        try {
            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(objeto);
            out.close();
            fileOut.close();
            System.out.println("Objeto salvo com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        desserializacaoDoLivro(lerBinario(arquivo));

    }

    public static byte[] lerBinario(File arquivo) {

        try (FileInputStream inputStream = new FileInputStream(arquivo)) {
            byte[] binario = new byte[(int) arquivo.length()];
            inputStream.read(binario);
            return binario;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void desserializacaoDoLivro(byte[] binario) {
        byte[] serializedObject = binario;

        try (ByteArrayInputStream byteStream = new ByteArrayInputStream(serializedObject);
                ObjectInputStream objectStream = new ObjectInputStream(byteStream)) {

            Object objetoDesserializado = objectStream.readObject();

            // Faça o cast do objeto para o tipo correto
            if (objetoDesserializado instanceof Livro) {
                Livro livro = (Livro) objetoDesserializado;
                // Faça o que for necessário com o objeto Livro
                System.out.println(livro.getNome());
                for (int i = 0; i < livro.getAutores().size(); i++) {
                    System.out.println(livro.getAutores().get(i).getNome());
                }

            } else {
                System.out.println("O objeto desserializado não é do tipo Livro.");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Autor> criarAutores() {
        ArrayList<Autor> autores = new ArrayList<Autor>() {
            {
               add( new Autor("Joao"));
            };
        };
        return autores;

    }

}
