package integracao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import integracao.Models.Aluno;
import integracao.Models.Curso;

public class AlunoTest {

    private Aluno aluno;
    private Curso curso;

    @Before
    public void setUp() {
        aluno = new Aluno();
        curso = new Curso();
    }

    @Test
    public void testAdicionarCurso() {
        aluno.addCurso(curso);
        Assert.assertTrue(aluno.getCursosConcluidos().contains(curso));
    }

    @Test
    public void testConcluiuDozeCursosFalse() {
        for (int i = 0; i < 10; i++) {
            aluno.addCurso(curso);
        }
        boolean resultado = aluno.concluiuDozeCursos();
        Assert.assertFalse(resultado);
    }

    @Test
    public void testConcluiuDozeCursosTrue() {
        for (int i = 0; i < 12; i++) {
            aluno.addCurso(curso);
        }
        boolean resultado = aluno.concluiuDozeCursos();
        Assert.assertTrue(resultado);
    }

    @Test
    public void testSolicitaProjetosReaisNaoElegivel() {
        for (int i = 0; i < 10; i++) {
            aluno.addCurso(curso);
        }
        String mensagem = aluno.solicitaProjetosReais();
        String mensagemEsperada = "Você precisa concluir mais 2 cursos para ser elegível para projetos reais.";
        Assert.assertEquals(mensagemEsperada, mensagem);
        Assert.assertNull(aluno.getVoucher());
    }

    @Test
    public void testSolicitaProjetosReaisElegivel() {
        for (int i = 0; i < 12; i++) {
            aluno.addCurso(curso);
        }
        String mensagem = aluno.solicitaProjetosReais();
        String mensagemEsperada = "Você é elegível para participar de projetos reais. Seu voucher = " + aluno.getVoucher();
        Assert.assertEquals(mensagemEsperada, mensagem);
        Assert.assertNotNull(aluno.getVoucher());
    }
}
