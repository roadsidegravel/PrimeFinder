import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class PrimeFinderTest {
    private Integer[] referencePrimes =  {2,3,5,7,11};
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
    public void beginFieldExists() {
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
    public void beginFieldIsCastableAsInteger() throws Exception {
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

    @Test
    public void primesFieldExists() {
        String fieldName = "primes";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        try {
            Field field = primeFinderClass.getDeclaredField(fieldName);
        } catch (Exception e) {
            Assert.fail("Field '" + fieldName + "' throws " + e.toString());
        }
    }

    @Test
    public void primesFieldIsLinkedList() throws Exception {
        String fieldName = "primes";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        Field field = primeFinderClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        Object fieldValue = field.get(primeFinder);
        Assert.assertTrue(fieldValue instanceof LinkedList);
    }

    @Test
    public void primesFieldStartsEmpty() throws Exception {
        String fieldName = "primes";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        Field field = primeFinderClass.getDeclaredField(fieldName);
        field.setAccessible(true);
        LinkedList fieldValue = (LinkedList) field.get(primeFinder);
        Assert.assertTrue(fieldValue.isEmpty());
    }

    @Test
    public void calculateNextMethodExists() {
        String methodName = "calculateNext";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        try {
            Method method = primeFinderClass.getDeclaredMethod(methodName);
        } catch (Exception e) {
            Assert.fail("Method '" + methodName + "' throws " + e.toString());
        }
    }

    @Test
    public void getPrimesMethodExists() {
        String methodName = "getPrimes";
        PrimeFinder primeFinder = new PrimeFinder();
        Class primeFinderClass = primeFinder.getClass();
        try {
            Method method = primeFinderClass.getDeclaredMethod(methodName);
        } catch (Exception e) {
            Assert.fail("Method '" + methodName + "' throws " + e.toString());
        }
    }

    @Test
    public void getPrimesReturnsLinkedList(){
        String expectedValue = "java.util.LinkedList";
        String actualValue;
        PrimeFinder primeFinder = new PrimeFinder();
        actualValue = primeFinder.getPrimes().getClass().getName();
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void atStartGetPrimesReturnsEmptyLinkedList(){
        PrimeFinder primeFinder = new PrimeFinder();
        LinkedList<Integer> result = primeFinder.getPrimes();
        Assert.assertTrue("at start getPrimes should return an empty list.", result.isEmpty());
    }

    @Test
    public void calculateNextOneTimePrimesLengthMatches(){
        Integer repeats = 1;
        Integer expectedValue = repeats;
        Integer actualValue;
        PrimeFinder primeFinder = new PrimeFinder();
        for (Integer i = 0; i < repeats; i++){
            primeFinder.calculateNext();
        }
        LinkedList<Integer> result = primeFinder.getPrimes();
        actualValue = result.size();
        Assert.assertEquals(repeats +"x calculateNext, Primes length "+repeats,expectedValue,actualValue);
    }

    @Test
    public void calculateNextOneRepeatPrimesCheckLastValue(){
        Integer repeats = 1;
        Integer expectedValue = referencePrimes[repeats-1];
        Integer actualValue;
        PrimeFinder primeFinder = new PrimeFinder();
        for (Integer i = 0; i < repeats; i++){
            primeFinder.calculateNext();
        }
        LinkedList<Integer> result = primeFinder.getPrimes();
        actualValue = result.getLast();
        Assert.assertEquals(repeats +"x calculateNext, last prime found",expectedValue,actualValue);
    }

    @Test
    public void calculateNextTwoTimesPrimesLengthMatches(){
        Integer repeats = 2;
        Integer expectedValue = repeats;
        Integer actualValue;
        PrimeFinder primeFinder = new PrimeFinder();
        for (Integer i = 0; i < repeats; i++){
            primeFinder.calculateNext();
        }
        LinkedList<Integer> result = primeFinder.getPrimes();
        actualValue = result.size();
        Assert.assertEquals(repeats +"x calculateNext, Primes length "+repeats,expectedValue,actualValue);
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

// asserting for instanceof LinkedList possible
// asserting for instanceof LinkedList<Integer/String/...> not possible
// it's just how it is

// kunt geen miscasts of wrong type errors catchen
// dat zet het hele testen op de helling, want hij wilt geen een
// van de testen doen als ie zo eentje heeft dus ge weet niet
// wie wat waarom