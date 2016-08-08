import java.util.Scanner;

class FilaArray {
	
	private int[] fila;
	private int tamanho;
	private int inicio;
	private int fim;
	
	
	public FilaArray(int tamanho) {
		this.fila = new int[tamanho];
		this.tamanho = tamanho;
		this.inicio = -1;
		this.fim = -1;
	}
	
	public boolean isEmpty() {
		if (this.inicio == -1 && this.fim == -1) {
			return true; 
		} else {
			return false;
		}
	}
	
	public boolean isFull() {
		if ((fim + 1) % tamanho == inicio) {
			return true;
		} else {
			return false;
		}
	}
	
	public void add(int elemento) {
		if (isFull()) {
			throw new RuntimeException("Fila lotada");
		}
		
		if (isEmpty()) {
			this.inicio = 0; 
			this.fim = 0;
			this.fila[fim] = elemento;
		} else {
			this.fim = (fim + 1) % tamanho;
			this.fila[fim] = elemento;
		}
	}
	
	public void remove() {
		if (isEmpty()) {
			throw new RuntimeException("Fila esta vazia");
		} else if (inicio ==  fim) {
			this.inicio = -1;
			this.fim = -1;
		}else {
			this.inicio = (inicio + 1) % tamanho;
		}
	}
	
	public int elemento() {
		if (isEmpty()) {
			throw new RuntimeException("Fila estavazia");
		} else {
			return this.fila[inicio];
		}
	}
	
	public String print() {
		int indice = inicio;
		String saida = fila[inicio] + " ";
		
		while (indice != fim) {
			indice = (indice + 1) % tamanho;
			saida +=  fila[indice] + " ";
		}
		return saida.trim();
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] values = sc.nextLine().split(" ");
		String option;
		int num;
		int size = Integer.parseInt(values[0]);
		
		FilaArray fila = new FilaArray(size);
		
		 while (!values[0].equals("end") && size > 0) {
			 
			values = sc.nextLine().split(" ");
			option = values[0];
			
			
			if (option.equals("add")) {
				num = Integer.parseInt(values[1]);
				if (fila.isFull())
					System.out.println("full");
				else
					fila.add(num);
				
			} else if (option.equals("remove")) {
				if (fila.isEmpty())
					System.out.println("empty");
				else
					fila.remove();
				
			} else if (option.equals("element")) {
				if (fila.isEmpty())
					System.out.println("empty");
				else
					System.out.println(fila.elemento());
				
			} else if (option.equals("print")) {
				if (fila.isEmpty()) 
					System.out.println("empty");
				else
					System.out.println(fila.print());
				
			}
		}
		sc.close();
	}
	
}
