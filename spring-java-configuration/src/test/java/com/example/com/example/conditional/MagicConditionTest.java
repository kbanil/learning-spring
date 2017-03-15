package com.example.com.example.conditional;

import com.example.conditional.MagicConditionConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by anil on 3/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MagicConditionConfig.class)
@ActiveProfiles("dev,prod")
public class MagicConditionTest {

    @Autowired
    private Object someObject;

    @Test
    public void testMagicCondition() throws Exception {
        assertNotNull(someObject);
    }
}
