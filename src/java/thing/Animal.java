package thing;

public class Animal {
    private String nome;
    private int id_rebanho;
    private float producao;

    public Animal(String nome, int id_rebanho, float producao) {
        this.nome = nome;
        this.id_rebanho = id_rebanho;
        this.producao = producao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_rebanho() {
        return id_rebanho;
    }

    public void setId_rebanho(int id_rebanho) {
        this.id_rebanho = id_rebanho;
    }

    public float getProducao() {
        return producao;
    }

    public void setProducao(float producao) {
        this.producao = producao;
    }
}