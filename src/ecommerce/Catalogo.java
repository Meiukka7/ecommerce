package ecommerce;

public class Catalogo {

	private No raiz;

	public Catalogo() {

		this.raiz = null;
	}

	public No busca(int codigo) {

		No noResultado = buscaRecursiva(raiz, codigo);

		return noResultado;

	}

	private No buscaRecursiva(No raiz, int codigo) {

		if (raiz != null) {

			if (codigo == raiz.getProduto().getCodigo()) {

				return raiz;

			} else if (codigo < raiz.getProduto().getCodigo()) {

				return buscaRecursiva(raiz.getEsquerdo(), codigo);
			} else {

				return buscaRecursiva(raiz.getDireito(), codigo);
			}

		}

		return null;
	}

	public void inserir(Produto produto) {

		if (raiz == null) {

			raiz = new No(produto);
		} else {
			inserirRecursivo(raiz, produto);
		}

	}

	private void inserirRecursivo(No raiz, Produto produto) {

		int codigo = produto.getCodigo();

		if (codigo < raiz.getProduto().getCodigo()) {
			if (raiz.getEsquerdo() == null) {

				No novoNo = new No(produto);
				raiz.setEsquerdo(novoNo);
				
			} else {

				inserirRecursivo(raiz.getEsquerdo(), produto);
			}

		} else if (codigo > raiz.getProduto().getCodigo()) {
			if (raiz.getDireito() == null) {

				No novoNo = new No(produto);
				raiz.setDireito(novoNo);

			} else {

				inserirRecursivo(raiz.getDireito(), produto);
			}

		}
	}

	public void remover(int codigo) {

		raiz = removerRecursivo(raiz, codigo);

	}

	private No removerRecursivo(No raiz, int codigo) {

		if (raiz == null) {

			return null;
		}
		if (codigo < raiz.getProduto().getCodigo()) {

			raiz.setEsquerdo(removerRecursivo(raiz.getEsquerdo(), codigo));
		}

		else if (codigo > raiz.getProduto().getCodigo()) {

			raiz.setDireito(removerRecursivo(raiz.getDireito(), codigo));

		}

		else {

			if (raiz.getEsquerdo() == null && raiz.getDireito() == null) {
				return null;
			}

			if (raiz.getEsquerdo() == null) {
				return raiz.getDireito();
			}

			if (raiz.getDireito() == null) {
				return raiz.getEsquerdo();
			}

			No sucessor = menorNo(raiz.getDireito());

			raiz.setProduto(sucessor.getProduto());

			raiz.setDireito(removerRecursivo(raiz.getDireito(), sucessor.getProduto().getCodigo()));
		}

		return raiz;
	}

	private No menorNo(No atual) {

		while (atual.getEsquerdo() != null) {
			atual = atual.getEsquerdo();
		}

		return atual;
	}

	public void listar() {
	    listarEmOrdem(raiz);
	}

	private void listarEmOrdem(No atual) {

	    if (atual != null) {

	        listarEmOrdem(atual.getEsquerdo());

	        atual.getProduto().mostraProduto();

	        listarEmOrdem(atual.getDireito());
	    }
	}
	
	
	
	
}
