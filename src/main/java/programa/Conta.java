package programa;

import ultilitarios.Utils;

/* Essa é uma classe representa uma conta bancária.
 Ela possui atributos para o número da conta, o cliente associado à conta e o saldo disponível.
 Ela também possui métodos para depositar, sacar e transferir valores entre contas.*/
public class Conta {

    private static int contadorContas = 1;
    private int numeroConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    /*O construtor Conta recebe um objeto Cliente como parâmetro e é responsável por criar uma conta nova.
    Ele atribui o número da conta (baseado no contador de contas) e associa o cliente fornecido à conta.
     */
    public Conta(Cliente cliente) {
        this.numeroConta = contadorContas;
        this.cliente = cliente;
        contadorContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /*Esse método retorna uma string que representa os detalhes da conta bancária.*/

    @Override
    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF:  " + this.cliente.getCpf() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        } else {
            System.out.println("Não foi possivél realizar o deposito!");
        }
    }
    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possivél realizar o deposito!");
        }
    }

    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        }
    }
}
