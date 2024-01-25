package codingtechniques.Filter;

import java.io.IOException;
import java.util.Collections;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializerBeans;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Transactional
@Component
@Order(1)

public class JWTFilter extends OncePerRequestFilter {
	private static final Log LOG = LogFactory.getLog(JWTFilter.class);

	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res, @NonNull FilterChain chain)
			throws ServletException, IOException {

		Collections.list(req.getHeaderNames()).forEach((header -> {
			LOG.info("Header :{}={}" + header + req.getHeader(header));
		}));

		try {
			LOG.info("Démarrage d'une transaction pour demande : {}" + req.getRequestURI());

			chain.doFilter(req, res);
			LOG.info("Validation d'une transaction pour demande :{}" + req.getRequestURI());

			LOG.info("Demande de journalisation {}: " + req.getMethod() + req.getRequestURI());
			LOG.info("Réponse de journalisation : {}" + res.getContentType());
		} catch (Exception e) {
			LOG.error("Erreur dans le filtre", e);
			res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		chain.doFilter(req, res);

	}
	@Bean
public CommandLineRunner cmdLineRunner(ApplicationContext context) {
    return args -> {
        ServletContextInitializerBeans scib = new ServletContextInitializerBeans(context,
                FilterRegistrationBean.class, DelegatingFilterProxyRegistrationBean.class);
        System.out.println("----");
        scib.iterator().forEachRemaining(s -> {
            System.out.println(s);
        });
    };
}

}
