import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class JavaTests {
	@Test
	public void compareTwoValueTypes() {

		int A = 1;
		int B = 1;

		boolean result = (A == B);
		boolean expectedResult = true;

		assertEquals(result, expectedResult, "A should equal B.");
	}

	@Test
	public void compareTwoReferenceTypes() {

		String A = "Hello world";
		String B = "Hello world";

		boolean result = (A == B);
		boolean expectedResult = true;

		assertEquals(result, expectedResult, "A should equal B.");
	}

	@Test
	public void compareTwoReferenceTypesDotEquals() {

		String A = "Hello world";
		String B = "Hello world";

		boolean expectedResult = true;

		assertEquals(A.equals(B),expectedResult, "A equals B.");
	}

	@Test
	public void demonstrateANDoperators() {

		int a=10;  
		int b=5;  
		int c=20;  

		boolean expectedResult = false;

		assertEquals(a<b&&a<c,expectedResult, "false && true should equal false ");
		assertEquals(a<b&a<c,expectedResult, "false & true should equal false  ");
	}

	@Test
	public void demonstrateORoperators() {

		int a=10;  
		int b=5;  
		int c=20;  

		boolean expectedResult = true;

		assertEquals(a>b||a<c,expectedResult, "2nd condition expected to be checked only if 1st was false");
		assertEquals(a>b|a<c,expectedResult, "Expected to check both condistions whether 1st was true or false");
	}

	@Test
	public void demonstrateUnaryPostIncrementOperator() {

		int number = 1;
		number++;

		int expectedNumber = 2;

		assertEquals(number,expectedNumber, "Number was expected to be incremented to 2");
	}

	@Test
	public void demonstrateUnaryPreDecrementOperator() {

		int number = 2;
		--number;

		int expectedNumber = 1;

		assertEquals(number,expectedNumber, "Number was expected to be deccremented to 1");
	}

	@Test
	public void demonstrateBooleanTrueFalseUsingNot() {

		boolean expecteBoolean = true;
		boolean testBoolean = false;

		if (testBoolean != true) {
			testBoolean = true;
		}

		assertEquals(testBoolean, expecteBoolean, "Number was expected to be deccremented to 1");
	}

	@Test
	public void demonstrateTwoIFstatementsNoESLEs() {

		int number = 10;
		int expectedNumber = 200;

		if(number > 0) {
			if (number < 11) {
				number = 200;
			}
		}

		assertEquals(number, expectedNumber, "Number was expected to be 200 since 10 is greater than 0 and 10 is less than 11");
	}

	@Test
	public void demonstrateIfElseStatements() {

		int number = 10;
		int expectedNumber = 200;

		if(number < 0) {
			number = 400;
		}
		else {
			number = 200;
		}


		assertEquals(number, expectedNumber, "Number was expected to be 200 since 10 is not less than 0");
	}

	@Test
	public void demonstrateNestedForLoop() {

		int[][] testArray = { {5, 4, 3, 2, 1}, {7, 8, 9, 10, 11} };
		int [][] expectedArray = { {5, 4, 3, 2, 1}, {7, 8, 9, 10, 11} };

        for (int[] array : testArray)
        {
            for (int i : array)
            {
                System.out.print(i+" ");
            }
            System.out.println("");
        }

		assertEquals(testArray, expectedArray, "Number was expected to be {5, 4, 3, 2, 1}, {7, 8, 9, 10, 11} ");
	}
	
	@Test
	public void demonstrateTryCatch() {
		
		try {
		      int divideByZero = 5 / 0;
		      System.out.println("Rest of code in try block");
		    }

		    catch (ArithmeticException e) {
		      System.out.println("ArithmeticException => " + e.getMessage());
		    }
	}
	
	@Test
	public void demonstrateForEachLoop() {


	    String[] arrayList = {"Pizza", "Coffee"};
	    String[] expectedArrayList = {"Pizza", "Coffee"};
	    
	    for(int i = 0; i< arrayList.length; i++){

	    	System.out.println(arrayList[i]);

	    	}

		assertEquals(arrayList, expectedArrayList, "Words were expected to be {Pizza, Coffee} ");
	}
}
