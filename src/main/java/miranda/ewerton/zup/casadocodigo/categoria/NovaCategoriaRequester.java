package miranda.ewerton.zup.casadocodigo.categoria;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico.ValorUnico;

public class NovaCategoriaRequester {

	@ValorUnico(classeDeDominio = Categoria.class ,nomeDoCampo = "nome")
	private String nome;
	
	public NovaCategoriaRequester(){};
		
	public NovaCategoriaRequester(String nome) {
	this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Categoria toModel() {
	return new Categoria(nome);
	}

}
