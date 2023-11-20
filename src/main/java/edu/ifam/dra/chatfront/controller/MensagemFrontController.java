package edu.ifam.dra.chatfront.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.ifam.dra.chatfront.model.Mensagem;
import edu.ifam.dra.chatfront.service.MensagemFrontService;

@RequestMapping("/mensagem")
@Controller
public class MensagemFrontController {
	
	@Autowired
	MensagemFrontService mensagemFrontService;

	@GetMapping
	public String mostraMensagens(Model model) {
		model.addAttribute("mensagens", mensagemFrontService.getMensagens());
		return "listaMensagens";
	}
	
	@GetMapping("/nova")
	public String novaMensagem(Mensagem mensagem) {
		return "novaMensagem";
	}
	
	
    @PostMapping
    public String inserirMensagem(@Validated Mensagem mensagem, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "novaMensagem";
        }
        
        mensagemFrontService.postMensagem(mensagem);
        return "redirect:/mensagem";
    }
    
    @DeleteMapping("/{id}")
    public String excluirMensagem(@PathVariable long id) {
    	mensagemFrontService.deleteMensagem(id);
    	return "redirect:/mensagem";
    }
    
}
