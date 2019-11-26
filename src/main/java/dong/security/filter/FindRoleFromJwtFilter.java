package dong.security.filter;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import dong.security.exception.UnAuthorizedException;

@Component
//public class RoleFindFromJwtFilter implements Filter {
public class FindRoleFromJwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		System.out.print("\n\n x-api-key is " + req.getHeader("x-api-key"));

		final String headerToken = req.getHeader("x-api-key");
		if (null == headerToken || headerToken.isEmpty()) {
			System.out.print("\n\n\n Current TimeStamp is " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()) + "\n\n");
			throw new UnAuthorizedException("UnAuthorized");
		}
		
		List<String> sList = new ArrayList<>();
		sList.add("ab");
		sList.add("cd");
		sList.add("ef");
		
		String s = sList.stream().map(String::toString).collect(Collectors.joining(" "));
		System.out.print("\n\n\n Result sList is " + s + "\n\n\n");

		HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(req);
		requestWrapper.addHeader("domain", "GSA");
		requestWrapper.addHeader("organization", "Octo");
		requestWrapper.addHeader("role", "Developer");

		chain.doFilter(requestWrapper, response);

	}

}
