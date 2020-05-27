package entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class BuscaCEP {
	
	private String cep;
	private String[] informacoes;
	
	public BuscaCEP(String cep) {
		this.cep = cep;
		this.informacoes = null;
	}

	private String pesquisaCEP() {
		String informacoes = "";
		try {
			// Prepara URL para se conectar e buscar logradouro pelo CEP
			URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
			
			// Faz a conex�o com o servi�o dispon�vel
			URLConnection urlConnection = url.openConnection();
			
			// Prepara para receber sequ�ncia de bits
			InputStream is = urlConnection.getInputStream();
			
			// Faz a leitura desta sequ�ncia de bits
			InputStreamReader isr = new InputStreamReader(is, "UTF8");
			
			// Converte para Bytes esta sequ�ncia de bits
			BufferedReader br = new BufferedReader(isr);
			
			// Prepara buffer para receber String
			StringBuffer bs = new StringBuffer();
			
			informacoes = br.readLine();
			while(informacoes != null) {
				bs.append(informacoes);
				informacoes = br.readLine();
			}
			
			// Fechando fluxos abertos
			br.close();
			isr.close();
			is.close();
			
			informacoes = bs.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(informacoes);
	}
	
	public String[] pesquisa() {
		String informacoes = this.pesquisaCEP();
		informacoes = informacoes.replaceAll("[{}]", "").replaceAll("\"", "");
		String listaInformacoes[] = informacoes.split(",");
		this.informacoes = listaInformacoes;
		return(listaInformacoes);
	}
	
	public String filtraPesquisa(String filtro) {
		String resultado = "";
		String partes[];
		if(this.informacoes == null) {
			this.pesquisa();
		}
		String nfiltro = filtro.toLowerCase();
		if(nfiltro.equals("endereco") || nfiltro.equals("endere�o")) {
			nfiltro = "logradouro";
		} else if (nfiltro.equals("cidade")) {
			nfiltro = "localidade";
		} else if (nfiltro.equals("estado")) {
			nfiltro = "uf";
		}
		String busca = "";
		for(String linha : this.informacoes) {
			partes = linha.split(": ");
			busca = partes[0].toLowerCase();
			if(busca.indexOf(nfiltro) > 0 && partes.length > 1) {
				resultado = partes[1];
			}
		}
		return(resultado);
	}
}
