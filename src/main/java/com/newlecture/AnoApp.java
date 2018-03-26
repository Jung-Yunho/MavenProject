package com.newlecture;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class AnoApp {

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// RTTI -> meta data -> RunTime Type Infomation
		
		Scanner scan = new Scanner(System.in);
		System.out.print("호출하고 싶은 함수의 이름은 : ");
		String url = scan.nextLine();
		
		AnoTestClass cls = new AnoTestClass();
		Class<?> clsInfo = cls.getClass();
		Haha haha = clsInfo.getAnnotation(Haha.class);
		
		if(haha != null) {
			Method[] met = cls.getClass().getDeclaredMethods();
			
			for(Method m : met) {
				Test test = m.getAnnotation(Test.class);
				if(test != null && test.name().equals(url)) {
					m.invoke(cls,null);
					//System.out.println(m.getName()+"()");
				}
			}
		}
		
		// RTTI 객체 가져오기 (Runtime Type Information)
		/*Test test = cls.getClass().getAnnotation(Test.class);
		System.out.println(test);
		Haha haha = cls.getClass().getAnnotation(Haha.class);
		System.out.println(haha);
		
		
		Annotation[] anos = cls.getClass().getAnnotations();
		
		System.out.println(anos.length);
		
		for(int i=0; i<anos.length; i++) {
			System.out.println(anos[i].annotationType().getName());
			System.out.println(anos[i].annotationType().getSimpleName());
		}*/
	}

}
