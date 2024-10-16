package trial;

import java.util.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;



public class PR3_1 {
	enum TokenType {
		NUMBER, SYMBOL, EOF, IDENTIFIER, ERROR
	}

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
		public Token(String value, String type) {
			super();
			this.value = value;
			this.type = type;
		}
		
		
	}

	static class Scanner {
		private final String input;
		private int pos = 0;
		private char currentChar;

		Scanner(String input) {
			this.input = input;
			currentChar = input.charAt(pos);
		}

		void advance() {
			pos++;
			if (pos < input.length()) {
				currentChar = input.charAt(pos);
			} else {
				currentChar = 0; // Null character to denote end of input
			}
		}

		Token getNextToken() {
			while (currentChar != 0) {
				if (Character.isWhitespace(currentChar)) {
					advance();
					continue;
				}
				if (Character.isDigit(currentChar)) {
					StringBuilder result = new StringBuilder();
					while (Character.isDigit(currentChar)) {
						result.append(currentChar);
						advance();
					}
					return new Token("NUMBER", result.toString());
				}
				if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'
						|| currentChar == '(' || currentChar == ')') {
					String symbol = String.valueOf(currentChar);
					advance();
					return new Token("SYMBOL", symbol);
				}
				throw new RuntimeException("Invalid character: " + currentChar);
			}
			return new Token("ERROR", null);
		}
	}

	public static class ASTNode {
		private String value;
		private List<ASTNode> children;

		// Patterns
		private static final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");
		private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");
		private static final Pattern SYMBOL_PATTERN = Pattern.compile("[+\\-*/()]");

		public ASTNode(String value) {
			this.value = value;
			this.children = new ArrayList<>();
		}

		public ASTNode(String value, List<ASTNode> children) {
			this.value = value;
			this.children = children;
		}

		@Override
		public String toString() {
			return toString(0);
		}

		private String toString(int level) {
			String ret = "\t".repeat(level) + value + " : " + getTokenType() + "\n";
			for (ASTNode child : children) {
				ret += child.toString(level + 1);
			}
			return ret;
		}

		private TokenType getTokenType() {
			if (IDENTIFIER_PATTERN.matcher(value).matches()) {
				return TokenType.IDENTIFIER;
			} else if (NUMBER_PATTERN.matcher(value).matches()) {
				return TokenType.NUMBER;
			} else if (SYMBOL_PATTERN.matcher(value).matches()) {
				return TokenType.SYMBOL;
			} else {
				return TokenType.ERROR;
			}
		}

		public double evaluate() {
			switch (getTokenType()) {
			case NUMBER:
				return Double.parseDouble(value);
			case IDENTIFIER:
				throw new RuntimeException("Identifier evaluation not supported");
			case SYMBOL:
				switch (value) {
				case "+":
					return children.stream().mapToDouble(ASTNode::evaluate).sum();
				case "-":
					return children.get(0).evaluate() - children.get(1).evaluate();
				case "*":
					return children.get(0).evaluate() * children.get(1).evaluate();
				case "/":
					double denominator = children.get(1).evaluate();
					if (denominator == 0) {
						throw new RuntimeException("Division by zero");
					}
					return Math.round(children.get(0).evaluate() / denominator);
				default:
					throw new RuntimeException("Unknown operator");
				}
			default:
				throw new RuntimeException("Invalid token type");
			}
		}
	}

	public static class Parser {
		private List<Token> tokens;
		private int currentTokenIndex;

		public Parser(List<Token> tokens) {
			this.tokens = tokens;
			this.currentTokenIndex = 0;
		}

		private Token getCurrentToken() {
			return currentTokenIndex < tokens.size() ? tokens.get(currentTokenIndex) : null;
		}

		private Token popToken() {
			return currentTokenIndex < tokens.size() ? tokens.get(currentTokenIndex++) : null;
		}

		public ASTNode parseExpression() {
			ASTNode term = parseTerm();
			while (currentTokenIndex < tokens.size() && getCurrentToken().type == "SYMBOL"
					&& getCurrentToken().value.equals("+")) {
				popToken(); // Pop the '+' symbol
				term = new ASTNode("+", List.of(term, parseTerm()));
			}
			return term;
		}

		private ASTNode parseTerm() {
			ASTNode factor = parseFactor();
			while (currentTokenIndex < tokens.size() && getCurrentToken().type == "SYMBOL"
					&& getCurrentToken().value.equals("-")) {
				popToken(); // Pop the '-' symbol
				factor = new ASTNode("-", List.of(factor, parseFactor()));
			}
			return factor;
		}

		private ASTNode parseFactor() {
			ASTNode piece = parsePiece();
			while (currentTokenIndex < tokens.size() && getCurrentToken().type == "SYMBOL"
					&& getCurrentToken().value.equals("/")) {
				popToken(); // Pop the '/' symbol
				piece = new ASTNode("/", List.of(piece, parsePiece()));
			}
			return piece;
		}

		private ASTNode parsePiece() {
			ASTNode element = parseElement();
			while (currentTokenIndex < tokens.size() && getCurrentToken().type == "SYMBOL"
					&& getCurrentToken().value.equals("*")) {
				popToken(); // Pop the '*' symbol
				element = new ASTNode("*", List.of(element, parseElement()));
			}
			return element;
		}

		private ASTNode parseElement() {
			Token currentToken = getCurrentToken();
			if (currentToken != null) {
				if (currentToken.type == "SYMBOL" && currentToken.value.equals("(")) {
					popToken(); // Pop the '(' symbol
					ASTNode expressionTree = parseExpression();
					if (getCurrentToken() != null && getCurrentToken().type == "SYMBOL"
							&& getCurrentToken().value.equals(")")) {
						popToken(); // Pop the ')' symbol
						return expressionTree;
					} else {
						throw new RuntimeException("Error: Mismatched parentheses in expression.");
					}
				} else if (currentToken.type == "NUMBER") {
					popToken();
					return new ASTNode(currentToken.value);
				} else if (currentToken.type == "IDENTIFIER") {
					popToken();
					return new ASTNode(currentToken.value);
				} else {
					throw new RuntimeException("Error: Unexpected token - " + currentToken.value);
				}
			}
			throw new RuntimeException("Error: Unexpected end of input.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String input = "3 * (5 + 10 / 3 - 1)";
//        printTokens(input);
//        Parser parser1 = new Parser(input);
//        ASTNode ast1 = parser1.expression();
//        System.out.println("\nAST:");
//        printAST(ast1, "");
//        System.out.println("\nOutput: " + evaluateAST(ast1));

		if (args.length != 2) {
			System.out.println("Usage: java PR3_1 <input_file> <output_file>");
			System.exit(1);
		}

		String inputFile = args[0];
		String outputFile = args[1];

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

	            String line;
	            while ((line = reader.readLine()) != null) {
	                line = line.trim();
	                writer.write("Tokens:\n");
	                List<Token> tokens = tokenize(line);
	                for (Token token : tokens) {
	                    writer.write(token.value + " : " + token.type + "\n");
	                }

	                writer.write("AST:\n");
	                try {
	                    Parser parser = new Parser(tokens);
	                    ASTNode ast = parser.parseExpression();
	                    writer.write(ast.toString());

	                    try {
	                        double result = ast.evaluate();
	                        writer.write("Output: " + String.format("%.0f", result) + "\n");
	                    } catch (Exception e) {
	                        writer.write("Evaluator Error: " + e.getMessage() + "\n");
	                    }

	                } catch (Exception e) {
	                    writer.write("Parser Error: " + e.getMessage() + "\n");
	                }
	            }

	        } catch (IOException e) {
	            System.out.println("An error occurred: " + e.getMessage());
	        }
	    }
	
	public static List<Token> tokenize(String line){
		List<Token> tokens = new ArrayList<Token>();
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
				if(line.substring(index,endIndex).length() > 100) {
					tokens.add(new Token("Length limit exceeded", line.substring(index,endIndex)));
				} else {
					tokens.add(new Token("NUMBER", line.substring(index, endIndex)));
					index = endIndex;
				}
				
			} else if (Character.isAlphabetic(currentChar)) { //check to see IDENTIFIER token
				int endIndex = index;
				while (endIndex < length && (Character.isAlphabetic(line.charAt(endIndex))
						|| Character.isDigit(line.charAt(endIndex)))) {
					endIndex++;
				}
				if(line.substring(index,endIndex).length() > 100) {
					tokens.add(new Token("Length limit exceeded", line.substring(index,endIndex)));
				} else {
					tokens.add(new Token("IDENTIFIER", line.substring(index, endIndex)));
					index = endIndex;
				}
				
			} else if (isSymbol(currentChar)) {
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
		String symbols = "+-*/()";
		return symbols.indexOf(c) != -1;
	}
}
