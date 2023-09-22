package integracao;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import integracao.Models.Aluno;
import integracao.Models.Curso;

public class AlunoTest {
	
	Aluno aluno;
	Curso curso;


	@Test
	public void testCalcularAprovacao_ReprovacaoFrequencia(){

		aluno = new Aluno();
		aluno.setFrequencia(74);
		assertEquals(false, aluno.calcularAprovacao());
	}

	@Test
	public void testCalcularAprovacao_ReprovacaoNota() {
		aluno = new Aluno();
		aluno.setFrequencia(75);
		aluno.setNota1 (29);
		aluno.setNota2 (30);
		assertEquals(false, aluno.calcularAprovacao());
	}

	@Test
	public void testAprovacao_AprovacaoNota(){
		aluno = new Aluno();
		aluno.setFrequencia(75);
		aluno.setNota1 (70);
		aluno.setNota2 (70);
		assertEquals(true, aluno.calcularAprovacao());
	}

	@Test
	public void testAprovacao_AprovacaoFinal(){
		aluno = new Aluno();
		aluno.setFrequencia(75);
		aluno.setNota1 (30);
		aluno.setNota2 (30);
		aluno.setNotaFinal (70);
		assertEquals(true, aluno.calcularAprovacao());
	}

	@Test
	public void testCalcularAprovacao_ReprovacaoFinal(){
		aluno = new Aluno();
		aluno.setFrequencia(75);
		aluno.setNota1 (30);
		aluno.setNota2 (30);
		aluno.setNotaFinal (69);
		assertEquals(false, aluno.calcularAprovacao());


	}

	   @Test
	    public void testaAlunoNaoConcluiuDozeCursos() { // Teste do método -> AlunoConcluiuDozeCursos()
		    aluno = new Aluno();
		    curso = new Curso();
		    for(int i = 0; i < 10; i ++) {
		    	aluno.addCurso(curso);// Teste criado para FALSE, por isso o aluno tem apenas 10 cursos concluidos, e não 12.
		    }
	        boolean resultado = aluno.concluiuDozeCursos();
	        Assert.assertFalse(resultado); // Deve retornar false, pois o aluno não atingiu a marca de 12 cursos.
	    }
	   
	   @Test
	    public void testaAlunoConcluiuDozeCursos() { // Teste do método -> AlunoConcluiuDozeCursos()
		   aluno = new Aluno();
		   curso = new Curso();
		   for(int i = 0; i < 12; i ++) {
		    	aluno.addCurso(curso);// Teste criado para TRUE, por isso o aluno tem 12 cursos concluidos.
		   }
	       boolean resultado = aluno.concluiuDozeCursos();
	       Assert.assertTrue(resultado); // Deve retornar true, pois o aluno atingiu a marca de 12 cursos.
	    }

	    @Test
	    public void testSolicitaProjetosReaisNaoElegivel() { // Teste do método -> solicitaProjetosReais()
	    	aluno = new Aluno();
		    for(int i = 0; i < 10; i ++) { // Teste criado para retornar como NÃO elegível, por isso 10, e não 12.
		    	aluno.addCurso(curso);
		    } 
	        String mensagem = aluno.solicitaProjetosReais();
	        String mensagemEsperada = "Você precisa concluir mais 2 cursos para ser elegível para projetos reais.";
	        Assert.assertEquals(mensagemEsperada, mensagem);
	        Assert.assertNull(aluno.getVoucher()); // O voucher = NULL, pois só é gerado se o Aluno for elegível durante a 
	        									  //execução do método gerado pelo método solicitaProjetosReais().
	    }

	    @Test
	    public void testSolicitaProjetosReaisElegivel() {
	    	aluno = new Aluno();
			   curso = new Curso();
			   for(int i = 0; i < 12; i ++) {
			    	aluno.addCurso(curso);
			   }
	        String mensagem = aluno.solicitaProjetosReais();
	        String mensagemEsperada = "Você é elegível para participar de projetos reais. Seu voucher = " + aluno.getVoucher();
	        Assert.assertEquals(mensagemEsperada, mensagem); // Valida se realmente o Aluno é elegível, e o retorno da mensagem + voucher;
	        Assert.assertNotNull(aluno.getVoucher()); // O voucher já deve ser existente, gerado pelo método solicitaProjetosReais().
	    }
}
