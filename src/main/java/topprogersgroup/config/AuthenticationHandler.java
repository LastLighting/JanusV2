package topprogersgroup.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException {
        Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
        authorities.forEach(authority -> {
            if(authority.getAuthority().equals("ADMIN")) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(authority.getAuthority().equals("PET_OWNER")) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/office/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(authority.getAuthority().equals("EMPLOYEE")) {
                try {
                    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/docs/home");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
