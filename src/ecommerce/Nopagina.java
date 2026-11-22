package ecommerce;

public class Nopagina {

	private String pagina;
	private Nopagina proximo;

	public Nopagina(String pagina) {
		this.pagina = pagina;
		this.proximo = null;

	}

	public String getPagina() {
		return pagina;
	}

	public Nopagina getProximo() {
		return proximo;
	}

	public void setProximo(Nopagina proximo) {
		this.proximo = proximo;
	}
}
