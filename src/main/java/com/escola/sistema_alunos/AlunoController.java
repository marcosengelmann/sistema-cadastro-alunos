package com.escola.sistema_alunos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/alunos") // CORREÇÃO: Define que este controller responde em /alunos
public class AlunoController {

    private List<Aluno> listaAlunos = new ArrayList<>();

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", listaAlunos);
        return "lista-alunos";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Aluno aluno) {
        if (aluno.getId() == null) {
            aluno.setId((long) (listaAlunos.size() + 1));
            listaAlunos.add(aluno);
        }
        return "redirect:/alunos";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        listaAlunos.removeIf(a -> a.getId().equals(id));
        return "redirect:/alunos";
    }
}