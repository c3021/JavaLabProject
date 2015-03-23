package test;

//TODO Q1
import java.*;
import t1.*;
import t2.*;
import f1.*;
import f2.*;

import java.util.ArrayList;

public class TestAny {

	public static void passBy(int a) {
		System.out.println("a in method passBy = " + a);
		a--;
		System.out.println("a in method passBy after -- = " + a);
	}
	public interface a1 {
		void i();
		int z(int a);
	}
	public interface b1 {
		void i();
		int z(int a);
	}
	public interface c1 {
		int i();
		int z(int a);
	}
	public interface d1<T> extends a1,b1{
		void i();
		int z(int a);
	}
	public class t1 {
		//TODO Q2: final public static int sf() {return (int)c1;}
		//TODO Q3: <T> > <T=String>? default type
		private int v1;
		final int ret1() { System.out.println(" t1 ");return this.v1;}
		public int get1() {
			return v1;
		}
		final public char c;
		final static public char c1 ='m';
		public t1() {
			c = 'p';
		}
		public t1(char d) {
			c = d;
		}
		private final int pint() { return 1;}
	}
	public class t2<T> extends t1 implements a1,b1,d1<T> {
		public char c;
		public char v1;
		public T vt;
		public char getV1() {
			return v1;
		}
		final static public char c1 ='f';
		public void setV1(char v) {
			v1 = v;		}
		public void i() {}
		private int pint() { return 2;}
		//private int pint() { return super.pint();}
		int ret1(ArrayList<Integer> a) { System.out.println(" t2 ");return this.v1;}
		int ret2() { System.out.println(" t2 "); return this.v1;}
		public int z(int a) {
			return 0;
			}
	}
	
	
	public static void main(String[] args) {
		//TODO Q4: same name for a package and a class

		//Z ta = new Z();
		//t1.Z ta = new Z();
		
		
		//f1.X x = new f2.X(); CAN'T
		//X x = new X(); CAN'T
		f1.X xa= new f1.X();
		f2.X xb= new f2.X();
		
		TestAny t = new TestAny();
		TestAny.t2<Object> abc = t.new t2<Object>();
		System.out.println(abc.c1);
		abc.v1 =10;
		abc.ret1();
		System.out.println(abc.pint());
		System.out.println(abc.getClass());
		System.out.println((abc.vt="S").getClass());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
		TestAny.t1 bc = t.new t2<Integer>();
		System.out.println(bc.getClass());
		TestAny.t2 bcc = t.new t2();
		System.out.println(bcc.getClass());
		//Q5: how to call bcc.super.c1 ? (method & var)
		System.out.println((bcc.vt='s').getClass());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		ArrayList<Integer> ac =new ArrayList();
		System.out.println(ac.getClass());
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		ArrayList abcc =new ArrayList();
		System.out.println(abcc.getClass());
		abcc.add(new TestAny());
		abcc.add(new Integer(2));
		System.out.println(abcc.get(0).getClass());
		System.out.println(abcc.get(1).getClass());
		Object i = abcc.get(1);
		System.out.println(i.getClass());
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
