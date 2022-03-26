package br.edu.univas.vo;

import java.util.ArrayList;

public class Player {

	private String name;

	private String site;
	
	public ArrayList<String> listPlayers;

	//GETTERS AND SETTERS ------------------------------------------------------------------------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}
