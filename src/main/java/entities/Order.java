package entities;

import entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;

    private Client client;
    private List<OrderItem> itens = new ArrayList<OrderItem>();

    public Order(){}

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //sem Getter e Setter de uma lista porque a manipulação da mesma se da pelos métodos addItem() e removeItem()
    //isso é uma forma de de encapsulamento e proteção da manipulação da lista de itens associada a um pedido

    public void addItem(OrderItem item){
        itens.add(item);
    }

    public void removeItem(OrderItem item){
        itens.remove(item);
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem it : itens){
            sum+=it.subTotal();
        }
        return sum;
    }

    @Override
    public String toString(){
        StringBuilder stb = new StringBuilder();
        stb.append("Order moment: ");
        stb.append(sdf.format(moment)+"\n");
        stb.append("Order Status: ");
        stb.append(status+"\n");
        stb.append("Client: ");
        stb.append(client+"\n");
        stb.append("Order itens: ");

        for(OrderItem it : itens){
            stb.append(it+"\n");
        }
        stb.append("Total price: $");
        stb.append(String.format("%.2f", total()));

        return stb.toString();
    }
}
