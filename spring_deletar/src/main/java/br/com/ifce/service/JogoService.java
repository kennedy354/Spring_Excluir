package br.com.ifce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifce.model.Jogo;
import br.com.ifce.repository.JogoRepository;

@Service
public class JogoService {
	
	@Autowired
	private JogoRepository jogoRepo;
	
	public void cadastrarJogo(Jogo jogo) {
		jogoRepo.save(jogo);
	}
	
	public List<Jogo> listarJogos() {
		return jogoRepo.findAll();
	}
	
	public void excluir(Long codigo) {
		jogoRepo.deleteById(codigo);
	}
}
