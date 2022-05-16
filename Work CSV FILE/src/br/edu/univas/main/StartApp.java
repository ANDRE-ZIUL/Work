package br.edu.univas.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Scanner;

public class StartApp {

	static Scanner scanner = new Scanner(System.in);
	
	static String file = System.getenv("CSV_FILE");
	
	public static void main(String[] args) throws IOException{
		
		
		while(true) {
			printMenu();
			int option = readIntValue();
			
			if(option >= 1 && option <= 4) {
				attendanceList(option);
			}else if(option == 9) {
				System.out.println("OBRIGADO POR USAR O SISTEMA, ATÉ A PRÓXIMA!!!");
				break;
			}else {
				System.out.println("OPÇÃO INVÁLIDA!!! POR FAVOR DIGITE UMA OPÇÃO VÁLIDA!!!\n");
			}
		}
	}
	
	public static void attendanceList(int option) throws IOException {
		String discipline = "";
		String nameDiscipline = "";
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd_MM_yyyy");
		DateTimeFormatter date2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
		if(option == 1) {
			discipline = "tecnicas_de_programacao_3_";
			nameDiscipline = "TÉCNICAS DE PROGRAMAÇÃO 3";
		}else if(option == 2) {
			discipline = "estrutura_de_dados_";
			nameDiscipline = "ESTRUTURA DE DADOS";
		}else if(option == 3) {
			discipline = "sistemas_operacionais_";
			nameDiscipline = "SISTEMAS OPERACIONAIS";
		}else if(option == 4) {
			discipline = "arquitetura_de_computadoes_2_";
			nameDiscipline = "ARQUITETURA DE COMPUTADORES 2";
		}
		
		String names = "LISTA DE PRESENÇA " + nameDiscipline + " DATA: " +  date2.format(LocalDateTime.now()) + "\n";
		String directory = newLocal(file);
		Path path = Path.of(directory + discipline + date.format(LocalDateTime.now())+ ".txt");
		
		System.out.println("DIGITE O NOME COMPLETO DO ALUNO: ");
		names = names + scanner.nextLine() + "\n";
		while(true) {
			System.out.println("DESEJA ADICIONAR MAIS UM ALUNO ? \n1 - SIM \n2 - NÃO");
			int option2 = readIntValue();
			if(option2 == 1) {
				System.out.println("DIGITE O NOME COMPLETO DO ALUNO: ");
				names = names + scanner.nextLine() + "\n";
			}else if(option2 == 2) {
				System.out.println("LISTA DE PRESENÇA GERADA COM SUCESSO!\n");
				break;
			}else {
				System.out.println("OPÇÃO INVÁLIDA!!! DIGITE UMA OPÇÃO VÁLIDA!!!\n");
			}
		}
		Files.writeString(path, names);
	}
	
	public static String newLocal(String newFile) {
		int value = newFile.lastIndexOf("\\");
		return newFile.substring(0, value + 1);
	}
	
	public static void printMenu() {
		System.out.println(":::CHAMADA::: \nESCOLHA A DISCIPLINA QUE DESEJA REALIZAR A CHAMADA: ");
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while(line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println("9 - SAIR");
	}
	
	public static int readIntValue() {
		int value = scanner.nextInt();
		scanner.nextLine();
		return value;
	}
}
