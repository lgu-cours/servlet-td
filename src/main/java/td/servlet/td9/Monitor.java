package td.servlet.td9;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class Monitor
 */
public class Monitor implements Filter {

    /**
     * Default constructor. 
     */
    public Monitor() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @return current time in milliseconds
	 *
	 */
	private long getTime() {
		// utiliser System.nanoTime() si besoin de plus de precision
		return System.currentTimeMillis();
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		final HttpServletRequest httpRequest = ((HttpServletRequest) request);
		final long startTime = getTime();
		
		try {
			//--- On laisse passer ...
			chain.doFilter(request, response);
			
		} finally {
			final long elapsedTime = getTime() - startTime;

			final StringBuilder sb = new StringBuilder();
			sb.append(" request URI = ");
			sb.append(httpRequest.getRequestURI() );
			sb.append(" duration = ");
			sb.append(elapsedTime);
			sb.append(" ms");
			
			System.out.println( sb.toString() );
		}
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
