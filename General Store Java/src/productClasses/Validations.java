package productClasses;

import java.io.IOException;


public class Validations {

    //Int Validation
   public int getIntValid(String text){
       Integer value = 0;
       try {
           value = Integer.parseInt(text);
       } catch (NumberFormatException nfe) { }
       return value;
   }
    public int getIntValid(String text,int Default_Value){
        Integer value = Default_Value;
        try {
            value = Integer.parseInt(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }

    //Float Validation
   public float getFloatValid(String text){
       Float value = (float)0.0;
       try {
           value = Float.parseFloat(text);
       } catch (NumberFormatException nfe) { }
       return value;
   }
    public float getFloatValid(String text,int Dafault_Value){
        Float value = (float)Dafault_Value;
        try {
            value = Float.parseFloat(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }
    public float getFloatValid(String text,double Dafault_Value){
        Float value = (float)Dafault_Value;
        try {
            value = Float.parseFloat(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }

    //Double Validation
    public double getDoubleValid(String text){
        Double value = 0.0;
        try {
            value = Double.parseDouble(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }
    public double getDoubleValid(String text,int Default_value){
        Double value = (double) Default_value;
        try {
            value = Double.parseDouble(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }
    public double getDoubleValid(String text,double Default_value){
        Double value = Default_value;
        try {
            value = Double.parseDouble(text);
        } catch (NumberFormatException nfe) { }
        return value;
    }

    //Text Validation
    public String getTextValid(String text){
       char []ch=text.toCharArray();
       for (int i=0;i<text.length();i++){
           if( ch[i]<'A' || ch[i]>'z'){
               ch[i]='\u0000';
           }
       }
       return  String.valueOf(ch);
    }
    public String getTextValid(String text,char Char_Allowed){
        char []ch=text.toCharArray();
        for (int i=0;i<text.length();i++){
            if( (ch[i]<'A' || ch[i]>'z') && ch[i]!=Char_Allowed){
                ch[i]='\u0000';
            }
        }
        return  String.valueOf(ch);
    }
    public String getUserValid(String text){
        char []ch=text.toCharArray();
        for (int i=0;i<text.length();i++){
            if( (ch[i]>='A' && ch[i]<='z')||(ch[i]<='9' && ch[i]>='0')){

            }else{
                ch[i]='\u0000';
            }
        }
        return  String.valueOf(ch);
    }
    public boolean getUserValidBool(String text){
        char []ch=text.toCharArray();
        boolean flag=true;
        for (int i=0;i<text.length();i++){
            if( (ch[i]>='A' && ch[i]<='z')||(ch[i]<='9' && ch[i]>='0')){

            }else{
//                ch[i]='\u0000';
                flag=false;
            }
        }
        return  flag;
    }

    //Email Validation
    public boolean getEmailValid(String text){
       char Char_Must='@';
       boolean email_valid=false;
       char []ch=text.toCharArray();
        for (int i=0;i<text.length();i++){
            if(ch[i]==Char_Must){
                email_valid=true;
            }
        }
        for (int i=0;i<text.length();i++){
            if(ch[i]==' '){
                email_valid=false;
            }
        }
        return  email_valid;
    }
    public boolean getEmailValid(String text,char Char_Must){
        boolean email_valid=false;
        char []ch=text.toCharArray();
        for (int i=0;i<text.length();i++){
            if(ch[i]==Char_Must){
                email_valid=true;
            }
        }
        for (int i=0;i<text.length();i++){
            if(ch[i]==' '){
                email_valid=false;
            }
        }
        return  email_valid;
    }

    //password validation
    public boolean getPasswordValid(String Password,int Password_length,int specila_Ch_length,int Digits_length){
        boolean password_valid=false;
        int length=0,ch_len=0,digit=0;
        char []ch=Password.toCharArray();
        for (int i=0;i<Password.length();i++){
            length++;
            if ((ch[i]<'A' || ch[i]>'z')&&(!(ch[i]>='0' && ch[i]<'9'))){
                ch_len++;
            }
            if ((ch[i]>='0' && ch[i]<'9')){
                digit++;
            }
        }
        if(length>=Password_length&&ch_len>=specila_Ch_length&&digit>=Digits_length){
            password_valid=true;
        }
        return  password_valid;
    }
    public int getPasswordLevels(String Password,int Password_length,int specila_Ch_length,int Digits_length){
        int levels=0;
        int length=0,ch_len=0,digit=0;
        char []ch=Password.toCharArray();
        for (int i=0;i<Password.length();i++){
            length++;
            if ((ch[i]<'A' || ch[i]>'z')&&(!(ch[i]>='0' && ch[i]<'9'))){
                ch_len++;
            }
            if ((ch[i]>='0' && ch[i]<'9')){
                digit++;
            }
        }
        if(length>=Password_length&&ch_len>=specila_Ch_length&&digit>=Digits_length){
            levels++;
        }
        if(digit>=Digits_length){
            levels++;
        }
        if(ch_len>=specila_Ch_length){
            levels++;
        }
        if(length>=Password_length){
            levels++;
        }

        return  levels;
    }

    public boolean getQuantityValid(String quantity,String symbol,String stored_Quantity){
       boolean result=false;
       if (symbol.equals("<")){
           if(getIntValid(quantity)<getIntValid(stored_Quantity)){
               result =true;
           }
       }else if (symbol.equals(">")){
           if(getIntValid(quantity)>getIntValid(stored_Quantity)){
               result =true;
           }
       }else if (symbol.equals("<=")){
           if(getIntValid(quantity) <= getIntValid(stored_Quantity)){
               result =true;
           }
       }else if (symbol.equals(">=")){
           if(getIntValid(quantity) >= getIntValid(stored_Quantity)){
               result =true;
           }
       }else if (symbol.equals("==")){
           if(getIntValid(quantity) == getIntValid(stored_Quantity)){
               result =true;
           }
       }
       return result;
    }
    public boolean getQuantityValid(String quantity) {
        Integer value = 0;
        boolean flag=true;
        try {
            value = Integer.parseInt(quantity);
        } catch (NumberFormatException nfe) { }
        if(value<0){
            flag=false;
        }
        return flag;


    }

    public static void main(String [] args) throws IOException {
       Validations v=new Validations();
        System.out.println(v.getIntValid("20"));
        System.out.println(v.getFloatValid("qasim",35.35));
        System.out.println(v.getTextValid("qasim 123 !@# raheem",'@'));
        System.out.println(v.getEmailValid("qasim123!@#raheem"));
        System.out.println(v.getQuantityValid("12","==","12"));
        System.out.println(v.getPasswordValid("Allahis1!",8,1,1));
        System.out.println(v.getPasswordLevels("Allahis1!",8,1,1));
        System.out.println("text:"+v.getUserValid("ABab0123456789@[]!@#"));
        System.out.println("text:"+v.getUserValidBool("ABab0123456789"));

    }
}