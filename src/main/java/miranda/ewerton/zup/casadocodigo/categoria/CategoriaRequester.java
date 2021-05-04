package miranda.ewerton.zup.casadocodigo.categoria;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.ValorUnico;

public class CategoriaRequester {

	@ValorUnico(nomeDoCampo = "nome" , domainClass = Categoria.class)
	private String nome;
	
	public String getNome() {
		return this.nome;
	}
	
	public Categoria toModel() {
		return new Categoria(nome); 
	}	
	
}
