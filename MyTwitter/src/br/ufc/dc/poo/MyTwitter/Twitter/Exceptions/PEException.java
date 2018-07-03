package br.ufc.dc.poo.MyTwitter.Twitter.Exceptions;

public class PEException extends Exception {
	private static final long serialVersionUID = 1L;
	private String usuario;
	
	public PEException(String usuario) {
		super("Perfil com este usuario ja existe!");
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}
	
	public String getMessage() {
		return super.getMessage()  + " usuario: " + this.usuario;
	}

	
	
	
}
