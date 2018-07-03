package br.ufc.dc.poo.MyTwitter.Twitter;
import java.util.Vector;
import br.ufc.dc.poo.MyTwitter.Perfis.*;
import java.io.IOException;
import br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions.*;
import br.ufc.dc.poo.MyTwitter.Twitter.Exceptions.*;

public interface ITwitter {
	public void criarPerfil(Perfil usuario) throws UJCException, PEException;
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException;
	public void tweetar(String usuario,String mensagem) throws PIException, MFPException;
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException;
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException, IOException;
	public void seguir(String seguidor,String seguido) throws PIException, PDException, SIException;
	public int numeroSeguidores(String usuario) throws PIException, PDException;
	public Vector<Perfil> seguidores(String  usuario) throws PIException, PDException;
	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException;
}
