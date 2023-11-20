package com.example.aluno;


import com.example.aluno.aluno.Aluno;
import com.example.aluno.aluno.AlunoService;
import com.example.aluno.disciplina.Disciplina;
import com.example.aluno.disciplina.DisciplinaService;
import com.example.aluno.matricula.Matricula;
import com.example.aluno.matricula.MatriculaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AlunoApplication implements CommandLineRunner {

    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    private final MatriculaService matriculaService;


    public AlunoApplication(AlunoService alunoService, DisciplinaService disciplinaService, MatriculaService matriculaService){
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
        this.matriculaService = matriculaService;
    }

    public static void main(String[] args) {
        SpringApplication.run(AlunoApplication.class, args);
    }

    @Override
    public void run(String... args){
        Scanner scanner = new Scanner(System.in);
        int option = showOptions();

        while (option != 7) {

            switch (option) {
                case 1:
                    System.out.println("Informe o nome do aluno:");
                    Aluno aluno = new Aluno(scanner.nextLine());
                    alunoService.save(aluno);
                    break;
                case 2:
                    System.out.println("Informe o código do aluno:");
                    Aluno alunoMatricula = alunoService.findById(scanner.nextLong());
                    System.out.println("Infomer o código da disciplina");
                    Disciplina disciplinaMatricula = disciplinaService.findById(scanner.nextLong());

                    matriculaService.save(alunoMatricula, disciplinaMatricula);
                    break;
                case 3:
                    alunoService.findAll().forEach(item -> System.out.println(item.getId() + " - " + item.getNome()));
                    break;
                case 4:
                    List<Matricula> matriculaList = matriculaService.findAll().isPresent()
                            ? matriculaService.findAll().get(): new ArrayList<>();
                    if (!matriculaList.isEmpty()){
                        matriculaList.forEach(matricula -> System.out.println(
                                matricula.getAluno().getNome()
                                        + " - " +
                                        matricula.getDisciplina().getNome()));
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome da disciplina:");
                    Disciplina disciplina = new Disciplina(scanner.nextLine());
                    disciplinaService.save(disciplina);
                    break;
                case 6:
                    disciplinaService.findAll();
                    break;
                default:
                    break;
            }
            option = showOptions();

        }
    }

    private static int showOptions() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");

        System.out.println("Informe a operação desejada: ");
        System.out.println("1 - Novo aluno ");
        System.out.println("2 - Matricula ");
        System.out.println("3 - Listar alunos ");
        System.out.println("4 - Listar alunos e disciplinas ");
        System.out.println("5 - Nova disciplina ");
        System.out.println("6 - Listar Disciplinas");
        System.out.println("7 - Finalizar");

        System.out.println("--------------------");

        return scanner.nextInt();
    }


}