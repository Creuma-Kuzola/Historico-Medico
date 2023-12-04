package ucan.edu.HistoricoMedico.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object object) throws Exception {
        
        System.out.println("No preHandle estamos a interceptar a solicitação");
        System.out.println("____________________________________________");
        
        String requestURI = request.getRequestURI();
        String tenantID = request.getHeader("TenantID");
        
        System.out.println("RequestURI::" + requestURI +" || Pesquisar pelo TenantID  :: " + tenantID);
        System.out.println("____________________________________________");
        
        if (tenantID == null) {
            response.getWriter().write("TenantID não está presente no cabeçalho da solicitação");
            response.setStatus(400);
            return false;
        }
        TenantContext.setCurrentTenant(tenantID);
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        TenantContext.clear();
    }

}
