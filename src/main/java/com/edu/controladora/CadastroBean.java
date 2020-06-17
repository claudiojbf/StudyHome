package com.edu.controladora;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.edu.entidade.Usuario;
import com.edu.repositorio.UsuarioDAO;

@ManagedBean(name = "cadastroBean")
@RequestScoped
public class CadastroBean {
	private String nome;
	private String email;
	private String senha;
	private String confirmarSenha;
	private String tipo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	//fução para chamar a pagina da aplicação de realizar cadastro
	public String acessarPaginaDeCadastro() {
		return "/CadastroUsuario/cadastro";
	}

	//Função para cadastrar um usuario no sistema
	public String cadastrar() {
		FacesContext context = FacesContext.getCurrentInstance();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario u = usuarioDAO.pegarUmUsuarioEspecifico(email);
		if(u==null) {
		if (!this.senha.equalsIgnoreCase(this.confirmarSenha)) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Confirmação de senha incorreta", ""));
			return "cadastro";
		}
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuario.setTipo(tipo);
		usuarioDAO.cadastrarUsuario(usuario);
		usuarioDAO.closeManager();
		return "/LoginPage/login";
		}else {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Email já existente", ""));
			return "cadastro";
		}
	}
}
