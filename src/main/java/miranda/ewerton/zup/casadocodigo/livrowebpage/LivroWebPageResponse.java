package miranda.ewerton.zup.casadocodigo.livrowebpage;

import java.time.format.DateTimeFormatter;

import miranda.ewerton.zup.casadocodigo.livro.Livro;

public class LivroWebPageResponse {
	
	@Deprecated
	public LivroWebPageResponse(){}
	
	public LivroWebPageResponse(Livro livro) {
	
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco().toString();
		this.isbn = livro.getIsbn();
		this.nomeAutor = livro.getAutor().getNome();
		this.descricaoAutor = livro.getAutor().getDescricao();		
		this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
	}

	private String titulo ;
	private String resumo ;
	private String sumario ;
	private String preco ;
	private String isbn ;
	private String dataPublicacao ;
	
	private String nomeAutor;
	private String descricaoAutor;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public String getSumario() {
		return sumario;
	}
	public void setSumario(String sumario) {
		this.sumario = sumario;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getDescricaoAutor() {
		return descricaoAutor;
	}
	public void setDescricaoAutor(String descricaoAutor) {
		this.descricaoAutor = descricaoAutor;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
	
	
	
}
