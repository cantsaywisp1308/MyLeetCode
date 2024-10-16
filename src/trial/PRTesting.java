package trial;
import java.util.*;
import java.io.*;

public class PRTesting {
	
	public static class Token { //used to define tokens
	    String type;
	    String value;

	    public Token(String type, String value) {
	        this.type = type;
	        this.value = value;
	    }

	    @Override
	    public String toString() {
	        return type + " : " + value;
	    }
	}

	public static class Scanner { //Scan each row of the input file and define tokens
	    private String input;
	    private int position;

	    public Scanner(String input) {
	        this.input = input;
	        this.position = 0;
	    }

	    public List<Token> scan() { //define tokens here
	        List<Token> tokens = new ArrayList<>();

	        while (position < input.length()) {
	            char currentChar = input.charAt(position);

	            if (Character.isDigit(currentChar)) {
	                StringBuilder number = new StringBuilder();
	                while (position < input.length() && Character.isDigit(input.charAt(position))) {
	                    number.append(input.charAt(position));
	                    position++;
	                }
	                tokens.add(new Token("NUMBER", number.toString()));
	            } else if (Character.isLetter(currentChar)) {
	                StringBuilder identifier = new StringBuilder();
	                while (position < input.length() && (Character.isLetter(input.charAt(position)) || Character.isDigit(input.charAt(position)))) {
	                    identifier.append(input.charAt(position));
	                    position++;
	                }
	                tokens.add(new Token("IDENTIFIER", identifier.toString()));
	            } else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/' || currentChar == '(' || currentChar == ')') {
	                tokens.add(new Token("SYMBOL", String.valueOf(currentChar)));
	                position++;
	            } else if (Character.isWhitespace(currentChar)) {
	                position++;
	            } else {
	                // Handle invalid characters
	                System.err.println("Error: Invalid character encountered");
	                System.exit(1);
	            }
	        }

	        return tokens;
	    }
	}
	
	public static class Parser { //parse into the tree
	    private List<Token> tokens;
	    private int currentTokenIndex;

	    public Parser(List<Token> tokens) {
	        this.tokens = tokens;
	        this.currentTokenIndex = 0;
	    }

	    public Node parse() {
	        return expression();
	    }

	    private Node expression() {
	        Node left = term();
	        while (match("SYMBOL", "+")) {
	            Node right = term();
	            left = new Node("SYMBOL", "+", left, right);
	        }
	        return left;
	    }

	    private Node term() {
	        Node left = factor();
	        while (match("SYMBOL", "-")) {
	            Node right = factor();
	            left = new Node("SYMBOL", "-", left, right);
	        }
	        return left;
	    }

	    private Node factor() {
	        Node left = piece();
	        while (match("SYMBOL", "/")) {
	            Node right = piece();
	            left = new Node("SYMBOL", "/", left, right);
	        }
	        return left;
	    }

	    private Node piece() {
	        Node left = element();
	        while (match("SYMBOL", "*")) {
	            Node right = element();
	            left = new Node("SYMBOL", "*", left, right);
	        }
	        return left;
	    }

	    private Node element() {
	        if (match("SYMBOL", "(")) {
	            Node expr = expression();
	            if (!match("SYMBOL", ")")) {
	                reportError("')'");
	            }
	            return expr;
	        } else if (match("NUMBER", null)) {
	            return new Node("NUMBER", tokens.get(currentTokenIndex - 1).value);
	        } else if (match("IDENTIFIER", null)) {
	            return new Node("IDENTIFIER", tokens.get(currentTokenIndex - 1).value);
	        } else {
	            reportError("an element");
	            return null; // unreachable
	        }
	    }

	    private boolean match(String expectedType, String expectedValue) {
	        if (currentTokenIndex < tokens.size()) {
	            Token currentToken = tokens.get(currentTokenIndex);
	            if (currentToken.type.equals(expectedType) && (expectedValue == null || currentToken.value.equals(expectedValue))) {
	                currentTokenIndex++;
	                return true;
	            }
	        }
	        return false;
	    }

	    private void reportError(String expected) {
	        Token errorToken = tokens.get(currentTokenIndex);
	        System.err.println("Error: Expected " + expected + " but found " + errorToken.type + " : " + errorToken.value);
	        System.exit(1);
	    }
	}

	public static class Node {
	    String type;
	    String value;
	    List<Node> children;

	    public Node(String type, String value) {
	        this.type = type;
	        this.value = value;
	        this.children = new ArrayList<>();
	    }

	    public Node(String type, String value, Node... children) {
	        this(type, value);
	        this.children.addAll(Arrays.asList(children));
	    }

	    public String print(int depth) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < depth; i++) {
	            sb.append("  ");
	        }
	        sb.append(value).append(" : ").append(type).append("\n");
	        for (Node child : children) {
	            sb.append(child.print(depth + 1));
	        }
	        return sb.toString();
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
            System.err.println("Usage: java LexpParser input_file output_file");
            System.exit(1);
        }
		String exp = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]));
             PrintWriter writer = new PrintWriter(args[1])) {

            String line;
            while ((line = reader.readLine()) != null) {
            	exp+= line;
                List<Token> tokens = new Scanner(line).scan();

                writer.println("Tokens:");
                for (Token token : tokens) {
                    writer.println(token);
                }

                writer.println("AST:");
                Node root = new Parser(tokens).parse();
                writer.println(root.print(0));
            }

        } catch (IOException e) {
            System.err.println("Error reading or writing files");
            System.exit(1);
        }
    }
}
