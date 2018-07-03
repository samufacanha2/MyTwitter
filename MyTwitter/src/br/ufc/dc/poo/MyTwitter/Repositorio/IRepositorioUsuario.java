package br.ufc.dc.poo.MyTwitter.Repositorio;
import br.ufc.dc.poo.MyTwitter.Perfis.*;
import br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions.*;
public interface IRepositorioUsuario {

	public void cadastrar(Perfil usuario) throws UJCException;
	public Perfil buscar(String usuario);
	public void atualizar(Perfil usuario) throws UNCException;

	
}
