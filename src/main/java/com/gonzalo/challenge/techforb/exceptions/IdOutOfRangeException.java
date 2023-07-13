package com.gonzalo.challenge.techforb.exceptions;

public class IdOutOfRangeException extends IllegalArgumentException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdOutOfRangeException() {
        super("ID out of range - exception");
    }

    public IdOutOfRangeException(String mensaje) {
        super(mensaje);
    }
}
