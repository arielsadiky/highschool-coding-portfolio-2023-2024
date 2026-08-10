package QueueNodeOOP_1_3_2024_fixed;

import QueueAndNode_9_2_2024.Node;

public class ShoppingList {
	private Node<Product> products;
	
	public ShoppingList() {
		this.products = null;
		for (int i=0; i<7; i++) {
			this.products = new Node<Product>(new Product(), this.products);
		}
	}
	
	public Node<Product> getProducts() {
		return products;
	}
	public void setProducts(Node<Product> products) {
		this.products = products;
	}

	public void budgetCut(double budget){
        if (products == null) return;
        Node<Product> p = this.products;
        double sum = 0;
        while (p != null){
            sum += (p.getValue().getPrice() * p.getValue().getAmount());
            p = p.getNext();
        }
        System.out.println(sum);
        while (sum > budget){
            p = this.products;
            while (p != null){
                p.getValue().setAmount(p.getValue().getAmount() - 1);
                p = p.getNext();
            }
            p = this.products;
            while (p != null  &&  p.getValue().getAmount() < 1)  p = p.getNext();
            this.products = p;
            while (p != null  &&  p.hasNext()){
                if (p.getNext().getValue().getAmount() < 1){
                    p.setNext(p.getNext().getNext());
                }
                else  p = p.getNext();
            }
            p = this.products;
            sum = 0;
            while (p != null){
                sum += (p.getValue().getPrice() * p.getValue().getAmount());
                p = p.getNext();
            }
            System.out.println(sum);
    	}
	}
	
	public String toString() {
		return "ShoppingList [" + products + "]";
	}
}
