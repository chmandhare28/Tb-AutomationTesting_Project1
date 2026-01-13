package AdvanceseleniumjUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJunit {
	
@BeforeClass
 public static void beforeClass() {
	System.out.println("Before Class");
}
@Before
public void before() {
	System.out.println("Before");
}
@Test
public void test() {
	System.out.println("Test"); 
}
@Test
public void test2() {
	System.out.println("Test2"); 
}
@After
public void after() {
	System.out.println("After");
}

@AfterClass
public static void afterClass() {
	System.out.println("After Class");
}

}
