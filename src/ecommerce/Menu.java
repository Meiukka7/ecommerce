package ecommerce;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	private Filapedido fila;
	private Catalogo catalogo;
	private PilhaHistorico historico;

	public Menu() {

		this.catalogo = new Catalogo();
		this.fila = new Filapedido();
		this.historico = new PilhaHistorico();

	}

	public void opções() {

		Produto p1 = new Produto(10, "Teclado", 150.00);
		Produto p2 = new Produto(20, "Mouse", 80.00);
		Produto p3 = new Produto(15, "Monitor", 900.00);
		Produto p4 = new Produto(30, "Gabinete", 250.00);
		Produto p5 = new Produto(45, "Processador", 2000.00);

		catalogo.inserir(p1);
		catalogo.inserir(p2);
		catalogo.inserir(p3);
		catalogo.inserir(p5);
		catalogo.inserir(p4);

		int opp;

		do {

			System.out.println("MENU DE OPÇÃO");
			System.out.println();
			System.out.println("1- CATÁLOGO DE PRODUTOS");
			System.out.println();
			System.out.println("2- PEDIDOS");
			System.out.println();
			System.out.println("3- HISTÓRICO");
			System.out.println();
			System.out.println("0- SAIR");

			opp = sc.nextInt();

			switch (opp) {

			case 1:
				menuProdutos();
				historico.empilhar("CATÁLOGO DE PRODUTOS");

				break;

			case 2:

				menuPedidos();

				historico.empilhar("PEDIDOS");

				break;

			case 3:

				historico.mostraHistorico();
				historico.empilhar("HISTÓRICO");

				break;

			case 0:
				System.out.println("Encerrando...");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (opp != 0);

	}

	public void menuProdutos() {

		int opp;

		do {

			System.out.println("MENU DE PRODUTOS");
			System.out.println();
			System.out.println("1- BUSCAR UM PRODUTO");
			System.out.println();
			System.out.println("2- VER TODOS OS PRODUTOS");
			System.out.println();
			System.out.println("0- SAIR");

			opp = sc.nextInt();

			switch (opp) {

			case 1:
				System.out.println("DIGITE O CÓDIGO DO PRODUTO QUE DESEJA");

				int code = sc.nextInt();

				No resultado = catalogo.busca(code);

				if (resultado != null) {

					resultado.getProduto().mostraProduto();

					System.out.println("1 - Adicionar ao carrinho");
					System.out.println("0 - Voltar");

					int compra = sc.nextInt();

					sc.nextLine();

					if (compra == 1) {

						System.out.println("Qual o nome do cliente?");

						String nome = sc.nextLine();

						Pedido novoPedido = new Pedido(nome, resultado.getProduto());

						fila.enfileirar(novoPedido);

						System.out.println("SEU PEDIDO FOI REGISTRADO");
						System.out.println("1 - deseja pagar agora?");
						System.out.println("0 - voltar");

						int pagar = sc.nextInt();

						if (pagar == 1) {

							Pedido pedidoAtual = fila.consultarInicio();

							if (pedidoAtual == novoPedido) {

								System.out.println("O VALOR DO PRODUTO FICOU   " + resultado.getProduto().getValor()
										+ "  , REALIZE O PAGAMENTO PARA FECHAR\"");

								double pagamento = sc.nextDouble();

								if (pagamento == resultado.getProduto().getValor()) {

									System.out.println("PARABÉNS, COMPRA BEM SUCEDIDA");

									fila.desenfileirar();

								} else {

									System.out.println("PAGAMENTO INCORRETO");

								}

							} else {

								System.out.println("SEU PEDIDO ESTÁ AGUARDANDO NA FILA.");
								System.out.println("AGUARDE SUA VEZ PARA REALIZAR O PAGAMENTO.");
							}

						}
					}

					else {

						System.out.println("PRODUTO NÃO ENCONTRADO");
					}

				}

				break;

			case 2:

				catalogo.listar();

				System.out.println("");
				System.out.println("AGUARDE SUA VEZ PARA REALIZAR O PAGAMENTO.");

				break;

			case 3:

				break;

			case 0:
				historico.desempilhar();
				System.out.println("Voltando ao menu principal...");
				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (opp != 0);

	}

	public void menuPedidos() {

		int opp;

		do {

			System.out.println("MENU DE OPÇÃO PEDIDOS");
			System.out.println();
			System.out.println("1- BUSCAR PEDIDO POR CÓDIGO");
			System.out.println();
			System.out.println("2- PEDIDOS");

			System.out.println();
			System.out.println("0- SAIR");

			opp = sc.nextInt();

			switch (opp) {

			case 1:

				System.out.println("DIGITE O CÓDIGO DO SEU PRODUTO");

				int codeProd = sc.nextInt();

				Pedido pedido = fila.buscarPedido(codeProd);

				if (pedido != null) {

					pedido.mostrarPedido();

					System.out.println("DESEJA REALIZAR O PAGAMENTO DO SEU PEDIDO? DIGITE 1 PARA SIM E 0 PARA VOLTAR");

					int cont = sc.nextInt();

					if (cont == 1) {

						System.out.println("O VALOR DO PEDIDO FOI  " + pedido.getValorTotal() + " ENVIE SEU PAGAMENTO");

						double pagamento = sc.nextInt();

						if (pagamento == pedido.getValorTotal()) {

							System.out.println("PARABÉNS, COMPRA BEM SUCEDIDA");

							fila.desenfileirar();

						} else {

							System.out.println("PAGAMENTO INCORRETO");

						}

					} else {

						System.out.println("SEU PEDIDO ESTÁ AGUARDANDO NA FILA.");
						System.out.println("AGUARDE SUA VEZ PARA REALIZAR O PAGAMENTO.");

					}

				}

				else {

					System.out.println("PEDIDO NÃO ENCONTRADO");
				}

				break;

			case 2:

				fila.mostrarPedidos();

				break;

			case 0:

				historico.desempilhar();
				System.out.println("Voltando ao menu principal...");

				break;

			default:
				System.out.println("Opção inválida!");
			}

		} while (opp != 0);

	}

}
