package train;

public class Train {
	private Locomotive locomotive;
	private Stack<Carriage> carriages;
	private int carriagesNum;
	
	public Train(Locomotive locomotive) {
		this.locomotive = locomotive;
		this.carriages = new Stack<Carriage>();
		this.carriagesNum = 0;
	}
	public Train(Locomotive locomotive, Stack<Carriage> carriages) {
		this.locomotive = locomotive;
		this.carriages = carriages;
		this.carriagesNum = 0;
		Stack<Carriage> temp = new Stack<Carriage>();
		while (!this.carriages.isEmpty()) {
			temp.push(this.carriages.pop());
			this.carriagesNum++;
		}
		while (!temp.isEmpty()) {
			this.carriages.push(temp.pop());
		}
	}
	
	public Locomotive getLocomotive() {
		return this.locomotive;
	}
	public void setLocomotive(Locomotive locomotive) {
		this.locomotive = locomotive;
	}
	public Stack<Carriage> getCarriages() {
		return this.carriages;
	}
	public void setCarriages(Stack<Carriage> carriages) {
		this.carriages = carriages;
	}
	public int getCarriagesNum() {
		return this.carriagesNum;
	}
	public void setCarriagesNum(int carriagesNum) {
		this.carriagesNum = carriagesNum;
	}
	
	public void addCarriage(Carriage carriage) {
		this.carriages.push(carriage);
		this.carriagesNum++;
	}
	public Carriage takeOutCarriage(int serialNum) {
		Carriage carriage = null;
		Stack<Carriage> temp = new Stack<Carriage>();
		while (!this.carriages.isEmpty()  &&  carriage == null) {
			if (this.carriages.top().getSerialNum() == serialNum) carriage = this.carriages.pop();
			else temp.push(this.carriages.pop());
		}
		while (!temp.isEmpty()) {
			this.carriages.push(temp.pop());
		}
		if (carriage != null) this.carriagesNum--;
		return carriage;
	}
	public Train reduceCarriages(Locomotive locomotive) {
		if (this.carriages.isEmpty()) return new Train(locomotive);
		Train emptyCarriages = new Train(locomotive);
		Stack<Carriage> temp = new Stack<Carriage>();
		while (!this.carriages.isEmpty()) temp.push(this.carriages.pop());
		this.carriages.push(temp.pop());
		while (!temp.isEmpty()) {
			Carriage topCarriage = this.carriages.top();
			Carriage topTemp = temp.top();
			if (topCarriage.getPassengersNum() < topCarriage.getMax()  &&  topTemp.getPassengersNum() > 0) {
				if (topCarriage.getPassengersNum()+topTemp.getPassengersNum() <= topCarriage.getMax()) {
					topCarriage.setPassengersNum(topCarriage.getPassengersNum()+topTemp.getPassengersNum());
					topTemp.setPassengersNum(0);
					emptyCarriages.addCarriage(temp.pop());
				}
				else {
					topTemp.setPassengersNum(topCarriage.getPassengersNum()+topTemp.getPassengersNum()-topCarriage.getMax());
					topCarriage.setPassengersNum(topCarriage.getMax());
					this.carriages.push(temp.pop());
				}
			}
			else if (topTemp.getPassengersNum() == 0) emptyCarriages.addCarriage(temp.pop());
			else this.carriages.push(temp.pop());
		}
		return emptyCarriages;
	}
	
	
 	public String toString() {
 		Stack<Carriage> temp1 = new Stack<Carriage>();
 		Stack<Carriage> temp2 = new Stack<Carriage>();
 		while (!this.carriages.isEmpty()) {
 			temp1.push(this.carriages.top());
 			temp2.push(this.carriages.pop());
 		}
 		while (!temp2.isEmpty()) {
 			this.carriages.push(temp2.pop());
 		}
		return locomotive + ",  " + temp1 + ",  " + carriagesNum;
	}
	
}
