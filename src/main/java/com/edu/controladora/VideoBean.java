package com.edu.controladora;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.edu.entidade.Video;
import com.edu.repositorio.VideoDAO;

@ManagedBean(name = ("videoBean"))
@RequestScoped
public class VideoBean {
	private Long idvideo;
	private String nomevideo;
	private String materiavideo;
	private String linkvideo;
	private Video video;
	private List<Video> videos;
	
	
	
	public Long getIdvideo() {
		return idvideo;
	}
	public void setIdvideo(Long idvideo) {
		this.idvideo = idvideo;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	public List<Video> getVideos() {
		return videos;
	}
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	public String getNomevideo() {
		return nomevideo;
	}
	public void setNomevideo(String nomevideo) {
		this.nomevideo = nomevideo;
	}
	public String getLinkvideo() {
		return linkvideo;
	}
	public void setLinkvideo(String linkvideo) {
		this.linkvideo = linkvideo;
	}
	
	public String getMateriavideo() {
		return materiavideo;
	}
	public void setMateriavideo(String materiavideo) {
		this.materiavideo = materiavideo;
	}
	public String realizarVideoCadastro() {
		return "/CadastroVideo/cadastrov";
	}
	
	//função para assitir um video especifico
	
	/*public String assistirVideo() {
		FacesContext context = FacesContext.getCurrentInstance();
		//linkvideo = pegarLinkVideo();
		if (linkvideo == null) {
			context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Link do video não existe", ""));
			return "home";
		}
		System.out.println(linkvideo);
		return "/VideoPage/video";
	}*/
	
	//função para cadastrar um video
	public String cadastroVideo() {
		VideoDAO videoDAO = new VideoDAO();
		
		Video video = new Video();
		video.setNomevideo(nomevideo);
		video.setMateriavideo(materiavideo);
		video.setLinkvideo(linkvideo);
		videoDAO.cadastrarVideo(video);
		videoDAO.closeManager();
		return "/HomePage/home";
	}
	
	public String listaVideos(String nome) {
		VideoDAO dao = new VideoDAO();
		videos = dao.listarTodosVideos(nome);
		
		return "/ListaVideo/lista";
	}
	
	public String assistirVideo() {
		VideoDAO dao = new VideoDAO();
		video = dao.findById(idvideo);
		
		return "/VideoPage/video";
	}
}
