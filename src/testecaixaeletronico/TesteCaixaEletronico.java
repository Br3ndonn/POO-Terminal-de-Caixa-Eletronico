package testecaixaeletronico;
import poo.gestaodecontas.*;
import poo.gestaodecaixaeletronico.*;
public class TesteCaixaEletronico {
    public static void main(String[] args) {
        Conta c1 = new Conta(1, new Cliente("12345", "Joao"), 123, 1000);
        Conta c2 = new Conta(2, new Cliente("23456", "Maria"), 123, 1700);
        Conta c3 = new Conta(3, new Cliente("34567", "Miguel"), 123, 900);
        Conta c4 = new Conta(4, c1.getTitular(), 123, 1500);

        CadastroContas cad = new CadastroContas(10);
        cad.adicionaConta(c1);cad.adicionaConta(c2);cad.adicionaConta(c3);cad.adicionaConta(c4);

        Terminal t = new Terminal(cad);
        t.iniciaOperacao();
    }
}
