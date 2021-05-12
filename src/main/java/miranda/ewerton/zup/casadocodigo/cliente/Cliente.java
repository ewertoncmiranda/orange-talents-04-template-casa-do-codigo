package miranda.ewerton.zup.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import miranda.ewerton.zup.casadocodigo.estado.Estado;
import miranda.ewerton.zup.casadocodigo.pais.Pais;

@Entity
public class Cliente {
	
	public Cliente() { };
	
	public Cliente(String email, String nome, String sobrenome, String documento, String endereco,
			String complemento, String cidade, String telefone, String cep, Pais pais, Estado estado) {
		
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.telefone = telefone;
		this.cep = cep;
		this.pais = pais;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String email;

	private String nome;
	
	private String sobrenome;
	
	private String documento;

	private String endereco;

	private String complemento;

	private String cidade;

	private String telefone;

	private String cep;
	
	@ManyToOne
	private Pais pais ;
	
	@ManyToOne
	private Estado estado ;

	public Long getId() {
		return id;
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

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}
	
 
	
	
	
}
