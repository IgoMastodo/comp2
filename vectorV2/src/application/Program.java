package application;

import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double soma=0;
		System.out.printf("Diga a quantidade de produtos : ");
		int n = sc.nextInt();
		Product[] vect = new Product[n];
		
		for (int i = 0; i < vect.length; i++) {
			System.out.printf("Diga o nome do produto %d :", (i+1));
			sc.nextLine();
			String name=sc.nextLine();
			System.out.printf("Diga o preço do produto %d :", (i+1));
			double price=sc.nextDouble();
			vect[i]=new Product(name , price);
		   soma += vect[i].getPrice();
		}
		System.out.printf("Valor medio : %.2f", (soma/n));
		
		sc.close();
		
	}

}
