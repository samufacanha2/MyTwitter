package br.ufc.dc.poo.MyTwitter.Perfis;

public class Tweet {
	private String usuario;
	private String mensagem;
	
	public void setUsuario(String usuario) {
		this.usuario=usuario;
	}
	
	public String getUsuario() {
		return this.usuario;
	}
	
	public void setMensagem(String msg) {
		this.mensagem = msg;
	}
	
	public String getMensagem() {
		return this.mensagem;
	}
}
