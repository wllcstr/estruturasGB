// Grupo 7
// Gabriel Ely
// Jorge Medeiros
// William Azevedo de Castro


import java.util.Random;

public class Cenario {
	// Atributo para cria��o de um array comum.
	private Comparable[] escopo;

	// Construtor.
	public Cenario() {
		this.escopo = null;
	}
		
	
	public Cenario(int tamanho) {
		this.escopo = new Comparable[tamanho];
	}
	
	public Comparable[] getEscopo() {
		return this.escopo;
	}
	
	// Escopo ser� preenchido em ordem ascendente.
	public Comparable[] ordemAscendente() {
		for (int i = 0; i < escopo.length; i++) {
			escopo[i] = i + 1;
		}
		return escopo;
	}

	// Escopo ser� preenchido em ordem descendente.
	public Comparable[] ordemDescendente() {
		for (int i = 0, j = escopo.length; i < escopo.length; i++, j--) {
			escopo[i] = j;
		}
		return escopo;
	}

	// Escopo ser� preenchido aleatoriamente, mas sem repeti��o.
	public Comparable[] ordemAleatoria() {
		// Primeiramente � criado um escopo em ordem ascendente, para n�o ter repeti��es.
		ordemAscendente();
		
		// Realiza��o do embaralhamento do array.
		Random random = new Random();
		for (int i = 0; i < (this.escopo.length - 1); i++) {
			int j = random.nextInt(this.escopo.length);
			Comparable temp = escopo[i];
			escopo[i] = escopo[j];
			escopo[j] = temp;
		}
		return escopo;
	}	
	
	// Escopo ser� preenchido aleatoriamente com repeti��es de 5% do tamanho do array para cada chave.
	public Comparable[] ordemAleatoriaRepetida() {
		int i = 0;
		int aux = 1;
		
		// Guarda o valor de 5% sobre o tamanho do escopo.
		int numRepeticoes = (int) (escopo.length * 0.05);
		
		// Repete o n�mero de vezes necess�rio para cada chave.
		while(i < escopo.length) {
			for (int j = 0; j < numRepeticoes && i < escopo.length; j++, i++) {
				escopo[i] = aux;
			}
			aux++;
		}
		
		// Realiza��o do embaralhamento do array.
		Random random = new Random();
		for (int a = 0; a < (this.escopo.length - 1); a++) {
			int b = random.nextInt(this.escopo.length);
			Comparable temp = escopo[a];
			escopo[a] = escopo[b];
			escopo[b] = temp;
		}
		return escopo;
	}

	// Impress�o na tela dos valores do escopo.
	public String toString() {
		String t = "";
		for (int i = 0; i < this.escopo.length; i++)
			t += this.escopo[i] + " ";
		return t;
	}

}
