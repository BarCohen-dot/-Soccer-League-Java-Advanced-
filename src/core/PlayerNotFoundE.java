package core;

public class PlayerNotFoundE extends Exception {
	
	// Unique identifier
	private static final long serialVersionUID = 1L; // To use files

	//constructor
	public PlayerNotFoundE(String message) {
        super(message);
    }
}
