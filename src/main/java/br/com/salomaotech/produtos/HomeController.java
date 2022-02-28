package br.com.salomaotech.produtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private CadastroRepository cadastroRepository;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/cadastro-form")
    public String cadastroForm() {
        return "cadastro-form";
    }

    @PostMapping("/cadastro")
    public String cadastro(Cadastro cadastro) {
        this.cadastroRepository.save(cadastro);
        return "cadastro-form";
    }

    @RequestMapping("/listar")
    public ModelAndView listar() {
        ModelAndView model = new ModelAndView("listar");
        model.addObject("resultados", this.cadastroRepository.findAll());
        return model;
    }

}
