package refriSA;

public class Montante {
    private int dois, cinco, dez, vinte, cinquenta, cem;

    public Montante () {
		dois = cinco = dez = vinte = cinquenta = cem = 0;
    }

    public Montante (int notas) {
        this.dois = this.cinco = this.dez = this.vinte = this.cinquenta = this.cem = notas;
    }
    
    public Montante (int dois, int cinco, int dez, int vinte, int cinquenta, int cem) {
        this.dois = dois;
        this.cinco = cinco;
        this.dez = dez;
        this.vinte = vinte;
        this.cinquenta = dois;
        this.cem = cem;
    }

    public int total () {
        return 2*dois + 5*cinco + 10*dez + 20*vinte + 50*cinquenta + 100*cem;
    }

    public String toString () {
    	return "Dois: " + this.dois + " Cinco: " + this.cinco + " Dez: " + this.dez + " Vinte: " + this.vinte + " Cinquenta: " + this.cinquenta + " Cem: " + this.cem;
    }

    public int getDois(){
    	return dois;
    }
     
    public void setDois(int dois){
    	this.dois = dois;
    }

    public int getCinco(){
    	return cinco;
    }
     
    public void setCinco(int cinco){
    	this.cinco = cinco;
    }

    public int getDez(){
    	return dez;
    }
     
    public void setDez(int dez){
    	this.dez = dez;
    }

    public int getVinte(){
    	return vinte;
    }
     
    public void setVinte(int vinte){
    	this.vinte = vinte;
    }

    public int getCinquenta(){
    	return cinquenta;
    }
     
    public void setCinquenta(int cinquenta){
    	this.cinquenta = cinquenta;
    }

    public int getCem(){
    	return cem;
    }
     
    public void setCem(int cem){
    	this.cem = cem;
    }

}
