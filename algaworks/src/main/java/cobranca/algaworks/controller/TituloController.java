package cobranca.algaworks.controller;

import cobranca.algaworks.model.StatusTitulo;
import cobranca.algaworks.model.Titulo;
import cobranca.algaworks.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;
    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST )
    public ModelAndView salvar(Titulo titulo){
        titulos.save(titulo);
        ModelAndView mv = new ModelAndView("CadastroTitulo");
        mv.addObject("mensagem", "Título salvo com sucesso!");
        return mv;
    }

    @RequestMapping
    public ModelAndView pesquisar(){
        List<Titulo> todosTitulos = titulos.findAll();
        ModelAndView mv = new ModelAndView("PesquisaTitulos");
        mv.addObject("titulos", todosTitulos);
        return mv;
    }
    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo(){
        return Arrays.asList(StatusTitulo.values());
    }

}
