package br.com.tokiomarine.seguradora.avaliacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
}