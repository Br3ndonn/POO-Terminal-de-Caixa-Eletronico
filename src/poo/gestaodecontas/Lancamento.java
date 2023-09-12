package poo.gestaodecontas;

public class Lancamento {
    private String descricao;
    private double valor;

    public Lancamento(String descricao, double valor) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}

