package ecommerce;

public class PilhaHistorico {

	private Nopagina topo;

	public PilhaHistorico() {

		this.topo = null;

	}

	public void empilhar(String pagina) {

		Nopagina novo = new Nopagina(pagina);

		novo.setProximo(topo);

		topo = novo;

	}

	public String desempilhar() {

		if (topo == null) {

			return null;
		}

		String pagina = topo.getPagina();

		topo = topo.getProximo();

		return pagina;

	}

	public Nopagina getTopo() {
		return topo;
	}

	public void setTopo(Nopagina topo) {
		this.topo = topo;
	}

	public void mostraHistorico() {

		Nopagina atual = topo;

		while (atual != null) {

			System.out.println(atual.getPagina());

			atual = atual.getProximo();
		}
	}

	public boolean estaVazia() {
		return topo == null;
	}

}
