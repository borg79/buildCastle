package buildCastle;
import java.util.*;
import java.io.*;

public class buildInfo {

private List<Integer> iArr;

private boolean readData() {
	
	String[] inputStr = null;
	String s = null;
	System.out.println("Please Input the data \n");
	try {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		s = buffer.readLine();
		
		if (s.trim().equals("")) {
			System.out.println("No data is entered, please run the program again !");
			return false;
		}
		inputStr = s.split(",");
		iArr= new ArrayList<Integer>();				
		for (int i=0; i<inputStr.length; i++) {
			try {
			iArr.add(Integer.parseInt(inputStr[i]));
			} catch (NumberFormatException e) {
				System.out.println("Error : data is not numeric, please run the program again" );
				return false;
			}
		}		
		if (iArr.isEmpty())		{
			return false; // if no data is entered
		} else {
		   return true;
		}
	} catch (Exception e) {
	    	System.out.println("Error : " + e.getMessage());
	    	return false;
	}
	
	    
        
}

private void buildProcess() {
	if (readData()) {
		countLandscape();
	}
}

private void countLandscape() {
	
	int j = 0;
	int curr = -10;
	int prev = -10;
	int flat = 0;
	int down = -1;
	int up = 1;
	int shapeform = -1; // value : 0 - peak  ;  1 - valley
	int res_peak, res_valley;
	int arrLen ;
	
	arrLen = iArr.size();
	res_valley = 0;
	res_peak = 0 ;
	System.out.println("-----------------------------------------------");
	System.out.println("                                               ");
	System.out.println("                                               ");
	
	
	while (j < arrLen) {
	  if (j == 0) {
		   prev = -10;
	  } else {
		   prev = curr;
	  }
	 
	  if (j < (arrLen-1)){			  
	    if (iArr.get(j) == iArr.get(j+1)){ 
		   curr = flat;
	    }
	    if (iArr.get(j) > iArr.get(j+1)){ 
		   curr = down;
	    }
	    if (iArr.get(j) < iArr.get(j+1)){ 
		   curr = up;
	    }
	  }
	
	  j++;
	  if ((prev == up) && (curr == flat)){
		    shapeform = 0;		
		    
	  }
	  if ((prev == down) && (curr == up)){
		    shapeform = 1;
		    
	  }
	  if ((shapeform == 0) && (curr == down)){
			 res_peak=res_peak+1;
			 shapeform = -1;
			 prev = -10;
	  }
	  if ((shapeform == 1) && (curr == up)){
			 res_valley=res_valley+1;
			
			 shapeform = -1;
			 prev = -10;
	  };
	 
	  
	  
	 
   }		
	System.out.println("                                               ");
	System.out.println("                                               ");
	System.out.println("                                               ");
	System.out.printf(" No. of Valley = %d \n  No. of Peak = %d \n", res_valley, res_peak  );
	System.out.println("                                               ");
	System.out.println("-----------------------------------------------");
	
	
}

public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	
	buildInfo test = new buildInfo();
	test.buildProcess();
	 		 
}

}