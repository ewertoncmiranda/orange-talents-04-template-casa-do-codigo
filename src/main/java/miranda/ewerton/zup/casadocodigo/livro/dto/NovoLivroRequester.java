package miranda.ewerton.zup.casadocodigo.livro.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import miranda.ewerton.zup.casadocodigo.autor.Autor;
import miranda.ewerton.zup.casadocodigo.categoria.Categoria;
import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.valorunico.ValorUnico;
import miranda.ewerton.zup.casadocodigo.livro.Livro;
import miranda.ewerton.zup.casadocodigo.validacao.existid.ExistsId;

public class NovoLivroRequester {
	
	@NotBlank
	@ValorUnico(classeDeDominio = Livro.class , nomeDoCampo = "titulo")
	private String titulo ;
	
	@NotBlank 
	@Size(max = 500)
	private String resumo ;
	
	@NotBlank
	private String sumario ;
	
	@NotNull
	@Min(20)	
	private BigDecimal preco ;
	
	@Min(200)
	private int paginas;	
	
	@NotBlank
	@ValorUnico(classeDeDominio = Livro.class , nomeDoCampo = "isbn")
	private String isbn ;	
	
	public String getTitulo() {
		return titulo;
	}

	@Future @JsonFormat(pattern = "dd/MM/yyyy" ,shape = Shape.STRING)
	@NotNull
	private LocalDate dataPublicacao ;
	
	@NotNull
	@ExistsId(classeDeDominio = Autor.class ,nomeDoCampo = "id")
	private Long idAutor ;
	
	@NotNull
	@ExistsId(classeDeDominio = Categoria.class ,nomeDoCampo = "id")
	private Long idCategoria ;

	public NovoLivroRequester() {	
	}
	
	
	public Livro toModel(EntityManager em) {
	
	@NotNull Autor autor = em.find(Autor.class, idAutor);	
	@NotNull Categoria categoria = em.find(Categoria.class, idCategoria);	
	
	Assert.state(autor!=null,"Voce esta querendo cadastrar um livro para um autor que não existe!");
	Assert.state(categoria!=null,"Voce esta querendo cadastrar uma categoria para um autor que não existe!");
	
	return new Livro(titulo , sumario , isbn , resumo , preco , paginas ,dataPublicacao,autor, categoria);
	
	}

	@Override
	public String toString() {
		return "NovoLivroRequester [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", paginas=" + paginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", idAutor=" + idAutor + ", idCategoria=" + idCategoria + "]";
	}

	public NovoLivroRequester(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo,
			@NotBlank String sumario, @NotNull @Min(20) BigDecimal preco, @Min(200) int paginas, @NotBlank String isbn,
			@Future @NotNull LocalDate dataPublicacao, @NotNull Long idAutor, @NotNull Long idCategoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.idAutor = idAutor;
		this.idCategoria = idCategoria;
	}

	

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	
	
}
