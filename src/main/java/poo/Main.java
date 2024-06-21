package poo;

import java.util.Scanner;

import poo.dao.AlunoDAO;
import poo.dao.DisciplinaDAO;
import poo.dao.ProfessorDAO;
import poo.model.Aluno;
import poo.model.Disciplina;
import poo.model.Professor;

public class Main {
    
    private static Scanner leitura = new Scanner(System.in);
    public static void main(String[] args) {
        
        int opcao;

        do {
            exibirMenuPrincipal();
            System.out.print("Escolha uma opção: ");
            opcao = leitura.nextInt();
            leitura.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    submenuCadastrar(leitura);
                    break;
                case 2:
                    submenuConsultar(leitura);
                    break;
                case 3:
                    submenuAtualizar(leitura);
                    break;
                case 4:
                    submenuExcluir(leitura);
                    break;
                case 5:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        leitura.close();
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n============= MENU =============");
        System.out.println("1. Cadastrar");
        System.out.println("2. Consultar");
        System.out.println("3. Atualizar");
        System.out.println("4. Excluir");
        System.out.println("5. Sair");
        System.out.println("================================");
    }

    private static void submenuCadastrar(Scanner leitura) {
        int escolha;

        do {
            System.out.println("\nEscolha o que deseja cadastrar:");
            System.out.println("1. Cadastrar Professor");
            System.out.println("2. Cadastrar Aluno");
            System.out.println("3. Cadastrar Disciplina");
            System.out.println("4. Voltar ao menu principal");

            System.out.print("Opção: ");
            escolha = leitura.nextInt();
            leitura.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    cadastrarProfessor();
                    break;
                case 2:
                    cadastrarAluno();
                    break;
                case 3:
                    cadastrarDisciplina();
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);
    }

    private static void submenuConsultar(Scanner leitura) {
        int escolha;

        do {
            System.out.println("\nEscolha como deseja consultar:");
            System.out.println("1. Lista de Alunos");
            System.out.println("2. Lista de Professores");
            System.out.println("3. Consultar Aluno por ID");
            System.out.println("4. Consultar Professor por ID");
            System.out.println("5. Voltar ao menu principal");

            System.out.print("Opção: ");
            escolha = leitura.nextInt();
            leitura.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    listarAlunos();
                    break;
                case 2:
                    listarProfessores();
                    break;
                case 3:
                    consultarAlunoPorId();
                    break;
                case 4:
                    consultarProfessorPorId();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 5);
    }

    private static void submenuAtualizar(Scanner leitura) {
        int escolha;

        do {
            System.out.println("\nEscolha quem deseja Atualizar:");
            System.out.println("1. Atualizar Professor");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Voltar ao menu principal");

            System.out.print("Opção: ");
            escolha = leitura.nextInt();
            leitura.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    atualizarProfessor();
                    break;
                case 2:
                    atualizarAluno();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 3);
    }

    private static void submenuExcluir(Scanner leitura){
        int escolha;

        do {
            System.out.println("\nEscolha quem deseja Excluir:");
            System.out.println("1. Excluir Professor");
            System.out.println("2. Excluir Aluno");
            System.out.println("3. Voltar ao menu principal");

            System.out.print("Opção: ");
            escolha = leitura.nextInt();
            leitura.nextLine(); // Limpar o buffer do scanner

            switch (escolha) {
                case 1:
                    deletarProfessor();
                    break;
                case 2:
                    deletarAluno();
                    break;
                case 3:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 4);
    }

    private static void cadastrarProfessor() {
        System.out.println("\nCadastrando Professor...");
        
        System.out.print("Nome: ");
        String nome = leitura.nextLine();

        System.out.print("CPF: ");
        String cpf = leitura.nextLine();

        System.out.print("Celular: ");
        String celular = leitura.nextLine();

        System.out.print("Email: ");
        String email = leitura.nextLine();

        System.out.print("Especialização: ");
        String especializacao = leitura.nextLine();

        Professor professor = new Professor(nome, cpf, celular, email, especializacao);
        ProfessorDAO dao = new ProfessorDAO();
        dao.cadastrarProfessor(professor);
    }

    private static void cadastrarAluno() {
        System.out.println("\nCadastrando Aluno...");
        
        System.out.print("Nome: ");
        String nome = leitura.nextLine();

        System.out.print("CPF: ");
        String cpf = leitura.nextLine();

        System.out.print("Celular: ");
        String celular = leitura.nextLine();

        System.out.print("Email: ");
        String email = leitura.nextLine();

        System.out.print("Curso: ");
        String curso = leitura.nextLine();

        Aluno aluno = new Aluno(nome, cpf, celular, email, curso);
        AlunoDAO dao = new AlunoDAO();
        dao.cadastrarAluno(aluno);

    }

    private static void cadastrarDisciplina() {
        System.out.println("\nCadastrando Disciplina...");

        System.out.println("Nome ");
        String nome = leitura.nextLine();

        System.out.println("Descrição: ");
        String descricao = leitura.nextLine();

        Disciplina disciplina = new Disciplina(nome, descricao);
        DisciplinaDAO dao = new DisciplinaDAO();
        dao.cadastrarDisciplina(disciplina);

    }

    private static void listarAlunos(){
        System.out.println("\nLista de Alunos");

        AlunoDAO dao = new AlunoDAO();
        dao.mostarAlunos();
    }

    private static void listarProfessores(){
        System.out.println("\nLista de Professores");

        ProfessorDAO dao = new ProfessorDAO();
        dao.mostarProfessores();
    }

    private static void consultarAlunoPorId() {
        System.out.println("\nConsultar Aluno por ID...");

        System.out.println("Digite o ID do aluno: ");
        Long id = leitura.nextLong();
        leitura.nextLine();

        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.getAlunoById(id);

        if (aluno != null) {
            System.out.println("Resultado:\n");
            System.out.println(aluno.toString());
        } else {
            System.out.println("\nNenhum aluno encontrado com o ID informado.");
        }
    }        

    private static void consultarProfessorPorId() {
        System.out.println("\nConsultar Aluno por ID...");

        System.out.println("Digite o ID do aluno: ");
        Long id = leitura.nextLong();
        leitura.nextLine();

        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = dao.getProfessorById(id);

        if (professor != null) {
            System.out.println("Resultado:\n");
            System.out.println(professor.toString());
        } else {
            System.out.println("\nNenhum professor encontrado com o ID informado.");
        }
    }        

    private static void atualizarProfessor(){
        System.out.println("\nAtualizar Professor...");
    
        System.out.print("Digite o ID do professor que deseja atualizar: ");
        Long id = leitura.nextLong();
        leitura.nextLine();
    
        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = dao.getProfessorById(id);
    
        if (professor != null) {
            System.out.println("Professor encontrado:");
            System.out.println(professor.toString());
    
            System.out.println("Digite os novos dados do professor:");
    
            System.out.print("Nome: ");
            String nome = leitura.nextLine();
    
            System.out.print("CPF: ");
            String cpf = leitura.nextLine();
    
            System.out.print("Celular: ");
            String celular = leitura.nextLine();
    
            System.out.print("Email: ");
            String email = leitura.nextLine();
    
            System.out.print("Especialização: ");
            String especializacao = leitura.nextLine();
    
            professor.setNome(nome);
            professor.setCpf(cpf);
            professor.setCelular(celular);
            professor.setEmail(email);
            professor.setEspecializacao(especializacao);

            dao.atualizarProfessor(professor);
        } else {
            System.out.println("\nNenhum professor encontrado com o ID informado.");
        }
    }

    private static void atualizarAluno() {
        System.out.println("\nAtualizar Aluno...");
    
        System.out.print("Digite o ID do aluno que deseja atualizar: ");
        Long id = leitura.nextLong();
        leitura.nextLine(); // Limpar o buffer do scanner
    
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.getAlunoById(id);
    
        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println(aluno.toString());
    
            System.out.println("Digite os novos dados do aluno:");
    
            System.out.print("Nome: ");
            String nome = leitura.nextLine();
    
            System.out.print("CPF: ");
            String cpf = leitura.nextLine();
    
            System.out.print("Celular: ");
            String celular = leitura.nextLine();
    
            System.out.print("Email: ");
            String email = leitura.nextLine();
    
            System.out.print("Curso: ");
            String curso = leitura.nextLine();
    
            aluno.setNome(nome);
            aluno.setCpf(cpf);
            aluno.setCelular(celular);
            aluno.setEmail(email);
            aluno.setCurso(curso);
    
            dao.atualizarAluno(aluno);
        } else {
            System.out.println("\nNenhum aluno encontrado com o ID informado.");
        }
    }
    
    private static void deletarAluno(){
        System.out.println("\nExcluir Aluno...");
    
        System.out.print("Digite o ID do aluno que deseja excluir: ");
        Long id = leitura.nextLong();
        leitura.nextLine(); // Limpar o buffer do scanner
    
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = dao.getAlunoById(id);
    
        if (aluno != null) {
            System.out.println("Aluno encontrado:");
            System.out.println(aluno.toString());
    
            dao.deletarAluno(aluno);
            System.out.println("Excluído com sucesso!");
        } else {
            System.out.println("\nNenhum aluno encontrado com o ID informado.");
        }
    }

    private static void deletarProfessor(){
        System.out.println("\nExcluir Aluno...");
    
        System.out.print("Digite o ID do aluno que deseja excluir: ");
        Long id = leitura.nextLong();
        leitura.nextLine(); // Limpar o buffer do scanner
    
        ProfessorDAO dao = new ProfessorDAO();
        Professor professor = dao.getProfessorById(id);
    
        if (professor != null) {
            System.out.println("Professor encontrado:");
            System.out.println(professor.toString());
    
            dao.deletarProfessor(professor);
            System.out.println("Excluído com sucesso!");
        } else {
            System.out.println("\nNenhum professor encontrado com o ID informado.");
        }
    }
}

