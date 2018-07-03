package br.ufc.dc.poo.MyTwitter.Twitter.Exceptions;

public class PDException extends Exception {
	private static final long serialVersionUID = 1L;
private String usuario;
	
	public PDException(String usuario) {
		super("Esse perfil encontra-se inativo : ");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage() +  this.usuario;
	}
}
