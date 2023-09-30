package integracao.Controllers;

import org.springframework.web.bind.annotation.*;

import integracao.Models.Curso;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/cursos")
@Tag(name = "Curso Controller")
public class CursoController {

    private List<Curso> cursosCadastrados;

    public CursoController() {
		this.cursosCadastrados = new ArrayList<>();
	}

    @PostMapping
    @Operation(summary = "Realiza o cadastro de cursos.", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro de Curso realizado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos."),
    })
    public void adicionarCurso(@RequestBody Curso curso) {
        cursosCadastrados.add(curso);
    }

    @GetMapping
    @Operation(summary = "Lista todos os cursos cadastrados", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cursos listados com sucesso"),
    })
    public List<Curso> listarCursos() {
        return cursosCadastrados;
    }
}
