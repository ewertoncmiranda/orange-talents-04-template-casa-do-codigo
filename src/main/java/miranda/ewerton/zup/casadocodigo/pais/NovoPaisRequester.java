package miranda.ewerton.zup.casadocodigo.pais;

import javax.validation.constraints.NotNull;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico.ValorUnico;

public class NovoPaisRequester {

	@NotNull
	@ValorUnico(classeDeDominio = Pais.class ,nomeDoCampo = "nome" ,message = "Nome do pais já cadastrado! Escolha outro.")
	private String nome;
	
	public Pais toModel(){return new Pais(nome);}

	public String getNome(){return nome;}
	
}
