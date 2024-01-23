import java.nio.file.Files; // Biblioteca para manipulação de arquivos
import java.nio.file.Path; // Biblioteca para manipulação de caminhos de arquivos
import java.nio.file.Paths; // Biblioteca para criação de objetos Path
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        verificaNotepad();
    }

    public static void verificaNotepad() {
        // especifica o nome do arquivo que queremos verificar
        String nomeArquivo = "dbt.txt";

        // obtem o caminho do diretório do projeto
        String diretorioProjeto = System.getProperty("user.dir");

        // cria um objeto Path com o caminho completo do arquivo
        Path caminhoArquivo = Paths.get(diretorioProjeto, nomeArquivo);

        // Verifica se o arquivo existe
        if (Files.exists(caminhoArquivo)) {
            System.out.println("O arquivo " + caminhoArquivo + " existe no diretório do projeto.");
        } else {
            System.out.println("O arquivo " + caminhoArquivo + " NÃO existe no diretório do projeto. Criando...");

            try {
                // Cria o arquivo
                Files.createFile(caminhoArquivo);
                System.out.println("Arquivo criado com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }
}
