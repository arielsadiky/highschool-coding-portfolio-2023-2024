package longNumbers;

public class Main {

	public static void main(String[] args) {
		LongNumbers a = new LongNumbers("00099AD99893@");
		System.out.println(a);
		
		LongNumbers b = new LongNumbers(14);
		System.out.println(b);
		
		LongNumbers c = new LongNumbers("9999111");
		System.out.println(a.comperTo(c));
		
		System.out.println(b);
		b.addInPlace(12311, 0);
		System.out.println(b);
		
		System.out.println(a);
		System.out.println(c);
		c.add(a);
		System.out.println(c);
		
		
		b.printHistogram();
		
        
	}
	
	/*public static void print(LongNumbers a){
        for (int i=0; i<a.getArryNum().length; i++){
        	System.out.print(a.getn(i)+" ");
        } 
        System.out.println();
	}*/

}
