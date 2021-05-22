package com.kosta.day11;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {

	public static void main(String[] args) {
		method3();
	}

	private static void method3() {
		Car[] arr = new Car[5];
		arr[0] = new Car("A", 5000);
		arr[1] = new Car("C", 3000);
		arr[2] = new Car("B", 4000);
		arr[3] = new Car("E", 2000);
		arr[4] = new Car("D", 5000);
		print("before", arr);
		Arrays.sort(arr);
		print("after", arr);
		Arrays.sort(arr, new Comparator<Car>() {

			@Override
			public int compare(Car o1, Car o2) {
				// TODO Auto-generated method stub
				return o2.getPrice() - o1.getPrice();	// 숫자면 -로 문자면 compareTo로
			}
		});
		print("descending sort", arr);
		
		int result = Arrays.binarySearch(arr, new Car("E", 2000));
		System.out.println(result + "번째에 있다.");

	}

	private static void print(String message, Car[] arr) {
		System.out.println("=======" + message + "=======");
		for(Car cc:arr) {
			System.out.println(cc);
		}
	}

	private static void method2() {
		Character[] arr = {'J', 'A', 'V', 'A'};
		Arrays.sort(arr);
		System.out.println(Arrays.binarySearch(arr, 'J') + "번째에 있다.");		// return값 int, sort 하고 써야됨
	}

	private static void method1() {
		Character[] arr = {'J', 'A', 'V', 'A'};
		Character[] arr2 = Arrays.copyOf(arr, arr.length-1);
		Character[] arr3 = new Character[arr.length];
		System.out.println("원본:"+Arrays.toString(arr));
		System.out.println("복사:"+Arrays.toString(arr2));
		
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		System.out.println("복사:"+Arrays.toString(arr3));
		
		//비교
		System.out.println(Arrays.equals(arr, arr2));
		System.out.println(Arrays.equals(arr, arr3));
		
		Arrays.sort(arr);
		System.out.println("sort:"+Arrays.toString(arr));
		
		// descending sort
		Arrays.sort(arr, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return o2.compareTo(o1);
			}
			
		});
		System.out.println("desc sort:"+Arrays.toString(arr));
		
		// CharDescending aa = new CharDescending();		
		// Arrays.sort(arr3, aa);
		Arrays.sort(arr3, new CharDescending());
		System.out.println("desc sort:"+Arrays.toString(arr3));

		Arrays.sort(arr3, new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				return o2 - o1;		
			}
		});
		System.out.println("desc sort:"+Arrays.toString(arr3));

	}

}
											// 기본형은 못들어감
class CharDescending implements Comparator<Character>{

	@Override
	public int compare(Character o1, Character o2) {
		return o2 - o1;		
		// 기본형은 o2-o1, 나머지는 o2.compareTo(o1)
		// Character는 기본형 아니지만 자동으로 언박싱됨
	}
	
}
