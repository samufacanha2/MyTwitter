package br.ufc.dc.poo.MyTwitter.Twitter;
import java.util.Vector;
import br.ufc.dc.poo.MyTwitter.Perfis.*;
import br.ufc.dc.poo.MyTwitter.Repositorio.*;
import br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions.*;
import br.ufc.dc.poo.MyTwitter.Twitter.Exceptions.*;

public class MyTwitter implements ITwitter{
	private IRepositorioUsuario repositorio;
	
	public MyTwitter(IRepositorioUsuario repositorio) {
		this.repositorio = repositorio;

	}
	
	public void criarPerfil(Perfil usuario) throws PEException, UJCException {
		if (repositorio.buscar(usuario.getUsuario()) == null) {
			repositorio.cadastrar(usuario);

		} else {
			throw new PEException(usuario.getUsuario());
		}
	}
	
	public void cancelarPerfil(String usuario) throws PIException, PDException, UNCException {
		try {
			Perfil p = repositorio.buscar(usuario);
			if (p != null && p.isAtivo() == true) {
				p.setAtivo(false);
				repositorio.atualizar(p);
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException pie) {
			pie.printStackTrace();
		} catch (PDException pde) {
			pde.printStackTrace();
		}

	}
	
	public void tweetar(String usuario, String mensagem) throws PIException, MFPException{
		Tweet t = new Tweet();
		Perfil p = repositorio.buscar(usuario);
		if (p != null && p.isAtivo() == true) {
				if (mensagem.length() <= 140) {
					t.setUsuario(usuario);
					t.setMensagem(mensagem);
					p.addTweet(t);
					for (Perfil pe : p.getSeguidores()) {
						if (pe.isAtivo() == true) {
							pe.addTweet(t);
						}
					}
				} else {
					throw new MFPException();
				}
			}
		 else {
			throw new PIException(usuario);
		}
		
	}
	
	public Vector<Tweet> timeline(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		if (p != null && p.isAtivo() == true) {
			
		}
		else if (p == null) {
			throw new PIException(usuario);
		}
		else if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}

		return p.getTimeline();
	}
	
	public Vector<Tweet> tweets(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Tweet> tw = new Vector<Tweet>();
		try {
			if (p != null && p.isAtivo() == true) {
				for (Tweet ta : p.getTimeline()) {
					if (ta.getUsuario().equals(usuario)) {
						tw.add(ta);
					}

				}
			}
			else if (p == null) {
				throw new PIException(usuario);
			}
			else if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}

		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return tw;
	}

	public void seguir(String seguidor, String seguido) throws PIException, PDException, SIException {
		Perfil p = repositorio.buscar(seguidor);
		Perfil pp = repositorio.buscar(seguido);
		try {
			if (seguido == seguidor) {
				throw new SIException();
			}

			if (p == null) {
				throw new PIException(seguidor);
			}
			if  (pp == null) {
				throw new PIException(seguido);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(seguidor);
			}
			if (pp != null && p.isAtivo() == false) {
				throw new PDException(seguido);
			}
			if (p != null && p.isAtivo() == true && pp != null && pp.isAtivo() == true) {
				pp.addSeguidor(p);
				p.addSeguido(pp);
				for(Tweet tw : tweets(seguido)){
					p.addTweet(tw);
				}
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException e) {
			e.printStackTrace();
		} catch (SIException e) {
			e.printStackTrace();
		}
	}
	
	public int numeroSeguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		int inativos = 0;
		try {
			if (p != null && p.isAtivo() == true) {
				for (Perfil pp : p.getSeguidores()) {
					if (pp.isAtivo() == false) {
						inativos++;
					}
				}
				return (p.getSeguidores().size() - inativos);
			}
			if (p == null) {
				throw new PIException(usuario);
			}
			if (p != null && p.isAtivo() == false) {
				throw new PDException(usuario);
			}
		} catch (PIException e) {
			e.printStackTrace();
		} catch (PDException ee) {
			ee.printStackTrace();
		}
		return 0;
	}
	
	public Vector<Perfil> seguidores(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vp = new Vector<Perfil>();
		if (p != null && p.isAtivo() == true) {
			for (Perfil pp : p.getSeguidores()) {
				if (pp.isAtivo() == true) {
					vp.add(pp);
				}
			}
		}

		if (p == null) {
			throw new PIException(usuario);
		}
		if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}
		return vp;
	}

	public Vector<Perfil> seguidos(String usuario) throws PIException, PDException {
		Perfil p = repositorio.buscar(usuario);
		Vector<Perfil> vp = new Vector<Perfil>();
		if (p != null && p.isAtivo() == true) {
			for (Perfil pp : p.getSeguidos()) {
				if (pp.isAtivo() == true) {
					vp.add(pp);
				}
			}
		}
		if (p == null) {
			throw new PIException(usuario);
		} else if (p != null && p.isAtivo() == false) {
			throw new PDException(usuario);
		}
		return vp;
	}

}
