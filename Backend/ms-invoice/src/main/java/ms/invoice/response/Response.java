package ms.invoice.response;

public class Response<T> {

	private T result;
	private ResponseError error;

	public Response(T result) {
		this.result = result;
	}

	public Response(ResponseError error) {
		this.error = error;
	}

	public Response(T result, ResponseError error) {
		this.result = result;
		this.error = error;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public ResponseError getError() {
		return error;
	}

	public void setError(ResponseError error) {
		this.error = error;
	}

}