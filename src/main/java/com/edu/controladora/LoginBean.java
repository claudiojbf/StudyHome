package com.edu.controladora;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.edu.entidade.Usuario;
import com.edu.repositorio.UsuarioDAO;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {
	private String email;
	private String senha;

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
	
	public String realizarLogin() {
		return "/LoginPage/login";
	}
	
	public String deslogar() {
		return "/index";
	}

	// funçao para realizar login na aplicação
	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.pegarUmUsuarioEspecifico(email);
		if (usuario != null) {
			if (!usuario.getSenha().equals(senha)) {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Email ou senha incorreta, por favor tente novamente", ""));
				return "index";
			} else {
				HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
				session.setAttribute("usuario", usuario);
				return "/HomePage/home?faces-redirect=true";
			}
		} else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Email ou senha incorreta, por favor tente novamente", ""));
			return "/LoginPage/login";
		}
	}

}
