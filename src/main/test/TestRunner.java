import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {
		
		// ---- Test Domain objects ----
		org.junit.runner.Result result = JUnitCore.runClasses(UserTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    result = JUnitCore.runClasses(FacultyTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(RoleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(ResultTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(SensorTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(LaboratoryTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(GroupTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    // ---- Test Table Modules ----
	    result = JUnitCore.runClasses(UserTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(FacultyTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(RoleTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(ResultTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(SensorTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(LaboratoryTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	    result = JUnitCore.runClasses(GroupTableModuleTest.class);
		for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	    }
			
	    System.out.println(result.wasSuccessful());
	    
	}
	
}
