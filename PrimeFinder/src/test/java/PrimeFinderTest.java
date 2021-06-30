import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class PrimeFinderTest {
    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void classExists() {
        String className = "PrimeFinder";
        try {
            Class.forName(className);
        } catch (Exception e) {
            Assert.fail("Class '" + className + "' throws " + e.toString());
        }
    }

    @Test
    public void classHasBeginField() {
        String fieldName = "begin";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        try {
            Field field = primeFinderClass.getDeclaredField(fieldName);
        } catch (Exception e) {
            Assert.fail("Field '" + fieldName + "' throws " + e.toString());
        }
    }

    @Test
    public void beginFieldTypeIsCastableAsInteger() throws Exception {
        String fieldName = "begin";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        Field field = primeFinderClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object fieldValue = field.get(primeFinder);
        try {
            Integer actualValue = (Integer) fieldValue;
        } catch (Exception e) {
            Assert.fail("Casting Field '" + fieldName + "' as Integer throws " + e.toString());
        }
    }

    @Test
    public void beginFieldStartValueIs2() throws Exception {
        String fieldName = "begin";
        Integer expectedValue = 2;
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        Field field = primeFinderClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object fieldValue = field.get(primeFinder);
        Integer actualValue = (Integer) fieldValue;
        Assert.assertEquals("Field " + fieldName + " start value", expectedValue, actualValue);
    }
}


// MyClass classInstance = new MyClass();
// Class classGotten = classInstance.getClass();
// Method method = classGotten.getDeclaredMethod(nameString,args)
// Field field = classGotten.getDeclaredField(nameString)
// both can show private stuff
// setAccessible(true/false) to access

// java: unreported exception java.lang.NoSuchFieldException; must be caught or declared to be thrown
// means you have to either catch it with try{} catch{}
// or add it to the method declaration
// public void beginFieldStartValueIs2() throws Exception{
