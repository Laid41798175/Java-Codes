package mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String str;
	static String[] spl;
	
	static int n;

	static int[] arr;
	static int[] operator;
	final static char[] ops = new char[] { '+', '-', '*', '/', '(', ')' };
	
	public static void main(String[] args) throws IOException {
		str = br.readLine();
		spl = str.split(" ");
		
		n = spl.length;
		postfix(spl);
	}
	
	public static void postfix(String[] perm) {
		Stack<Character> s = new Stack<>();
		String postfix = "";
		for (int i = 0; i < perm.length; i++) {
			if (perm[i].compareTo("+") == 0) {
				while (!s.empty() && (s.peek() != '(')) {
					postfix += s.pop();
				}
				s.push('+');
			} else if (perm[i].compareTo("-") == 0) {
				while (!s.empty() && (s.peek() != '(')) {
					postfix += s.pop();
				}
				s.push('-');
			} else if (perm[i].compareTo("*") == 0) {
				while (!s.empty() && (s.peek() == '*' || s.peek() == '/') ) {
					postfix += s.pop();
				}
				s.push('*');
			} else if (perm[i].compareTo("/") == 0) {
				while (!s.empty() && (s.peek() == '*' || s.peek() == '/') ) {
					postfix += s.pop();
				}
				s.push('/');
			} else if (perm[i].compareTo("(") == 0) {
				s.push('(');
			} else if (perm[i].compareTo(")") == 0) {
				while (!s.empty() && s.peek() != '(') {
					postfix += s.pop() + " ";
				}
				s.pop(); // remove '('
			} else { // perm[i] = integer
				postfix += perm[i] + " ";
			}
		}
		
		while (!s.empty()) {
			postfix += s.pop() + " ";
		}
		
		System.out.print(postfix);
		calc(postfix);
	}

	public static void calc(String postfix) {
		Stack<Integer> s = new Stack<>();
		spl = postfix.split(" ");
		for (int i = 0; i < spl.length; i++) {
			if (spl[i].compareTo("+") == 0) {
				int a = s.pop();
				int b = s.pop();
				s.push(a + b);
			} else if (spl[i].compareTo("-") == 0) {
				int a = s.pop();
				int b = s.pop();
				s.push(a - b);
			} else if (spl[i].compareTo("*") == 0) {
				int a = s.pop();
				int b = s.pop();
				s.push(a * b);
			} else if (spl[i].compareTo("/") == 0) {
				int a = s.pop();
				int b = s.pop();
				s.push(a < 0 ? -(-a / b) : a / b);
			} else { // integer
				s.push(Integer.parseInt(spl[i]));
			}
		}
		
		int val = s.pop();
		System.out.println(" = " + val);		
	}
}
