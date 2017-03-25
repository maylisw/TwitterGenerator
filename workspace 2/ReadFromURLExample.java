import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
 
/*public class ReadFromURLExample {
    private URL url;
    private String ans ="";
    public ReadFromURLExample(String s) throws java.net.MalformedURLException
    {
        url = new URL(s);
    }
    
     public String text(){
         try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
             
            String line;
            while ( (line = br.readLine()) != null)
                ans += line;
             
            br.close();
            is.close();
             
        } catch (Exception e) {
            e.printStackTrace();
        }  
        int place = 0;
        String ans2 = "";
        int far = ans.length();
        StringBuilder parsed = new StringBuilder();
        while(place <= far){
            int starter = ans.indexOf("<", place);
            int ender = ans.indexOf(">", starter);
            if(ender > far){
                ender = far;
            }
            else {
                import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
*/
public class ReadFromURLExample {
    private URL url;
    private String ans ="";
    public ReadFromURLExample(String s) throws java.net.MalformedURLException
    {
        url = new URL(s);
    }
    
     public String text(){
         try {
            InputStream is = url.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
             
            String line;
            while ( (line = br.readLine()) != null)
                ans += line;
             
            br.close();
            is.close();
             
        } catch (Exception e) {
            e.printStackTrace();
        }  
        int place = 0;
        String ans2 = "";
        int far = ans.length();
        StringBuilder parsed = new StringBuilder();
        while(place <= far){
            int starter = ans.indexOf("<", place);
            int ender = ans.indexOf(">", starter);
            if(ender > far){
                ender = far;
            }
            else {
                parsed.append(ans.substring(ender + 1, far - 1));
            }
            //ans2 = ans2 + ans.substring(ender + 1, far - 1);
            place = ender;
            System.out.println("place: " + place + ", far: " + far + ", starter: " + starter + ", ender: " + ender);
        }
        return ans2;
        //return ans;
        
    }
    /*public String plainText(String ans2){
        String ans3 = ans2;
        int place = 0;
        ans2 = "";
        int far = ans3.length();
        while(place <= far){
            int starter = ans3.indexOf("<");
            int ender = ans3.indexOf(">");
            ans2 = ans2.concat(ans3.substring(ender + 1, far - 1));
            place = ender;
        }
        return ans2;
    }*/

	public String plainText(String text) {
		// TODO Auto-generated method stub
		return null;//do life
	}
    
}

   /*
   1. Find first occurance of <.
   2. Set start index to <.
   3> Find first occurance of >.
   4. Set end index to >.
   5. Concatenate string before < w/ string behind >.
   6. Set place to end.
   7. Repeat until place > far.

            ans2 = ans2 + ans.substring(ender + 1, far - 1);
            place = ender;
            System.out.println("place: " + place + ", far: " + far + ", starter: " + starter + ", ender: " + ender);
        }
        return ans2;
        //return ans;
        
    }
        public String plainText(String ans2){
        String ans3 = ans2;
        int place = 0;
        ans2 = "";
        int far = ans3.length();
        while(place <= far){
            int starter = ans3.indexOf("<");
            int ender = ans3.indexOf(">");
            ans2 = ans2.concat(ans3.substring(ender + 1, far - 1));
            place = ender;
        }
        return ans2;
    }*/
    

   /*
   1. Find first occurance of <.
   2. Set start index to <.
   3> Find first occurance of >.
   4. Set end index to >.
   5. Concatenate string before < w/ string behind >.
   6. Set place to end.
   7. Repeat until place > far.
   */
