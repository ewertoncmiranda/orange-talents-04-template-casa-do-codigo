package miranda.ewerton.zup.casadocodigo.categoria;

import javax.validation.constraints.NotEmpty;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.ValorUnico;

public class CategoriaRequester {
	
	@ValorUnico(nomeDoCampo = "nome" , domainClass = Categoria.class)
	@NotEmpty
	private String nome;
	
	public CategoriaRequester (String nome) {this.nome = nome ;	}
	
	public String getNome() {return this.nome;}	
	
	public Categoria toModel() {return new Categoria(nome); }

	@Override
	public String toString() {return "Categoria[nome=" + nome + "]"; }	
	
	
	
}
