package com.zz.test;

public class Test {
	public static void main(String[] args) {
         Person person = new Person();
         person.setName("in");
		dealA(person);
           System.out.println("out:"+person);
	}

	private static void dealA(Person a) {
                  a.setName(a.getName().substring(1));	
                  System.out.println("in:"+a);
	}
	private static void dealB(String a) {
		// TODO Auto-generated method stub
		
	}
}
