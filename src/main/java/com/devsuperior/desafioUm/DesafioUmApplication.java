package com.devsuperior.desafioUm;

import com.devsuperior.desafioUm.entities.Order;
import com.devsuperior.desafioUm.services.OrderService;
import com.devsuperior.desafioUm.services.ShippingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DesafioUmApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DesafioUmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		int flag = 0;
		do{

			System.out.println("Servidor no ar!");
			Order order = new Order();

			ShippingService shippingService = new ShippingService();

			OrderService orderService = new OrderService(shippingService);

			Locale.setDefault(Locale.US);
			Scanner scanner = new Scanner(System.in);

			System.out.println("Digite o código");
			order.setCode(scanner.nextInt());

			System.out.println("Digite o valor básico");
			order.setBasic(scanner.nextDouble());

			System.out.println("Digite o desconto");
			order.setDiscount(scanner.nextDouble());

			System.out.println("Código: " + order.getCode() +
					"\nValor Básico: " + order.getBasic() +
					"\nDesconto: " + order.getDiscount());

			System.out.println(orderService.total(order));

			System.out.println("Deseja continuar a execução ?" + "\nAperte NÚMERO tecla para SIM"
			+ "\nAperte 1 para NÃO");
			flag = scanner.nextInt();
			scanner.close();



		} while (flag != 1);



	}
}
