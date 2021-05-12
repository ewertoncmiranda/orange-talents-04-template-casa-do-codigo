package miranda.ewerton.zup.casadocodigo.cliente;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico.ValorUnico;
import miranda.ewerton.zup.casadocodigo.estado.Estado;
import miranda.ewerton.zup.casadocodigo.pais.Pais;
import miranda.ewerton.zup.casadocodigo.validacao.estadoPertencePais.EstadoPertencePais;
import miranda.ewerton.zup.casadocodigo.validacao.existid.ExistsId;

@EstadoPertencePais(campoIdEstado = "idEstado" ,campoIdPais = "idPais" ,classeDeDominio = Estado.class)
public class NovoClienteRequester {

	public NovoClienteRequester() {
	}

	@NotNull
	@Email
	@ValorUnico(nomeDoCampo = "email", classeDeDominio = Cliente.class)
	private String email;

	@NotNull
	@NotEmpty
	private String nome;

	@NotNull
	@NotEmpty
	private String sobrenome;

	@CPF
	@ValorUnico(nomeDoCampo = "email", classeDeDominio = Cliente.class)
	private String documento;

	@NotNull
	@NotEmpty
	private String endereco;

	@NotEmpty
	private String complemento;

	@NotEmpty
	private String cidade;

	@ExistsId(classeDeDominio = Pais.class, nomeDoCampo = "id")
	private Long idPais;

	@ExistsId(classeDeDominio = Estado.class, nomeDoCampo = "id")
	private Long idEstado;

	@NotNull
	@NotEmpty
	private String telefone;

	@NotNull
	@NotEmpty
	private String cep;	
	
	
	public Cliente toModel(EntityManager em)  {
	
	Pais pais = em.find(Pais.class,	idPais);
	Estado estado = em.find(Estado.class, idEstado);
		 
	return new Cliente( email, nome, sobrenome, documento, endereco, complemento, cidade, telefone, cep, pais, estado);
			
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCEP() {
		return cep;
	}

	@Override
	public String toString() {
		return "NovoClienteRequester [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", idPais=" + idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", CEP=" + cep + "]";
	}

}
