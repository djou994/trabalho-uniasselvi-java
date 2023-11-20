package com.example.aluno.disciplina;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    private final DisciplinaRepository repository;

    public DisciplinaService (DisciplinaRepository repository){
        this.repository = repository;
    }

    public Disciplina save(Disciplina disciplina){
        return  repository.save(disciplina);
    }

    public List<Disciplina> findAll(){
        return (List<Disciplina>) repository.findAll();
    }

    public Disciplina findById(long id) {
        return repository.findById(id).orElseThrow();
    }
}
