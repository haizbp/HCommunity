package hm.model;

import java.io.Serializable;

public class Response implements Serializable {

	private int code = 200;
	private String message;
	private Object data;

	public Response() {
		// empty
	}

	public Response(Object data) {
		super();
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
