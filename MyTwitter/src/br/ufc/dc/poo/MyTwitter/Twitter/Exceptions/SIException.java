package br.ufc.dc.poo.MyTwitter.Twitter.Exceptions;

public class SIException extends Exception {
	private static final long serialVersionUID = 1L;
	public SIException() {
		super("Voce não pode seguir a si mesmo! ");
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
