package in.ushatech.dsa;
//TODO revise section 20 and 21
public class RecursionPractice {
    
    public String reverse(String str)
    {
        if(str.length()==0) return str;
        return  reverse(str.substring(1))+ str.charAt(0);
    }
}
