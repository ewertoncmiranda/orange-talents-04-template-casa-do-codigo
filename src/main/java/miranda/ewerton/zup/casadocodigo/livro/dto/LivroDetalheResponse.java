package miranda.ewerton.zup.casadocodigo.livro.dto;

import miranda.ewerton.zup.casadocodigo.livro.Livro;

public class LivroDetalheResponse {

	private String titulo;

	private Long id;

	public LivroDetalheResponse() {
	};

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
