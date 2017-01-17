/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @author Marco
 */
public class SecurityFilter implements Filter {

    List<String> FuncionarioActions = Arrays.asList("/home.jsp");

    List<String>[] userActions;

    public SecurityFilter() {
        userActions = (List<String>[]) new List[2];
        userActions[1] = FuncionarioActions;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession ses = req.getSession();
        String LOGIN = "/SistemaDecomisos/login.jsp";
        String SEGURIDAD = "/SistemaDecomisos/ErrorSeguridad.jsp";
        String uri = req.getRequestURI().substring(req.getContextPath().length());
        if (uri.equals("/Servlet")) {
            String action = request.getParameter("action");
            if (action == null) {
                resp.sendRedirect(SEGURIDAD);
            }
            uri = uri + "_" + action;
        }
        if (!(userActions[1].contains(uri))) { // open access
            chain.doFilter(request, response);
        } else {  // restricted access*/
            Usuario user = (Usuario) ses.getAttribute("usuario");

            if (user == null ) {
                resp.sendRedirect(LOGIN);
            } else {
                chain.doFilter(request, response);

            }
            /*else{
             resp.sendRedirect(SEGURIDAD);
             }*/
            /*else{
             if (userActions[user.getTipo()].contains(uri)){
             chain.doFilter(request,response);
             }
             else{
             resp.sendRedirect(SEGURIDAD);
             }
             }*/

        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}
