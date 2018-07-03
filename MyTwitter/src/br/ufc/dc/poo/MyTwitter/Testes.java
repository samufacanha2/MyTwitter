package br.ufc.dc.poo.MyTwitter;

import java.io.IOException;

import br.ufc.dc.poo.MyTwitter.Repositorio.*;
import br.ufc.dc.poo.MyTwitter.Twitter.Exceptions.*;
import br.ufc.dc.poo.MyTwitter.Repositorio.Exceptions.*;
import br.ufc.dc.poo.MyTwitter.Perfis.*;
import br.ufc.dc.poo.MyTwitter.Twitter.*;


public class Testes {
	public static void main(String[] args) throws UJCException, UNCException, PEException, PIException, PDException,
	MFPException, SIException, IOException {




RepositorioUsuario rp = new RepositorioUsuario();
MyTwitter my = new MyTwitter(rp);
PessoaFisica Pes = new PessoaFisica("samu2", 1000);
PessoaFisica Pes1 = new PessoaFisica("samu3", 1001);
PessoaFisica Pes2 = new PessoaFisica("samu4", 1002);
PessoaFisica Pes3 = new PessoaFisica("samu5", 1003);

my.criarPerfil(Pes);
my.criarPerfil(Pes1);
my.criarPerfil(Pes2);
my.criarPerfil(Pes3);


my.tweetar("samu2", "aqui é o samu2");
my.tweetar("samu3", "aqui é o samu3");
my.tweetar("samu4", "aqui é o samu4");
my.tweetar("samu5", "aqui é o samu5");



my.seguir("samu2", "samu3");
my.seguir("samu2", "samu4");
my.seguir("samu3", "samu2");
my.seguir("samu4", "samu2");
my.seguir("samu3", "samu4");
my.seguir("samu5", "samu2");
my.seguir("samu5", "samu3");
my.seguir("samu5", "samu4");
my.seguir("samu4", "samu5");
my.seguir("samu3", "samu5");

//my.cancelarPerfil("samu5");

System.out.println("######################################################################");


System.out.println("samu 2");


System.out.println("Meus tweets :");

for(Tweet t : my.tweets("samu2")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");



System.out.println("TIMELINE");



for(Tweet t : my.timeline("samu2")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("SEGUIDORES : " +my.numeroSeguidores("samu2"));



for(Perfil p : my.seguidores("samu2")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");



for(Perfil p : my.seguidos("samu2")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");



System.out.println("samu 3");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("samu3")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");


for(Tweet t : my.timeline("samu3")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("samu3"));

for(Perfil p : my.seguidores("samu3")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("samu3")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");

System.out.println("samu 4");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("samu4")){
	System.out.println(t.getMensagem());
}
System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");

for(Tweet t : my.timeline("samu4")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("samu4"));

for(Perfil p : my.seguidores("samu4")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("samu4")){
	System.out.println(p.getUsuario());
};

System.out.println("######################################################################");

System.out.println("samu 5");

System.out.println("Meus tweets :");

for(Tweet t : my.tweets("samu5")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");


System.out.println("TIMELINE");

for(Tweet t : my.timeline("samu5")){
	System.out.println(t.getMensagem());
}

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDORES : " +my.numeroSeguidores("samu5"));

for(Perfil p : my.seguidores("samu5")){
	System.out.println(p.getUsuario());
};

System.out.println("----------------------------------------------------------------------------");

System.out.println("SEGUIDOS");

for(Perfil p : my.seguidos("samu5")){
	System.out.println(p.getUsuario());
};



}

}
