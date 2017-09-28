package refrizao;
public abstract class Produto {
	private String nome;
	private double valor;
	private String marca;
	private String validade;
	public String Sabor;
	
	public Produto() {
		
	}
	public Produto(double valor,String marca,String validade,String nome,String sabor) {
		this.valor = valor;
		this.marca = marca;
		this.validade = validade;
		this.nome = nome;
		this.Sabor = sabor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSabor() {
		return Sabor;
	}
	public void setSabor(String sabor) {
		Sabor = sabor;
	}
	@Override
	public String toString() {
		return "\nNome: " + this.getNome() +" Marca: "+ this.getMarca() +" Sabor: "+ this.getSabor() +" Validade: " + this.getValidade()+" Valor: " +this.getValor();
	}

}
