package br.ufc.dc.poo.MyTwitter.Twitter.Exceptions;

public class MFPException extends Exception {
	private static final long serialVersionUID = 1L;

	public MFPException() {
		super("Esta mensagem excede 140 caracteres!");
	}
	
	public String getMessage() {
		return super.getMessage();
	}

}
