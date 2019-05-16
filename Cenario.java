// Grupo 7
// Gabriel Ely
// Jorge Medeiros
// William Azevedo de Castro

public class Cenario {
	private int[] escopo;

	public Cenario(int n) {
		this.escopo = new int[n];
	}
	
	public void geraEscopoAscendente() {
		for(int i = 0; i < this.escopo.length; i++)
			escopo[i] = i+1;
	}
	
	public void geraEscopoDescendente() {
		int j = this.escopo.length;
		for(int i = 0; i < this.escopo.length; i++) {
			escopo[i] = j--;
		}
			
	}
	
	public void geraEscopoRepetido() {
		int r = (int)Math.ceil(this.escopo.length / 20);
		for(int i = 0; i < this.escopo.length;) {
			int j = 0;
			int t = i;
			while(j < r && i < this.escopo.length) {
				escopo[i] = t+1;
				j++;
				i++;
			}
		}
	}
	
	public void geraEscopoRepetidoAleatorio() {
		geraEscopoRepetido();
		escopoAleatorio();
	}
	
	public void geraEscopoAleatorio() {
		geraEscopoAscendente();
		escopoAleatorio();
	}
	
	public void escopoAleatorio() {
		for(int i = 0; i < this.escopo.length; i++) {
			int ran = (int)(Math.random()*(((escopo.length-1)-0)+1))+0;
			int temp = escopo[i];
			escopo[i] = escopo[ran];
			escopo[ran] = escopo[i];
		}
	}
	
	public String toString() {
		String t = "";
		for(int i = 0; i < this.escopo.length; i++)
			t += this.escopo[i] + " ";
		return t;
	}
}
