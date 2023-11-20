package com.example.aluno.aluno;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository){
        this.repository = repository;
    }

    public Aluno save(Aluno aluno){
        return  repository.save(aluno);
    }

    public Aluno findById(Long id){
        return repository.findById(id).orElseThrow();
    }

    public List<Aluno> findAll(){
        return (List<Aluno>) repository.findAll();
    }
}
