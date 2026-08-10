package Cube2;

public class CubeTower {
	
	public Cube[] tower;
	public int amountOfCubes;
	public int maxCubes;
	
	public CubeTower(int maxCubes) {
		this.maxCubes = maxCubes;
		this.tower = new Cube[maxCubes];
		this.amountOfCubes = 0;
	}
	public CubeTower(CubeTower c) {
		this.maxCubes =c.getMaxCubes();
		this.tower = new Cube[maxCubes];
		this.amountOfCubes = c.getAmountOfCubes();
		for (int i=0; i<amountOfCubes; i++) {
			tower[i] = new Cube(getTower()[i]);
		}
	}
	
	public Cube[] getTower() {
		return this.tower;
	}
	public void setTower(Cube[] tower) {
		this.tower = tower;
	}
	public int getAmountOfCubes() {
		return this.amountOfCubes;
	}
	public void setAmountOfCubes(int amountOfCubes) {
		this.amountOfCubes = amountOfCubes;
	}
	public int getMaxCubes() {
		return this.maxCubes;
	}
	public void setMaxCubes(int maxCubes) {
		this.maxCubes = maxCubes;
	}
	
	
	public void add(Cube c) {     // n הפעולה מוסיפה משתנה מסוג קוביה ב"ראש המגדל" התא הפנוי הבא - סיבוכיות
		if (amountOfCubes < maxCubes) {
			tower[amountOfCubes] = c;
			amountOfCubes++;
		}
	}
	public Cube takeOff() {     // הפעולה מחזירה את הקוביה בתא האחרון בו יש קוביה ומאפסת את התא - סיבוכיות 0
		if (amountOfCubes > 0) {
			amountOfCubes--;
			Cube c = tower[amountOfCubes];
			tower[amountOfCubes] = null;
			return c;
		}
		return null;
	}
	public boolean isColorInTower(String color) {     // n הפעולה בודקת האם קיימם במגדל קוביה בצבע הנתון - סיבוכיות 
		for (int i=0; i<this.amountOfCubes; i++) {
			if (tower[i].getColor().equals(color)) {
				return true;
			}
		}
		return false;
	}
	public boolean isTowerEmpty() {     // הפעולה בודקת האם המגדל ריק בכך שמוודא שאין קוביות במגדל - סיבוכיות 0
		if (amountOfCubes == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isTowerFull() {     // הפעולה בודקת האם המגדל מלא בכך בודקת האם יש קמות מקסימלית של קוביות במגדל - סיבוכיות 0
		if (amountOfCubes == maxCubes) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean equles(CubeTower c) {     // n הפעולה בודקת האם מימדי וצבעי הקוביות בשני מגדלים שויים (לא היים מדובר באותן הקוביות בדיוק) - סיבוכיות
		if (amountOfCubes == c.getAmountOfCubes()) {
			for (int i=0; i<amountOfCubes; i++) {
				if (!tower[i].equals(c.getTower()[i])) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public CubeTower buildOneOfEachColorTower() {     // n הפעולה בודקת האם מימדי וצבעי הקוביות בשני מגדלים שויים (לא היים מדובר באותן הקוביות בדיוק) - סיבוכיות
		CubeTower c = new CubeTower(this.amountOfCubes);
		int x = amountOfCubes;
		Cube temp;
		boolean is = false;
		for (int i=0; i<x; i++) {
			temp = takeOff();
			for (int j=0; j<c.getAmountOfCubes(); j++) {
				if ((temp.getColor()).equals(c.getTower()[j].getColor())) {
					is = true;
				}
			}
			if (!is) {
				c.add(temp);
			}
			is = false;
		}
		return c;
	}
	public void towerSort() {
		Cube temp;
		for (int i=0; i<this.amountOfCubes; i++) {
			int minIndex = i;
			for (int j=i+1; j<this.amountOfCubes; j++) {
				if (tower[j].getSideLength() < tower[minIndex].getSideLength()) {
					minIndex = j;
				}
			}
			temp = tower[i];
			tower[i] = tower[minIndex];
			tower[minIndex] = temp;
		}
	}
	
	public String toString() {
		for (int i=0; i<amountOfCubes; i++) {
			System.out.println(tower[i]);
		}
		return "";
	}
}
