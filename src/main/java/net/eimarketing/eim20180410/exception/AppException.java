package net.eimarketing.eim20180410.exception;

public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String msg;

	public AppException(String message, Throwable cause) {
		super(message, cause);
		this.msg = message;
	}

	public AppException(String message) {
		super(message);
		this.msg = message;
	}

	public String getMsg() {
		return msg;
	}

}
