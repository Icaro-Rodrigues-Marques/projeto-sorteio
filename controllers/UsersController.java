package br.com.imepac.site.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.imepac.site.entities.LoginForm;
import br.com.imepac.site.entities.Users;
import br.com.imepac.site.interfaces.impl.RuleException;
import br.com.imepac.site.interfaces.impl.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UsersService usuarioServico;

	@GetMapping
	public List<Users> homePageCadastrar() {
		return usuarioServico.reads();
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Users users) {
		  usuarioServico.save(users);
		  return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Users users){
		Users usersUpdate = usuarioServico.read(id);
		BeanUtils.copyProperties(users, usersUpdate, "id");
		usuarioServico.save(usersUpdate);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginForm loginForm){
		Users users = usuarioServico.login(loginForm.getEmail());
		
		if(!users.getPassword().equals(loginForm.getPassword())) {
			throw new RuleException("Error em Email ou Senha. Tente novamente.");
		}
		
		return ResponseEntity.ok().body(users);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteDelete(@PathVariable Long id) {
		usuarioServico.delete(id);
		return ResponseEntity.noContent().build();
    }
	
	@GetMapping(value = "/{id}")
	public Users findById(@PathVariable Long id) {
		Users users = usuarioServico.read(id);
		return users;
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
