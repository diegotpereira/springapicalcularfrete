package br.com.spring.springapicalcularfrete.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.springapicalcularfrete.model.Cep;

@Repository
public interface CepRepositorio extends JpaRepository<Cep, Long>{
	
}
