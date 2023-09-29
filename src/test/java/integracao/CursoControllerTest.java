package integracao;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import integracao.Controllers.CursoController;
import integracao.Models.Curso;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import static org.mockito.Mockito.*;


public class CursoControllerTest {
    
    private CursoController cursoController;

    @Before
    public void setUp() {
        cursoController = Mockito.mock(CursoController.class); // Crie um mock do CursoController
    }

    @Test
    public void testAdicionarCurso() {
        Curso curso = new Curso();
        cursoController.adicionarCurso(curso);
        List<Curso> cursos = cursoController.listarCursos();
        Assert.assertTrue(!cursos.contains(curso));
    }    

    @Test
    public void testListarCursos() {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso());
        when(cursoController.listarCursos()).thenReturn(cursos);
        List<Curso> resultado = cursoController.listarCursos();
        Assert.assertEquals(cursos, resultado);
    }
}
