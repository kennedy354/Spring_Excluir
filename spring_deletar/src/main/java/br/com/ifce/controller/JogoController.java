package br.com.ifce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.com.ifce.model.Jogo;
import br.com.ifce.service.JogoService;

@Controller
public class JogoController {
	@Autowired
	private JogoService jogoService;
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/home/formulario")
	public String formulario() {
		return "formulario";
	}
	
	@GetMapping("/home/formulario/salvar")
	public String salvar(Jogo jogo) {
		jogoService.cadastrarJogo(jogo);
		return "salvou";
	}
	
	@GetMapping("/home/lista")
	public ModelAndView listarJogos() {
		List<Jogo> jogos = jogoService.listarJogos();
		
		ModelAndView mv = new ModelAndView("lista-jogos");
		mv.addObject("listaDeJogos", jogos);
		
		return mv;
	}
	
	@GetMapping("/home/lista/excluir/{codigo}")
	public ModelAndView apagar(@PathVariable Long codigo) {
		jogoService.excluir(codigo);
		
		ModelAndView mv = new ModelAndView("redirect:/home/lista");
		
		return mv;
	}
}
