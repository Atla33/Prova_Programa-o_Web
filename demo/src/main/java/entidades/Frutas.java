package entidades;

public class Frutas {

    private Integer idFruta;
    private String nome;
    private String tamanho;
    private Integer preco;
    private String descricao;
    private String data_validade;

    public Frutas() {

    }

    public Frutas(String s, String melancia, String grande, String s1, String melancia_importada, String data_validade) {
    }

    public Frutas(String nome, String tamanho, Integer preco, String descricao, String data_validade) {

        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.descricao = descricao;
        this.data_validade = data_validade;
    }

    public Frutas(Integer idFruta, String nome, String tamanho, Integer preco, String descricao, String data_validade) {
        this.idFruta = idFruta;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.descricao = descricao;
        this.data_validade = data_validade;
    }

    public static void add(Frutas obj) {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "idlivro=" + idFruta +
                ", nome='" + nome + '\'' +
                ", tamanho='" + tamanho + '\'' +
                ", preco='" + preco + '\'' +
                ", descricao='" + descricao + '\'' +
                ", data_validade='" + data_validade +
                '}';
    }

    public Integer getIdFruta() {
        return idFruta;
    }

    public String getNome() {
        return nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public Integer getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_validade() {
        return data_validade;
    }

    public void setIdFruta(Integer idFruta) {
        this.idFruta = idFruta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData_validade(String data_validade) {
        this.data_validade = data_validade;
    }
}