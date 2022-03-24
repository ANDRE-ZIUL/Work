package br.edu.univas.main;

import java.util.Scanner;

import br.edu.univas.vo.students;

public class listOfStudents {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		students list = new students();
		students[] printList = new students[100];
		boolean acepted = true;
		int students = 0;
		
		while(acepted == true) {
		printMenu();
		int option = scanner.nextInt();
		scanner.nextLine();
		
		if(option == 1) {
			studentRegistration(list, printList, students, scanner);
		}else if(option == 2) {
			printList(printList, students);
		}else if(option == 9) {
			System.out.println("PROGRAMA ENCERRADO!");
			acepted = false;
		}else {
			System.out.println("OPÇÃO INVÁLIDA!!! POR FAVOR DIGITE UMA OPÇÃO VÁLIDA!!!");
			}
		}
	}


	public static void printMenu() {
		System.out.println("MENU - ESCOLHA A OPÇÃO DESEJADA: \n1 - CADASTRAR NOVO ALUNO \n2 - ALUNOS CADASTRADOS \n9 - SAIR");
	}
	
	public static void studentRegistration(students list, students printList[], int students, Scanner scanner) {
				
		System.out.println("NOVO CADASTRO");
		System.out.println("NOME COMPLETO DO ALUNO: ");
		list.setName(scanner.nextLine());
		System.out.println("IDADE DO ALUNO: ");
		list.setAge(scanner.nextInt());
		System.out.println("CPF DO ALUNO: ");
		list.setCPF(scanner.nextInt());
		scanner.nextLine();
		System.out.println("NOME COMPLETO DA MÃE OU RESPONSÁVEL: ");
		list.setMotherName(scanner.nextLine());
		System.out.println("NOME COMPLETO DO PAI OU RESPONSÁVEL: ");
		list.setFatherName(scanner.nextLine());
		
		printList[students] = list;
		students++;
	}
	
	public static void printList(students printList[], int students) {
		System.out.println("LISTA DE ALUNOS CADASTRADOS");
		for(int i = 0; i < students; i++) {
			System.out.println(printList[i]);
		}
	}

}


