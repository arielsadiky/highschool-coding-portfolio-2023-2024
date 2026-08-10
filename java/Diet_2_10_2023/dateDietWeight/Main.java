package dateDietWeight;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Diet a = buildIlanit();
		Diet b = buildIAlon();
		Diet c = buildIYuval();
		
		System.out.println(a);
		System.out.println(a.dietLength());
		System.out.println(a.amountLost());
		System.out.println(a.avgWeightLossPerDay());
		System.out.println(a.stedyDiet());
		System.out.println(a.maxLossDate());
		System.out.println();
		
		System.out.println(b);
		System.out.println(b.dietLength());
		System.out.println(b.amountLost());
		System.out.println(b.avgWeightLossPerDay());
		System.out.println(b.stedyDiet());
		System.out.println(b.maxLossDate());
		System.out.println();
		
		System.out.println(c);
		System.out.println(c.dietLength());
		System.out.println(c.amountLost());
		System.out.println(c.avgWeightLossPerDay());
		System.out.println(c.stedyDiet());
		System.out.println(c.maxLossDate());
		System.out.println();
		
		
		Node<Diet> list = new Node<Diet>(a, new Node<Diet>(b, new Node<Diet>(c)));
		losstMostInPrecenteg(list);
	}
	
	public static Diet buildIlanit() {   // O(1)
		Diet d = new Diet("Ilanit", "1000", new Date(1,1,2023), 110);
		Random rnd = new Random();
		for (int i=1; i<13; i++) {
			d.addWeight(new Date(2+rnd.nextInt(27),i,2023), d.getLastWeight().getValue().getWeight()-rnd.nextInt(i));
		}
		return d;
	}
	public static Diet buildIAlon() {   // O(1)
		Diet d = new Diet("Alon", "1001", new Date(1,1,2023), 90);
		Random rnd = new Random();
		for (int i=1; i<12; i++) {
			d.addWeight(new Date(2+rnd.nextInt(27),i,2023), d.getLastWeight().getValue().getWeight()+5-rnd.nextInt(i*2));
		}
		return d;
	}
	public static Diet buildIYuval() {   // O(1)
		Diet d = new Diet("Yuval", "1002", new Date(1,1,2023), 100);
		Random rnd = new Random();
		for (int i=1; i<10; i++) {
			d.addWeight(new Date(2+rnd.nextInt(27),i,2023), 100-rnd.nextInt(i*3));
		}
		return d;
	}
	
	public static void losstMostInPrecenteg(Node<Diet> list) {   // O(n)
		String name = "";
		double max = 0;
		while (list != null) {
			Diet d = list.getValue();
			double weightLosstInPresentid = ((double)d.amountLost()/(double)d.getWeightList().getValue().getWeight());
			if (weightLosstInPresentid > max) {
				max = weightLosstInPresentid;
				name = d.getName();
			}
			list = list.getNext();
		}
		System.out.println(name);
	}

}
