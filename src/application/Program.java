package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entitites.ImportedProduct;
import entitites.Product;
import entitites.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Enter the product #" + i + " data: ");
			System.out.println("Common, used or imported?");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price:");
			double price = sc.nextDouble();

			if (ch == 'u') {
				System.out.print("Manufacture date: DD/MM/YYYY");
				Date manufactureDate = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, manufactureDate));

			} else if (ch == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));

			} else {

				list.add(new Product(name, price));
			}

		}
		System.out.println();
		System.out.println("PRICE TAGS");
		for (Product x : list) {
			System.out.println(x.priceTag());
		}

		sc.close();
	}
}
