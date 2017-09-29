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
        return comprador.toString() + " TOTAL: " + comprador.total();
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
                if (montante.getCem() >= r) {
                    preco -= 100*r;
                    troco.setCem(r);
                } else if (montante.getCem() > 0) {
                    preco -= 100*montante.getCem();
                    troco.setCem(montante.getCem());
                }
            }

            if (preco >= 50) {
                int r = preco / 50;
                if (montante.getCinquenta() >= r) {
                    preco -= 50*r;
                    troco.setCinquenta(r);
                } else if (montante.getCinquenta() > 0) {
                    preco -= 50*montante.getCinquenta();
                    troco.setCinquenta(montante.getCinquenta());
                }
            }

            if (preco >= 20) {
                int r = preco / 20;
                if (montante.getVinte() >= r) {
                    preco -= 20*r;
                    troco.setVinte(r);
                } else if (montante.getVinte() > 0) {
                    preco -= 20*montante.getVinte();
                    troco.setVinte(montante.getVinte());
                }
            }

            if (preco >= 10) {
                int r = preco / 10;
                if (montante.getDez() >= r) {
                    preco -= 10*r;
                    troco.setDez(r);
                } else if (montante.getDez() > 0) {
                    preco -= 10*montante.getDez();
                    troco.setDez(montante.getDez());
                }
            }

            if (preco >= 5) {
                int r = preco / 5;
                if (montante.getCinco() >= r) {
                    preco -= 5*r;
                    troco.setCinco(r);
                } else if (montante.getCinco() > 0) {
                    preco -= 5*montante.getCinco();
                    troco.setCinco(montante.getDois());
                }
            }

            if (preco >= 2) {
                int r = preco / 2;
                if (montante.getDois() >= r) {
                    preco -= 2*r;
                    troco.setDois(r);
                } else if (montante.getDois() > 0) {
                    preco -= 2*montante.getDois();
                    troco.setDois(montante.getDois());
                }
            }
        }

        return troco;
    }
}
