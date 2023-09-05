package poo.gestaodecontas;

public class Lancamento {
    private String descicao;
    private double valor;

    public Lancamento(String descricao, double valor) {
        this.valor = valor;
        this.descicao = descricao;
    }

    public String getDescicao() {
        return descicao;
    }

    public double getValor() {
        return valor;
    }
}

