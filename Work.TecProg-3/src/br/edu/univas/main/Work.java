package br.edu.univas.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.edu.univas.vo.Player;
import br.edu.univas.vo.Title;

public class Work {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Variaveis utilizadas no sistema
		ArrayList<Title> titles = new ArrayList<Title>(); //Lista geral de titulos
		ArrayList<Title> comedy = new ArrayList<Title>(); //Lista de titulos de com�dia
		ArrayList<Title> action = new ArrayList<Title>(); //Lista de titulos de a��o
		ArrayList<Title> adventure = new ArrayList<Title>(); //Lista de titulos de aventura
		ArrayList<Title> horror = new ArrayList<Title>(); //Lista de titulos de terror
		ArrayList<Title> police = new ArrayList<Title>(); //Lista de titulos de policial
		Player player = new Player();
		ArrayList<String> listOfPlayers = new ArrayList<String>(); //Lista dos players adicionados
		
		//Sistema principal
		System.out.println("JAVASTREAMING - SUA PROGRAMA��O � AQUI");
		while(true) {
			printMenu();
			int option = readIntValue();
			
			if(option == 1) {
				playerRegistration(player, listOfPlayers);
			}else if(option == 2) {
				titleRegistration(listOfPlayers, titles, comedy, horror, police, action, adventure);
			}else if(option == 3) {
				searchTitles(titles, listOfPlayers);
			}else if(option == 4) {
				aleatoryTitles(titles);
			}else if(option == 5) {
				 genreTitles(titles, comedy, horror, police, action, adventure);
			}else if(option == 0) {
				System.out.println("OBRIGADO POR USAR A FERRAMENTA!!! AT� A PR�XIMA!!!!");
				break;
			}else {
				invalidOption();
			}
		}
	}
	
	public static void searchTitles(ArrayList<Title> titles, ArrayList<String> listOfPlayers) {
		System.out.println("SELECIONE COMO DESEJA PESQUISAR: \n1 - NOME \n2 - ATOR \n3 - DIRETOR \n4 - CLASSIFICA��O INDICATIVA \n5 - PLATAFORMAS CADASTRADAS");
		int option = readIntValue();
		
		if(option == 1) {
			System.out.println("DIGITE O NOME TITULO: ");
			String nameTitle = scanner.nextLine();
			for(int i = 0; i < titles.size(); i++) {
				if(titles.get(i).getTitle().equals(nameTitle)) {
					printResult(titles, i);
				}
			}
		}else if(option == 2) {
			System.out.println("DIGITE O NOME DO ATOR: ");
			String nameActor = scanner.nextLine();
			for(int i = 0; i < titles.size(); i++) {
				for(int j = 0; j < titles.get(i).getCast().size(); j++) {
					if(titles.get(i).getCast().get(j).equals(nameActor)) {
						printResult(titles, i);		
					}
				}
			}
		}else if(option == 3) {
			System.out.println("DIGITE O NOME DO DIRETOR: ");
			String nameDirector = scanner.nextLine();
			for(int i = 0; i < titles.size(); i++) {
				if(titles.get(i).getDirector().equals(nameDirector)) {
					printResult(titles, i);	
				}
			}
		}else if(option == 4) {
			printClassification();
			int classification = readIntValue();
			
			if(classification == 1) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("LIVRE PARA TODOS OS PUBLICOS")) {
						printResult(titles, i);		
					}
				}
			}else if(classification == 2) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("INAPROPRIADO PARA MENORES DE 10 ANOS")) {
						printResult(titles, i);	
					}
				}
			}else if(classification == 3) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("INAPROPRIADO PARA MENORES DE 12 ANOS")) {
						printResult(titles, i);	
					}
				}
			}else if(classification == 4) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("INAPROPRIADO PARA MENORES DE 14 ANOS")) {
						printResult(titles, i);	
					}
				}
			}else if(classification == 5) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("INAPROPRIADO PARA MENORES DE 16 ANOS")) {
						printResult(titles, i);	
					}
				}
			}else if(classification == 6) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getClassification().equals("INAPROPRIADO PARA MENORES DE 18 ANOS")) {
						printResult(titles, i);		
					}
				}
			}else {
				invalidOption();
			}
		}else if(option == 5) {
			for(int i = 0; i < listOfPlayers.size(); i++) {
				System.out.println((i + 1) + " - " + listOfPlayers.get(i));
			}
			int plataform = readIntValue();
			
			if(plataform >= 1 && plataform <= (listOfPlayers.size() + 1)) {
				for(int i = 0; i < titles.size(); i++) {
					if(titles.get(i).getPlataforms().equals(listOfPlayers.get(plataform - 1))) {
						printResult(titles, i);		
					}
				}
			}else {
				invalidOption();
			}
		}else {
			invalidOption();
		}
	}
	
	//Metodo que cadastra os titulos
	public static Title titleRegistration(ArrayList<String> listOfPlayers, ArrayList<Title> titles, ArrayList<Title> comedy, ArrayList<Title> horror, ArrayList<Title> police, ArrayList<Title> action, ArrayList<Title> adventure) {
		if(listOfPlayers.size() != 0) {
			Title title = new Title();
			
			System.out.println("CADASTRO DE TITULOS");
			
			//Adicionando o nome do titulo
			System.out.println("DIGITE O NOME: ");
			title.setTitle(scanner.nextLine());
			
			//Adicionando o tipo do player
			System.out.println("SELECIONE O TIPO DO TITULO: \n1 - FILME \n2 - S�RIE");
			int type = readIntValue();
			if(type == 1) {
				title.setType("FILME");
			}else if(type == 2) {
				title.setType("S�RIE");
			}else {
				invalidOption();
			}
			
			//Adicionando o elenco
			ArrayList<String> cast1 = new ArrayList<String>();
			System.out.println("DIGITE OS ATORES DO ELENCO: ");
			while(true) {
				cast1.add(scanner.nextLine());
				System.out.println("DESEJA ADICIONAR MAIS ATORES AO ELENCO: \n1 - SIM \n2 - N�O");
				int option = readIntValue();
				if(option == 1) {
					System.out.println("DIGITE O PR�XIMO ATOR: ");
					continue;
				}else if(option == 2) {
					break;
				}else {
					invalidOption();
				}
			}
			title.setCast(cast1);
			
			//Adicionando a descri��o
			System.out.println("DIGITE A DESCRI��O DO TITULO: ");
			title.setDescription(scanner.nextLine());
			
			//Adicionando o g�nero
			System.out.println("SELECIONE QUAL O GENERO DO TITULO: ");
			printTypesGenre();
			int genre = readIntValue();
			if(genre == 1) {
				title.setGenre("A��O");
				action.add(title);
			}else if(genre == 2) {
				title.setGenre("AVENTURA");
				adventure.add(title);
			}else if(genre == 3) {
				title.setGenre("TERROR");
				horror.add(title);
			}else if(genre == 4) {
				title.setGenre("COM�DIA");
				comedy.add(title);
			}else if(genre == 5) {
				title.setGenre("POLICIAL");
				police.add(title);
			}else {
				invalidOption();
			}
			
			//Adicionando nome do diretor 
			System.out.println("DIGITE O NOME DO DIRETOR DO TITULO: ");
			title.setDirector(scanner.nextLine());
			
			//Adicionando classifica��o indicativa
			printClassification();
			int classification = readIntValue();
			if(classification == 1) {
				title.setClassification("LIVRE PARA TODOS OS P�BLICOS");
			}else if(classification == 2) {
				title.setClassification("INAPROPRIADO PARA MENORES DE 10 ANOS");
			}else if(classification == 3) {
				title.setClassification("INAPROPRIADO PARA MENORES DE 12 ANOS");
			}else if(classification == 4) {
				title.setClassification("INAPROPRIADO PARA MENORES DE 14 ANOS");
			}else if(classification == 5) {
				title.setClassification("INAPROPRIADO PARA MENORES DE 16 ANOS");
			}else if(classification == 6) {
				title.setClassification("INAPROPRIADO PARA MENORES DE 18 ANOS");
			}else {
				invalidOption();
			}
			
			//Adicionando plataforma
			System.out.println("SELECIONE A PLATAFORMA: ");
			for(int i = 0; i < listOfPlayers.size(); i++) {
				System.out.println((i + 1) + " - " + listOfPlayers.get(i));
			}
			int plataform = readIntValue();
			
			if(plataform >= 1 && plataform <= (listOfPlayers.size() + 1)) {
				title.setPlataforms(listOfPlayers.get(plataform - 1));
			}else {
				invalidOption();
			}
			
			titles.add(title);
			System.out.println("TITULO CADASTRADO COM SUCESSO!!!");
			return title;
		}else {
			System.out.println("N�O H� PLATAFORMAS CADASTRADAS!!! CADASTRE UMA PLATAFORMA PARA HOSPEDAR O TITULO!!!");
			return null;
		}
	}
		
		//Metodo que cria os players
		public static void playerRegistration(Player player, ArrayList<String> listOfPlayers) {
			System.out.println("CADASTRO DE PLAYERS");
			//Adicionando o nome do player
			System.out.println("DIGITE O NOME DO PLAYER: ");
			player.setName(scanner.nextLine());
			
			//Adicionando a url do player
			System.out.println("DIGITE A URL DO PLAYER: ");
			player.setSite(scanner.nextLine());
			
			//Adicionando player criado na lista
			listOfPlayers.add(player.getName());
			System.out.println("PLAYER CADASTRADO COM SUCESSO!!!");
	}
	
	//Metodo que imprime os titulos por gen�ro
	public static void genreTitles(ArrayList<Title> titles, ArrayList<Title> comedy, ArrayList<Title> horror, ArrayList<Title> police, ArrayList<Title> action, ArrayList<Title> adventure) {
		System.out.println("SELECIONE O GEN�RO DESEJADO: ");
		printTypesGenre();
		int typeGenre = readIntValue();
			if(typeGenre == 1) {
				if(action.size() != 0) {
					System.out.println("G�NERO: A��O");
					for(int i = 0; i < action.size(); i++) {
						printResult(action, i);	
					}
				}else {
					printNotResult();
				}
			}else if(typeGenre == 2) {
				if(adventure.size() != 0) {
					System.out.println("G�NERO: AVENTURA");
					for(int i = 0; i < adventure.size(); i++) {
						printResult(adventure, i);	
					}
				}else {
					printNotResult();
				}
			}else if(typeGenre == 3) {
				if(horror.size() != 0) {
					System.out.println("G�NERO: TERROR");
					for(int i = 0; i < horror.size(); i++) {
						printResult(horror, i);	
					}
				}else {
					printNotResult();
				}
			}else if(typeGenre == 4) {
				if(comedy.size() != 0) {
					System.out.println("G�NERO: COM�DIA");
					for(int i = 0; i < comedy.size(); i++) {
						printResult(comedy, i);	
					}
				}else {
					printNotResult();
				}
			}else if(typeGenre == 5) {
				if(police.size() != 0) {
					System.out.println("G�NERO: POLICIAL");
					for(int i = 0; i < police.size(); i++) {
						printResult(police, i);	
					}
				}else {
					printNotResult();
				}
			}else {
				invalidOption();
			}
		}
	
	//M�todo que imprime titulos aleat�rios
	public static void aleatoryTitles(ArrayList<Title> titles){
		if(titles.size() != 0) {
			System.out.println("TOP 5 MAIS RECOMENDADOS: ");
			Random random = new Random();
			int aleatoryNum;
			for(int i = 0; i < 5; i++) {
				aleatoryNum = random.nextInt(titles.size());
				printResult(titles, aleatoryNum);
			}
		}else {
			System.out.println("N�O H� TITULOS CADASTRADOS!!!");
		}
	}
	
	//M�todo que imprime o menu principal
	public static void printMenu() {
		System.out.println("\nMENU - DIGITE A OP��O DESEJADA: ");
		System.out.println("1 - CADASTRAR PLAYER");
		System.out.println("2 - CADASTRAR TITULOS");
		System.out.println("3 - PESQUISAR TITULO");
		System.out.println("4 - RECOMENDA��ES ");
		System.out.println("5 - GEN�ROS");
		System.out.println("0 - SAIR");
	}
	
	//M�todo que imprime op��o inv�lida
	public static void invalidOption() {
		System.out.println("OP��O INV�LIDA!!!");
	}
	
	//M�todo que l� dados do tipo int
	public static int readIntValue() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}
	
	//M�todo que imprime os tipos de g�neros dispon�veis
	public static void printTypesGenre() {
		System.out.println("1 - A��O \n2 - AVENTURA \n3 - TERROR \n4 - COM�DIA \n5 - POLICIAL");
	}
	
	//M�todo que imprime classifica��o indicativa
	public static void printClassification() {
		System.out.println("SELECIONE A OP��O DE CLASSIFICA��O INDICATIVA: ");
		System.out.println("1 - LIVRE PARA TODOS OS PUBLICOS");
		System.out.println("2 - INAPROPRIADO PARA MENORES DE 10 ANOS");
		System.out.println("3 - INAPROPRIADO PARA MENORES DE 12 ANOS");
		System.out.println("4 - INAPRORIADO PARA MENORES DE 14 ANOS");
		System.out.println("5 - INAPROPRIADO PARA MENORES DE 16 ANOS");
		System.out.println("6 - INAPROPRIADO PARA MENORES DE 18 ANOS");
	}
	
	//M�todo que imprime o resultado dos titulos
	public static void printResult(ArrayList<Title> titles, int position) {
		System.out.println("\nNOME: " + titles.get(position) .getTitle());
		System.out.println("TIPO: " + titles.get(position).getType());
		System.out.println("DESCRI��O: " + titles.get(position).getDescription());
		System.out.println("G�NERO: " + titles.get(position).getGenre());
		System.out.println("ELENCO: " + titles.get(position).getCast());
		System.out.println("DIRETOR: " + titles.get(position).getDirector());
		System.out.println("CLASSIFICA��O ET�RIA: " + titles.get(position).getClassification());
		System.out.println("PLATAFORMA DISPON�VEL: " + titles.get(position).getPlataforms());
		System.out.println("\n-----------------------------------------");
	}
	
	//M�todo que imprime quando n�o h� resultados encontrados 
	public static void printNotResult() {
		System.out.println("NENHUM TITULO ENCONTRADO!!!");
	}
}
