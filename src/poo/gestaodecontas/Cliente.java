package poo.gestaodecontas;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String cpf, String nome) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        return this.nome + "\n" + "CPF: " + this.cpf;
    }
}
