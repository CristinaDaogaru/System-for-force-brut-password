package ro.ucv.thread.pool;

import java.util.ArrayList;
import java.util.List;

public class SubIntervale {

	private long startInterval;
	private long stopInterval;
	private long nrSubIntervale;
	
	//private List intervale = new ArrayList();
	private List<Long> intervale = new ArrayList<Long>();
	
	
	public SubIntervale(long startInterval,long stopInterval,long nrSubIntervale)
	{
		this.startInterval = startInterval;
		this.stopInterval = stopInterval;
		this.nrSubIntervale = nrSubIntervale;
		
	}
	
	
	public void CalculareInterval()
	{
		  long ultimElSubInterval = startInterval;
          long primulElSubInterval = startInterval;
          
          long nrElemente = stopInterval - startInterval + 1;
          long nrElementeSubInterval = nrElemente / nrSubIntervale;
          long nrElementeSubIntervalInPlus = nrElemente % nrSubIntervale;
          
          for(long nrSubIntervaleAux = nrSubIntervale; nrSubIntervaleAux >0 ; nrSubIntervaleAux-- )
          {
          	  if ( nrElementeSubIntervalInPlus > 0 )
          	  {
          		  ultimElSubInterval += nrElementeSubInterval;
          	  }
          	  else
          	  {
          		  ultimElSubInterval += nrElementeSubInterval - 1;
          	  }
          	  nrElementeSubIntervalInPlus--;
          	  
        	  intervale.add(primulElSubInterval);
        	  intervale.add(ultimElSubInterval);
        	  
        	  ultimElSubInterval++;
        	  primulElSubInterval = ultimElSubInterval;        	  
          }
          //System.out.println(intervale.size());
	}
	
	public List<Long> getListEl()
	{
		return intervale;
	}
}
