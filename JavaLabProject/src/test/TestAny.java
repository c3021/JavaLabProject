package test;

public class TestAny {

	public static void passBy(int a) {
		System.out.println("a in method passBy = " + a);
		a--;
		System.out.println("a in method passBy after -- = " + a);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Case 3-1 & 3-2 tested result are String.repace and String.replaceAll are the same
		//Case 3-1 String.replaceAll String.replace
		/*
		String a = "pass";
		String b = "passpasspasspasspass";
		String c = "pass pass pass pass pass";
		String d = "passpass passpass passpass";
		String e = "pass passpass passpasspass";

		System.out.println("a is " + a);
		System.out.println(a.replace("pass ", "6"));
		System.out.println(a.replaceAll("pass ", "6"));
		System.out.println("b is " + b);
		System.out.println(b.replace("pass ", "6"));
		System.out.println(b.replaceAll("pass ", "6"));
		System.out.println("c is " + c);
		System.out.println(c.replace("pass ", "6"));
		System.out.println(c.replaceAll("pass ", "6"));
		System.out.println("d is " + d);
		System.out.println(d.replace("pass ", "6"));
		System.out.println(d.replaceAll("pass ", "6"));
		System.out.println();
		System.out.println("e is " + e);
		System.out.println(e.replace("pass ", "6"));
		System.out.println(e.replaceAll("pass ", "6"));
		System.out.println();
		*/
		
		//Case 3-2 replaceAll replace
		/*
		String a = "aaaa";
		String b = "aaaaaaaa";
		String c = "aaaa aaaa aaaa aaaa ";
		String d = "aaaaaaaa aaaaaaaa aaaaaaaa";
		String e = "aaaa aaaaaaaa aaaaaaaaaaaa";

		System.out.println("a is " + a);
		System.out.println(a.replace("aa", "a"));
		System.out.println(a.replaceAll("aa", "a"));
		System.out.println("b is " + b);
		System.out.println(b.replace("aa", "a"));
		System.out.println(b.replaceAll("aa", "a"));
		System.out.println("c is " + c);
		System.out.println(c.replace("aa", "a"));
		System.out.println(c.replaceAll("aa", "a"));
		System.out.println("d is " + d);
		System.out.println(d.replace("aa", "a"));
		System.out.println(d.replaceAll("aa", "a"));
		System.out.println();
		System.out.println("e is " + e);
		System.out.println(e.replace("aa", "a"));
		System.out.println(e.replaceAll("aa", "a"));
		System.out.println();
		*/
		
		//Case2 pass by value in method
		/*
		int c = 3;
		System.out.println("a in main = " + c);
		passBy(c);
		System.out.println("a in main after passBy = " + c);
		*/
		
		
		
		
		//Case 1
		/*
		int[] iArr = {1,2};
		String[] sArr = {"A", "b"};
		for (int i : iArr)
		{
			String s = sArr[0];
			System.out.println(i);
			System.out.println(s);
		}
		*/
	}

}
