package com.ajith.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowerMockTest {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemUnderTest systemUnderTest;

    @Test
    public void testStaticMethod() {

        List<Integer> stats = Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        PowerMockito.mockStatic(UtilityClass.class);
        when(UtilityClass.staticMethod(6)).thenReturn(70);
        int result = systemUnderTest.methodCallingAStaticMethod();
        assertEquals(70, result);
        UtilityClass.staticMethod(10);
    }

    @Test
    public void testPrivateMethod() throws Exception {

        List<Integer> stats = Arrays.asList(1,2,3);
        when(dependency.retrieveAllStats()).thenReturn(stats);
        long result = Whitebox.invokeMethod(systemUnderTest, "privateMethodUnderTest");
        assertEquals(6, result);
    }

}