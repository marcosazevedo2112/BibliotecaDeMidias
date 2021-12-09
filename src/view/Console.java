package view;

import controller.BibliotecaController;
import controller.MidiasController;
import model.CD;
import model.DVD;
import model.Midia;

import java.util.Random;
import java.util.Scanner;

public class Console {
    Scanner input = new Scanner(System.in);
    Random rdm = new Random();
    MidiasController controller = new MidiasController();
    BibliotecaController bibliotecaController = new BibliotecaController(controller,"biblioteca.txt");

    public void inicia() {

        System.out.println("Bem vindo ao gerenciador de midias v2000");
        while (true) {
            System.out.println("Temos as seguintes opções:");
            System.out.println(" 1    Cadastrar uma midia");
            System.out.println(" 2    Excluir uma midia");
            System.out.println(" 3    Pesquisar por uma midia");
            System.out.println(" 4    Ver todas as midias cadastradas");
            System.out.println(" 5    Salvar biblioteca");
            System.out.println(" 6    Carregar biblioteca");
            System.out.println(" -1   Sair");
            System.out.println("O que deseja fazer?");
            int opcao = input.nextInt();
            input.nextLine();
            if (opcao == -1) {
                System.out.println("Até outro dia!");
                return;
            }
            switch (opcao) {
                case 1: {
                    cadastrarMidia();
                    break;
                }
                case 2: {
                    removerMidia();
                    break;
                }
                case 3: {
                    pesquisarMidia();
                    break;
                }
                case 4: {
                    verTodasMidias();
                    break;
                }
                case 5:{
                    salvaBilicoteca();
                    break;
                }
                case 6:{
                    carregarBiblioteca();
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }

    private void cadastrarMidia() {
        System.out.println("Você selecionou: 1 - Cadastrar uma midia");
        while (true) {
            System.out.println("Essa midia é um:");
            System.out.println(" 1    DVD");
            System.out.println(" 2    CD");
            System.out.println("Digite o numero da sua opção(1/2): ");
            int tipo = input.nextInt();
            input.nextLine();
            if (tipo == 1) {
                String nome;
                double preco;
                String sinopse;

                //Criando DVD
                System.out.println("Você selecionou: 1 - DVD");
                System.out.println("Digite o nome do DVD: ");
                nome = input.nextLine();
                if (validaStr(nome)){
                    System.out.println("O nome que você digitou não é valido, por favor recomece o cadastramento");
                }
                System.out.println("Digite o preco do DVD usando pontos(ex: 9.99): ");
                preco = input.nextDouble();
                input.nextLine();
                System.out.println("Digite uma breve sinopse(uma linha) do DVD: ");
                sinopse = input.nextLine();
                if (validaStr(sinopse)){
                    System.out.println("A sinopse que você digitou não é valida, por favor recomece o cadastramento(Não pode conter '\\n' ou '-!-')");
                }

                DVD dvd = new DVD(rdm.nextInt(999999), preco, nome, sinopse);
                controller.cadastrar(dvd);
                System.out.println("DVD adicionado!");
                break;
            } else if (tipo == 2) {
                String nome;
                double preco;
                int nFaixas = 0;

                //Criando CD
                System.out.println("Você selecionou: 1 - CD");
                System.out.println("Digite o nome do CD: ");
                nome = input.nextLine();
                System.out.println("Digite o preco do CD usando pontos(ex: 9.99): ");
                preco = input.nextDouble();
                input.nextLine();
                System.out.println("Numeros de faixas do CD:");
                input.nextInt();
                input.nextLine();

                CD dvd = new CD(rdm.nextInt(999999), preco, nome, nFaixas);
                controller.cadastrar(dvd);
                System.out.println("CD adicionado!");
                break;
            } else {
                System.out.println("Não entendemos a sua escolha, tente novamente");
                continue;
            }
        }
    }

    private void removerMidia() {
        System.out.println("Você selecionou: 2 - Remover uma midia");
        System.out.println("Digite o codigo da midia a ser deletada(caso o codigo seja " +
                "invalido, a operação será cancelada):");
        int cod = input.nextInt();
        input.nextLine();
        Midia midia = null;
        try {
            midia = controller.pesquisa(cod);
        } catch (Exception e) {
            System.out.println("O codigo indicado não é pertence a nenhuma midia ou não é valido, operação cancelada");
            System.out.println("error: " + e);
            return;
        }
        System.out.println("Tem certeza que deseja excluir '" + midia.getNome() + "' (S/N)?");
        String confirmacao = input.nextLine();
        if (confirmacao.equals("s") || confirmacao.equals("S") || confirmacao.equals("sim") || confirmacao.equals("SIM")) {
            controller.excluir(cod);
            System.out.println("Midia excluida!");
        } else {
            System.out.println("Operação cancelada");
        }
        return;
    }

    private void pesquisarMidia() {
        System.out.println("Você selecionou: 3 - Pesquisar uma midia");
        System.out.println("Digite o codigo da midia a ser pesquisada(caso o codigo seja " +
                "invalido, a operação será cancelada):");
        int cod = input.nextInt();
        input.nextLine();
        Midia midia = null;
        try {
            midia = controller.pesquisa(cod);
        } catch (Exception e) {
            System.out.println("O codigo indicado não é pertence a nenhuma midia ou não é valido, operação cancelada");
            return;
        }
        System.out.println("Midia encontrada!");
        System.out.println("Tipo: " + midia.getTipo());
        System.out.println("Detalhes: " + midia.getDetalhes());
        return;
    }

    private void verTodasMidias() {
        System.out.println("Você selecionou: 4 - Ver todas as midias cadastradas");
        System.out.println("Tipo -!- Nome -!- Preço -!- Codigo -!- Sinopse/Nfaixas");
        Midia itens[] = controller.listarTodas();
        for (Midia midia : itens) {
            System.out.println(midia.getTipo() + " -!- " + midia.getDetalhes());
        }
    }

    private void salvaBilicoteca(){
        System.out.println("Você selecionou: 5 - Salvar e sobrescrever a biblioteca");
        System.out.println("Ao fazer isso você ira substituir todos os dados salvos em 'biblioteca.txt', " +
                "\nTem certazq eu deseja fazer isso?(S/N)");
        String confirmacao = input.nextLine();
        if (confirmacao.equals("s") || confirmacao.equals("S") || confirmacao.equals("sim") || confirmacao.equals("SIM")) {
            try{
                bibliotecaController.sobrescreveArquivo();
                System.out.println("Biblioteca atualizada!");
                return;

            }catch(Exception e){
                System.out.println("Operação cancelada por erro interno");
                System.out.println("Erro: " + e);
            }
        }else{
            System.out.println("Operação cancelada");
        }
    }

    private void carregarBiblioteca(){
        System.out.println("Você selecionou: 5 - Carregar a biblioteca");
        System.out.println("Ao fazer isso você ira substituir todos os dados atuais pelos dados salvos em 'biblioteca.txt', " +
                "\nTem certazq eu deseja fazer isso?(S/N)");
        String confirmacao = input.nextLine();
        if (confirmacao.equals("s") || confirmacao.equals("S") || confirmacao.equals("sim") || confirmacao.equals("SIM")) {
            try{
                Midia[] itens = bibliotecaController.leArquivo();
                controller.carregarMidias(itens);
                controller.carregarTamanho(itens.length);
                System.out.println("Biblioteca carregada!");
                System.out.println("Sua biblioteca agora é: ");
                System.out.println("Tipo | Nome | Preço | Codigo | sinopse/nfaixas");
                for (Midia midia:itens) {
                    System.out.println(midia.getDetalhes());
                }
                return;

            }catch(Exception e){
                System.out.println("Operação cancelada por erro interno");
                System.out.println("Erro: " + e);
            }
        }else{
            System.out.println("Operação cancelada");
        }
    }

    private boolean validaStr(String str){
        return (str.contains("-!-") || str.contains("\n"));
    }
}
