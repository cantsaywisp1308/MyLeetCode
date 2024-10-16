package trial;

import java.util.*;
import java.util.function.Predicate;



import java.io.*;




public class LimpInterpreter {
	
	static class ASTNode {
	    String type;
	    List<ASTNode> children;
	    String value;

	    public ASTNode(String type) {
	        this.type = type;
	        this.children = new ArrayList<>();
	    }

	    public ASTNode(String type, String value) {
	        this.type = type;
	        this.value = value;
	        this.children = new ArrayList<>();
	    }
	}

	 static class Token {
		String type;
		String value;

		public Token(String type, String value) {
			this.type = type;
			this.value = value;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	 
	 

	 private static int currentTokenIndex = 0;
	 private static List<Token> tokens;

	 private static ASTNode expression() {
	     ASTNode node = term();
	     while (currentToken().getType().equals("SYMBOL") && currentToken().getValue().equals("+")) {
	         consume();
	         ASTNode sumNode = new ASTNode("SUM");
	         sumNode.children.add(node);
	         sumNode.children.add(term());
	         node = sumNode;
	     }
	     return node;
	 }

	 private static ASTNode term() {
	     ASTNode node = factor();
	     while (currentToken().getType().equals("SYMBOL") && currentToken().getValue().equals("-")) {
	         consume();
	         ASTNode differenceNode = new ASTNode("DIFFERENCE");
	         differenceNode.children.add(node);
	         differenceNode.children.add(factor());
	         node = differenceNode;
	     }
	     return node;
	 }

	 private static ASTNode factor() {
	     ASTNode node = piece();
	     // If division is added in the future, it should be handled here.
	     return node;
	 }

	 private static ASTNode piece() {
	     ASTNode node = element();
	     while (currentToken().getType().equals("SYMBOL") && currentToken().getValue().equals("*")) {
	         consume();
	         ASTNode productNode = new ASTNode("PRODUCT");
	         productNode.children.add(node);
	         productNode.children.add(element());
	         node = productNode;
	     }
	     return node;
	 }

	 private static ASTNode element() {
	     if (currentToken().getType().equals("SYMBOL") && currentToken().getValue().equals("(")) {
	         consume();
	         ASTNode node = expression();
	         if (currentToken().getType().equals("SYMBOL") && currentToken().getValue().equals(")")) {
	             consume();
	             return node;
	         }
	         // Error handling: mismatched parenthesis.
	         return null;
	     } else if (currentToken().getType().equals("NUMBER")) {
	         return new ASTNode("NUMBER", consume().getValue());
	     } else if (currentToken().getType().equals("IDENTIFIER")) {
	         return new ASTNode("IDENTIFIER", consume().getValue());
	     } else {
	         // Error handling: unexpected token type.
	         return null;
	     }
	 }

	 // Utility functions to manage the current token index
	 private static Token currentToken() {
	     return tokens.get(currentTokenIndex);
	 }

	 private static Token consume() {
	     return tokens.get(currentTokenIndex++);
	 }

	 private static boolean isEndOfTokens() {
	     return currentTokenIndex >= tokens.size();
	 }

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Usage: java LimpInterpreter input_file output_file");
			return;
		}

		String inputFileName = args[0];
		String outputFileName = args[1];

		List<Token> tokens = tokenizeFromFile(inputFileName);

		if (tokens != null) {
			writeTokensToFile(tokens, outputFileName);
		}

		//Parser parser = new Parser(tokens);
        

	}


	public static List<Token> tokenizeFromFile(String fileName) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fileName));
			List<Token> tokens = new ArrayList<>();
			String line;

			while ((line = reader.readLine()) != null) {
				tokens.addAll(tokenizeLine(line));
			}

			return tokens;
		} catch (IOException e) {
			System.err.println("Error reading the input file: " + e.getMessage());
			return null;
		}
	}

	public static List<Token> tokenizeLine(String line) {
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
				String word = line.substring(index, endIndex);
				if (checkKeyword(word)) {
					tokens.add(new Token("KEYWORD", word));
				} else {
					tokens.add(new Token("IDENTIFIER", line.substring(index, endIndex)));
				}
				index = endIndex;
			} else if (isSymbol(currentChar)) {
				tokens.add(new Token("SYMBOL", Character.toString(currentChar)));
				index++;
			} else if (currentChar == ':') {
				if (line.charAt(index + 1) == '=') {
					tokens.add(new Token("SYMBOL", line.substring(index, index + 2)));
					index = index + 2;
				}
			} else {
				System.err.println("ERROR READING '" + currentChar + "'");
				break;
			}
		}
		return tokens;
	}

	public static boolean checkKeyword(String s) {
		if (s.equals("if") || s.equals("then") || s.equals("else") || s.equals("endif") || s.equals("while")
				|| s.equals("do") || s.equals("endwhile") || s.equals("skip")) {
			return true;
		}
		return false;
	}

	public static boolean isSymbol(char c) {
		String symbols = "+-*/();";
		return symbols.indexOf(c) != -1;
	}

	public static boolean checkSymbol(String s) {
		if (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("*") || s.equalsIgnoreCase("\\")
				|| s.equalsIgnoreCase("//") || s.equalsIgnoreCase("(") || s.equalsIgnoreCase(")")
				|| s.equalsIgnoreCase(":=") || s.equalsIgnoreCase(";")) {
			return true;
		}
		return false;
	}

	public static void writeTokensToFile(List<Token> tokens, String fileName) {
		try (FileWriter writer = new FileWriter(fileName)) {
			writer.write("Tokens:\n");
			for (Token token : tokens) {
				writer.write(token.type + " " + token.value + "\n");
			}
		} catch (IOException e) {
			System.err.println("Error writing the output file: " + e.getMessage());
		}
	}
}
