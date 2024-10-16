package trial;

import java.util.ArrayList;
import java.util.List;

import trial.LexpScanner2.Token;

public class Try {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "x32 :=0; skip";
		System.out.print(tokenize(test));
	}

	public static List<Token> tokenize(String line) {
		List<Token> tokens = new ArrayList<Token>();
		int index = 0;
		int length = line.length();
		while (index < line.length()) {
			char currentChar = line.charAt(index);
			if (Character.isWhitespace(currentChar)) {
				index++;
			} else if (Character.isDigit(currentChar)) {
				int endIndex = index;
				while (endIndex < length && Character.isDigit(line.charAt(endIndex))) {
					endIndex++;
				}
				if (line.substring(index, endIndex).length() > 100) {
					tokens.add(new Token("Length limit exceeded", line.substring(index, endIndex)));
				} else {
					tokens.add(new Token("NUMBER", line.substring(index, endIndex)));
					index = endIndex;
				}

			} else if (Character.isAlphabetic(currentChar)) { // check to see IDENTIFIER token
				int endIndex = index;
				while (endIndex < length && (Character.isAlphabetic(line.charAt(endIndex))
						|| Character.isDigit(line.charAt(endIndex)))) {
					endIndex++;
				}
				if (line.substring(index, endIndex).length() > 100) {
					tokens.add(new Token("Length limit exceeded", line.substring(index, endIndex)));
				} else if (checkKeywords(line.substring(index, endIndex))){
					tokens.add(new Token("KEYWORDS", line.substring(index, endIndex)));
					index = endIndex;
				} else {
					tokens.add(new Token("IDENTIFIER", line.substring(index, endIndex)));
					index = endIndex;
				}
			} else if (currentChar == ':'){
				int endIndex = index+1;
				if(line.charAt(endIndex) == '=') {
					tokens.add(new Token("SYMBOL", line.substring(index, endIndex+1)));
				}
				index = index +2;
				
			}else if (isSymbol(currentChar)) {
				tokens.add(new Token("SYMBOL", Character.toString(currentChar)));
				index++;
			} else {
				tokens.add(new Token("ERROR READING", Character.toString(currentChar)));
				break;
			}
		}
		return tokens;
	}

	public static boolean isSymbol(char c) {
		String symbols = "+-*/();";
		return symbols.indexOf(c) != -1;
	}

	public static boolean checkKeywords(String s) {
		boolean status = false;
		String[] keywords = { "if", "then", "else", "endif", "while", "do", "endwhile", "skip" };
		for (int i = 0; i < keywords.length; i++) {
			if (keywords[i].equalsIgnoreCase(s)) {
				status = true;
				break;
			}
		}
		return status;
	}
	
	


	
}
