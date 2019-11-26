package dong.security.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerControlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UnAuthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public @ResponseBody ExceptionResponse handleUnAuthorizeCase(final UnAuthorizedException exception,
			final HttpServletRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse();
		exceptionResponse.setErrorMessage(exception.getMessage());
		exceptionResponse.setHttpStatus(HttpStatus.UNAUTHORIZED);
		exceptionResponse.setRequestedUri(request.getRequestURI());		

		return exceptionResponse;
	}

}
