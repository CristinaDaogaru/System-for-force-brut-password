package ro.ucv.thread.pool;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class PasswordTester implements Callable<String> {

	
	//TODO: check off all the todos
	
	/**
	 * TODO: this constructor should receive an interval where to generate passwords 
	 * and the password hash 
	 * TODO: all three parameters must be saved locally just like name
	 * 
	 * @param intervalStart int
	 * @param intervalEnd int
	 * @param hash String
	 * @param name name of the PasswordTester instance
	 * 
	 */
	
	private String password;
	private long intervalStart;
	private long intervalEnd;
	
	public PasswordTester(String password,long intervalStart,long intervalEnd){
		
		
		this.password = password;
		this.intervalStart = intervalStart;
		this.intervalEnd = intervalEnd;
		// at this point , name dies!!
	
		
	
	}
	@Override
	public String call() throws Exception {
		
		System.out.println(Thread.currentThread().getId()+": i'm starting ");
		
		//TODO: all passwords from intervalStart to intervalEnd must be hashed using sha256 
		//TODO: and checked if their sha256 hash is equal to  the locally saved hash from the constructor
		
		
		for(Long i = intervalStart ; i < intervalEnd ; i++ )
		{
			
			if(sha256(i).equals(password))
			{
				System.out.println("Parola gasita: " + i );
				System.out.println(Thread.currentThread().getId() + ": i= " + i );
				return i.toString(); 
				
			}
			
		}
		
		return  ": i finished !"; 
		//return null;
	}
	
	
	String sha256(long possiblePassword) {
		 try{
		        MessageDigest digest = MessageDigest.getInstance("SHA-256");
		        byte[] hash = digest.digest((""+possiblePassword).getBytes("UTF-8"));
		        StringBuffer hexString = new StringBuffer();

		        for (int i = 0; i < hash.length; i++) {
		            String hex = Integer.toHexString(0xff & hash[i]);
		            if(hex.length() == 1) hexString.append('0');
		            hexString.append(hex);
		        }

		        return hexString.toString();
		    } catch(Exception ex){
		       throw new RuntimeException(ex);
		    }
	}

}
