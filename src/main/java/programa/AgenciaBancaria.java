package programa;

import java.util.ArrayList;
import java.util.Scanner;

/*Essa classe simula o funcionamento de uma agência bancária. Ele permite criar contas bancárias,
 realizar operações como depósito, saque e transferência, listar as contas cadastradas e sair da agência.
 */
public class AgenciaBancaria {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    /*O método operacoes() é responsável por exibir o menu de operações disponíveis e lidar com a seleção do usuário.*/
    public static void operacoes() {

        System.out.println("----------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência-------------");
        System.out.println("----------------------------------------------------");
        System.out.println("****** Selecione a operação que deseja realizar*****");
        System.out.println("|  Opção 1 - Criar conta  |");
        System.out.println("|  Opção 2 - Depositar    |");
        System.out.println("|  Opção 3 - Sacar        |");
        System.out.println("|  Opção 4 - Transferir   |");
        System.out.println("|  Opção 5 - Listar       |");
        System.out.println("|  Opção 6 - Sair         |");

        int operacao = teclado.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigada por ultilizar nossa Agência Bancaria!");
                System.exit(0);

            default:
                System.out.println("Opção invalida!");
                operacoes();
                break;
        }
    }

    /*O método criarConta() solicita ao usuário informações como nome, CPF e email para criar uma nova conta.
    Ele cria um objeto Cliente com essas informações e, em seguida, cria uma nova conta com o cliente fornecido.
    A conta é adicionada à lista de contas bancárias.*/
    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = teclado.next();

        System.out.println("\nCPF: ");
        String cpf = teclado.next();

        System.out.println("\nEmail: ");
        String email = teclado.next();

        Cliente cliente = new Cliente(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Conta criada com sucesso!");

        operacoes();
    }

    /*O método buscarConta() recebe o número da conta como argumento e retorna a conta correspondente,
     caso seja encontrada na lista de contas bancárias.
     */
    private static Conta buscarConta(int numemoConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numemoConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }

    /*O método depositar() solicita ao usuário o número da conta e o valor a ser depositado.
     Ele encontra a conta correspondente e chama o método depositar() da classe Conta para realizar o depósito.
     */
    public static void depositar() {
        System.out.println("Numero da conta: ");
        int numeroConta = teclado.nextInt();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual valor deseja depositar?");
            Double valorDeposito = teclado.nextDouble();
            conta.depositar(valorDeposito);
        } else {
            System.out.println("Conta não encontrada! ");
        }
        operacoes();
    }

    /*O método sacar() solicita ao usuário o número da conta e o valor a ser sacado.
     Ele encontra a conta correspondente e chama o método sacar() da classe Conta para realizar o saque.
     */
    public static void sacar() {
        System.out.println("Numero da conta ");
        int numeroConta = teclado.nextInt();

        Conta conta = buscarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual  valor deseja sacar?");
            Double valorSaque = teclado.nextDouble();
            conta.sacar(valorSaque);
        } else {
            System.out.println("Conta não encontrada!");
        }
        operacoes();
    }

    /*O método transferir() solicita ao usuário o número da conta remetente,
     o número da conta destinatária e o valor a ser transferido.
     Ele encontra as contas correspondentes e chama o método transferir() da classe Conta para realizar a transferência.
     */

    public static void transferir() {
        System.out.println("Numero da conta do remetente: ");
        int numeroContaRemetente = teclado.nextInt();

        Conta contaRemetente = buscarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Numero da conta do destinatario: ");
            int numeroContaDestinatario = teclado.nextInt();

            Conta contaDestinatario = buscarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Qual valor deseja transferir?");
                Double valor = teclado.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("Conta para deposito não encontrada!");
            }

        }else {
            System.out.println("Conta para transferência não encontrada!");
        }
        operacoes();
    }


    /*O método listarContas() verifica se há contas cadastradas na lista contasBancarias e, se houver,
     percorre a lista e exibe as informações de cada conta.
     */

    public static void listarContas() {
        if (contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                System.out.println(conta);
            }
        } else {
            System.out.println("Não há contas cadastradas!");
        }
        operacoes();
    }
}
