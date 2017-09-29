package refriSA;

public class Produto {
    private String nome;
    private int preco;
    private String tipo;
    private String descricao;

    public Produto (String nome, int preco, String tipo, String descricao) {
    	this.nome = nome;
    	this.preco = preco;
    	this.tipo = tipo;
    	this.descricao = descricao;
    }

    public String toString () {
    	return this.tipo + " " + this.nome + " " + this.descricao + " R$ " + this.preco + ",00";
    }

    public String getNome(){
		return nome;
	}
    
	public void setNome(String nome){
		this.nome = nome;
	}

	public int getPreco(){
		return preco;
	}

	public void setPreco(int preco){
		this.preco = preco;
	}

	public String getTipo(){
		return tipo;
	}

	public void setTipo(String tipo){
		this.tipo = tipo;
	}

	public String getDescricao(){
		return descricao;
	}

	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
}
