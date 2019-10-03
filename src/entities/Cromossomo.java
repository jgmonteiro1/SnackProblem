package entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Cromossomo {
	
	//Peso total suportado pelo cromossomo
	private float pesoTotal;
	//A soma de todos os valores(Beneficio)
	private float valorTotal;
	//Capacidade máxima suportada pela mochila
	private float capacidadeMaxima;
	//Probabilidade de haver mutação no cromossomo
	private float probabilidadeMutacao;
	//Aptidão do indivíduo
	private float aptidaoTotal;
	//Lista de genes;
	private ArrayList<Item> genes;
	
	
	
	public Cromossomo(ArrayList<Item> genes) {
		super();
		this.genes = genes;
		
		// percorrer a lista de genes e definir os ativos e inativos
		for(Item item : genes) {
			Random r = new Random();
			//Seta os itens ativos ou não aleatoriamente
			item.setAtivo(r.nextBoolean());
		}
	}
	
	
	
	
	public float getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(float capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public float getProbabilidadeMutacao() {
		return probabilidadeMutacao;
	}

	public void setProbabilidadeMutacao(float probabilidadeMutacao) {
		this.probabilidadeMutacao = probabilidadeMutacao;
	}

	public float getPesoTotal() {
		return pesoTotal;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public ArrayList<Item> getGenes() {
		return genes;
	}
	
	
	public void realizarMutacao() {
		//Se o número randomico for menor que a probabilidade de mutação, ele entra no if e gera uma mutação
		if(Math.random() < this.probabilidadeMutacao) {
			int count = 0;
			Random r = new Random();
			for(Item gene : this.genes) {
				//Se o número aleatório for menor que 5(representa a porcentagem de chance de haver mutação = 5%) ele altera o estado do gene, ou seja, se ele estiver ativo passa a estar inativo e vice versa
				if(r.nextInt(101) < 5) {
					gene.setAtivo(!gene.isAtivo());
				}
			}
		}
	}

	public float CalculodeAptidao() {
		
		if(this.aptidaoTotal > 0) {
			return this.aptidaoTotal;
		}
		
		
		this.pesoTotal = 0;
		this.valorTotal = 0;
		this.aptidaoTotal = 0;
		
		for(Item gene : this.genes) {
			//Só será calculado o item que foi selecionado
			if(gene.isAtivo()) {
				this.pesoTotal += gene.getPeso();
				this.valorTotal += gene.getPreco();
			}
		}
		
		this.aptidaoTotal = this.valorTotal;
		
		//Se o peso total for maior que a capacidade maxima permitida eu realizo uma punição no cromossomo
		if(this.pesoTotal > this.capacidadeMaxima) {
			this.aptidaoTotal -= (this.pesoTotal - this.capacidadeMaxima) * 100;
		}
		
		
		return this.aptidaoTotal;
	}
	
	public void Crossover (Cromossomo other){
		int tam = this.genes.size();
		int cut = (int) tam/2;
		ArrayList<Item> child1 = new ArrayList();
		ArrayList<Item> child2 = new ArrayList();
		Iterator<Item> j = other.getGenes().iterator();
		int i = 0;
		
		for(Item gene: this.genes) {
			if(i < cut) {
				child2.add(gene);
				child1.add(j.next());
			}else {
				child1.add(gene);
				child2.add(j.next());
			}
			
			i++;
		}
		
		this.genes = child1;

	}
}
