import java.util.Scanner;

class Fila {

	Node head;
	int size;

	public Fila() {
		this.size = 0;
	}

	public void add(int element) {
		if (isEmpty()) {
			Node newNode = new Node(element);
			this.head = newNode;
		} else {
			this.head.add(element);
		}
		this.size++;
	}

	public void remove() {
		if (isEmpty()) {
			throw new RuntimeException("EmptyQueueException");
		} else {

			if (head.next == null) {
				this.head = null;
			} else {
				this.head.previous = null;
				this.head = head.next;
			}
			this.size--;
		}
	}

	public int search(int element) {
		if (isEmpty()) {
			return -1;
		} else {
			return head.search(element);
		}
	}

	public String print() {
		if (isEmpty()) {
			return "empty";
		} else {
			return head.print();
		}
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public int element() {
		if (isEmpty()) {
			throw new RuntimeException("EmptyQueueException");
		} else {
			return head.element();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] values = sc.nextLine().split(" ");
		String option = values[0];
		;
		int num;

		Fila fila = new Fila();

		while (!option.equals("end")) {

			if (option.equals("add")) {
				num = Integer.parseInt(values[1]);
				fila.add(num);

			} else if (option.equals("remove")) {
				if (fila.isEmpty()) {
					System.out.println("empty");
				} else {
					fila.remove();
				}
			} else if (option.equals("print")) {
				System.out.println(fila.print());

			} else if (option.equals("search")) {
				num = Integer.parseInt(values[1]);
				System.out.println(fila.search(num));

			} else if (option.equals("element")) {
				if (fila.isEmpty()) {
					System.out.println("empty");
				} else {
					System.out.println(fila.element());
				}
			}

			values = sc.nextLine().split(" ");
			option = values[0];

		}
		sc.close();
	}

}

class Node {

	Node previous;
	Node next;
	int element;

	public Node(int element) {
		this.element = element;
	}

	public int element() {
		return this.element;
	}

	public void add(int element) {
		if (next == null) {
			Node newNode = new Node(element);
			newNode.previous = this;
			next = newNode;
		} else {
			next.add(element);
		}
	}

	public int search(int element) {
		if (this.element == element) {
			return 0;
		} else if (next != null) {
			int saida = next.search(element);
			if (saida == -1) {
				return -1;
			} else {
				return 1 + saida;
			}
		} else {
			return -1;
		}
	}

	public String print() {
		if (next == null) {
			return "" + element;
		} else {
			return element + " " + this.next.print();
		}
	}

}
