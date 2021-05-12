package miranda.ewerton.zup.casadocodigo.cliente;

public class ClienteResponse {

	private String nome ;
	private String id ;
	
	public ClienteResponse() {}
	
	public ClienteResponse(String nome, String id) {
		this.id = id ;
		this.nome = nome ;
	}

	public ClienteResponse(Cliente cliente) {	
		id = cliente.getId().toString();
		nome = cliente.getNome();		
	}

	public String getNome() {
		return nome;
	}
	public String getId() {
		return id;
	}	
	
}
