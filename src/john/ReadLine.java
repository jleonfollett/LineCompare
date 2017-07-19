package john;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadLine {

	public static final String UTF8_BOM = "﻿";
	private BufferedReader br;
	private BufferedReader br2;
	private FileReader fr;
	private FileReader fr2;
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Character> line1List = new ArrayList<Character>(); 
	private ArrayList<Character> line2List = new ArrayList<Character>(); 
	private ArrayList<Character> resultList = new ArrayList<Character>(); 


	public ReadLine() throws IOException, ParseException{
		// Opens File and BufferedReader
		System.out.println("Please provide file to be read");
		fr = new FileReader(scanner.nextLine());
		br = new BufferedReader(fr);
		String line = br.readLine();
		String line2 = br.readLine();
		checkEmpty(line, line2);
		}
	
	
	private ArrayList<Character> populateList(String line, ArrayList<Character> list){
		for (int i = 0; i < line.length(); i++){
			list.add(line.charAt(i));
		}
		return list;
	}
	
	private void checkEmpty(String line, String line2){
		if(line == null || line2 == null){
			if(line == null){
				System.out.println("The first line is empty!");
			} else {
				populateList(line, line1List);
			}
			if(line2 == null){
				System.out.println("The second line is empty!");
			} else {
				populateList(line2, line2List);
			}
		} else {
			populateList(line, line1List);
			populateList(line2,line2List);
			if(line.equals(line2)){
				System.out.println("The lines are the same!");
			}
		}
		evaluate(line1List, line2List);
	}

	private void evaluate(ArrayList<Character> char1, ArrayList<Character> char2){
		boolean match;
		for(int i = 0; i < char1.size(); i++){
			match = false;
			for(int x = 0; x < char2.size(); x++){
				if(char1.get(i) == char2.get(x)){
					char2.remove(x);
					match = true;
					break;
				}
			}
			if(!match){
				resultList.add(char1.get(i));
			}
		}
		System.out.println("The first line has the following extra characters: " + resultList);
		System.out.println("The second line has the following extra characters: " + char2);
		
	}


	


}
