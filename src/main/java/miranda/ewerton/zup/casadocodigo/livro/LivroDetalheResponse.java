package miranda.ewerton.zup.casadocodigo.livro;

public class LivroDetalheResponse {

	private String titulo;

	private Long id;

	public LivroDetalheResponse() {
	};

	public LivroDetalheResponse(String titulo, Long id) {
		this.id = id;
		this.titulo = titulo;
	}

	public LivroDetalheResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public String getTitulo() {
		return titulo;
	}

	public Long getId() {
		return id;
	}

}
