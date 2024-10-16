package trial;

import java.util.ArrayList;
import java.util.List;

class Rotor {
	private final String wiring;
	int position;

	public Rotor(String wiring) {
		this.wiring = wiring;
		this.position = 0;
	}

	public char encrypt(char input) {
		int index = (input - 'A' + position) % 26;
		char encryptedChar = wiring.charAt(index);
		return (char) ((encryptedChar - position - 'A' + 26) % 26 + 'A');
	}

	public void rotate() {
		position = (position + 1) % 26;
	}
}

class EnigmaMachine {
	private final List<Rotor> rotors;
	private final Rotor reflector;

	public EnigmaMachine(Rotor[] rotors, Rotor reflector) {
		this.rotors = new ArrayList<>(List.of(rotors));
		this.reflector = reflector;
	}

	public char encrypt(char input) {
		for (int i = rotors.size() - 1; i >= 0; i--) {
			input = rotors.get(i).encrypt(input);
		}
		input = reflector.encrypt(input);
		for (Rotor rotor : rotors) {
			input = rotor.encrypt(input);
		}
		rotors.get(0).rotate();
		for (int i = 0; i < rotors.size() - 1; i++) {
			if ((rotors.get(i).position + 1) % 26 == 0) {
				rotors.get(i + 1).rotate();
			}
		}
		return input;
	}
}

public class EnigmaCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rotor rotorI = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ");
		Rotor rotorII = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE");
		Rotor rotorIII = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO");

		// Create a reflector rotor
		Rotor reflector = new Rotor("YRUHQSLDPXNGOKMIEBFZCWVJAT");

		// Create an Enigma machine with the rotors and reflector
		EnigmaMachine enigmaMachine = new EnigmaMachine(new Rotor[] { rotorI, rotorII, rotorIII }, reflector);

		// Message to encrypt
		String message = "HELLO";

		// Encrypt the message
		StringBuilder encryptedMessage = new StringBuilder();
		for (char letter : message.toCharArray()) {
			if (Character.isAlphabetic(letter)) {
				encryptedMessage.append(enigmaMachine.encrypt(Character.toUpperCase(letter)));
			} else {
				encryptedMessage.append(letter);
			}
		}

		System.out.println("Original Message: " + message);
		System.out.println("Encrypted Message: " + encryptedMessage.toString());
	}

}
