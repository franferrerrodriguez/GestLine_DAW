package ms.contract.response;

public class ResponseError {

	private String code;
	private String message;

	public ResponseError(String message) {
		this.message = message;
	}

	public ResponseError(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}