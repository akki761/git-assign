import org.apache.commons.lang3.StringUtils;

public class hello {
    public static void main(String[] args) {
        System.out.println("hello world");
        String n="Akash";
       String n1=StringUtils.upperCase(n);
        System.out.println(n1);
        Hello2 ob=new Hello2();
        ob.disp();
    }
}
