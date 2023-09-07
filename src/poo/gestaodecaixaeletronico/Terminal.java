package poo.gestaodecaixaeletronico;

import java.util.Scanner;

public class Terminal {
    private Caixa meuCaixa;
    private int modoAtual;

    public Terminal(CadastroContas bd) {
        this.meuCaixa = new Caixa(this, bd);
    }
    public void iniciaOperacao() {
        int opcao;

        opcao = this.getOpcao();
        while(opcao != 8) {
            switch (opcao) {
                case 1: double saldo = this.meuCaixa.consultaSaldo(getInt("Numero da Conta"), getInt("Senha"));
                    if(saldo != -1) {
                        System.out.println("Saldo atual: " + saldo);
                    }else{
                        System.out.println("Conta/senha invalida");
                    }
                    break;
                case 2: boolean b = this.meuCaixa.efetuaSaque(getInt("Numero da Conta"), (double) getInt("Valor"), getInt("Senha"));
                    if(b) {
                        System.out.println("Retire o dinheiro");
                    }else {
                        System.out.println("Pedido de saque recusaod");
                    }
                    break;
                case 3: this.meuCaixa.recarrega();
                    break;
                case 4: boolean c = this.meuCaixa.transferencia(getInt("Conta pagadora"), getInt("Conta destino"), (double) getInt("Valor"), getInt("Senha"));
                    if(c) {
                        System.out.println("Transferencia realizada");
                    } else {
                        System.out.println("Erro na transferencia");
                    }
            }
            opcao = getOpcao();
        }
    }

    public void setModo(int modo) {
        if(modo == 0 || modo == 1) {
            this.modoAtual = modo;
        }
    }

    private int getOpcao() {
        int opcao = 0;
        do {
            if(this.modoAtual == 1) {
                opcao = getInt("Opcao: 1 - Consulta saldo, 2 - Saque, 4 - Transferencia, 8 - Sair");
                if(opcao != 1 & opcao != 2 & opcao != 4 & opcao != 8) {
                    opcao = 0;
                }else {
                    opcao = getInt("Opcao: 3 - Recarrega, 8 - Sair");
                    if(opcao != 3 & opcao != 4 & opcao != 8) {
                        opcao = 0;
                    }
                }
            }
        }while(opcao == 0);
        return opcao;
    }
    private int getInt(String string) {
        Scanner r = new Scanner(System.in);
        System.out.println("Entre com: " + string);

        if(r.hasNextInt()) {
            return r.nextInt();
        }
        String st = r.next();
        System.out.println("Erro na leitura de dados");
        return 0;
    }
}
