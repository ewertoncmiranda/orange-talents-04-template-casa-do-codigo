package miranda.ewerton.zup.casadocodigo.pais;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String nome ;
	
	public Pais() {}
	
	public Pais(String nome) {
		this.nome =nome;
	}

	public Long getId() {return id;	}
	public String getNome() {return nome;}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + "]";
	}
		
	
}
