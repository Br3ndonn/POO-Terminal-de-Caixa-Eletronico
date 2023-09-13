package poo.gestaodecaixaeletronico;

import poo.gestaodecontas.*;

public class Caixa {
    private Terminal meuTerminal;
    private CadastroContas bdContas;
    private double saldo;

    public Caixa(Terminal terminal, CadastroContas bd) {
        this.meuTerminal = terminal;
        this.bdContas = bd;
    }
    
    public double consultaSaldo(int numeroDaConta, int senha) {
        Conta conta;
        conta = this.bdContas.buscaConta(numeroDaConta);
        if(conta != null) {
            return conta.varificaSaldo(senha);
        }else{
            return -1;
        }
    }
    
    public boolean efetuaSaque(int numeroDaConta, double valor, int senha) {
        if(valor < 0 || (valor % 50) != 0 || valor > 500 || valor > this.saldo) {
            return false;
        }
        Conta conta = bdContas.buscaConta(numeroDaConta);
        if(conta == null || !conta.debitaValor(valor, senha, "Saque automatico")) {
            return false;
        }
        this.liberaCedulas((int)(valor/50));
        this.saldo -= valor;
        if(this.saldo < 500){
            this.meuTerminal.setModo(0);
        }
        return true;
    }

    public boolean transferencia(int numeroContaPagadora, int numerocontaDestino, double valor, int senha) {

        Conta pagadora = bdContas.buscaConta(numeroContaPagadora);
        Conta destino = bdContas.buscaConta(numerocontaDestino);

        if(pagadora == null || destino == null || !pagadora.debitaValor(valor, senha, "Transferencia")){
            return false;
        }
        return true;
    }
    
    public boolean depositoEmEnvelope (int numeroContaDestino, double valor) {
    	
    	Conta destino = bdContas.buscaConta(numeroContaDestino);
    	
    	if(destino == null) {
    		return false;
    	}
    	destino.creditaValor(valor, "Deposito em envelope");
    	this.saldo += valor;
    	return true;
    }
    
    public boolean depositoEmDinheiro (int numeroContaDestino, double valor) {
    	
    	Conta destino = bdContas.buscaConta(numeroContaDestino);
    	
    	if(destino == null) {
    		return false;
    	}
    	destino.creditaValor(valor, "Deposito em dinheiro");
    	this.saldo += valor;
    	return true;
    }
    public boolean geraExtrato(int numeroConta, int senha) {
    	Conta conta = bdContas.buscaConta(numeroConta);
    	if(conta == null || !conta.extrato(senha)) {
    		return false;
    	}
    	System.out.println("\nSaldo Atual: " + conta.varificaSaldo(senha));
    	return true;
    }
    public void recarrega() {
        this.saldo = 2000;
        this.meuTerminal.setModo(1);
    }
    
    private void liberaCedulas(int quantidade) {
        while(quantidade-- > 0) {
            System.out.println("===/ R$50,00 /===");
        }
    }
}
