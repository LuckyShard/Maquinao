package refrizao;

import java.util.ArrayList;
import java.util.List;

public class MaquinaoDaPorra {
	private List<Produto> pd;
	private double caixaTotal;
	public MaquinaoDaPorra() {
		pd = new ArrayList<Produto>();
	}
	public MaquinaoDaPorra(double caixaTotal) {
		pd = new ArrayList<Produto>();
		this.caixaTotal = caixaTotal;
	}

	public List<Produto> getPd() {
		return pd;
	}

	public void setPd(List<Produto> pd) {
		this.pd = pd;
	}

	public double getCaixaTotal() {
		return caixaTotal;
	}

	public void setCaixaTotal(double caixaTotal) {
		this.caixaTotal = caixaTotal;
	}
	public boolean inserirProduto(Produto p) {
		if(pd.add(p)) return true;
		return false;
	}
	public boolean remover(String nome) {
		for(int i = 0; i<pd.size();i++) {
			if(nome.equalsIgnoreCase(pd.get(i).getNome())) {
				pd.remove(i);
				return true;
			}
		}
		return false;
	}
	public double Troco(double troco) {
		return troco;
	}
	public boolean Compra(double valorC, double valorP) {
		double troco=0;
		if(valorC >= valorP) {
			this.caixaTotal += valorC;
			troco = valorC - valorP;
			if(troco <= this.caixaTotal) {
				this.caixaTotal -= troco;
				Troco(troco);
				return true;
			}
			else {
				Troco(0);
				return true;
			}
			
		}
		return false;
	}
	

}
