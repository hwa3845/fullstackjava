package com.my.sts;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sts23Application implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sts23Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		Stream<String> stream = Stream.of("item1","item2","ITEM3","item2","ITEM4");
//		List list=List.of("item1","item2","item3","item4");
//		Stream stream=list.stream();
//		Set list=Set.of("item1","item2","item3","item4");
//		Stream stream=list.stream();
//		List list=Arrays.asList("item1","item2","item3","item4");
//		Stream stream=list.stream();
		
//		String[] array = {"a1", "a2", "b1", "b2", "c2", "c1"};
//		Stream<String> stream = Arrays.stream(array);
		
//		Stream<String> stream=Stream.generate(() -> "item").limit(5);
//		Stream<Integer> stream=Stream.iterate(0,n -> n+2).limit(5);
		
//		Stream<String> stream=
//				Stream.<String>builder()
//				.add("item1")
//				.add("item2")
//				.add("item3")
//				.add("item4")
//				.add("item5")
//				.build();
		
		//range -> 5 포함 X, rangeClosed -> 5포함
//		IntStream intStream = IntStream.range(1, 5);
//		LongStream stream = LongStream.rangeClosed(1, 5);
		
//		Stream<Integer> stream= intStream.boxed();
//		DoubleStream stream = new Random().doubles(3);//난수 3개 생성
//		IntStream stream = new Random().ints(3);
		
//		IntStream stream= "Stream".chars();	//[83,116,114,101,97,109]
//		Stream<String> stream=
//				Pattern.compile(", ").splitAsStream("Eric, Elena, Java");
//				Arrays.stream("Eric, Elena, Java".split(", "));
				
//		File f=new File("./file.txt");
//		Stream<String> stream =
//				Files.lines(Paths.get("file.txt"),
//						Charset.forName("UTF-8"));
//				Files.lines(Paths.get(f.getAbsolutePath()),
//						Charset.forName("UTF-8"));
		//중복값 처리
//		stream=stream.distinct();
		//predicate 타입(매개변수 있고 리턴 타입이 boolean
//		stream=stream.filter(a->a.startsWith("item"));
		//정렬 (음수, 양수(0포함)), 집어넣은 순서
//		stream=stream.sorted((a,b)->-1);
		//정렬(compare 로 오름차순, 내림차순)
//		stream=stream.sorted((a,b)->a.compareTo(b));
//		stream=stream.sorted((a,b)->b.compareTo(a));
		//map
//		stream=stream.map(a->{
//			System.out.println("중간 출력:"+a);
//			return a;});
		//중간 출력을 보기 위해 print할 거면 map말고 peek을 써야 함
		//map(function이라서)의 경우 return값의 
		//타입을 바꿀 수도(예. String -> parseInt) 있기 때문에 
//		stream=stream.peek(a->{System.out.println("중간 출력:"+a);});
		//병합(concat)
//		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5");
//		List<String> chars = Arrays.asList("a", "b", "c", "d", "e");
//		Stream<String> stream1 = numbers.stream();
//		Stream<String> stream2 = chars.stream();
//		stream = Stream.concat(stream1, stream2);
//		
//		stream.forEach(s -> System.out.println(s));
		
//		List<String> list = Arrays.asList("apple","banana","cherry","date");
//		Consumer result=System.out::println;
//		list.stream().forEach(result);
		
//		int[] intArr = { 2, 4 ,6 ,3};
//		boolean result = Arrays.stream(intArr)
//		            .allMatch(a -> a%2==0); //and
//					.anyMatch(a -> a%2!=0); //or
//					.noneMatch(a -> a%2!=0); //not
//		System.out.println(result);
		
//		IntStream stream = IntStream.range(1, 101);
//		stream.forEach(a -> sum += a);
//		System.out.println("총합:"+sum);
//		
//		IntStream.range(10, 21).min().ifPresent(System.out::println);
//		IntStream.range(10, 21).max().ifPresent(System.out::println);
//		IntStream.range(10, 21).average().ifPresent(System.out::println);
//		sum=IntStream.range(10, 21).sum();
//		System.out.println("총합: "+sum);
//		Long su=IntStream.range(10, 21).count();
//		System.out.println("개수: "+su);
//		IntStream.range(10, 21).reduce((a,b)->a+b).ifPresent(System.out::println);
//		sum=IntStream.range(10, 21).reduce(1000,(a,b)->a+b);
//		System.out.println(sum);
		
//		List<String> langs = Arrays.asList("1", "2", "3", "4", "5");
//
//		Stream<String> stream = langs.stream();
//		Optional<String> op = stream
//		        .reduce((a,b)->String.valueOf(
//		                        Integer.parseInt(a)+Integer.parseInt(b)));
//		System.out.println(op.get());

//		OptionalInt op2 = langs.stream()
//				//존재하는 클래스 :: 해당 메소드 -> 생성자일 땐 new 
//		        .mapToInt(Integer::parseInt)
//		        .mapToInt(a->Integer.parseInt(a))
//		        .reduce((a,b)->a+b);
//		System.out.println(op2.getAsInt());
		
//		IntStream stream2= langs.stream()
//		        .mapToInt(a->Integer.parseInt(a));
//		System.out.println(stream2.reduce((a,b)->a+b).getAsInt());
//
//		Stream<Integer> stream3 = langs.stream().map(Integer::parseInt);
//		Optional<Integer> op3 = stream3.reduce((a,b)->a+b);
//		System.out.println(op3.get());
//		
//		System.out.println(
//				langs.stream().map(Integer::parseInt).reduce((a,b)->a+b).get()
//				);
//		Stream<String> stream = Stream.of("apple", "banana", "cherry", "date");
//		List<String> list = stream.collect(Collectors.toList());
//		Set<String> list = stream.collect(Collectors.toSet());
//		Map<String,String> list = stream.collect(Collectors.toMap(a->a,a->a.toUpperCase()));
//		String list=stream.collect(Collectors.joining(","));
//		Map<Integer, List<String>> list = null;
//		list=stream.collect(Collectors.groupingBy(String::length));
//		List<String> list = stream.toList();
//		Object[] list = stream.toArray();
//		System.out.println(list);
		
		String string="문자열";
//		Optional<String> opString=Optional.of(string);
//		System.out.println(opString.get());
		Optional<String> opString=Optional.empty();
		System.out.println(opString.isPresent());
		opString.ifPresent(System.out::println);
		opString.ifPresentOrElse(System.out::println, ()->System.out.println("없음"));
	}
	//local class 안에서는 final 이기 때문에 필드로 빼야 람다식에서 사용 가능
	int sum=0;
}
