package miranda.ewerton.zup.casadocodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String email ;
    private String nome ;
    private String descricao ;
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome ;
        this.email = email ;
        this.descricao = descricao;
    }

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