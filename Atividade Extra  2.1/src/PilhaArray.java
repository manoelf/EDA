import java.util.Scanner;

class PilhaArray {
	
	private int[] pilha;
	private int index;
	private int size;
	
	
	//FILO
	public PilhaArray(int size) {
		this.pilha = new int[size];
		this.index = -1;
		this.size = size;
	}
	
	public boolean isEmpty() {
		return index == -1;
	}
	
	public boolean isFull() {
		return (index + 1) == size;
	}
	 
	public boolean push(int value) {
		if (!isFull()) {
			index++;
			this.pilha[index] = value;
			return true;
		} else {
			return false;
		}
	}
	
	public String peek() {
		String result;
		if (!isEmpty()) {
			result = "" + pilha[index]; 
		} else {
			result = "empty";
		}
		return result;
	}
	
	public boolean pop() {
		if (!isEmpty()) {
			index--;
			return true;
		} else {
			return false;
		}
	}
	
	public String print() {
		String result = "";
		
		if (isEmpty()) {
			result = "empty";
		} else {
			for (int i = 0; i <= index; i++) {
				result += pilha[i] + " ";
			}
			result = result.substring(0, result.length() -1);
		}
			return result;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] values = sc.nextLine().split(" ");
		String opition;
		int num;
		int size = Integer.parseInt(values[0]);
		
		PilhaArray pilha = new PilhaArray(size);
		
		 while (!values[0].equals("end") && size > 0 ) {
			 
			values = sc.nextLine().split(" ");
			opition = values[0];
			
			if (opition.equals("pop")) {
				if (!pilha.pop()) 
					System.out.println("empty");
				
				
			} else if (opition.equals("push")) {
				num = Integer.parseInt(values[1]); 
				
				if (!pilha.push(num)) 
					System.out.println("full");
				
				
			} else if (opition.equals("peek")) {
				System.out.println(pilha.peek());
				
			} else if (opition.equals("print")) {
				System.out.println(pilha.print());
			}
		
		}
		sc.close();
	}
	
	
	
}
