package miranda.ewerton.zup.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

import miranda.ewerton.zup.casadocodigo.pais.Pais;
import miranda.ewerton.zup.casadocodigo.validacao.estadounicoporpais.EstadoUnicoPorPais;
import miranda.ewerton.zup.casadocodigo.validacao.existid.ExistsId;

@EstadoUnicoPorPais(classeDeDominio = Estado.class ,campoNome = "nome",campoIdPais = "idPais" , message = "Não é possivel cadastrar mais de um estado com mesmo nome por Pais.")
public class NovoEstadoRequester {

	@NotNull
	private String nome;

	@NotNull
	@ExistsId(classeDeDominio = Estado.class, nomeDoCampo = "id", message = "Id de pais não encontrado!")
	private Long idPais;

	public NovoEstadoRequester(String nome, Long id) {
		this.nome = nome;
		this.idPais = id;
	}

	public NovoEstadoRequester() {}

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
