package dateDietWeight;

public class Diet {
	private String name;
	private String id;
	private Node<Weight> first;
	private Node<Weight> last;
	
	public Diet(String name, String id, Date date, int weight){
		this.name = name;
		this.id = id;
		this.first = new Node<Weight>(new Weight(date, weight));
		this.last = this.first;
	}
	
	public String getName(){
		return this.name;
	}
	public String getId(){
		return this.id;
	}
	public Node<Weight> getWeightList(){
		return this.first;
	}
	public Node<Weight> getLastWeight(){
		return this.last;
	}
	
	public void addWeight(Weight weight){
		this.last.setNext(new Node<Weight>(weight));
		this.last = this.last.getNext();
	}
	public void addWeight(Date date, int weight){
		this.last.setNext(new Node<Weight>(new Weight(date, weight)));
		this.last = this.last.getNext();
	}
	
	public int dietLength() {   // O(1)
		Date f = this.first.getValue().getDate();
		Date l = this.last.getValue().getDate();
		return f.numOfDays(l);
	}
	public int amountLost() {   // O(1)
		int f = this.first.getValue().getWeight();
		int l = this.last.getValue().getWeight();
		return f-l;
	}
	public double avgWeightLossPerDay() {   // O(1)
		return ((double)this.amountLost()/(double)this.dietLength());
	}
	public boolean stedyDiet() {   // O(n)
		Node<Weight> p = this.first;
		int count = 0;
		while(p.hasNext()){
			int courent = p.getValue().getWeight();
			int next = p.getNext().getValue().getWeight();
			if (courent < next)  count++;
			if (count > 2)  return false;
			p = p.getNext();
		}
		return true;
	}
	public Date maxLossDate() {   // O(n)
		Node<Weight> p = this.first;
		Date lossDate = null;
		int max = 0;
		while(p.hasNext()){
			int courent = p.getValue().getWeight();
			int next = p.getNext().getValue().getWeight();
			if (courent-next > max) {
				max = courent-next;
				lossDate = p.getNext().getValue().getDate();
			}
			p = p.getNext();
		}
		return lossDate;
	}
	
	public String toString() {
		return "Diet:\nname - " + name + "\nid - " + id + "\nlist of weights:\n" + first;
	}
		
}
