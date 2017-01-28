package be.vdab.filters;


import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("*.htm")
public class JPAFilter implements Filter {
	
// de entityManagerFactory blijft in het RAM tijdens de hele levensduur van de website
private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("fietsacademy");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	// voor vreemde tekens op te vangen in de requests
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {
		entityManagerFactory.close();	// sluit de database connection als de website stopt
	}
	
	public static EntityManager getEntityManager() {	// je kan hem overal in de website oproepen
		return entityManagerFactory.createEntityManager();	// maakt een EntityManager aan
	}
	
}