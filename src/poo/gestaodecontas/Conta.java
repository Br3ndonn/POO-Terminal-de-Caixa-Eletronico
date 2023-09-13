package poo.gestaodecontas;

public class Conta {
    private int numero;
    private int senha;
    private Cliente titular;
    private double saldo;
    private HistoricoDeLancamentos historico;

    public Conta(int numero, Cliente titular, int senha, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.senha = senha;
        this.saldo = saldo;
        this.historico = new HistoricoDeLancamentos(10);
    }

    public int getNumero() {
        return this.numero;
    }

    public Cliente getTitular() {
        return this.titular;
    }
    public double varificaSaldo(int senha) {
        if(senhaEhValida(senha)) {
            return this.saldo;
        }
        return -1;
    }
    public boolean debitaValor(double valor, int senha, String operacaoBancaria) {
        if(!senhaEhValida(senha) | valor > this.saldo | valor < 0) {
            return false;
        }
        this.saldo -= valor;
        this.historico.insereLancamento(new Lancamento(operacaoBancaria, -valor));
        return  true;
    }
    public boolean creditaValor(double valor, String operacaoBancaria) {
        if(valor < 0) {
            return false;
        }
        this.saldo += valor;
        this.historico.insereLancamento(new Lancamento(operacaoBancaria, valor));
        return true;
    }
    public boolean extrato(int senha) {
    	if(!senhaEhValida(senha)) {
    		return false;
    	}
    	System.out.println(historico.geraHistoricoDeLancamentos());
		return true;
    }
    public boolean senhaEhValida(int senha) {
        return this.senha == senha;
    }
    public String toString() {
        return "Numero: " + this.numero + "\n" +
                "Titular: " + this.titular + "\n";
    }
}
