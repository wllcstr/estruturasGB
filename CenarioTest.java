// Grupo 7
// Gabriel Ely
// Jorge Medeiros
// William Azevedo de Castro

import java.util.Arrays;
import java.util.Scanner;


public class CenarioTest {
	
	static Cenario[] escopo = new Cenario[10];
	
	// classe que faz os sorts
	static Sort sort = new Sort();	
	
	public static void main(String[] args) {
		
		for (Integer amostra : Arrays.asList(128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536)) {
			for (String cenario : Arrays.asList("ascendente", "descendente", "aleatoria", "repetida")) {
				arrayFill(amostra);
				for (String metodo : Arrays.asList("bubble", "insertion", "selection", "heap", "shell", "merge", "quick")) {
					// ordena 10 cenarios em ordem crescente
					ordena(cenario);
					// executa ordenação com bubble sorte para o cenário
					System.out.println("================= CLASSIFICAÇÃO " + cenario.toUpperCase() + " ==================");
					tempoExecucao(metodo);
				}
			}
		}
		
		return;
	}
	
	// metodo que recebe a ordenação e ordena todos os arrays da matriz
	public static void ordena(String ordenacao) {
		switch(ordenacao) {
		case "ascendente":
			for(int i = 0; i < 10; i++) 
				escopo[i].ordemAscendente();
			break;
		case "descendente":
			for(int i = 0; i < 10; i++) 
				escopo[i].ordemDescendente();
			break;
		case "aleatoria":
			for(int i = 0; i < 10; i++) 
				escopo[i].ordemAleatoria();
			break;
		case "repetida":
			for(int i = 0; i < 10; i++) 
				escopo[i].ordemAleatoriaRepetida();
			break;
		}
	}

	// Método preenche a matriz com vários cenários iguais.
	public static void arrayFill(int qChaves) {
		Cenario c = new Cenario(qChaves);
		for(int i = 0; i < 10; i++)  
			escopo[i] = c;
	}

	
	public static void tempoExecucao(String tipo) {
		System.out.println("Tempo de execução em nanosegundos - " + tipo + " sort - "  + escopo[0].getEscopo().length + " chaves");
		switch(tipo) {
		case "bubble":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.bubbleSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "insertion":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.insertionSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "selection":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.selectionSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "heap":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.heapSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "shell":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.shellSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "merge":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.mergeSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		case "quick":
			for(int i = 0; i < 10; i++)  {
				double initial = System.nanoTime();
				sort.quickSort(escopo[i].getEscopo());
				// Fim da contagem de tempo.
				double finalt = System.nanoTime();
				double time = (finalt - initial);
				System.out.println("Amostra " + (i+1) + ": " + time);
			}
			break;
		}
	}
	
	
	

	

}
