package integracao;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    private List<Curso> cursosCadastrados = new ArrayList<>();

    @PostMapping
    public void adicionarCurso(@RequestBody Curso curso) {
        cursosCadastrados.add(curso);
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursosCadastrados;
    }
}
