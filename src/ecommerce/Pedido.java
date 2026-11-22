package ecommerce;

public class Pedido {

	private static int proximoCodigo = 1;

	private int codigo;
	private String cliente;
	private Produto produto;
	private double valorTotal;
	private String status;

	public Pedido(String cliente, Produto produto) {

		this.codigo = proximoCodigo++;
		this.cliente = cliente;
		this.produto = produto;
		this.valorTotal = produto.getValor();
		this.status = "AGUARDANDO PAGAMENTO";
	}

	public void mostrarPedido() {

		System.out.println("===== DADOS DO PEDIDO =====");
		System.out.println("Código: " +codigo);
		System.out.println("Cliente: " + cliente);
		System.out.println("Produto: " + produto.getNome());
		System.out.println("Valor total: R$ " + valorTotal);
		System.out.println("Status: " + status);
	}

	public void atualizarStatus(String novoStatus) {
		this.status = novoStatus;
	}

	public static int getProximoCodigo() {
		return proximoCodigo;
	}

	public static void setProximoCodigo(int proximoCodigo) {
		Pedido.proximoCodigo = proximoCodigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
