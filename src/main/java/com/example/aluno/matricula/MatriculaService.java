package com.example.aluno.matricula;

import com.example.aluno.aluno.Aluno;
import com.example.aluno.disciplina.Disciplina;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    private final IMatriculaRepository repository;

    public MatriculaService(IMatriculaRepository repository){
        this.repository = repository;
    }

    public Matricula save(Aluno aluno, Disciplina disciplina){
        Matricula matricula = new Matricula(aluno, disciplina);

        return this.repository.save(matricula);
    }

    public Optional<List<Matricula>> findAll(){
        return Optional.ofNullable((List<Matricula>) this.repository.findAll());
    }
}
