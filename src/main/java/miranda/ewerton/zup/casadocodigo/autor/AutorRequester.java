package miranda.ewerton.zup.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import miranda.ewerton.zup.casadocodigo.compatilhado.validacao.ValorUnico;

public class AutorRequester {

    @NotBlank @Email @ValorUnico(domainClass = Autor.class ,nomeDoCampo = "email") private String email ;
    @NotBlank private String nome ;
    @Size(max=400,min=0)private String descricao ;

    public AutorRequester(@Email @NotBlank String email,
                          @NotBlank String nome,
                          @Size(max = 400 ,min = 0)  String descricao) {
        this.email = email;
        this.nome = nome;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
    
    public String getEmail() { return email;   }
    public String getNome() { return nome;   }
    public String getDescricao() {return descricao;  }
    public Autor toModel() {return new Autor(this.nome , this.email ,this.descricao);    }
    
}
