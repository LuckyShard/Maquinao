package refrizao;

import java.util.Scanner;
public class MaeMain {
	public static  MaquinaoDaPorra actInsert(MaquinaoDaPorra x) {
		Scanner sc = new Scanner(System.in);
		Refrigerante rg = new Refrigerante();
		rg.setNome("Coca");
		rg.setMarca("Coca-Cola");
		rg.setmL(150);
		rg.setSabor("Vanilla Ice");
		rg.setValidade("10-12-19");
		rg.setValor(2.5);
		int n;
		MaquinaoDaPorra m = new MaquinaoDaPorra();
		m=x;
		System.out.println("Digite a quantidade de produtos que você deseja inserir");
		n= sc.nextInt();
		for(int i = 0; i< n;i++) {
			m.inserirProduto(rg);
			
		}
		return m;
	}

	public static void main(String[] args) {
		Refrigerante rg = new Refrigerante();
		rg.setNome("Coca");
		rg.setMarca("Coca-Cola");
		rg.setmL(150);
		rg.setSabor("Vanilla Ice");
		rg.setValidade("10-12-19");
		rg.setValor(2.5);
		MaquinaoDaPorra m = new MaquinaoDaPorra();
		/*m = actInsert(m);
		System.out.println(m.getPd().toString());
		*/
		int op = -1;
		while(op != 0) {
			m=actInsert(m);
			System.out.println(m.getPd().toString());
		}
		
		
	/*	Scanner rd = new Scanner(System.in);
		MaquinaoDaPorra maq = new MaquinaoDaPorra();
		int opUp = -1, op = -1,oppai = -1;
		while(opUp != 0) {
			System.out.println("1- The dumbster \n2- The adm \n0-Gtfo");
			opUp = rd.nextInt();
			switch(opUp) {
			case 1:
				while(op != 0) {
					System.out.println("1- Buyar \n2- Listar Produtos \n0-Gtfo");
					op = rd.nextInt();

					switch(op) {
					case 0:
						break;
					}
				}
				break;
			case 2:
				while(oppai != 0) {
					System.out.println("1- Inserir produtos \n2- Listar Produtos \n3- Remover Produto \n0-Gtfo");
					oppai = rd.nextInt();
					switch(oppai) {
					case 0:
						break;
					default : System.out.println("Sabe ler não?");
					break;


					}

				}

				break;
			case 0:
				break;
			}
		}
		rd.close();*/
	}

}
