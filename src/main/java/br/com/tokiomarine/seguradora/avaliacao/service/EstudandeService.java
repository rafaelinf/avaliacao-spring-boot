package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;

@Service
public class EstudandeService {

	@Autowired
	private EstudanteRepository estudanteRepository;

	public List<Estudante> buscarEstudantes() {
		return estudanteRepository.findAll();
	}

	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		return estudanteRepository.save(estudante);
	}

	public Estudante buscarEstudante(long id) {
		Optional<Estudante> estudante = estudanteRepository.findById(id);
		if (estudante.isPresent()) {
			return estudante.get();
		}
		return null;
	}

	public Estudante atualizarEstudante(@Valid Estudante estudante) {
		return estudanteRepository.save(estudante);
	}
	
	public void apagar(@Valid Estudante estudante) {
		estudanteRepository.delete(estudante);
	}
}
