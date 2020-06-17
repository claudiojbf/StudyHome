package com.edu.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edu.entidade.Usuario;

public class UsuarioDAO {
	EntityManagerFactory factory;
	EntityManager manager;

	public UsuarioDAO() {
		factory = Persistence.createEntityManagerFactory("studyhome");
		manager = factory.createEntityManager();
	}

	//função para cadastrar o usuario dentro do banco de dados
	public void cadastrarUsuario(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}

	//função utilizada para pegar os dados de um usuario
	public Usuario pegarUmUsuarioEspecifico(String email) {
		Usuario u = null;
		try {
		u = (Usuario) manager.createQuery("SELECT u FROM Usuario as u WHERE email='"+email+"'").getSingleResult();
		}catch(Exception e) {
			e.getMessage();
		}
		return u;
	}
	
	

	public void closeManager() {
		manager.close();
		factory.close();
	}
}
