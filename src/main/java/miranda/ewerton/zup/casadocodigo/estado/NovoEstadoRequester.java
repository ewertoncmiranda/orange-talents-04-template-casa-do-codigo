package miranda.ewerton.zup.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.existid.ExistsId;
import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico.ValorUnico;
import miranda.ewerton.zup.casadocodigo.pais.Pais;


public class NovoEstadoRequester {

	@NotNull
	@ValorUnico(classeDeDominio = Estado.class, nomeDoCampo = "nome")
	private String nome;

	@NotNull
	@ExistsId(classeDeDominio = Pais.class, nomeDoCampo = "id", message = "Id de pais não encontrado!")
	private Long idPais;

	public NovoEstadoRequester(String nome, Long id) {
		this.nome = nome;
		this.idPais = id;
	}

	public NovoEstadoRequester() {
	}

	@Override
	public String toString() {
		return "NovoEstadoRequester [nome=" + nome + ", idPais=" + idPais + "]";
	}

	public Estado toModel(EntityManager em) {
		Pais pais = em.find(Pais.class, this.idPais);
		return new Estado(nome ,pais);
	}

	public Long getIdPais() {
		return idPais;
	}

	public String getNome() {
		return nome;
	}

}
