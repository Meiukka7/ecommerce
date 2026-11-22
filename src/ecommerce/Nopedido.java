package ecommerce;

public class Nopedido {
	
	
	private Pedido pedido;
    private Nopedido proximo;

    public Nopedido(Pedido pedido) {
        this.pedido = pedido;
        this.proximo = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Nopedido getProximo() {
        return proximo;
    }

    public void setProximo(Nopedido proximo) {
        this.proximo = proximo;
    }
}


