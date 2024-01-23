import java.nio.file.Files; // Biblioteca para manipulação de arquivos
import java.nio.file.Path; // Biblioteca para manipulação de caminhos de arquivos
import java.nio.file.Paths; // Biblioteca para criação de objetos Path
import java.io.IOException; // Verificação de erros na copilação
import java.util.InputMismatchException; //Verifica erro de inputs
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        verificaUserBase();
        menuPrincipal();
        verificaNumberBase();
    }

    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            limparConsole();
            System.out.println("##################");
            System.out.println("##### AGENDA #####");
            System.out.println("##################");
            getContatos();
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Sair");

            try {
                System.out.print("Digite uma opção: ");
                opcao = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Por favor, digite um número válido.");
                scanner.nextLine(); // Limpa o buffer do scanner
                opcao = 0; // Reinicializa a opção para evitar um loop infinito
            }

        } while (opcao <= 0 || opcao >= 5);
    }

    public static void getContatos(){
        System.out.println("");
        System.out.println(">>>> Contatos <<<<");
        System.out.println("Id | Nome ");
        processarContatos("userBase.txt");
        System.out.println("");
    }
    public static void processarContatos(String nomeArquivo) {
        try {
            // obtem o caminho do diretório do projeto
            String diretorioProjeto = System.getProperty("user.dir");

            // Cria um objeto Path com o caminho completo do arquivo
            Path caminhoArquivo = Paths.get(diretorioProjeto, nomeArquivo);

            // Lê todas as linhas do arquivo
            Files.lines(caminhoArquivo).forEach(linha -> {
                // Divide a linha em campos usando a vírgula como delimitador
                String[] campos = linha.split(",");
                // Verifica se a linha tem pelo menos três campos
                if (campos.length >= 3) {
                    // Concatena os três primeiros campos e imprime o resultado
                    String resultado = campos[0] + " | " + campos[1] + " " + campos[2];
                    System.out.println(resultado);
                }
            });
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
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

    public static void limparConsole() { System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); }

}