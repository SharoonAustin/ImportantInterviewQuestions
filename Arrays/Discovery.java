package Arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.TreeMap;

public class Discovery{
  
  public static String getTheOutPut(Double MRP, Double Paid, TreeMap<Double,String> hmap){
    Double remaining= Double.parseDouble(String.format("%.3f", Paid-MRP));  // can be required precision
   

    if(Double.compare(MRP, Paid)==0)
      return "ZERO";
   
    if(MRP>Paid)
      return "ERROR";
    
    if(hmap.containsKey(remaining))
      return hmap.get(remaining);
    
    else{
    Double key=0.00;
    
    StringBuffer sbuffer=new StringBuffer();
    
    while(remaining!=0){
      if(hmap.containsKey(remaining)) {
    	  sbuffer.append(hmap.get(remaining));
    	  remaining=remaining-remaining;
      }
      
      else if(!hmap.containsKey(remaining) && remaining!=0) {
    	  key=hmap.lowerKey(remaining);
    	  sbuffer.append(hmap.get(key)+",");
    	  remaining=Double.parseDouble(String.format("%.3f", remaining-key));
      }
    }
    return sbuffer.toString();
    }
  }
  
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      TreeMap<Double,String> hmap=new TreeMap<Double,String>();
      hmap.put(0.01,"PENNY");
      hmap.put(0.05,"NICKEL");
      hmap.put(0.10,"DIME");
      hmap.put(0.25,"QUARTER");
      hmap.put(0.50,"HALF DOLLAR");
      hmap.put(1.00,"ONE");
      hmap.put(2.00,"TWO");
      hmap.put(5.00,"FIVE");
      hmap.put(10.00,"TEN");
      hmap.put(100.00,"ONE HUNDRED");
      
      String Currency[]=line.split(";");
      Double MRP=Double.parseDouble(Currency[0]);
      Double Paid=Double.parseDouble(Currency[1]);
      System.out.println(getTheOutPut(MRP, Paid, hmap));
      
    }
  }
}