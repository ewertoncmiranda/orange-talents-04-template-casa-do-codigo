package miranda.ewerton.zup.casadocodigo.estado;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import miranda.ewerton.zup.casadocodigo.pais.Pais;

@Entity
public class Estado {

	public Estado() {};
	
	public Estado(String nome) {this.nome=nome ;	};
	public Estado(String nome ,Pais pais) {
		this.nome=nome ;	
		this.pais = pais ;
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;	
	
	private String nome ;
	
	@ManyToOne
	private Pais pais ;	

	public Long getId() {return id;}

	public String getNome() {return nome;}

	@Override
	public String toString() {
		return "Estado [id= " + id + ", nome= " + nome + "]";
	}

	public Pais getPais() {
		return pais;
	}
	
	
}
