package integracao;

import javax.validation.constraints.AssertTrue;

import org.junit.Before;
import org.junit.Test;
import integracao.Models.Curso;
import org.junit.Assert;

public class CursoTest {

    private Curso curso;

    @Before
    public void setUp() {
        curso = new Curso();   
        curso.setNome("Basic to Advanced in JAVA");
        curso.setDuracaoEmHoras(5);     
    }

    @Test
    public void testGetDuracaoHoras(){
        int actual = curso.getDuracaoEmHoras();
        Assert.assertTrue(actual == 5);
    }

    @Test
    public void testGetNome(){
        String actual = curso.getNome();
        Assert.assertEquals("Basic to Advanced in JAVA", actual);
    }

}
