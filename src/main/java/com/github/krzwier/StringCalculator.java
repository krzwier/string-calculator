package com.github.krzwier;

import java.util.Scanner;
import java.util.regex.*; 

public class StringCalculator {

	public int Add(String inputString) throws Exception {
		// initialize default delimiters
		String delimiters = "[,\n]";

		// check for comment
		String splitInput[] = CheckForComment(inputString);
		String comment = splitInput[0];
		String realInput = splitInput[1];
		if (!comment.isEmpty()){
			delimiters = comment;
		}

		String[] args = realInput.split(delimiters);
		int sum = 0;
		String negNumList = "";
		boolean exceptionFlag = false;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].isEmpty()){
				int temp = Integer.parseInt(args[i]);
				if (temp < 0) {
					exceptionFlag = true;
					negNumList = negNumList + temp;
				} else if (temp <= 1000){
					sum += temp;
				}
			}
		}
		if (exceptionFlag) {
			throw new Exception("Negatives not allowed! (" + negNumList + ")");
		}
		return sum;
	}

	/** 
	 * This method takes input string and checks for a beginning comment
	 * returns a String array where returnStrings[0] = comment and 
	 * returnStrings[1] = number string
	 * 
	*/

	private String[] CheckForComment(String inputString) {
		// index 0 is used for comment
		// index 1 is used for real input string
		String[] returnStrings = {"", ""};

		if (inputString.indexOf("//") == 0 && inputString.indexOf("[") == 2) {
			// this is case where there are one or more bracketed delimiters
			returnStrings = handleBracketedDelimiters(inputString);
		} else if (inputString.indexOf("//") == 0) {
			// this is case where there is a single-character custom delimiter
			returnStrings = handleSingleCharacterDelimiter(inputString);
		} else {
			// this is case where there is no comment
			returnStrings[0] = "";
			returnStrings[1] = inputString;
		}
		return returnStrings;
	}

	private String[] handleBracketedDelimiters(String inputString) {
		String temp = inputString.substring(2);
		StringBuilder delimiter = new StringBuilder("(");
		while (temp.indexOf("[") == 0) {
			// this loop runs for each delimiter within square brackets
			int end = temp.indexOf("]");
			delimiter.append(Pattern.quote(temp.substring(1,end)) + "|");
			temp = temp.substring(end + 1);
		}
		// delete appended pipe
		delimiter.deleteCharAt(delimiter.length() - 1);
		// add closing parentheses
		delimiter.append(")");

		String[] returnStrings = {"", ""};
		returnStrings[0] = delimiter.toString();
		returnStrings[1] = temp.substring(1);
		return returnStrings;
	}

	private String[] handleSingleCharacterDelimiter(String inputString) {
		String delimiter = inputString.substring(2, 3);
		String[] returnStrings = {"", ""};
		returnStrings[0] = Pattern.quote(delimiter);
		returnStrings[1] = inputString.substring(4);
		return returnStrings;
	}

	public int Subtract(int minuend, int subtrahend) {
		return minuend - subtrahend;
	}

	public int parse(String inputString) {
		if (inputString.isEmpty()){
			return 0;
		} 
		return Integer.parseInt(inputString);
	}

    public static void main(String[] args) throws Exception {
        String input = "";
        StringCalculator calc = new StringCalculator();
        Scanner in = new Scanner(System.in);
        while (!input.equals("exit")){
            System.out.println(calc.Add(input));
            System.out.println("Enter your addition problem as a string of numbers, or type \"exit\" to quit program:");
            input = in.nextLine();

        }
        in.close();
        
    }


}
