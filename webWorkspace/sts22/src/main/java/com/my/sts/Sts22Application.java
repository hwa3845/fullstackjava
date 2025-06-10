package com.my.sts;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sts22Application implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sts22Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Inter inter=new Inter() {
//
//			@Override
//			public void func01() {
//				System.out.println("func01 run...");
//			}
//		};
//		inter.func();
//		inter.func01();
	//람다식 -> 화살표 함수문법을 본떠 만든 문법
//	Inter inter=(b)->{System.out.println("param:"+b*2);};
//	Inter inter2=new Inter(){
//
//		@Override
//		public void func01(int a) {
//			System.out.println("param:"+a*2);};
//		};
//	func(inter);
//	inter2.func01(1111);
		
//		Thread thr=new Thread(()->System.out.println("새로운 스레드 실행"));
//		thr.start();
	
		Runnable f1 = ()->{System.out.println("출력");};
		Supplier<Integer> f2 = ()->{return 1234;};
		Consumer<Integer> f3 = (a)->{};
		Consumer f4 = a ->{};
		Function<Integer,String> f5 = a ->{return a+"";};
		Predicate<Integer> f6 = (a) ->{return true;};
		IntBinaryOperator f7 = (a,b) ->{return a;};
		f1.run();
		f2.get();
		f3.accept(1234);
		f5.apply(1234);
		f6.test(1234);
		f7.applyAsInt(1, 2);
		
	}
	
//	public void func(Inter inter) {
//		inter.func01(1234);
//	}
}

//@FunctionalInterface
//추상화 메소드를 하나만 가질 수 있게 해 줌 -> 람다식 사용 가능
//interface Inter{
////	int su=1111;
//	void func01(int a);
//	//8 이후 interface의 구현부 사용 가능
//	default void func() {
//		System.out.println("run...");
//	}
//}
