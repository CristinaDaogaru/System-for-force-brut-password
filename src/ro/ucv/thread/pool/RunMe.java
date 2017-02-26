package ro.ucv.thread.pool;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunMe {
		
	public static void main(String[] args) {
		
		SubIntervale subInterval = new SubIntervale(10000000, 99999999, 56);
		String password = "957EE8E4D1C6382F5329C6757FC3CA34E4D1327510DAF3BAB406DC801303A8EB".toLowerCase();
		System.out.println(password);
		
		subInterval.CalculareInterval();
		
		List<Long> intervale = subInterval.getListEl();
		
		ExecutorService executor = Executors.newFixedThreadPool(intervale.size());
		
		Collection collection = new ArrayList<PasswordTester>( );

		for(int i=0 ; i < intervale.size() ; i+=2)
		{
			PasswordTester pass = new PasswordTester(password ,intervale.get(i),intervale.get(i+1));
			
			collection.add(pass);
		}
		try {
			//this is called when one of the threads returns something other than null
			// all other threads are canceled
			String f= (String) executor.invokeAny(collection);
			System.out.println("Finished  - " + f);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		executor.shutdown();
		
	}

		
		

}
