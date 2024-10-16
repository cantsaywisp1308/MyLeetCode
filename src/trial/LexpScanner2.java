package trial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import trial.LexpScanner2.Token;



public class LexpScanner2 {

	public static class Token {
		private String value;
		private String type;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Token(String type, String value) {
			super();
			this.value = value;
			this.type = type;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.print("Error");
			System.exit(1);
		}

		String inputFile = args[0];
		String outputFile = args[1];

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write("Line: " + line);
				writer.newLine();
				List<Token> tokens = tokenize(line);
				for (Token token : tokens) {
					if(token.getType() == "ERROR READING") {
						writer.write(token.getType() + " : " + '"' + token.getValue()+ '"');
						writer.newLine();
					} else {
						writer.write(token.getValue() + " : " + token.getType());
						writer.newLine();
					}
					
				}
			}
		}

		catch (IOException e) {
			System.err.println("Error reading/writing files: " + e.getMessage());
		}

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
