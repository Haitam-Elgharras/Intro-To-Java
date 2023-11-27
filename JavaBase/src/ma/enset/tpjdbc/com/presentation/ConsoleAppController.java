package ma.enset.tpjdbc.com.presentation;

import ma.enset.tpjdbc.com.dao.ClientDaoImpl;
import ma.enset.tpjdbc.com.dao.ProductDaoImpl;
import ma.enset.tpjdbc.com.dao.entities.Client;
import ma.enset.tpjdbc.com.dao.entities.Product;
import ma.enset.tpjdbc.com.service.ClientService;
import ma.enset.tpjdbc.com.service.IClientService;
import ma.enset.tpjdbc.com.service.IProductService;
import ma.enset.tpjdbc.com.service.ProductService;

public class ConsoleAppController {
    public static void main(String[] args) {
        IProductService service = new ProductService(new ProductDaoImpl());

        // add a list of Products

        for (int i = 0; i < 10; i++) {
            Product product = new Product("Product " + i, (i+1)*10, 1000.0 + i);
            service.addProduct(product);
        }

        System.out.println("All products: \n");
        service.getAllProducts().forEach(System.out::println);


        IClientService clientService = new ClientService(new ClientDaoImpl());

//        // add a list of Clients
        for (int i = 0; i < 10; i++) {
            clientService.addClient(new Client("Client " + i, "Client " + i+"@gmail.com" , "Client " + i+" Phone", "Client " + i+" Address"));
        }

        System.out.println("All clients: \n");
        clientService.getAllClients().forEach(System.out::println);
    }
}
