/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.imepac.Controllers;

import com.br.imepac.entidades.Usuario;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author icaro
 */
@Controller
public class UsuarioControllers {
    
    @RequestMapping(value = "usuarios/novo")
    public String novo() {
        return "usuarios/novo";
    }
    @RequestMapping(value = "usuarios/salvar")
    public ModelAndView salvar(@Valid @ModelAttribute Usuario usuario, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("usuarios/novo");
            modelAndView.addObject(usuario);
            return modelAndView;
        }
        // salvar os dados no banco - Hibernate
        //definir a página de retorno caso sucesso
        return modelAndView;
    }
}
