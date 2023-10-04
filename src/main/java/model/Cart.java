package model;

public class Cart {
    private int idCart;
    private Order order;
    private Product product;
    private int quantity;
    private boolean status;

    public Cart() {
    }

    public Cart(int idCart, Order order, Product product, int quantity, boolean status) {
        this.idCart = idCart;
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "idCart=" + idCart +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", status=" + status +
                '}';
    }
}
