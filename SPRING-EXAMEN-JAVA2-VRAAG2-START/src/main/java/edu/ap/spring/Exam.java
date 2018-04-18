package edu.ap.spring;

import java.awt.Point;
import java.nio.CharBuffer;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		numbers.stream()
				.filter(n -> n > 1)
				.
	}
	
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {

		List<Character> chars = string.chars().mapToObj(e->(char)e).collect(Collectors.toList());
		
		
		
		chars.stream()
		.filter(c -> Character.toUpperCase(c.charValue()) == true)
		.count();
		
       
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	public int sumOfX(List<Point> points) {
		
		double sum = points.stream()
		.map(Point::getX)
		.mapToDouble(i->i).sum();
		
		int result = (int)sum;
		
		return result;
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
		
	}
}
