import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


public class Main {
	
	private static final int N=Constants.N;
	public static void main ( String[] args ) throws IOException

	  {
	    AbstractST<String,String> 
		st = new SeparateChaining<String,String>(); // Hashing with separate chaining
	    BufferedReader in = null; 

	    int counter=0;

	    try { // process input
	      in = new BufferedReader(new FileReader("data.tsv")); 
	      
	      String line = null;
	      StopWatch sw=new StopWatch();
	     for (int i=1, K=N*i/30;i<=30;i++,K=N*i/30) { 
	    	 while((line = in.readLine()) != null && counter<=K){
	    		 String[] keys = line.split("\\t");
	    		 counter++;	
	    		 
	    		 if (keys.length>=4) {
	    			 st.put(keys[3],keys[2]);
	    		 } 
	    	 }
	    	 System.out.println("To create ST with separate chaining of " +K+" elements, we need "+sw.elapsedTime());
	      } 
	     System.out.println("********************************");
	    	 
	    }catch (IOException x) { System.err.println(x); } 
	    if ( in!=null ) in.close(); 
	    
	    Random r=new Random();//create an object of Random class
	     String arr[]=new String[N];//create an array of random keys
	     String randV;
			StopWatch sw2=new StopWatch();
			 for (int i=1, K=N*i/30;i<=30;i++,K=N*i/30){
				 for(int j=0;j<N;j++){
					 randV="&"+"#"+(r.nextInt(10000+1)-1);
					 st.get(randV);
				 }
				 System.out.println("Search in ST with separate chaining of " +K+" elements, we need "+sw2.elapsedTime());
			}
	    }	 
}

