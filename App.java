package techsilicon.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    
    	
    		String s = 		"20 Dec 2011 281M root delete-this.mov \n"
				    	    +"03 Sep 2009 875K root system.dll \n"
				    	    +"13 Jun 2002 610M root listing.h \n"
				    	    +"11 Oct 1959 998 root moonlight-sonata.wav \n" 
				    	    +"29 Nov 1992 669K john temporary.txt \n"
				    	    +"25 Jul 1974 992K admin picture.gif \n"
				    	    +"31 Jan 1990 562M root important.xml \n";
    	
//    	String s = "10 12 2016 128M root fileType "
//    			+ "10/12/2016 FileName 256K TEXT "
//    			+ "10/12/2016 FileName 512B TEXT "
//    			+ "10/12/2016 FileName 1024M TEXT "
//    			+ "10/12/2016 FileName 2048M TEXT ";
    	
    	int totatlSize = getStrings(s);
    	
        System.out.println( "totatlSize :" + totatlSize );
    }

	private static int getStrings(String S) {
		
		int totalSize = 0;
		
		Scanner scanner = new Scanner(S);
		while (scanner.hasNextLine()) {
		  String line = scanner.nextLine();
		  
		  String[] split = line.split(" ");
		  
		  String fileSizeString = split[3];
		  String owner = split[4];
		  String dateStr = "31 Jan 1990";
		  
		  int fileSize = 0;
		  
		  if (fileSizeString != null && fileSizeString.length() > 0 && fileSizeString.charAt(fileSizeString.length()-1)=='M') {
			  fileSize = Integer.valueOf(fileSizeString.substring(0, fileSizeString.length()-1))*1048576;
		  }
		  else if (fileSizeString != null && fileSizeString.length() > 0 && fileSizeString.charAt(fileSizeString.length()-1)=='K') {
			  fileSize = Integer.valueOf(fileSizeString.substring(0, fileSizeString.length()-1))*1000;
		  }
		  else if (fileSizeString != null && fileSizeString.length() > 0 && fileSizeString.charAt(fileSizeString.length()-1)=='G') {
			  fileSize = Integer.valueOf(fileSizeString.substring(0, fileSizeString.length()-1))*1073741824;
		  }else{
			  if(fileSizeString != null && fileSizeString.length() > 0){
				  fileSize = Integer.valueOf(fileSizeString);
			  }
		  }
		  Date date = getConvertedDate(dateStr);
		  
		  Date fileDate = getConvertedDate(split[0].concat(" ").concat(split[1]).concat(" ").concat(split[2]));
		  
		  if(owner.equalsIgnoreCase("root") && fileDate.after(date)){
		      totalSize = totalSize + fileSize;
		  }
		}
		scanner.close();
		return totalSize;
	}

	private static Date getConvertedDate(String dateStr) {
		DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
		  Date date = new Date();
		  try {
			  date = (Date)formatter.parse(dateStr);
			  Calendar cal = Calendar.getInstance();
			  cal.setTime(date);
			  String formatedDate = cal.get(Calendar.DATE) 
					  + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
			  System.out.println("formatedDate : " + formatedDate); 
		  } catch (ParseException e) {
			e.printStackTrace();
		  }
		  return date;
	}
}


//String fileSizeStringNew = fileSizeString.replaceAll("[^M\\w\\s\\.]", "");
//int fileSize = 0;
//Scanner fi = new Scanner(fileSizeString);
//fi.useDelimiter("[^\\p{Alnum},^M,\\.-]"); 
//while (true) {
//   if (fi.hasNextInt())
//       fileSize = fi.nextInt();
//       break;
//}

//String stringDateOfFile = split[0].concat("-").concat(split[1]).concat("-").concat(split[2]);
//SimpleDateFormat sdf = new SimpleDateFormat("dd-mon-yyyy");
//try {
//	Date date = sdf.parse("31-Jan-1990");
//	Date dateOfFile = sdf.parse(stringDateOfFile);
//} catch (ParseException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
