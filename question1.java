package Assigment3;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class question1 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> tokens = new HashMap<>();
        tokens.put("+", "addition operator");
        tokens.put("-", "subtraction operator");
        tokens.put("*", "multiplication operator");
        tokens.put("/", "division operator");
        tokens.put("%", "modulus operator");
        tokens.put("()", "grouping symbols");
        tokens.put("==", "assignment operator");
        tokens.put("=", "equals operator");
        tokens.put("<", "less than operator");
        tokens.put("<=", "less than or equal operator");
        tokens.put(">", "greater than operator");
        tokens.put(">=", "greater than or equal operator");
        tokens.put("&&", "logical and operator");
        tokens.put("||", "logical or operator");
        tokens.put("VARIABLE_ID", "variable identifier");
        tokens.put("INTEGER_LITERAL", "integer literal");
        tokens.put("FLOATING_LITERAL", "floating point literal");

        String filename = "/home/philip/Documents/Assignments/question1.txt";
        
        
        FileReader reader = new FileReader(filename);
        int character;
        ArrayList<String> clumps = new ArrayList<String>();
       
        String temp = "";
       while ((character = reader.read()) != -1) {
            char currentChar = (char) character;
            System.out.print(currentChar);
           
            if (currentChar == '('){
                temp += currentChar;
                clumps.add(temp);
                temp = "";
            } else if (currentChar == ')'){
                clumps.add(temp);
                clumps.add(String.valueOf(currentChar));
                temp = "";
            } else  if (currentChar!= ' '){
                temp += currentChar;
            }
            else {
                    clumps.add(temp);
                    temp = "";
                }
            
          
       }
      
       clumps.add(temp);
       System.out.println();
       
       Pattern pattern = Pattern.compile("[0-9]+");
       Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
       
    for (int i = 0; i< clumps.size();i++){
        Matcher matcher = pattern.matcher(clumps.get(i));
        Matcher matcher2 = pattern2.matcher(clumps.get(i));
        if (matcher.matches()){
            if (clumps.get(i).contains(".")){
                printer(clumps.get(i), tokens.get("FLOATING_LITERAL"));
            } else {
                printer(clumps.get(i), tokens.get("INTEGER_LITERAL"));
            }
        }
        else if (matcher2.matches()){
            printer(clumps.get(i), tokens.get("VARIABLE_ID"));
        } 
        else if (clumps.get(i).equals("||")){printer(clumps.get(i), tokens.get("||"));}
        else if (clumps.get(i).equals("&&")){printer(clumps.get(i), tokens.get("&&"));}
        else if (clumps.get(i).equals(">=")){printer(clumps.get(i), tokens.get(">="));}
        else if (clumps.get(i).equals(">")){printer(clumps.get(i), tokens.get(">"));}
        else if (clumps.get(i).equals("<=")){printer(clumps.get(i), tokens.get("<="));}
        else if (clumps.get(i).equals("<")){printer(clumps.get(i), tokens.get("<"));}
        else if (clumps.get(i).equals("=")){printer(clumps.get(i), tokens.get("="));}
        else if (clumps.get(i).equals("==")){printer(clumps.get(i), tokens.get("=="));}
        else if (clumps.get(i).equals("(") || clumps.get(i).equals(")")){printer(clumps.get(i), tokens.get("()"));}
        else if (clumps.get(i).equals("%")){printer(clumps.get(i), tokens.get("%"));}
        else if (clumps.get(i).equals("/")){printer(clumps.get(i), tokens.get("/"));}
        else if (clumps.get(i).equals("*")){printer(clumps.get(i), tokens.get("*"));}
        else if (clumps.get(i).equals("-")){printer(clumps.get(i), tokens.get("-"));}
        else if (clumps.get(i).equals("+")){printer(clumps.get(i), tokens.get("+"));}
        else { printer(clumps.get(i), "UNKOWN");}}
        

        
    }
    public static void printer (String x, String y){
        System.out.println("Lexeme: " + x + ", " + "Token: " + y);
    }
}
