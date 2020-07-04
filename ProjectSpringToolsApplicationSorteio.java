package br.com.imepac.site;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class ProjectSpringToolsApplicationSorteio {

	public void onStartup(ServletContext container) {
        XmlWebApplicationContext appContext = new XmlWebApplicationContext();
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(appContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/scripts/*");
    }
	
	@Scope("singleton")
	@Bean
	public ModelAndView getModelAndView() {
		return new ModelAndView();
	}
	

	@Bean
	public ViewResolver internalResourceViewResolver() {
	    InternalResourceViewResolver bean = new InternalResourceViewResolver();
	    bean.setPrefix("/WEB-INF/JSP/");
	    bean.setSuffix(".jsp");
	    return bean;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectSpringToolsApplicationSorteio.class, args);
	}

}
