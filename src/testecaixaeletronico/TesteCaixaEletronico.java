package testecaixaeletronico;
import poo.gestaodecaixaeletronico.*;

import poo.gestaodecontas.*;


public class TesteCaixaEletronico {
    public static void main(String[] args) {
        Conta c1 = new Conta(1, new Cliente("12345", "Joao"), 123, 1000);
        Conta c2 = new Conta(2, new Cliente("23456", "Maria"), 123, 1700);
        Conta c3 = new Conta(3, new Cliente("34567", "Miguel"), 123, 900);

        CadastroContas cad = new CadastroContas(10);
        cad.adicionaConta(c1);cad.adicionaConta(c2);
        //System.out.println(c1);
        //System.out.println(c2);
        //System.out.println(c3);
        System.out.println(cad.buscaConta(1));
        System.out.println(cad.buscaConta(2));

    }
}
