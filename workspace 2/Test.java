/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    public static void main(String[] arg) throws java.net.MalformedURLException
    {
        ReadFromURLExample r = new ReadFromURLExample("http://www.cnn.com/2017/02/18/politics/donald-trump-florida-campaign-rally/index.html");
        String plain = r.text();
        System.out.println(plain);
    }
}
