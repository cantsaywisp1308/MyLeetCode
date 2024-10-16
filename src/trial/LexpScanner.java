package trial;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexpScanner {

	public static class Token {
		private String type;
		private String value;

		public Token(String type, String value) {
			this.type = type;
			this.value = value;
		}

		public String getType() {
			return type;
		}

		public String getValue() {
			return value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.err.println("Usage: java LexpScanner input_file output_file");
			System.exit(1);
		}

		String inputFilePath = args[0];
		String outputFilePath = args[1];

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

			String line;
			while ((line = reader.readLine()) != null) {
				writer.write("Line: " + line);
				writer.newLine();
				ArrayList<Token> tokens = tokenize(line);
				for (Token token : tokens) {
					writer.write(token.getType() + " : " + token.getValue());
					writer.newLine();
				}
			}

		} catch (IOException e) {
			System.err.println("Error reading/writing files: " + e.getMessage());
		}
	}

	public static ArrayList<Token> tokenize(String line) {
		ArrayList<Token> tokens = new ArrayList<>();
		int index = 0;
		int length = line.length();

		while (index < length) {
			char currentChar = line.charAt(index);
			if (Character.isWhitespace(currentChar)) {
				index++;
			} else if (Character.isDigit(currentChar)) {
				int endIndex = index;
				while (endIndex < length && Character.isDigit(line.charAt(endIndex))) {
					endIndex++;
				}
				tokens.add(new Token("NUMBER", line.substring(index, endIndex)));
				index = endIndex;
			} else if (Character.isAlphabetic(currentChar)) {
				int endIndex = index;
				while (endIndex < length && (Character.isAlphabetic(line.charAt(endIndex))
						|| Character.isDigit(line.charAt(endIndex)))) {
					endIndex++;
				}
				tokens.add(new Token("IDENTIFIER", line.substring(index, endIndex)));
				index = endIndex;
			} else if (isSymbol(currentChar)) {
				tokens.add(new Token("SYMBOL", Character.toString(currentChar)));
				index++;
			} else {
				System.err.println("ERROR READING '" + currentChar + "'");
				break;
			}
		}

		return tokens;
	}
	
	public static boolean isSymbol(char c) {
        String symbols = "+-*/()";
        return symbols.indexOf(c) != -1;
    }

}
