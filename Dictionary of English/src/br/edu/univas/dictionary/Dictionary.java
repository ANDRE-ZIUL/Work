package br.edu.univas.dictionary;

import java.util.Scanner;

public class Dictionary {
	
	static Scanner scanner = new Scanner(System.in);	
	
	public static void main(String[] args) {
		
		int i = 0;
		int amountOfWords = 0;
		String[] registeredWord = new String[100];
		String[] registeredTranslation = new String[100];
		
		while(true) {
			System.out.println("\nMENU \nDigite a opção desejada: \n1 - Pesquisar palavras \n2 - Cadastrar palavras \n3 - Editar palavras \n4 - Excluir palavras \n9 - Sair");
			int chosenFunction = scanner.nextInt();
			scanner.nextLine();
			
			if(chosenFunction == 1) {
				System.out.println(wordSearch(registeredWord, registeredTranslation, amountOfWords));
			}else if(chosenFunction == 2) {
				registeredWord[amountOfWords] = wordRegistration(i);
				registeredTranslation[amountOfWords] = translationOfWords(i);
				amountOfWords++;
				System.out.println("\nPalavra cadastrada com sucesso!!!");
			}else if(chosenFunction == 3) {
				wordEditing(registeredWord, registeredTranslation, i, amountOfWords);
			}else if(chosenFunction == 4) {
				exclusaoDeDados(registeredWord, registeredTranslation, i, amountOfWords);
			}else if(chosenFunction == 9) {
				System.out.println("\nOBRIGADO POR USAR O SISTEMA, ATÉ A PRÓXIMA!");
				break;
			}else {
				System.out.println("\nOPÇÃO INVÁLIDA!!! POR FAVOR DIGITE NOVAMENTE!");	
		}	
	}
}
	
	public static String wordRegistration(int i) {
		System.out.println("\nDigite a palavra que deseja cadastrar: ");
		String word = scanner.nextLine();
		return word;
	}
	
	public static String translationOfWords(int i) {
		System.out.println("\nDigite a traducao da palavra que deseja cadastrar: ");
		String translate = scanner.nextLine();
		return translate;
	}
	
	public static String wordSearch(String palavraCadastrada[], String traducaoCadastrada[], int qtdPalavras) {
		System.out.println("\nPalavra desejada: ");
		String typedWord = scanner.nextLine();
		String translate = "";
		
		for(int i = 0; i < qtdPalavras; i++) {
			if(typedWord.equals(palavraCadastrada[i])) {
				translate += ("\nTRADUÇÃO = " + traducaoCadastrada[i]);
			}else if(typedWord.equals(traducaoCadastrada[i])) {
				translate += ("\nTRADUÇÃO = " + palavraCadastrada[i]);
			}else {
				translate += ("\nPalavra NÃO cadastrada!!!");
			}
		}
		return translate;
	}
	
	public static void wordEditing(String registeredWord[], String registeredTranslation[], int i, int amountOfWords) {
		System.out.println("\nDigite a palavra/tradução que deseja editar: ");
		String typedWord = scanner.nextLine();
		
		for(i = 0; i < amountOfWords; i++) {
			if(typedWord.equals(registeredWord[i])) {
				System.out.println("\nDigite a palavra editada: ");
				registeredWord[i] = scanner.nextLine();
				System.out.println("\nPalavra editada com sucesso!!!");
			} else if(typedWord.equals(registeredTranslation[i])) {
				System.out.println("Digite a palavra editada: ");
				registeredTranslation[i] = scanner.nextLine();
				System.out.println("\nPalavra editada com sucesso!!!");
			}else {
				System.out.println("\nPalavra NÃO cadastrada!!!");
			}
		}
	}
	
	public static void exclusaoDeDados(String registeredWord[], String registeredTranslation[], int i, int amountOfWords) {
		System.out.println("Digite a palavra/tradução que deseja excluir: ");
		String typedWord = scanner.nextLine();
		
		for(i = 0; i < amountOfWords; i++) {
			if(typedWord.equals(registeredWord[i])) {
				registeredWord[i] = "";
				registeredTranslation[i] = "";
				System.out.println("\nPalavra excluida com sucesso!!!");
			} else if(typedWord.equals(registeredTranslation[i])) {
				registeredWord[i] = "";
				registeredTranslation[i] = "";
				System.out.println("\nPalavra excluida com sucesso!!!");
			} else {
				System.out.println("\nPalavra NÃO cadastrada!!!");
			}
		}
	}
}
