package refriSA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner (System.in);

    	Maquina m = new Maquina (50, 1);
    	m.iniciarCompra();

    	Produto dollynho = new Produto ("Dollyinho", 5, "Refrigerante", "350ml");
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	m.inserirProduto(dollynho);
    	Produto guarana = new Produto ("Guarana", 5, "Refrigerante", "350ml");
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	m.inserirProduto(guarana);
    	Produto pepsicola = new Produto ("Pepsi", 5, "Refrigerante", "350ml");
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);
    	m.inserirProduto(pepsicola);

    	boolean cc = true;
    	while (cc) {
    		mostrarMenu();
    		int op = sc.nextInt();
    		switch (op) {
    			case 1:
    				verProdutos(m);
    				break;
    			case 2:
    				inserirCreditos(m, sc);
    				break;
    			case 3:
    				verCreditos(m);
    				break;
    			case 4:
    				escolherProduto (m, sc);
    				break;
    			default:
    				cc = false;
    				break;
    		}
    	}
    }

    public static void mostrarMenu () {
    	System.out.println("---------------- MAQUINA DE VENDAS ----------------");
    	System.out.println("1 - Ver produtos");
    	System.out.println("2 - Inserir créditos");
    	System.out.println("3 - Ver créditos");
    	System.out.println("4 - Escolher próduto");
    	System.out.println("---------------------------------------------------");
    }

    public static void verProdutos (Maquina m) {
    	System.out.println("-------------------- PRODUTOS ---------------------");
    	System.out.print(m.mostrarAgrupado());
    }

    public static void inserirCreditos (Maquina m, Scanner sc) {
    	System.out.println("----------------- INSIRA UMA NOTA -----------------");
    	System.out.println("2 REAIS");
    	System.out.println("5 REAIS");
    	System.out.println("10 REAIS");
    	System.out.println("20 REAIS");
    	System.out.println("50 REAIS");
    	System.out.println("100 REAIS");
    	System.out.println("---------------------------------------------------");
    	int nota = sc.nextInt();
    	m.inserirCredito(nota);
    }

    public static void verCreditos (Maquina m) {
    	System.out.println("-------------------- CREDITOS --------------------");
    	System.out.println(m.verCreditos());
    }

    public static void escolherProduto (Maquina m, Scanner sc) {
    	verProdutos(m);
    	System.out.println("------------------- ESCOLHA UM -------------------");
    	int pro = sc.nextInt();
    	Montante troco = m.selecionarProduto(pro);
    	if (troco.getDois() == -1) {
    		System.out.println("---------------------------------------------------");
    		System.out.println("CREDITOS INSUFUCIENTES, DINHEIRO DEVOLVIDO");
    	} else {
	    	System.out.println("--------------------- TROCO ----------------------");
	    	System.out.println(troco.toString() + " TOTAL: " + troco.total());
    	}
    	m.iniciarCompra();
    }
}
