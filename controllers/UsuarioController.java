package br.com.imepac.site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.imepac.site.entities.Users;
import br.com.imepac.site.interfaces.impl.UsersServico;

@Controller
public class UsuarioController {

	@Autowired
	private UsersServico usuarioServico;

	@RequestMapping(method = RequestMethod.GET, value = "usuarios/cadastrar")
	public String homePageCadastrar() {
		return "usuarios/cadastrar";
	}

	@RequestMapping(method = RequestMethod.POST, value = "usuarios/salvar")
	public ModelAndView salvar(@Valid Users usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("usuarios/cadastrar");
			modelAndView.addObject("message_error", "Foram encontrados erros!");
			modelAndView.addObject(usuario);
		} else {
			usuarioServico.save(usuario);
			modelAndView.setViewName("redirect:gerenciar");
			modelAndView.addObject("message_success", "Cadastro efetuado com sucesso!");
		}
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "usuarios/gerenciar")
	public ModelAndView gerenciar() {
		List<Users> usuarios = usuarioServico.reads();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usuarios/gerenciar");
		modelAndView.addObject("usuarios",usuarios);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET, value = "usuarios/visualizar/{id}")
	public ModelAndView visualizar(@PathVariable long id) {
		Users usuario = usuarioServico.read(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usuarios/visualizar");
		modelAndView.addObject(usuario);
		return modelAndView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "usuarios/deletar/{id}")
	public ModelAndView deletar(@PathVariable long id) {
		usuarioServico.delete(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usuarios/gerenciar");
		modelAndView.addObject("message_success", "Usuário deletado com sucesso!");
		return modelAndView;
	}
}
