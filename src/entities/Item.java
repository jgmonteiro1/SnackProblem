package entities;

public class Item {
	private String nome;
	private float preco;
	private float peso;
	private boolean ativo;
	
	
	public Item(String nome, float preco, float peso, boolean ativo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.peso = peso;
		this.ativo = ativo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}
