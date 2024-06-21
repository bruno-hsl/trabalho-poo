package poo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String curso;

    public Aluno(){};

    public Aluno(String nome, String cpf, String celular, String email, String curso) {
        super(nome, cpf, celular, email);
        this.curso = curso;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id_matricula) {
        this.id = id_matricula;
    }

    public String getCurso() {
        return this.curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }



    @Override
    public String toString() {
        return String.format(
        "| %-5s | %-10s | %-20s | %-15s | %-15s | %-30s |%n",
        "id", "curso", "nome", "cpf", "celular", "email") +
        String.format(
        "| %-5s | %-10s | %-20s | %-15s | %-15s | %-30s |%n",
        getId(), getCurso(), getNome(), getCpf(), getCelular(), getEmail());
    }

}
