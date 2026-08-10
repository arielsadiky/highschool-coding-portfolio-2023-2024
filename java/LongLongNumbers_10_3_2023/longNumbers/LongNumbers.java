package longNumbers;

import java.util.Random;

public class LongNumbers {
	static Random rnd = new Random();
    private int[] n;
    private String str="";
    
    public LongNumbers(String num) {
        int j=0, count=0;
        while (((num.charAt(j))<'1' || (num.charAt(j))>'9')){
            j++;
        }
        for (int i=j; i<num.length(); i++){
            if (((num.charAt(i))>='0' && (num.charAt(i))<='9')){
                count++;
            }
        } 
        this.n = new int[count];
        for (int i=0; i<n.length && j<num.length(); j++){
            if ((num.charAt(j))>='0' && (num.charAt(j))<='9'){
                this.n[i] = (Integer.valueOf(""+num.charAt(j)));
                this.str+=num.charAt(j);
                i++;
            }
        }
    }
    public LongNumbers(int length) {
        int num;
    	this.n = new int[length];
        for (int i=0; i<length; i++){
        	if (i==0) {
        		num = rnd.nextInt(9)+1;
        		n[i] = num;
        		this.str+=num;
        	}
        	else {
        		num = rnd.nextInt(10);
        		n[i] = num;
        		this.str+=(num);
        	}
        } 
    }
    
    public  int getLength() {
    	return this.n.length;
    }
    public  int[] getArryNum() {
    	return this.n;
    }
    public  int getn(int i) {
    	return this.n[i];
    }
    
    public int comperTo(LongNumbers l) {
    	if(n.length > l.getLength()) {
    		return 1;
    	}
    	else if(n.length < l.getLength()) {
    		return -1;
    	}
    	else {
    		for (int i=0; i<n.length; i++) {
    			if (n[i] > l.getArryNum()[i]) {
        			return 1;
        		}
        		else if (n[i] < l.getArryNum()[i]) {
        			return -1;
        		}
    		}
    	}
        return 0;
    }
    public void addInPlace(int num, int pos) {
    	int count = 0, tmp = num;
    	while (tmp>0) {
    		count++;
    		tmp/=10;
    	}
    	int[] temp = new int[n.length+count];
    	if(pos>temp.length) {
    		for (int i=0; i<n.length; i++) {
        		temp[i] = n[i];
        	}
    		this.str+=num;
    		for (int i=(temp.length-1); i>(n.length); i--) {
    			temp[i] = (num%10);
    			num/=10;
    		}
    	}
    	else {
    		this.str="";
    		for (int i=0, j=0; i<temp.length; i++) {
        		if (i == pos) {
        			this.str+=num;
        			for (int h=(i+count-1); h>=i; h--) {
            			temp[h] = (num%10);
            			num/=10;
            		}
        			i+=(count-1);
        		}
        		else {
        			temp[i] = n[j];
        			this.str+=temp[i];
        			j++;
        		}
        	}
        	this.n = temp;
        	
    	}
    }
    public void printHistogram() {
    	int[] count = frequency();
    	int max = findMax(count);
    	System.out.println();
    	printOneToTen();
    	printNiceLine();
    	for (int i=max; i>0; i--) {
    		for (int j=0; j<count.length; j++) {
    			if (count[j] >= i) {
    				System.out.print(" *");
    			}
    			else{
    				System.out.print("  ");
    			}
    		}
    		System.out.println();
    	}
    	printNiceLine();
    	printOneToTen();
    }
    public void add(LongNumbers l) {
    	int[] temp;
    	this.str = "";
    	if (n.length > (l.getLength())) {
    		temp = new int[n.length+1];
    	}
    	else {
    		temp = new int[l.getLength()+1];
    	}
    	temp = addInToNew(l, temp);
    	if (temp[0] == 0) {
    		int[] last = new int[temp.length-1];
    		for (int i=0, j=1; i<last.length; i++, j++) {
    			last[i] = temp[j];
    			this.str += last[i];
    		}
    		this.n = last;
    	}
    	else {
    		for (int i=0; i<temp.length; i++) {
    			this.str += temp[i];
    		}
    		this.n = temp;
    	}
    	
    }
    
    public int[] frequency() {
    	int[] digits = new int[10];
    	for (int i=0; i<digits.length; i++) {
    		digits[i] = 0;
    	}
    	for (int i: this.n) {
    		digits[i]++;
    	}
    	return digits;
    }
    public int findMax(int[] arr) {
    	int max = 0;
    	for (int i=0; i<arr.length; i++) {
    		if (arr[i] > max) {
    			max = arr[i];
    		}
    	}
    	return max;
    }
    public void printOneToTen() {
    	for (int i=0; i<10; i++) {
        	System.out.print(" "+i);
    	}
    	System.out.println();
    }
    public void printNiceLine() {
    	for (int i=0; i<10; i++) {
        	System.out.print("==");
    	}
    	System.out.println();
    }
    public int[] addInToNew(LongNumbers l, int[] arr) {
    	int tmp = 0;
    	for (int i=(n.length-1), j=(l.getLength()-1), h=(arr.length-1); h>=0; j--, i--, h--) {
    		if (i<0 && j>=0) {
    			if ((l.getArryNum()[j]+tmp)>9) {
    				arr[h] = ((l.getArryNum()[j]+tmp)%10);
	    			tmp=1;
	    		}
	    		else {
	    			arr[h] = (l.getArryNum()[j])+tmp;
	    			tmp=0;
	    		}
    		}
    		else if (j<0 && i>=0) {
    			if ((n[i]+tmp)>9) {
    				arr[h] = ((n[i]+tmp)%10);
	    			tmp=1;
	    		}
	    		else {
	    			arr[h] = (n[i])+tmp;
	    			tmp=0;
	    		}
    		}
    		else if (j<0 && i<0) {
    			arr[h] = tmp;
    		}
    		else {
	    		if ((n[i]+l.getArryNum()[j]+tmp)>9) {
	    			arr[h] = ((n[i]+l.getArryNum()[j]+tmp)%10);
	    			tmp=1;
	    		}
	    		else {
	    			arr[h] = (n[i]+l.getArryNum()[j])+tmp;
	    			tmp=0;
	    		}
    		}
    	}
    	return arr;
    }

    public String toString(){
        return this.str;
    }
}
