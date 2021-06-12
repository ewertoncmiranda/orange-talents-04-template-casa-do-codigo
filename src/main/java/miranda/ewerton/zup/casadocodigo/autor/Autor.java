package miranda.ewerton.zup.casadocodigo.autor;

import miranda.ewerton.zup.casadocodigo.livro.Livro;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String email ;
    private String nome ;
    private String descricao ;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome ;
        this.email = email ;
        this.descricao = descricao;
    }
    public Autor() {};
    public Long getId() {
        return id;
    }
    public String getEmail() { return email;}
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public LocalDateTime getDataCriacao(){return dataCriacao;}

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
