package br.ufc.dc.poo.MyTwitter.Repositorio;

import java.util.Vector;
import br.ufc.dc.poo.MyTwitter.Perfis.*;
import br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions.*;

public class RepositorioUsuario implements IRepositorioUsuario{
	private Vector<Perfil> usuarios;
	
	public RepositorioUsuario() {
		this.usuarios = new Vector<Perfil>();
	}
	
	public void cadastrar(Perfil usuario) throws UJCException {
		
		try {
			if (this.buscar(usuario.getUsuario()) == null) {
				this.usuarios.add(usuario);

			} else {
				throw new UJCException(usuario.getUsuario());
			}
		} catch (UJCException e) {
			e.printStackTrace();
		} 

	}
	
	public Perfil buscar(String usuario) {
		for (Perfil u : usuarios) {
			if (u.getUsuario().equals(usuario)) {
				return u;
			}
		}
		return null;
	}
	
	public void atualizar(Perfil usuario) throws UNCException {
		
		Perfil p = this.buscar(usuario.getUsuario());
		
		if (p != null) {
			this.usuarios.add(usuario);
			
		} else {
			throw new UNCException(usuario.getUsuario());
		}
	}
}
