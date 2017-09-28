package refrizao;

public class Refrigerante extends Produto {
	public double mL;
	public Refrigerante() {
		super();
	}
	public Refrigerante(double valor,String marca,String validade,double mL,String nome,String sabor) {
		super(valor,marca,validade,nome,sabor);
		this.mL = mL;
	}
	public double getmL() {
		return mL;
	}
	public void setmL(double mL) {
		this.mL = mL;
	}
	@Override
	public String toString() {
		return super.toString() + " Quantidade de mL: " + this.getmL();
	}
	

}
