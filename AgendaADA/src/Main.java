import java.nio.file.Files; // Biblioteca para manipulação de arquivos
import java.nio.file.Path; // Biblioteca para manipulação de caminhos de arquivos
import java.nio.file.Paths; // Biblioteca para criação de objetos Path
import java.io.IOException; // Verificação de erros na copilação
import java.util.InputMismatchException; //Verifica erro de inputs
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        verificaUserBase();
        verificaNumberBase();
        menuPrincipal();
    }

    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("");
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
        if (opcao == 1) {
            adicionarContato();
        } else if(opcao == 2){

        } else if(opcao == 3){

        } else {

        }
    }

    public static void adicionarContato() {
        Scanner scanner = new Scanner(System.in);

        // Obtém o caminho do diretório do projeto
        String diretorioProjeto = System.getProperty("user.dir");

        // Especifica os nomes dos arquivos
        String nomeArquivoBase = "userBase.txt";
        String nomeArquivoNumero = "userNumber.txt";

        // Cria os caminhos completos dos arquivos
        Path caminhoArquivoBase = Paths.get(diretorioProjeto, nomeArquivoBase);
        Path caminhoArquivoNumero = Paths.get(diretorioProjeto, nomeArquivoNumero);

        try {
            // Lê todos os IDs existentes
            List<Long> idsExistentes = Files.lines(caminhoArquivoBase)
                    .map(linha -> Long.parseLong(linha.split(",")[0]))
                    .collect(Collectors.toList());

            // Encontra o próximo ID disponível
            long novoId;
            do {
                // Solicita o ID ao usuário
                System.out.print("Digite o ID desejado: ");
                novoId = scanner.nextLong();
                scanner.nextLine(); // Consumir a quebra de linha pendente

                // Verifica se o ID já existe
                if (idsExistentes.contains(novoId)) {
                    System.out.println("Este ID já existe. Escolha outro.");
                }
            } while (idsExistentes.contains(novoId));

            // Solicita informações ao usuário
            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = scanner.nextLine();

            // Solicita o DDD
            System.out.print("Digite o DDD: ");
            int ddd = scanner.nextInt();

            // Consumir a quebra de linha pendente após nextInt()
            scanner.nextLine();

            // Verifica se o número com o mesmo DDD já existe
            List<String> numerosExistentesComDDD = Files.lines(caminhoArquivoNumero)
                    .filter(linha -> linha.contains("," + ddd + ","))
                    .collect(Collectors.toList());

            // Solicita o número de telefone
            String numeroTelefone = obterNumeroTelefone(scanner, numerosExistentesComDDD);

            // Adiciona informações ao arquivo userBase.txt
            String novoContatoBase = String.format("%d,%s,%s", novoId, nome, sobrenome);
            Files.write(caminhoArquivoBase, (novoContatoBase + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            // Adiciona informações ao arquivo userNumber.txt
            String novoContatoNumero = String.format("%d,%s,%s", novoId, ddd, numeroTelefone);
            Files.write(caminhoArquivoNumero, (novoContatoNumero + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);

            System.out.println("Contato adicionado com sucesso!");
            menuPrincipal();

        } catch (IOException e) {
            System.out.println("Erro ao ler ou escrever no arquivo: " + e.getMessage());
            menuPrincipal();
        }
    }

    private static String obterNumeroTelefone(Scanner scanner, List<String> numerosExistentesComDDD) {
        String numeroTelefone;
        boolean numeroValido;

        System.out.print("Digite o número de telefone: ");
        numeroTelefone = scanner.next();
        scanner.nextLine();

        // Verifica se o número com o mesmo DDD já existe
        final String numeroTelefoneFinal = numeroTelefone;
        numeroValido = !numerosExistentesComDDD.stream().anyMatch(linha -> linha.endsWith("," + numeroTelefoneFinal));

        if (!numeroValido) {
            System.out.println("Já existe um número de telefone com o mesmo DDD. Tente outro número.");
            menuPrincipal();
        }

        return numeroTelefone;
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
            System.out.println("system@agenda: Base de dados 1 carregada!");
        } else {
            //System.out.println("O arquivo " + caminhoArquivo + " NÃO existe no diretório do projeto. Criando...");
            try {
                // Cria o arquivo
                Files.createFile(caminhoArquivo);
                //System.out.println("Arquivo criado com sucesso!");
                System.out.println("system@agenda: Base de dados 1 criada! " + caminhoArquivo);
            } catch (IOException e) {
                System.out.println("system@agenda: Erro ao criar o arquivo: " + e.getMessage());
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
            System.out.println("system@agenda: Base de dados 2 carregada!");
            System.out.println("");
        } else {
            //System.out.println("O arquivo " + caminhoArquivo + " NÃO existe no diretório do projeto. Criando...");
            try {
                // Cria o arquivo
                Files.createFile(caminhoArquivo);
                System.out.println("system@agenda: Base de dados 2 criada! " + caminhoArquivo);
            } catch (IOException e) {
                System.out.println("system@agenda: Erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

}