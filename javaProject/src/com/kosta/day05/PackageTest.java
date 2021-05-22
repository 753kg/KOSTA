package com.kosta.day05;

import java.sql.Date;

import com.kosta.day04.Car;

/*import java.sql.Date;
//import java.util.Calendar;
//import java.util.Scanner;
import java.util.*;*/

public class PackageTest {

	public static void main(String[] args) {
		long aa = new java.util.Date().getTime();
		Date d = new Date(aa);
		System.out.println(d);
		
		new Car();

	}

}
