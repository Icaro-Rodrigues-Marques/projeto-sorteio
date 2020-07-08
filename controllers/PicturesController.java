package br.com.imepac.site.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.imepac.site.interfaces.impl.Disco;

@RestController
@RequestMapping("/pictures")
public class PicturesController {

	@Autowired
	private Disco disco;
	
	@PostMapping
	public void upload(@RequestParam MultipartFile foto) {
		disco.salvarFoto(foto);
		
	}
}
