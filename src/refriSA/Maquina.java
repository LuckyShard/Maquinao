package refriSA;

public class Maquina {
    private Montante montante;
    private Montante comprador;
    private Produto produtos[];

    public Maquina () {
    	this.produtos = new Produto[50];
    	this.montante = new Montante (50);
    }

    public Maquina (int capacidade, int notas) {
    	this.produtos = new Produto[capacidade];
    	this.montante = new Montante (notas);
    }
    
    public Maquina (int capacidade, int dois, int cinco, int dez, int vinte, int cinquenta, int cem) {
    	this.produtos = new Produto[capacidade];
    	this.montante = new Montante (dois, cinco, dez, vinte, cinquenta, cem);
    }

    public void inserirProduto (Produto p) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = p;
                break;
            }
        }
    }

    public String mostrarAgrupado () {
        String menu = "";
        String listagem[] = new String[produtos.length];
        int qtds[] = new int[produtos.length];

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) {
                boolean jtem = false;
                for (int j = 0; j < listagem.length; j++) {
                    if (listagem[j] != null && listagem[j].equals(produtos[i].toString())) {
                        qtds[j]++;
                        jtem = true;
                        break;
                    }
                }
                if (!jtem) {
                    for (int j = 0; j < listagem.length; j++) {
                        if (listagem[j] == null) {
                            qtds[j] = 1;
                            listagem[j] = produtos[i].toString();
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < produtos.length; i++) {
            if (listagem[i] != null)
                menu += i + " - " + listagem[i].toString() + " (" + qtds[i] + ")\n";
        }

        return menu;

    }

    public String mostrarProdutos () {
        String menu = "";
        
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null)
                menu += produtos[i].toString() + "\n";
        }

        return menu;
    }

    public void iniciarCompra () {
        comprador = new Montante();
    }

    public void inserirCredito (int nota) {
        if (nota == 2)
            comprador.setDois(comprador.getDois() + 1);
        if (nota == 5)
            comprador.setCinco(comprador.getCinco() + 1);
        if (nota == 10)
            comprador.setDez(comprador.getDez() + 1);
        if (nota == 20)
            comprador.setVinte(comprador.getVinte() + 1);
        if (nota == 50)
            comprador.setCinquenta(comprador.getCinquenta() + 1);
        if (nota == 100)
            comprador.setCem(comprador.getCem() + 1);
    }

    public String verCreditos () {
        return comprador.toString();
    }

    public Montante selecionarProduto (int idx) {
        String listagem[] = new String[produtos.length];
        int qtds[] = new int[produtos.length];

        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null) {
                boolean jtem = false;
                for (int j = 0; j < listagem.length; j++) {
                    if (listagem[j] != null && listagem[j].equals(produtos[i].toString())) {
                        qtds[j]++;
                        jtem = true;
                        break;
                    }
                }
                if (!jtem) {
                    for (int j = 0; j < listagem.length; j++) {
                        if (listagem[j] == null) {
                            qtds[j] = 1;
                            listagem[j] = produtos[i].toString();
                            break;
                        }
                    }
                }
            }
        }

        Produto p = null;
        String ps = listagem[idx];
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null && produtos[i].toString().equals(ps)) {
                p = produtos[i];
                if (p.getPreco() <= comprador.total())
                    produtos[i] = null;
                break;
            }
        }

        if (p != null) {
            Montante troco = calcularTroco(p);
            montante.setDois(montante.getDois() - troco.getDois());
            montante.setCinco(montante.getCinco() - troco.getCinco());
            montante.setDez(montante.getDez() - troco.getDez());
            montante.setVinte(montante.getVinte() - troco.getVinte());
            montante.setCinquenta(montante.getCinquenta() - troco.getCinquenta());
            montante.setCem(montante.getCem() - troco.getCem());
            return troco;
        }
        return new Montante (-1, -1, -1, -1, -1, -1);
    }

    public Montante calcularTroco (Produto p) {
        Montante troco;
        int preco = p.getPreco();
        if (preco > comprador.total()) {
             troco = new Montante (-1, -1, -1, -1, -1, -1);
        } else {
            troco = new Montante ();
            preco = comprador.total() - preco;
            System.out.println(preco);
            if (preco >= 100) {
                int r = preco / 100;
                preco -= 100*r;
                troco.setCem(r);
            }

            if (preco >= 50) {
                int r = preco / 50;
                preco -= 50*r;
                troco.setCinquenta(r);
            }

            if (preco >= 20) {
                int r = preco / 20;
                preco -= 20*r;
                troco.setVinte(r);
            }

            if (preco >= 10) {
                int r = preco / 10;
                preco -= 10*r;
                troco.setDez(r);
            }

            if (preco >= 5) {
                int r = preco / 5;
                preco -= 5*r;
                troco.setCinco(r);
            }

            if (preco >= 2) {
                int r = preco / 2;
                preco -= 2*r;
                troco.setDois(r);
            }
        }

        return troco;
    }
}
