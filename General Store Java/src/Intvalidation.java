import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

import static java.lang.System.in;

public class Intvalidation {

    private char ch;
    char [] user=new char[10];//to store username.
    char [] pass=new char[10];//to store password.
    String log_user="admin";
    String log_pass="admin";
    public void user_name()
    {
        System.out.println("\t\t\t\t\t\tEnter numbers  :");
        //to store password.
        int i = 0;
        char a=0;//a Temp char
        for(i=0;;)//infinite loop
        {
            try {
                 a = (char) in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //a=getch();//stores char typed in a

            //check if a is numeric or alphabet
            if(a !=8&&a>='0'&&a<='9')
            {
                if (a!=13)
                {
                    user[i]=a;//stores a in pass
                    ++i;
                    System.out.println(a);
                }
            }
            if(a=='\b'&&i>=1)//if user typed backspace
            //i should be greater than 1.
            {
                System.out.println("\b \b");//rub the character behind the cursor.
                --i;
            }
            if(a=='\r'&&user[0]!='\0')//if enter is pressed
            {
                user[i]='\0';//null means end of string.
                break;//break the loop
            }
        }
    }
    public static void main(String [] args) throws IOException {
        Intvalidation i=new Intvalidation();

        java.io.BufferedReader br = new BufferedReader(System.in);
        String keyPressed = br.readLine();
        try {
            char a = (char) in.read();
            System.out.println("this is "+a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //i.user_name();
    }
}
