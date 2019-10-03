package entities;

import java.util.ArrayList;

public class Population {
	
	private ArrayList<Cromossomo> cromossomo = new ArrayList<>();
	private double corte;
	private int tamanhoPopulacao;
	private ArrayList<Item> listItem = new ArrayList<>();
	
	public Population(int tamanhoPopulacao, ArrayList<Item> listItem) {
		super();
		this.tamanhoPopulacao = tamanhoPopulacao;
		this.listItem = listItem;
	}
	
	public void gerarPopulacao() {
		//Garante que seja a população máxima
		while(cromossomo.size() < tamanhoPopulacao) {
			//Se a população for menor que metade do tamaho eu continuo preenchendo
			if(cromossomo.size()< tamanhoPopulacao / 5) {
				cromossomo.add(new Cromossomo(listItem));
			} else {
				
			}
		}
	}
	
}
