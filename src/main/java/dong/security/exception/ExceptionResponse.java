package dong.security.exception;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private final SimpleDateFormat FOMAT = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss.SSSSSSSS");

	private String errorTimestamp = new Timestamp(System.currentTimeMillis()).toString();
	private HttpStatus httpStatus;
	private String errorMessage;
	private String requestedUri;
	
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestedUri() {
		return requestedUri;
	}
	public void setRequestedUri(String requestedUri) {
		this.requestedUri = requestedUri;
	}
	public String getErrorTimestamp() {
		System.out.println("\n\n from geeting " + FOMAT.format(errorTimestamp));
		return errorTimestamp;
	}
	
}
