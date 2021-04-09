package br.edu.univas.main;

import java.util.Scanner;

public class WorkTecProg1 {

	public static void main(String[] args) {
		
		int a = 0;
		
		Scanner leia = new Scanner(System.in); 
		
		while(a == 0) {
		
		System.out.println("Digite a op��o desejada: \n 1 - Quadrado \n 2 - Tri�ngulo \n 3 - C�rculo \n 4 - Ret�ngulo \n 9 - Sair");
		int opcao = leia.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("Digite a medida da base: ");
			int baseQuadrado = leia.nextInt();
			System.out.println("Digite a medida da altura:");
			int alturaQuadrado = leia.nextInt();
			int areaQuadrado = baseQuadrado * alturaQuadrado;
			System.out.println("A medida da �rea do Quadrado �: " + areaQuadrado);
		break;
		
		case 2:
			System.out.println("Digite a medida da base: ");
			int baseTriangulo = leia.nextInt();
			System.out.println("Digite a medida da altura: ");
			int alturaTriangulo = leia.nextInt();
			int areaTriangulo = baseTriangulo * alturaTriangulo / 2;
			System.out.println("A medida da �rea do Tri�ngulo �: " + areaTriangulo);
		break;
		
		case 3:
			System.out.println("Digite a op��o da forma que deseja usar: \n 1 - Pelo di�metro \n 2 - Pelo raio");
			int opcao2 = leia.nextInt();
			if(opcao2 == 1) {
				System.out.println("Digite a medida do di�metro: ");
				float diametro = leia.nextFloat();
				float areaCirculoD = diametro * diametro * 3.14f / 4;
				System.out.println("A medida do raio do C�rculo �: " + areaCirculoD);
			} else if (opcao2 == 2) {
				System.out.println("Digite a medida do raio: ");
				float raio = leia.nextFloat();
				float areaCirculoR = raio * raio * 3.14f;
				System.out.println("A medida do �rea do C�rculo �: " + areaCirculoR);
			} else {
				System.out.println("Op��o inv�lida!");
			}
		break;
		
		case 4:
			System.out.println("Digite a medida da base: ");
			int baseRetangulo = leia.nextInt();
			System.out.println("Digite a medida da altura: ");
			int alturaRetangulo = leia.nextInt();
			int areaRetangulo = baseRetangulo * alturaRetangulo;
			System.out.println("A medida da �rea do Ret�ngulo �: " + areaRetangulo);
		break;	
		
		case 9:
			System.out.println("Obrigado por usar a ferramenta, at� a pr�xima!!!");
			a++;
		break;
		
		default:
			System.out.println("Op��o inv�lida!, por favor, digite uma op��o correta!");
			}
		}
	
		leia.close();
	}
}