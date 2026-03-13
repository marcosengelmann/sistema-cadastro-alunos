package com.aula.sistema_alunos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/alunos")
public class AlunoController {

    // Lista temporária para guardar os alunos
    private List<Aluno> listaAlunos = new ArrayList<>();

    // Ver a lista de alunos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("alunos", listaAlunos);
        return "lista-alunos"; // vai procurar o arquivo lista-alunos.html
    }

    // Abrir o formulário de cadastro
    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "form-aluno";
    }

    // Salvar o aluno
    @PostMapping("/salvar")
    public String salvar(Aluno aluno) {
        aluno.setId((long) (listaAlunos.size() + 1));
        listaAlunos.add(aluno);
        return "redirect:/alunos"; // Volta para a lista
    }

    // Deletar o aluno
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        listaAlunos.removeIf(a -> a.getId().equals(id));
        return "redirect:/alunos";
    }
}