package ucan.edu.HistoricoMedico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ucan.edu.HistoricoMedico.interceptor.RequestInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer
{
    //@Autowired
    //MinimalInterceptor minimalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry)
    {
        registry.addInterceptor(new RequestInterceptor());
    }
}
