package app;

import java.lang.reflect.*;

/**
 * Classe Lista, representa uma lista encadeada duplamente ligada desordenada sem repetição.
 *
 * @param <X> tipo a ser armazenado
 */
public class ListaEncadeadaDesordenadaSemRepeticao<X> {
	/**
	 * Classe Nó, representa um elemento da lista.
	 */
	public class No {
		private No ante;
		private X info;
		private No prox;

		/**
		 * Construtor de classe.
		 * @param a Nó anterior a este.
		 * @param i Os dados deste Nó.
		 * @param p Nó seguinte a este.
		 */
		public No(No a, X i, No p) {
			this.ante = a;
			this.info = i;
			this.prox = p;
		}

		/**
		 * Construtor de classe.
		 * @param i Os dados deste Nó.
		 */
		public No(X i) {
			this.ante = null;
			this.info = i;
			this.prox = null;
		}

		/**
		 * Get do Nó anterior a este.
		 * @return o Nó anterior
		 */
		public No getAnte() {
			return this.ante;
		}

		/**
		 * Get dos dados armazenados neste Nó.
		 * @return os dados deste Nó
		 */
		public X getInfo() {
			return this.info;
		}

		/**
		 * Get do Nó seguinte a este.
		 * @return o próximo Nó
		 */
		public No getProx() {
			return this.prox;
		}

		/**
		 * Define o Nó anterior a este
		 * @param a o Nó anterior
		 */
		public void setAnte(No a) {
			this.ante = a;
		}

		/**
		 * Define os dados deste Nó.
		 * @param i os dados deste Nó
		 */
		public void setInfo(X i) {
			this.info = i;
		}

		/**
		 * Define o Nó seguinte a este
		 * @param p o próximo Nó
		 */
		public void setProx(No p) {
			this.prox = p;
		}
	}

	protected No primeiro, ultimo;
	
	/**
	 * Construtor de classe
	 */
	public ListaEncadeadaDesordenadaSemRepeticao() {
		this.primeiro = this.ultimo = null;
	}

	/**
	 * Retorna um clone do objeto.
	 * @param x objeto a ser clonado
	 * @return clone de x
	 */
	protected X meuCloneDeX(X x) {
		X ret = null;

		try {
			Class<?> classe = x.getClass();
			Class<?>[] tiposDosParms = null;
			Method metodo = classe.getMethod("clone", tiposDosParms);
			Object[] parms = null;
			ret = (X) metodo.invoke(x, parms);
		} catch (Exception erro) {
		}

		return ret;
	}

	/**
	 * Insere um Nó no início da lista.
	 * @param i Nó a ser inserido
	 * @throws Exception caso i seja nulo
	 * @throws Exception caso i já exista na lista
	 */
	public void insiraNoInicio(X i) throws Exception {
		if (i == null)
			throw new Exception("Infomacao passada nula");

		if (this.tem(i))
			throw new Exception("Informacao ja existente");

		X inserir = null;
		if (i instanceof Cloneable)
			inserir = meuCloneDeX(i);
		else
			inserir = i;

		this.primeiro = new No(null, inserir, this.primeiro);

		if (this.primeiro.getProx() != null)
			this.primeiro.getProx().setAnte(this.primeiro);

		this.primeiro.setAnte(null);

		if (this.ultimo == null)
			this.ultimo = this.primeiro;
	}

	/**
	 * Insere um Nó no fim da lista.
	 * @param i Nó a ser inserido
	 * @throws Exception caso i seja nulo
	 * @throws Exception caso i já exista na lista
	 */
	public void insiraNoFim(X i) throws Exception {
		if (i == null)
			throw new Exception("Informacao passada nula");

		if (this.tem(i))
			throw new Exception("Informacao ja existente");

		X inserir = null;
		if (i instanceof Cloneable)
			inserir = meuCloneDeX(i);
		else
			inserir = i;

		if (this.ultimo == null) {
			this.ultimo = new No(inserir);
			this.primeiro = this.ultimo;
		} else {
			this.ultimo.setProx(new No(this.ultimo, inserir, null));
			this.ultimo = this.ultimo.getProx();
		}
	}

	/**
	 * Remove o Nó do fim da lista.
	 * @throws Exception caso a lista esteja vazia
	 */
	public void removaDoFim() throws Exception {
		if (this.isVazia())
			throw new Exception("A lista esta vazia");

		this.ultimo = this.ultimo.getAnte();
		
		if(this.ultimo == null)
			this.primeiro = null;
		else
			this.ultimo.setProx(null);
	}

	/**
	 * Remove o Nó do início da lista.
	 * @throws Exception caso a lista esteja vazia
	 */
	public void removaDoInicio() throws Exception {
		if (this.isVazia())
			throw new Exception("A lista esta vazia");

		this.primeiro = this.primeiro.getProx();
		
		if(this.primeiro==null)
			this.ultimo = null;
		else
			this.primeiro.setAnte(null);
	}

	/**
	 * Remove o Nó indicado
	 * @param i Nó a ser removido
	 * @throws Exception caso i seja nulo
	 * @throws Exception caso a lista esteja vazia
	 */
	public void remova(X i) throws Exception {
		if (i == null)
			throw new Exception("Informacao passada nula");

		if (this.isVazia())
			throw new Exception("A lista esta vazia");

		if (i.equals(this.primeiro.getInfo())) {
			this.primeiro = this.primeiro.getProx();

			if (this.primeiro == null)
				this.ultimo = null;
			else
				this.primeiro.setAnte(null);

			return;
		}

		No atual = this.primeiro;

		for (;;) {
			if (atual == null)
				throw new Exception("Lista esta vazia");

			if (i.equals(atual.getInfo())) {
				if (atual == this.primeiro) {
					this.primeiro = this.primeiro.getProx();

					if (this.primeiro == null)
						this.ultimo = null;
					else
						this.primeiro.setAnte(null);

					return;
				}

				if (atual == this.ultimo) {
					this.ultimo = this.ultimo.getAnte();

					if (this.ultimo == null)
						this.primeiro = null;
					else
						this.ultimo.setProx(null);

					return;
				}

				atual.getAnte().setProx(atual.getProx());
				atual.getProx().setAnte(atual.getAnte());
				return;
			}

			atual = atual.getProx();
		}
	}

	/**
	 * Verifica se um Nó está presente na lista
	 * @param i o Nó a ser verificado
	 * @return se o Nó está na lista
	 * @throws Exception caso i seja nulo
	 */
	public boolean tem(X i) throws Exception {
		if (i == null)
			throw new Exception("Informacao ausente");

		No atual = this.primeiro;

		while (atual != null) {
			if (i.equals(atual.getInfo()))
				return true;

			atual = atual.getProx();
		}

		return false;
	}

	/**
	 * Get da quantidade de Nós na lista
	 * @return a quantidade de Nós na lista
	 */
	public int getQtd() {
		int ret = 0;

		No atual = this.primeiro;

		while (atual != null) {
			ret++;
			atual = atual.getProx();
		}

		return ret;
	}

	/**
	 * Get das informações do primeiro Nó
	 * @return dados do primeiro Nó
	 * @throws Exception caso a lista esteja vazia
	 */
	public X getPrimeiro() throws Exception {
		if (this.isVazia())
			throw new Exception("Lista vazia, nada a obter");

		X ret = this.primeiro.getInfo();
		if (ret instanceof Cloneable)
			ret = meuCloneDeX(ret);

		return ret;
	}

	/**
	 * Get das informações do último Nó
	 * @return dados do último Nó
	 * @throws Exception caso a lista esteja vazia
	 */
	public X getUltimo() throws Exception {
		if (this.isVazia())
			throw new Exception("Lista vazia, nada a obter");

		X ret = this.ultimo.getInfo();
		if (ret instanceof Cloneable)
			ret = meuCloneDeX(ret);

		return ret;
	}

	/**
	 * Verifica se a lista está vazia
	 * @return se a lista está vazia
	 */
	public boolean isVazia() {
		return this.primeiro == null;
	}

	/**
	 * Inverte a ordem da lista
	 */
	public void invertaSe() {
		if (this.primeiro == null)
			return;
		
		if (this.primeiro.getProx() == null)
			return;
		
		ListaEncadeadaDesordenadaSemRepeticao<X> inversao = new ListaEncadeadaDesordenadaSemRepeticao<X>();
		
		inversao = this.getInversao();
		
		this.primeiro = new No(inversao.primeiro.getInfo());

		No thisNo = this.primeiro;
		No outroNo = inversao.primeiro.getProx();

		while (outroNo != null) {
			thisNo.setProx(new No(thisNo, outroNo.getInfo(), null));
			thisNo = thisNo.getProx();
			outroNo = outroNo.getProx();
		}

		this.ultimo = thisNo;
		
	}

	/**
	 * Retorna a inversão da lista
	 * @return a lista, invertida
	 */
	public ListaEncadeadaDesordenadaSemRepeticao<X> getInversao() {
		ListaEncadeadaDesordenadaSemRepeticao<X> ret = new ListaEncadeadaDesordenadaSemRepeticao<X>();
		
		for (No atual = this.primeiro; atual != null; atual = atual.getProx()) {
			try {
				ret.insiraNoInicio(atual.getInfo());
			} catch (Exception e) {}
		}
		
		return ret;
	}

	public String toString() {
		String ret = "[";

		No atual = this.primeiro;

		while (atual != null) {
			ret = ret + atual.getInfo();

			if (atual != this.ultimo)
				ret = ret + ", ";

			atual = atual.getProx();
		}

		return ret + "]";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (this.getClass() != obj.getClass())
			return false;

		ListaEncadeadaDesordenadaSemRepeticao<X> outro = (ListaEncadeadaDesordenadaSemRepeticao<X>) obj;

		No thisNo = this.primeiro;
		No outroNo = outro.primeiro;

		while (thisNo != null && outroNo != null) {
			if (!thisNo.getInfo().equals(outroNo.getInfo()))
				return false;

			thisNo = thisNo.getProx();
			outroNo = outroNo.getProx();
		}

		if (thisNo != null || outroNo != null)
			return false;

		return true;
	}

	public int hashCode() {
		int ret = 7;

		No atual = this.primeiro;

		while (atual != null) {
			ret = 13 * ret + atual.hashCode();
			atual = atual.getProx();
		}

		return ret;
	}

	/**
	 * Construtor de cópia
	 * @param modelo lista a ser copiada
	 * @throws Exception caso modelo seja nulo
	 */
	public ListaEncadeadaDesordenadaSemRepeticao(ListaEncadeadaDesordenadaSemRepeticao<X> modelo) throws Exception {
		if (modelo == null)
			throw new Exception("Modelo ausente");

		if (modelo.primeiro == null)
			return;

		this.primeiro = new No(modelo.primeiro.getInfo());

		No thisNo = this.primeiro;
		No outroNo = modelo.primeiro.getProx();

		while (outroNo != null) {
			thisNo.setProx(new No(thisNo, outroNo.getInfo(), null));
			thisNo = thisNo.getProx();
			outroNo = outroNo.getProx();
		}

		this.ultimo = thisNo;
	}

	public Object clone() {
		ListaEncadeadaDesordenadaSemRepeticao<X> ret = null;

		try {
			ret = new ListaEncadeadaDesordenadaSemRepeticao<X>(this);
		} catch (Exception e) {
		}

		return ret;
  }
}
