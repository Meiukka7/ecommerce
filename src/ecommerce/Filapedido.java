package ecommerce;

public class Filapedido {

	private Nopedido inicio;
	private Nopedido fim;

	public Filapedido() {
		this.inicio = null;
		this.fim = null;
	}

	public void enfileirar(Pedido pedido) {

		Nopedido novo = new Nopedido(pedido);

		if (inicio == null) {
			inicio = novo;
			fim = novo;
		} else {
			fim.setProximo(novo);
			fim = novo;
		}
	}
	public Pedido consultarInicio() {

	    if (inicio == null) {
	        return null;
	    }

	    return inicio.getPedido();
	}

	public Pedido desenfileirar() {

		if (inicio == null) {
			return null;
		}

		 Pedido pedido = inicio.getPedido();

		inicio = inicio.getProximo();

		if (inicio == null) {
			fim = null;
		}

		return pedido;
	}

	public void mostrarPedidos() {

		Nopedido atual = inicio;

		while (atual != null) {

			atual.getPedido().mostrarPedido();

			atual = atual.getProximo();
		}
	}

	public boolean estaVazia() {
		return inicio == null;
	}
	
	public Pedido buscarPedido(int codigo) {

	    Nopedido atual = inicio;

	    while (atual != null) {

	        if (atual.getPedido().getCodigo() == codigo) {

	            return atual.getPedido();

	        }

	        atual = atual.getProximo();

	    }

	    return null;
	}
}
