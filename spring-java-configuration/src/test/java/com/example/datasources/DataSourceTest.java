package com.example.datasources;

import com.sun.xml.internal.rngom.digested.DSchemaBuilderImpl;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

import static org.junit.Assert.*;

/**
 * Created by anil on 3/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
public class DataSourceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testDevProfileDataSource() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.register(DataSourceConfig.class);
        ctx.refresh();
        DataSource dataSource = ctx.getBean("dataSourceForDev", DataSource.class);
        assertNotNull(dataSource);
        exception.expect(NoSuchBeanDefinitionException.class);
        ctx.getBean("dataSourceForProd");
    }

    @Test
    public void testProdProfileDataSource() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.getEnvironment().setDefaultProfiles("default");
        ctx.register(DataSourceConfig.class);
        ctx.refresh();
        assertNotNull(ctx.getBean("dataSourceForProd"));
        exception.expect(NoSuchBeanDefinitionException.class);
        ctx.getBean("defaultDataSource");
    }

    @Test
    public void testDefaultProfile() throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setDefaultProfiles("default");
        ctx.register(DataSourceConfig.class);
        ctx.refresh();
        assertNotNull(ctx.getBean("defaultDataSource"));
        exception.expect(NoSuchBeanDefinitionException.class);
        ctx.getBean("dataSourceForDev");
        //exception.expect(NoSuchBeanDefinitionException.class);
        System.out.println("Is it executed");
        ctx.getBean("dataSourceForProd");
    }
}
