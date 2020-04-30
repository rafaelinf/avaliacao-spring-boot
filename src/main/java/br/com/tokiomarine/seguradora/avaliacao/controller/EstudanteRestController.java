package br.com.tokiomarine.seguradora.avaliacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tokiomarine.seguradora.avaliacao.dto.EstudanteDTO;
import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import br.com.tokiomarine.seguradora.avaliacao.utils.MapperUtils;

// TODO não esquecer de usar as anotações para criação do restcontroller
@RestController
@RequestMapping("/api")
public class EstudanteRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EstudanteRestController.class);

    @Autowired
    private EstudandeService estudandeService; 
    
	// TODO IMPLEMENTAR CADASTRO DE ESTUDANTES (POST)
    @PostMapping("/add")
	public EstudanteDTO add(@Valid @RequestBody Estudante estudante) throws Exception {
    	LOGGER.info(this.getClass().getName() + " - novo cadastro.");
    	
    	Estudante estudanteSalvo = estudandeService.cadastrarEstudante(estudante);
    	EstudanteDTO dto = (EstudanteDTO) MapperUtils.convertToDto(estudanteSalvo, EstudanteDTO.class);    	

    	return dto;
	}

	// TODO IMPLEMENTAR ATUALIZACAO DE ESTUDANTES (PUT)
    @PutMapping("/atualizar")
	public EstudanteDTO atualizar(@Valid @RequestBody Estudante estudante) throws Exception {
    	LOGGER.info(this.getClass().getName() + " - atualizar cadastro.");
    	
    	Estudante estudanteSalvo = estudandeService.atualizarEstudante(estudante);
    	EstudanteDTO dto = (EstudanteDTO) MapperUtils.convertToDto(estudanteSalvo, EstudanteDTO.class);    	

    	return dto;
	}    

	// TODO IMPLEMENTAR A LISTAGEM DE ESTUDANTES (GET)
    @GetMapping("/lista")
	public List<EstudanteDTO> lista() throws Exception {
    	LOGGER.info(this.getClass().getName() + " - listar cadastro de estudantes.");
    	
    	List<Estudante> listaEstudantes = estudandeService.buscarEstudantes();
    	List<EstudanteDTO> listDto = MapperUtils.convertListToDto(listaEstudantes, EstudanteDTO.class);    	

    	return listDto;
	}      

	// TODO IMPLEMENTAR A EXCLUSÃO DE ESTUDANTES (DELETE)
    @DeleteMapping("/apagar")
	public EstudanteDTO apagar(@Valid @RequestBody Estudante estudante) throws Exception {
    	LOGGER.info(this.getClass().getName() + " - atualizar cadastro.");
    	
    	estudandeService.apagar(estudante);
    	EstudanteDTO dto = (EstudanteDTO) MapperUtils.convertToDto(estudante, EstudanteDTO.class);    	

    	return dto;
	}  
}
