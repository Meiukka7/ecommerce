package ecommerce;

public class No {

	private Produto produto;
	private No esquerdo;
	private No direito;

	public No(Produto produto) {

		this.produto = produto;
		this.direito = direito;
		this.esquerdo = esquerdo;

	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

}
