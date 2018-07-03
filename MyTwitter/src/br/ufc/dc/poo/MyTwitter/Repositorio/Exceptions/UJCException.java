package br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions;

public class UJCException extends Exception {
	private static final long serialVersionUID = 1L;
	private String usuario;


	public UJCException(String usuario) {
		super("Usuario ja cadastrado!");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() + " usuario: " + this.usuario;
	}
}
