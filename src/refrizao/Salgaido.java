package refrizao;

public class Salgaido extends Produto{
	
	public double kG;
	
	public Salgaido() {
		super();
	}
	public Salgaido(double valor,String marca,String validade,String sabor,double kG,String nome) {
		super(valor,marca,validade,nome,sabor);
		this.kG = kG;
	}
	public double getkG() {
		return kG;
	}
	public void setkG(double kG) {
		this.kG = kG;
	}
	@Override
	public String toString() {
		return super.toString()+ " Quantidade em kG: " + this.getkG();
	}

}
