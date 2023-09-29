package integracao.Models;

import java.util.ArrayList;
import java.util.UUID;

public class Aluno {
	private String nome;
	private String cpf;
	private String voucher;
	private ArrayList<Curso> cursosConcluidos;
	
	public Aluno() {
		super();
		this.cursosConcluidos = new ArrayList<>();
	}

	public void addCurso(Curso curso) {
		cursosConcluidos.add(curso);
	}

		public ArrayList<Curso> getCursosConcluidos() {
		return cursosConcluidos;
	}
	
	public String getVoucher() {
		return voucher;
	}

	public boolean concluiuDozeCursos() {
        return cursosConcluidos.size() >= 12;
    }

    public String solicitaProjetosReais() {
        if (!concluiuDozeCursos()) {
            return "Você precisa concluir mais " + (12 - cursosConcluidos.size()) + " cursos para ser elegível para projetos reais.";
        } else {
        	voucher = UUID.randomUUID().toString();
            return "Você é elegível para participar de projetos reais. Seu voucher = " + voucher;
        }
    }


}
