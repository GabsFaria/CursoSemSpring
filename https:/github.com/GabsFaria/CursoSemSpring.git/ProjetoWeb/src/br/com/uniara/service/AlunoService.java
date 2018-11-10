package br.com.uniara.service;

import java.sql.SQLException;

import br.com.uniara.DAO.AlunoDAO;
import br.com.uniara.model.Aluno;

public class AlunoService {
	public void salvar(Aluno aluno) {
		try {
			AlunoDAO.salvar(aluno);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String obterTudo() {
		try {
			return AlunoDAO.obterTudo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Deu Errado";
	}
	
}
