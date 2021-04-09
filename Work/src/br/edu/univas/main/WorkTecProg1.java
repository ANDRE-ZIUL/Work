package br.edu.univas.main;

import java.util.Scanner;

public class WorkTecProg1 {

	public static void main(String[] args) {
		
		int a = 0;
		
		Scanner leia = new Scanner(System.in); 
		
		while(a == 0) {
		
		System.out.println("Digite a opção desejada: \n 1 - Quadrado \n 2 - Triângulo \n 3 - Círculo \n 4 - Retângulo \n 9 - Sair");
		int opcao = leia.nextInt();
		
		switch(opcao) {
		case 1:
			System.out.println("Digite a medida da base: ");
			int baseQuadrado = leia.nextInt();
			System.out.println("Digite a medida da altura:");
			int alturaQuadrado = leia.nextInt();
			int areaQuadrado = baseQuadrado * alturaQuadrado;
			System.out.println("A medida da área do Quadrado é: " + areaQuadrado);
		break;
		
		case 2:
			System.out.println("Digite a medida da base: ");
			int baseTriangulo = leia.nextInt();
			System.out.println("Digite a medida da altura: ");
			int alturaTriangulo = leia.nextInt();
			int areaTriangulo = baseTriangulo * alturaTriangulo / 2;
			System.out.println("A medida da área do Triângulo é: " + areaTriangulo);
		break;
		
		case 3:
			System.out.println("Digite a opção da forma que deseja usar: \n 1 - Pelo diâmetro \n 2 - Pelo raio");
			int opcao2 = leia.nextInt();
			if(opcao2 == 1) {
				System.out.println("Digite a medida do diâmetro: ");
				float diametro = leia.nextFloat();
				float areaCirculoD = diametro * diametro * 3.14f / 4;
				System.out.println("A medida do raio do Círculo é: " + areaCirculoD);
			} else if (opcao2 == 2) {
				System.out.println("Digite a medida do raio: ");
				float raio = leia.nextFloat();
				float areaCirculoR = raio * raio * 3.14f;
				System.out.println("A medida do área do Círculo é: " + areaCirculoR);
			} else {
				System.out.println("Opção inválida!");
			}
		break;
		
		case 4:
			System.out.println("Digite a medida da base: ");
			int baseRetangulo = leia.nextInt();
			System.out.println("Digite a medida da altura: ");
			int alturaRetangulo = leia.nextInt();
			int areaRetangulo = baseRetangulo * alturaRetangulo;
			System.out.println("A medida da área do Retângulo é: " + areaRetangulo);
		break;	
		
		case 9:
			System.out.println("Obrigado por usar a ferramenta, até a próxima!!!");
			a++;
		break;
		
		default:
			System.out.println("Opção inválida!, por favor, digite uma opção correta!");
			}
		}
	
		leia.close();
	}
}