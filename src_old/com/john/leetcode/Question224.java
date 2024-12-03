package com.john.leetcode;

public class Question224 {

	public static void main(String[] args) {
		String s = "2-(1+2)";
		System.out.println(new Question224().calculate(s));
	}

	public int calculate(String s) {
		Elem head = breakDownInput(s.toCharArray());
		combineElems(head);

		return head.val;
	}

	private Elem breakDownInput(char[] input) {
		Elem preHead = new Elem(-1);
		Elem curr = preHead;
		String currNum = "";

		for (int i = 0; i < input.length; i++) {
			if (input[i] == ' ') {
				// skip whitespace
				if (!currNum.equals("")) {
					int num = Integer.parseInt(currNum);
					Elem elem = new Elem(num);
					elem.prev = curr;
					curr.next = elem;
					curr = curr.next;
					currNum = "";
				}
			} else if (Character.isDigit(input[i])) {
				// number
				currNum += input[i];
			} else {
				// operator or paren
				if (!currNum.equals("")) {
					int num = Integer.parseInt(currNum);
					Elem numElem = new Elem(num);
					numElem.prev = curr;
					curr.next = numElem;
					curr = curr.next;
					currNum = "";
				}

				Elem opElem = new Elem(input[i]);
				opElem.prev = curr;
				curr.next = opElem;
				curr = curr.next;
			}
		}
		if (!currNum.equals("")) {
			int num = Integer.parseInt(currNum);
			Elem elem = new Elem(num);
			elem.prev = curr;
			curr.next = elem;
			curr = curr.next;
			currNum = "";
		}

		return preHead.next;
	}

	private void combineElems(Elem head) {
		Elem curr = head;
		while (curr.next != null) {
			if (curr.isNum && isInParenGroupAlone(curr)) {
				curr = combineParenGroup(curr);
				// System.out.println("paren " + curr);
			} else if (curr.isOp() && isSurroundedByNumbers(curr)) {
				curr = combineCalculation(curr);
				// System.out.println("calc " + curr);
			} else {
				// its something we can't operate on yet
				// System.out.println("else " + curr);
				curr = curr.next;
			}
		}
	}

	private boolean isSurroundedByNumbers(Elem curr) {
		if (curr.prev == null || curr.next == null) {
			return false;
		}
		return curr.prev.isNum() && curr.next.isNum();
	}

	private Elem combineParenGroup(Elem curr) {
		Elem newCurr = curr.prev;
		newCurr.val = curr.val;
		newCurr.elem = '\0';
		newCurr.isNum = true;
		Elem newNext = curr.next.next;
		curr.prev = null;
		curr.next = null;
		newCurr.next = newNext;
		if (newNext != null) {
			newNext.prev = newCurr;
		}
		return newCurr.prev;
	}

	private boolean isInParenGroupAlone(Elem curr) {
		if (curr.prev == null || curr.next == null) {
			return false;
		}
		return curr.prev.elem == '(' && curr.next.elem == ')';
	}

	private Elem combineCalculation(Elem curr) {
		int calculation = performOp(curr, curr.prev, curr.next);
		Elem newCurr = curr.prev;
		newCurr.val = calculation;
		Elem newNext = curr.next.next;
		curr.prev = null;
		curr.next = null;
		newCurr.next = newNext;
		if (newNext != null) {
			newNext.prev = newCurr;
		}
		return newCurr;
	}

	private int performOp(Elem curr, Elem lhs, Elem rhs) {
		switch (curr.elem) {
		case '+':
			return lhs.val + rhs.val;
		case '-':
			return lhs.val - rhs.val;
		}
		throw new RuntimeException("invalid op");
	}

	private static class Elem {
		Elem prev = null;
		Elem next = null;
		char elem;
		int val;
		private boolean isNum = false;

		Elem(int val) {
			this.val = val;
			this.isNum = true;
		}

		Elem(char elem) {
			this.elem = elem;
		}

		boolean isOp() {
			return elem == '+' || elem == '-';
		}

		boolean isNum() {
			return isNum;
		}

		@Override
		public String toString() {
			String out = "";
			Elem curr = this;
			while (curr != null) {
				if (curr.isNum()) {
					out += curr.val;
				} else {
					out += curr.elem;
				}

				out += ", ";
				curr = curr.next;
			}

			return out;
		}
	}
}
