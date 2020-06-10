package br.com.imepac.site.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.imepac.site.entities.Sweepstakes;
import br.com.imepac.site.interfaces.impl.SweepstakesServico;

public class SweepstakesController {

	/*id*/
	@RequestMapping(method = RequestMethod.POST, value = "/salvar")
	public ModelAndView salvar(@Valid Sweepstakes usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("id/cadastrar");
			modelAndView.addObject("message_error", "Foram encontrados erros!");
			modelAndView.addObject(usuario);
		} else {
			SweepstakesServico.save(usuario);
			modelAndView.setViewName("redirect:gerenciar");
			modelAndView.addObject("message_success", "Cadastro efetuado com sucesso!");
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "id/gerenciar")
	public ModelAndView gerenciar() {
		List<Sweepstakes> usuarios = SweepstakesServico.reads();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("id/gerenciar");
		modelAndView.addObject("id",usuarios);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "id/visualizar/{id}")
	public ModelAndView visualizar(@PathVariable long id) {
		Sweepstakes usuario = SweepstakesServico.read(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("id/visualizar");
		modelAndView.addObject(usuario);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "id/deletar/{id}")
	public ModelAndView deletar(@PathVariable long id) {
		SweepstakesServico.delete(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("id/gerenciar");
		modelAndView.addObject("message_success", "Usuário deletado com sucesso!");
		return modelAndView;
	}
	
	
}
