package br.com.uniara.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uniara.model.Aluno;
import br.com.uniara.service.AlunoService;

/**
 * Servlet implementation class AlunoServlet
 */
@WebServlet("/AlunoServlet")
public class AlunoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoService as = new AlunoService();
		String obter = as.obterTudo();
		response.getWriter().append(obter);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Aluno aluno = new Aluno();
		
		String nome = request.getParameter("name");
		String sobrenome = request.getParameter("lastName");
		int ra = Integer.parseInt(request.getParameter("ra"));
		int idade = Integer.parseInt(request.getParameter("age"));
		int curso = Integer.parseInt(request.getParameter("course"));
		
		aluno.setCurso(curso);
		aluno.setIdade(idade);
		aluno.setNome(nome);
		aluno.setSobrenome(sobrenome);
		aluno.setRa(ra);
		
		AlunoService alunoService = new AlunoService();
		alunoService.salvar(aluno);
	}

}
