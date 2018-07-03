package br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions;

public class UNCException extends Exception{

	private static final long serialVersionUID = 1L;
	private String usuario;

	public UNCException(String usuario) {
		super("Usuario nao cadastrado!");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}
