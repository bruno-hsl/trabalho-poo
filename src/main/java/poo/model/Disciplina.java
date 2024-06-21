package poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disciplina {
    @Id
    private Long id;
    
    private String nome;
    private String descrição;

    public Disciplina(){}


    public Disciplina(String nome, String descrição) {
        this.nome = nome;
        this.descrição = descrição;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrição() {
        return this.descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }


}
