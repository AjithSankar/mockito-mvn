package com.ajith.powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class)
public class PowerMockConstructorTest {

    @InjectMocks
    SystemUnderTest systemUnderTest;
    @Mock
    ArrayList mockList;

    @Test
    public void testConstructorMethod() throws Exception {

        when(mockList.size()).thenReturn(5);
        PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn( mockList);
        int result = systemUnderTest.methodUsingAnArrayListConstructor();
        assertEquals(5, result);

    }

}