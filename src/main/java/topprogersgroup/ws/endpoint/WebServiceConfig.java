package topprogersgroup.ws.endpoint;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        // MessageDispatcherServlet позволяет обмениваться XML-сообщениями через http
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        // внедрение ApplicationContext в MessageDispatcherServlet
        // для автоматического обнаружения бинов, связанных с web-сервисами
                messageDispatcherServlet.setApplicationContext(context);
        return new ServletRegistrationBean(messageDispatcherServlet, "topprogersgroup/ws/*");
    }

    @Bean
    public Wsdl11Definition defaultWsdl11Definition() {
        SimpleWsdl11Definition wsdl11Definition = new SimpleWsdl11Definition();
        wsdl11Definition.setWsdl(new ClassPathResource("/wsdl/ForeignSystem.wsdl"));
        return wsdl11Definition;
    }
}
