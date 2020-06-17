package com.edu.repositorio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edu.entidade.Video;

public class VideoDAO {
	EntityManagerFactory factory;
	EntityManager manager;
	
	public VideoDAO() {
		factory = Persistence.createEntityManagerFactory("studyhome");
		manager = factory.createEntityManager();
	}
	
	public void cadastrarVideo(Video video) {
		manager.getTransaction().begin();
		manager.persist(video);
		manager.getTransaction().commit();
	}
	
	
	public List<Video> listarTodosVideos(String nome){
		List<Video> vdos = manager
				.createQuery("SELECT u FROM Video AS u WHERE materiavideo="+"'"+nome+"'")
				.getResultList();
		
		for(Video v: vdos)
			System.out.println(v.getNomevideo()+"\n");
		
		return vdos;
	}
	
	public Video findById(Long id) {
		Video video = manager.find(Video.class, id);
		if (video != null) {
			return video;
		}else {
			return video;
		}
	}
	
	public void closeManager() {
		manager.close();
		factory.close();
	}
}
