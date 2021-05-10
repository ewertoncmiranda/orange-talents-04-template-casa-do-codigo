package miranda.ewerton.zup.casadocodigo.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import miranda.ewerton.zup.casadocodigo.autor.Autor;
import miranda.ewerton.zup.casadocodigo.categoria.Categoria;

@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	
	private String titulo ;
		
	private String resumo ;
		
	private String sumario ;
		
	private BigDecimal preco ;
	
	private int paginas;	
	
	private String isbn ;	
		
	private LocalDate dataPublicacao ;
		
	@ManyToOne
	private Autor autor ;
	
	@ManyToOne
	private Categoria categoria ;	
	
	public Livro() {}
	
	public Livro(@NotBlank String titulo, @NotBlank String sumario, @NotBlank String isbn,
			@NotBlank @Size(max = 500) String resumo, @NotNull @Min(20) BigDecimal preco, @Min(200) int paginas,
			@Future @NotNull LocalDate dataPublicacao, @NotNull @Valid Autor autor, @NotNull @Valid Categoria categoria) {
				
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", paginas=" + paginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao + ", autor="
				+ autor + ", categoria=" + categoria + "]";
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
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

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

 

}
