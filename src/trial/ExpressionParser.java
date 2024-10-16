package trial;

import java.io.PrintWriter;
import java.util.*;

public class ExpressionParser {
	// Token Types
	enum TokenType {
		NUMBER, SYMBOL, EOF
	}

	static class Token {
		TokenType type;
		String value;

		Token(TokenType type, String value) {
			this.type = type;
			this.value = value;
		}

		@Override
		public String toString() {
			return value + " : " + type;
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
					return new Token(TokenType.NUMBER, result.toString());
				}
				if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/'
						|| currentChar == '(' || currentChar == ')') {
					String symbol = String.valueOf(currentChar);
					advance();
					return new Token(TokenType.SYMBOL, symbol);
				}
				throw new RuntimeException("Invalid character: " + currentChar);
			}
			return new Token(TokenType.EOF, null);
		}
	}

	static class ASTNode {
		String value;
		ASTNode left;
		ASTNode right;

		ASTNode(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + (left != null || right != null ? " : SYMBOL" : " : NUMBER");
		}
	}

	static class Parser {
		private final Scanner scanner;
		private Token currentToken;

		Parser(String input) {
			this.scanner = new Scanner(input);
			this.currentToken = scanner.getNextToken();
		}

		void eat(TokenType type) {
			if (currentToken.type == type) {
				currentToken = scanner.getNextToken();
			} else {
				throw new RuntimeException("Expected token " + type + ", but found " + currentToken.type);
			}
		}

		ASTNode factor() {
			Token token = currentToken;
			if (token.type == TokenType.NUMBER) {
				eat(TokenType.NUMBER);
				return new ASTNode(token.value);
			} else if (token.value.equals("(")) {
				eat(TokenType.SYMBOL);
				ASTNode node = expression();
				eat(TokenType.SYMBOL);
				return node;
			}
			throw new RuntimeException("Factor error: " + token.value);
		}

		ASTNode term() {
	        ASTNode node = factor();
	        while (currentToken.type == TokenType.SYMBOL &&
	               (currentToken.value.equals("*") || currentToken.value.equals("/"))) {
	            Token token = currentToken;
	            eat(TokenType.SYMBOL);
	            ASTNode newNode = new ASTNode(token.value);
	            newNode.left = node;
	            newNode.right = factor();
	            node = newNode;
	        }
	        return node;
	    }

		ASTNode expression() {
	        ASTNode node = term();
	        while (currentToken.type == TokenType.SYMBOL &&
	               (currentToken.value.equals("+") || currentToken.value.equals("-"))) {
	            Token token = currentToken;
	            eat(TokenType.SYMBOL);

	            // This is where we need to modify the structure.
	            // If the next token is an addition or subtraction, and the current node is a term with
	            // multiplication or division, we need to rotate the AST nodes to maintain precedence.
	            if ((token.value.equals("+") || token.value.equals("-")) &&
	                (node.value.equals("*") || node.value.equals("/"))) {
	                ASTNode newNode = new ASTNode(token.value);
	                newNode.left = node.left;
	                newNode.right = term();
	                node.left = newNode;
	            } else {
	                ASTNode newNode = new ASTNode(token.value);
	                newNode.left = node;
	                newNode.right = term();
	                node = newNode;
	            }
	        }
	        return node;
	    }
	}

	static int evaluateAST(ASTNode node) {
		if (node.left == null && node.right == null) {
			return Integer.parseInt(node.value);
		}
		switch (node.value) {
		case "+":
			return evaluateAST(node.left) + evaluateAST(node.right);
		case "-":
			return evaluateAST(node.left) - evaluateAST(node.right);
		case "*":
			return evaluateAST(node.left) * evaluateAST(node.right);
		case "/":
			return evaluateAST(node.left) / evaluateAST(node.right);
		default:
			throw new RuntimeException("Invalid operator: " + node.value);
		}
	}

	static void printTokens(String input, PrintWriter writer) {
		Scanner scanner = new Scanner(input);
		Token token = scanner.getNextToken();
		writer.println("Tokens:");
		while (token.type != TokenType.EOF) {
			writer.println(token);
			token = scanner.getNextToken();
		}
	}

	static void printAST(ASTNode node, String prefix, PrintWriter writer) {
		if (node != null) {
			writer.println(prefix + node);
			if (node.left != null || node.right != null) {
				printAST(node.left, prefix + "  ", writer);
				printAST(node.right, prefix + "  ", writer);
			}
		}

	}

	public static void main(String[] args) {
		String input = "3 * (5 + 10 / 3 - 1)";

//		printTokens(input);
//		Parser parser1 = new Parser(input);
//		ASTNode ast1 = parser1.expression();
//		System.out.println("\nAST:");
//		printAST(ast1, "");
//		System.out.println("\nOutput: " + evaluateAST(ast1));
	}
}
