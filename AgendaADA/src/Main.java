import java.nio.file.Files; // Biblioteca para manipulação de arquivos
import java.nio.file.Path; // Biblioteca para manipulação de caminhos de arquivos
import java.nio.file.Paths; // Biblioteca para criação de objetos Path
import java.io.IOException; // Verificação de erros na copilação


public class Main {
    public static void main(String[] args) {
        verificaUserBase();
        menuPrincipal();
        verificaNumberBase();
    }

    public static void menuPrincipal(){
        System.out.println("##################");
        System.out.println("##### AGENDA #####");
        System.out.println("##################");
        getContatos();
        System.out.println(">>>> Menu <<<<");
        System.out.println("1 - Adicionar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Editar Contato");
        System.out.println("4 - Sair");
    }

    public static void getContatos(){
        System.out.println("");
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Em projeto");
        System.out.println("");
    }


    public static void verificaUserBase() {
        // especifica o nome do arquivo que queremos verificar
        String nomeArquivo = "userBase.txt";

        // obtem o caminho do diretório do projeto
        String diretorioProjeto = System.getProperty("user.dir");

        // cria um objeto Path com o caminho completo do arquivo
        Path caminhoArquivo = Paths.get(diretorioProjeto, nomeArquivo);

        // Verifica se o arquivo existe
        if (Files.exists(caminhoArquivo)) {
            //System.out.println("O arquivo " + caminhoArquivo + " existe no diretório do projeto.");
        } else {
            //System.out.println("O arquivo " + caminhoArquivo + " NÃO existe no diretório do projeto. Criando...");
            try {
                // Cria o arquivo
                Files.createFile(caminhoArquivo);
                //System.out.println("Arquivo criado com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    public static void verificaNumberBase() {
        // especifica o nome do arquivo que queremos verificar
        String nomeArquivo = "userNumber.txt";

        // obtem o caminho do diretório do projeto
        String diretorioProjeto = System.getProperty("user.dir");

        // cria um objeto Path com o caminho completo do arquivo
        Path caminhoArquivo = Paths.get(diretorioProjeto, nomeArquivo);

        // Verifica se o arquivo existe
        if (Files.exists(caminhoArquivo)) {
            //System.out.println("O arquivo " + caminhoArquivo + " existe no diretório do projeto.");
        } else {
            //System.out.println("O arquivo " + caminhoArquivo + " NÃO existe no diretório do projeto. Criando...");
            try {
                // Cria o arquivo
                Files.createFile(caminhoArquivo);
                //System.out.println("Arquivo criado com sucesso!");
            } catch (IOException e) {
                System.out.println("Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }
}