package integracao;

import java.util.ArrayList;
import java.util.UUID;

public class Aluno {
	private int frequencia;
	private float nota1;
	private float nota2;
	private float notaFinal;
	private String voucher;
	private ArrayList<Curso> cursosConcluidos;
	
	
	
	public Aluno() {
		super();
		this.cursosConcluidos = new ArrayList<>();
	}

	public void addCurso(Curso curso) {
		cursosConcluidos.add(curso);
	}
	
	public String getVoucher() {
		return voucher;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public float getNota1() {
		return nota1;
	}

	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}

	public float getNota2() {
		return nota2;
	}

	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}

	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}

	public boolean calcularAprovacao() {

		float media;
		if (frequencia < 75) {
			return false;
		}

		else {
			media = (nota1 + nota2) / 2;
			if (media < 30) {
				return false;
			} else {
				if (media >= 70) {
					return true;
				} else {
					if ((media + notaFinal) / 2 >= 50) {
						return true;
					} else {

						return false;

					}

				}

			}

		}
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
