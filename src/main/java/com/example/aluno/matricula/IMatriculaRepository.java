package com.example.aluno.matricula;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatriculaRepository extends CrudRepository<Matricula, Long> {

    @Override
    @Query("select m from Matricula m order by m.aluno.id")
    Iterable<Matricula> findAll();
}
