package longNumbersList;

public class Main {

	public static void main(String[] args) {
		LongNumbers n1 = new LongNumbers("1234", "3456");
		System.out.println(n1);
		System.out.println(n1.getBigerNum());
		System.out.println(n1.sumOfNums());
		System.out.println();
		
		LongNumbers n2 = new LongNumbers("76967", "23489");
		LongNumbers n3 = new LongNumbers("147", "935");
		LongNumbers n4 = new LongNumbers("1198", "4991");
		
		Node<Integer> n5 = n1.getNum1();
		Node<Integer> n6 = n1.getNum2();
		Node<Integer> n7 = n2.getNum1();
		Node<Integer> n8 = n2.getNum2();
		Node<Integer> n9 = n3.getNum1();
		Node<Integer> n10 = n3.getNum2();
		Node<Integer> n11 = n4.getNum1();
		Node<Integer> n12 = n4.getNum2();
		
		Node<Node<Integer>> list1 = new Node<Node<Integer>>(n5);
		list1 = insertIntoSortedList(list1, n6);
		list1 = insertIntoSortedList(list1, n7);
		list1 = insertIntoSortedList(list1, n8);
		list1 = insertIntoSortedList(list1, n9);
		list1 = insertIntoSortedList(list1, n10);
		list1 = insertIntoSortedList(list1, n11);
		list1 = insertIntoSortedList(list1, n12);
		printListOfNum(list1);
		System.out.println();
		
		Node<Node<Integer>> list2 = new Node<Node<Integer>>(n5);
		list2 = new Node<Node<Integer>>(n6, list2);
		list2 = new Node<Node<Integer>>(n7, list2);
		list2 = new Node<Node<Integer>>(n8, list2);
		list2 = new Node<Node<Integer>>(n9, list2);
		list2 = new Node<Node<Integer>>(n10, list2);
		list2 = new Node<Node<Integer>>(n11, list2);
		list2 = new Node<Node<Integer>>(n12, list2);
		printListOfNum(list2);
		list2 = insertionSort(list2);
		printListOfNum(list2);
		System.out.println();
		
		Node<Node<Integer>> list3 = new Node<Node<Integer>>(n5);
		list3 = new Node<Node<Integer>>(n6, list3);
		list3 = new Node<Node<Integer>>(n7, list3);
		list3 = new Node<Node<Integer>>(n11, list3);
		list3 = new Node<Node<Integer>>(n12, list3);
		list3 = new Node<Node<Integer>>(n8, list3);
		list3 = new Node<Node<Integer>>(n9, list3);
		list3 = new Node<Node<Integer>>(n10, list3);
		printListOfNum(list3);
		list3 = insertionSortInPlace(list3);
		printListOfNum(list3);
		System.out.println();
		
		Node<Node<Integer>> list4 = new Node<Node<Integer>>(n5);
		list4 = new Node<Node<Integer>>(n6, list4);
		list4 = new Node<Node<Integer>>(n7, list4);
		list4 = new Node<Node<Integer>>(n9, list4);
		list4 = new Node<Node<Integer>>(n7, list4);
		list4 = new Node<Node<Integer>>(n9, list4);
		list4 = new Node<Node<Integer>>(n10, list4);
		list4 = insertionSortInPlace(list4);
		printListOfNum(list4);
		Node<Node<Integer>> list5 = sortedUnionNewDuply(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = sortedUnionNew(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = sortedUnionToList(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = listsIntersection(list5, list3);
		printListOfNum(list5);
		System.out.println();
		
		System.out.println("==================================================");
		
		LongNumbersRec m1 = new LongNumbersRec("1234", "3456");
		System.out.println(m1);
		System.out.println(m1.getBigerNum());
		System.out.println(m1.sumOfNums());
		System.out.println();
		
		LongNumbersRec m2 = new LongNumbersRec("76967", "23489");
		LongNumbersRec m3 = new LongNumbersRec("147", "935");
		LongNumbersRec m4 = new LongNumbersRec("1198", "4991");
		
		n5 = m1.getNum1();
		n6 = m1.getNum2();
		n7 = m2.getNum1();
		n8 = m2.getNum2();
		n9 = m3.getNum1();
		n10 = m3.getNum2();
		n11 = m4.getNum1();
		n12 = m4.getNum2();
		
		list1 = new Node<Node<Integer>>(n5);
		list1 = insertIntoSortedListRec(list1, n6);
		list1 = insertIntoSortedListRec(list1, n7);
		list1 = insertIntoSortedListRec(list1, n8);
		list1 = insertIntoSortedListRec(list1, n9);
		list1 = insertIntoSortedListRec(list1, n10);
		list1 = insertIntoSortedListRec(list1, n11);
		list1 = insertIntoSortedListRec(list1, n12);
		printListOfNumRec(list1);
		System.out.println();
		
		list2 = new Node<Node<Integer>>(n5);
		list2 = new Node<Node<Integer>>(n6, list2);
		list2 = new Node<Node<Integer>>(n7, list2);
		list2 = new Node<Node<Integer>>(n8, list2);
		list2 = new Node<Node<Integer>>(n9, list2);
		list2 = new Node<Node<Integer>>(n10, list2);
		list2 = new Node<Node<Integer>>(n11, list2);
		list2 = new Node<Node<Integer>>(n12, list2);
		printListOfNumRec(list2);
		list2 = insertionSortRec(list2);
		printListOfNumRec(list2);
		System.out.println();
		
		list3 = new Node<Node<Integer>>(n5);
		list3 = new Node<Node<Integer>>(n6, list3);
		list3 = new Node<Node<Integer>>(n7, list3);
		list3 = new Node<Node<Integer>>(n11, list3);
		list3 = new Node<Node<Integer>>(n12, list3);
		list3 = new Node<Node<Integer>>(n8, list3);
		list3 = new Node<Node<Integer>>(n9, list3);
		list3 = new Node<Node<Integer>>(n10, list3);
		printListOfNumRec(list3);
		list3 = insertionSortInPlaceRec(list3);
		printListOfNumRec(list3);
		System.out.println();
		/*
		list4 = new Node<Node<Integer>>(n5);
		list4 = new Node<Node<Integer>>(n6, list4);
		list4 = new Node<Node<Integer>>(n7, list4);
		list4 = new Node<Node<Integer>>(n9, list4);
		list4 = new Node<Node<Integer>>(n7, list4);
		list4 = new Node<Node<Integer>>(n9, list4);
		list4 = new Node<Node<Integer>>(n10, list4);
		list4 = insertionSortInPlace(list4);
		printListOfNum(list4);
		list5 = sortedUnionNewDuply(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = sortedUnionNew(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = sortedUnionToList(list3, list4);
		printListOfNum(list5);
		System.out.println();
		
		list5 = listsIntersection(list5, list3);
		printListOfNum(list5);
		System.out.println();
		*/
	}
	
	public static void printListOfNum(Node<Node<Integer>> list) {
		while (list != null) {
			System.out.print(list.getValue() + ",  ");
			list = list.getNext();
		}
		System.out.println();
	}
	public static boolean is1SmallerThen2(Node<Integer> num1, Node<Integer> num2) {
		Node<Integer> p1 = num1;
		Node<Integer> p2 = num2;
		while (p1 != null  &&  p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		if (p1 == null  &&  p2 == null) {
			p1 = num1;
			p2 = num2;
			while (p1 != null  &&  p2 != null) {
				if (p1.getValue()>p2.getValue()) return false;
				if (p1.getValue()<p2.getValue()) return true;
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
		}
		if (p1 == null) return true;
		return false;
	}
	public static boolean equels(Node<Integer> num1, Node<Integer> num2) {
		Node<Integer> p1 = num1;
		Node<Integer> p2 = num2;
		while (p1 != null  &&  p2 != null) {
			p1 = p1.getNext();
			p2 = p2.getNext();
		}
		if (p1 == null  &&  p2 == null) {
			p1 = num1;
			p2 = num2;
			while (p1 != null  &&  p2 != null) {
				if (p1.getValue() != p2.getValue()) return false;
				p1 = p1.getNext();
				p2 = p2.getNext();
			}
		}
		else return false;
		return true;
	}
	
	public static Node<Node<Integer>> insertIntoSortedList(Node<Node<Integer>> list, Node<Integer> num){
		if (is1SmallerThen2(num, list.getValue())) return new Node<Node<Integer>>(num, list);
		Node<Node<Integer>> p = list;
		while (p.hasNext()) {
			if (is1SmallerThen2(num, p.getNext().getValue())) {
				p.setNext(new Node<Node<Integer>>(num, p.getNext()));
				return list;
			}
			
			p = p.getNext();
		}
		p.setNext(new Node<Node<Integer>>(num));
		return list;
		
	}
	public static Node<Node<Integer>> insertionSort(Node<Node<Integer>> list) {
		Node<Node<Integer>> sorted = new Node<Node<Integer>>(list.getValue());
		list = list.getNext();
		while (list != null) {
			sorted = insertIntoSortedList(sorted, list.getValue());
			list = list.getNext();
		}
		return sorted;
	}
	public static Node<Node<Integer>> insertionSortInPlace(Node<Node<Integer>> list) {
		Node<Node<Integer>> p = list;
		Node<Node<Integer>> r = list;
		Node<Node<Integer>> q = list.getNext();
		boolean foundPlace = false;
		while (q != null) {
			if (is1SmallerThen2(q.getValue(), p.getValue())) {
				r.setNext(q.getNext());
				q.setNext(p);
				list = q;
			}
			else {
				while (!foundPlace  &&  p.getNext() != q) {
					if (is1SmallerThen2(q.getValue(), p.getNext().getValue())) {
						r.setNext(q.getNext());
						q.setNext(p.getNext());
						p.setNext(q);
						foundPlace = true;
					}
					p = p.getNext();
				}
				if (!foundPlace) r = r.getNext();
			}
			p = list;
			q = r.getNext();
			foundPlace = false;
		}
		return list;
		
	}
	public static Node<Node<Integer>> sortedUnionNewDuply(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> newList = null;
		if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
			newList = new Node<Node<Integer>>(l1.getValue());
			l1 = l1.getNext();
		}
		else {
			newList = new Node<Node<Integer>>(l2.getValue());
			l2 = l2.getNext();
		}
		Node<Node<Integer>> p = newList;
		while (l1 != null  &&  l2 != null) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				l1 = l1.getNext();
			}
			else {
				p.setNext(new Node<Node<Integer>>(l2.getValue()));
				l2 = l2.getNext();
			}
			p = p.getNext();
		}
		while (l1 != null) {
			p.setNext(new Node<Node<Integer>>(l1.getValue()));
			l1 = l1.getNext();
			p = p.getNext();
		}
		while (l2 != null) {
			p.setNext(new Node<Node<Integer>>(l2.getValue()));
			l2 = l2.getNext();
			p = p.getNext();
		}
		
		return newList;
	}
	public static Node<Node<Integer>> sortedUnionNew(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> newList = null;
		if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
			newList = new Node<Node<Integer>>(l1.getValue());
			l1 = l1.getNext();
		}
		else {
			newList = new Node<Node<Integer>>(l2.getValue());
			l2 = l2.getNext();
		}
		Node<Node<Integer>> p = newList;
		while (l1 != null  &&  l2 != null) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
				if (!equels(p.getValue(), l1.getValue())) {
					p.setNext(new Node<Node<Integer>>(l1.getValue()));
					p = p.getNext();
				}
				l1 = l1.getNext();
			}
			else {
				if (!equels(p.getValue(), l2.getValue())) {
					p.setNext(new Node<Node<Integer>>(l2.getValue()));
					p = p.getNext();
				}
				l2 = l2.getNext();
			}
		}
		while (l1 != null) {
			if (!equels(p.getValue(), l1.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				p = p.getNext();
			}
			l1 = l1.getNext();
		}
		while (l2 != null) {
			if (!equels(p.getValue(), l2.getValue())) {
				p.setNext(new Node<Node<Integer>>(l2.getValue()));
				p = p.getNext();
			}
			l2 = l2.getNext();
		}
		return newList;
	}
	public static Node<Node<Integer>> sortedUnionToList(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> p = null;
		while (equels(l2.getValue(), l1.getValue())) {
			l2 = l2.getNext();
		}
		if (is1SmallerThen2(l2.getValue(), l1.getValue())) {
			p = l2.getNext();
			l2.setNext(l1);
			l1 = l2;
			l2 = p;
		}
		Node<Node<Integer>> q = l1;
		while (q.hasNext()  &&  l2 != null) {
			if (equels(q.getValue(), q.getNext().getValue())) {
				q.setNext(q.getNext().getNext());
			}
			if (equels(l2.getValue(), q.getNext().getValue())) {
				l2 = l2.getNext();
			}
			else if (is1SmallerThen2(l2.getValue(), q.getNext().getValue())) {
				p = l2.getNext();
				l2.setNext(q.getNext());
				q.setNext(l2);
				l2 = p;
			}
			q = q.getNext();
		}
		if (l2 != null) {
			q.setNext(l2);
			while (q != null  &&  q.hasNext()) {
				if (equels(q.getValue(), q.getNext().getValue())) {
					q.setNext(q.getNext().getNext());
				}
				q = q.getNext();
			}
		}
		return l1;
	}
	public static Node<Node<Integer>> listsIntersection(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		while (!equels(l1.getValue(), l2.getValue())) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) l1 = l1.getNext();
			else l2 = l2.getNext();
		}
		Node<Node<Integer>> intersection = new Node<Node<Integer>>(l1.getValue());
		Node<Node<Integer>> p = intersection;
		l1 = l1.getNext();
		while (l1 != null  &&  l2 != null) {
			if (equels(l1.getValue(), l2.getValue())  &&  !equels(l1.getValue(), p.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				p = p.getNext();
				l1 = l1.getNext();
				l2 = l2.getNext();
			}
			else if (is1SmallerThen2(l1.getValue(), l2.getValue())) l1 = l1.getNext();
			else l2 = l2.getNext();
		}
		return intersection;
	}
	
	//============================================================================================================
	
	public static void printListOfNumRec(Node<Node<Integer>> list) {
		if (list == null) System.out.println();
		else {
			System.out.print(list.getValue() + ",  ");
			printListOfNumRec(list.getNext());
		}
	}
	
	public static boolean is1SmallerThen2Rec(Node<Integer> num1, Node<Integer> num2) {
		Node<Integer> b = longerNum(num1, num2, num1, num2);
		if (b == null) return is1SmallerThen2RecHelp(num1, num2);
		if (b == num1) return false;
		return true;
	}
	public static Node<Integer> longerNum(Node<Integer> p1, Node<Integer> p2, Node<Integer> num1, Node<Integer> num2) {
		if (p1 == null  &&  p2 == null) return null;
		if (p1 == null  &&  p2 != null) return num2;
		if (p1 != null  &&  p2 == null) return num1;
		return longerNum(p1.getNext(), p2.getNext(), num1, num2);
	}
	public static boolean is1SmallerThen2RecHelp(Node<Integer> p1, Node<Integer> p2) {
		if (p1 == null  ||  p2 == null) return false;
		if (p1.getValue()>p2.getValue()) return false;
		if (p1.getValue()<p2.getValue()) return true;
		return is1SmallerThen2RecHelp(p1.getNext(), p2.getNext());
	}
	
	public static boolean equelsRec(Node<Integer> num1, Node<Integer> num2) {
		if (isSameLength(num1, num2)) return isSameNum(num1, num2);
		return false;
	}
	public static boolean isSameNum(Node<Integer> p1, Node<Integer> p2) {
		if (p1 == null  &&  p2 == null) return true;
		if ((p1 == null  &&  p2 != null)  ||  (p1 != null  &&  p2 == null)) return false;
		return isSameLength(p1.getNext(), p2.getNext());
	}
	public static boolean isSameLength(Node<Integer> p1, Node<Integer> p2) {
		if (p1 == null  &&  p2 == null) return true;
		if (p1.getValue() != p2.getValue()) return false;
		return is1SmallerThen2RecHelp(p1.getNext(), p2.getNext());
	}
	
	
	public static Node<Node<Integer>> insertIntoSortedListRec(Node<Node<Integer>> list, Node<Integer> num){
		if (is1SmallerThen2Rec(num, list.getValue())) return new Node<Node<Integer>>(num, list);
		return insertIntoSortedListRec(list, list, num);		
	}
	public static Node<Node<Integer>> insertIntoSortedListRec(Node<Node<Integer>> p, Node<Node<Integer>> list, Node<Integer> num){
		if (!p.hasNext()) { 
			p.setNext(new Node<Node<Integer>>(num));
			return list;
		}
		if (is1SmallerThen2Rec(num, p.getNext().getValue())) {
			p.setNext(new Node<Node<Integer>>(num, p.getNext()));
			return list;
		}
		return insertIntoSortedListRec(p.getNext(), list, num);
	}
	
	public static Node<Node<Integer>> insertionSortRec(Node<Node<Integer>> list) {
		return insertionSortRec(list.getNext(), new Node<Node<Integer>>(list.getValue()));
	}
	public static Node<Node<Integer>> insertionSortRec(Node<Node<Integer>> list, Node<Node<Integer>> sorted) {
		if (list == null) return sorted;
		return insertionSortRec(list.getNext(), insertIntoSortedListRec(sorted, list.getValue()));
	}
	
	public static Node<Node<Integer>> insertionSortInPlaceRec(Node<Node<Integer>> list) {
		return insertionSortInPlaceRec(list, list, list, list.getNext());
	}
	public static Node<Node<Integer>> insertionSortInPlaceRec(Node<Node<Integer>> list, Node<Node<Integer>> p, Node<Node<Integer>> r, Node<Node<Integer>> q) {
		if (q == null) return list;
		if (is1SmallerThen2(q.getValue(), p.getValue())) {
			r.setNext(q.getNext());
			q.setNext(p);
			list = q;
			return insertionSortInPlaceRec(q, list, r, r.getNext());
		}
		r = insertionSortInPlaceRec(p, r, q, false);
		return insertionSortInPlaceRec(list, list, r, r.getNext());
	}
	public static Node<Node<Integer>> insertionSortInPlaceRec(Node<Node<Integer>> p, Node<Node<Integer>> r, Node<Node<Integer>> q, boolean foundPlace) {
		if (foundPlace  ||  p.getNext() == q) { 
			if (!foundPlace) return r.getNext();
			return r;
		}
		if (is1SmallerThen2(q.getValue(), p.getNext().getValue())) {
			r.setNext(q.getNext());
			q.setNext(p.getNext());
			p.setNext(q);
			foundPlace = true;
		}
		return insertionSortInPlaceRec(p.getNext(), r, q, foundPlace);
	}
	
	/*public static Node<Node<Integer>> sortedUnionNewDuply(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> newList = null;
		if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
			newList = new Node<Node<Integer>>(l1.getValue());
			l1 = l1.getNext();
		}
		else {
			newList = new Node<Node<Integer>>(l2.getValue());
			l2 = l2.getNext();
		}
		Node<Node<Integer>> p = newList;
		while (l1 != null  &&  l2 != null) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				l1 = l1.getNext();
			}
			else {
				p.setNext(new Node<Node<Integer>>(l2.getValue()));
				l2 = l2.getNext();
			}
			p = p.getNext();
		}
		while (l1 != null) {
			p.setNext(new Node<Node<Integer>>(l1.getValue()));
			l1 = l1.getNext();
			p = p.getNext();
		}
		while (l2 != null) {
			p.setNext(new Node<Node<Integer>>(l2.getValue()));
			l2 = l2.getNext();
			p = p.getNext();
		}
		
		return newList;
	}
	public static Node<Node<Integer>> sortedUnionNew(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> newList = null;
		if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
			newList = new Node<Node<Integer>>(l1.getValue());
			l1 = l1.getNext();
		}
		else {
			newList = new Node<Node<Integer>>(l2.getValue());
			l2 = l2.getNext();
		}
		Node<Node<Integer>> p = newList;
		while (l1 != null  &&  l2 != null) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) {
				if (!equels(p.getValue(), l1.getValue())) {
					p.setNext(new Node<Node<Integer>>(l1.getValue()));
					p = p.getNext();
				}
				l1 = l1.getNext();
			}
			else {
				if (!equels(p.getValue(), l2.getValue())) {
					p.setNext(new Node<Node<Integer>>(l2.getValue()));
					p = p.getNext();
				}
				l2 = l2.getNext();
			}
		}
		while (l1 != null) {
			if (!equels(p.getValue(), l1.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				p = p.getNext();
			}
			l1 = l1.getNext();
		}
		while (l2 != null) {
			if (!equels(p.getValue(), l2.getValue())) {
				p.setNext(new Node<Node<Integer>>(l2.getValue()));
				p = p.getNext();
			}
			l2 = l2.getNext();
		}
		return newList;
	}
	public static Node<Node<Integer>> sortedUnionToList(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		Node<Node<Integer>> p = null;
		while (equels(l2.getValue(), l1.getValue())) {
			l2 = l2.getNext();
		}
		if (is1SmallerThen2(l2.getValue(), l1.getValue())) {
			p = l2.getNext();
			l2.setNext(l1);
			l1 = l2;
			l2 = p;
		}
		Node<Node<Integer>> q = l1;
		while (q.hasNext()  &&  l2 != null) {
			if (equels(q.getValue(), q.getNext().getValue())) {
				q.setNext(q.getNext().getNext());
			}
			if (equels(l2.getValue(), q.getNext().getValue())) {
				l2 = l2.getNext();
			}
			else if (is1SmallerThen2(l2.getValue(), q.getNext().getValue())) {
				p = l2.getNext();
				l2.setNext(q.getNext());
				q.setNext(l2);
				l2 = p;
			}
			q = q.getNext();
		}
		if (l2 != null) {
			q.setNext(l2);
			while (q != null  &&  q.hasNext()) {
				if (equels(q.getValue(), q.getNext().getValue())) {
					q.setNext(q.getNext().getNext());
				}
				q = q.getNext();
			}
		}
		return l1;
	}
	public static Node<Node<Integer>> listsIntersection(Node<Node<Integer>> l1, Node<Node<Integer>> l2) {
		while (!equels(l1.getValue(), l2.getValue())) {
			if (is1SmallerThen2(l1.getValue(), l2.getValue())) l1 = l1.getNext();
			else l2 = l2.getNext();
		}
		Node<Node<Integer>> intersection = new Node<Node<Integer>>(l1.getValue());
		Node<Node<Integer>> p = intersection;
		l1 = l1.getNext();
		while (l1 != null  &&  l2 != null) {
			if (equels(l1.getValue(), l2.getValue())  &&  !equels(l1.getValue(), p.getValue())) {
				p.setNext(new Node<Node<Integer>>(l1.getValue()));
				p = p.getNext();
				l1 = l1.getNext();
				l2 = l2.getNext();
			}
			else if (is1SmallerThen2(l1.getValue(), l2.getValue())) l1 = l1.getNext();
			else l2 = l2.getNext();
		}
		return intersection;
	}
	*/
}
