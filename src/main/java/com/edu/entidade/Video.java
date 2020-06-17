package com.edu.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
public class Video {
	@Id
	@GeneratedValue
	private Long id;
	private String nomevideo;
	private String materiavideo;
	private String linkvideo;
	
	public Video() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomevideo() {
		return nomevideo;
	}

	public void setNomevideo(String nomevideo) {
		this.nomevideo = nomevideo;
	}
	
	public String getMateriavideo() {
		return materiavideo;
	}
	
	public void setMateriavideo(String materiavideo) {
		this.materiavideo = materiavideo;
	}

	public String getLinkvideo() {
		return linkvideo;
	}

	public void setLinkvideo(String linkvideo) {
		this.linkvideo = linkvideo;
	}

}
