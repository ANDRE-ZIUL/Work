package br.edu.univas.vo;

public class students {

	private String name;
	
	private int age;
	
	private int cpf;
	
	private String fatherName;
	
	private String motherName;
	
	//NAME------------------------------------------------
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	//AGE-------------------------------------------------
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	//CPF-------------------------------------------------
	public void setCPF(int cpf) {
		this.cpf = cpf;
	}
	
	public int getCPF() {
		return cpf;
	}
	
	//FATHER NAME------------------------------------------
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	
	public String getFatherName() {
		return fatherName;
	}
	
	//MOTHER NAME------------------------------------------
		public void setMotherName(String motherName) {
			this.motherName = motherName;
		}
		
		public String getMotherName() {
			return motherName;
		}
}









