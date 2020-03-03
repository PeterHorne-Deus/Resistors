/*
 * Peter Horne-Deus
 * The is decodes a 3 band resistor
 * Resistors.java
 * March 2, 2020
 */
package resistors;


import javax.swing.*;


/**
 *
 * @author Peter
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables and Arrays
        String[] colours = {"black","brown","red","orange","yellow","green",
                "blue","violet","grey","white"};
        String input = JOptionPane.showInputDialog("Enter The Colour Code Of The "
                + "Resistor \nAdd '-' inbetween each colour");
        double[] num = new double[3];
        int inputLength = 1;
        String colour = "";
        int n = 0;
        double out = 0;

        
        
        try{
            //This loop is used to check length of the inputed colour code and insure its correct
            for(int i = 0; i < input.length(); i++){
                //Checking for the ends of words inorder to make sure there are 3 colours
                if(input.charAt(i) != '-'){

                }
                else{
                    inputLength += 1;
                }
                //If there are more than 3 colours user is prompted to reenter information
                if(inputLength > 3){
                    input = JOptionPane.showInputDialog("Enter A Valid 3 Colour "
                            + "Colour Code Of The "
                            + "Resistor \nAdd '-' inbetween each colour");
                    inputLength = 1;
                    i=0;
                }
                //if there are less than 3 then the user must reenter information
                if(inputLength != 3 && i == input.length() - 1){
                    input = JOptionPane.showInputDialog("Enter A Valid 3 Colour "
                            + "Colour Code Of The "
                            + "Resistor \nAdd '-' inbetween each colour");
                    inputLength = 1;
                    i=0;
                }
            }
            //Setting the input to lower case to remove the need to be character perfect on the inputs
            input.toLowerCase();
            
            //This loop assigns number values based on the colours
            for(int u = 0; u < input.length(); u++){
                
                //Setting a string to each colour
                if(input.charAt(u) != '-'){
                    colour = colour + input.charAt(u);
                    
                }
                
                if(input.charAt(u) == '-' || u == input.length() - 1){
                    //Checking for the colour in my colours array
                    for(int k = 0; k < 8; k ++){
                        //If the colour is found a number is then set to the index of that colour
                        if(colours[k].equals(colour)){
                            num[n] = k; 
                            n++;
                            colour = "";
                            
                            break;
                        }
                        //If the colour cannot be found this error appears
                        if(k == 7){
                            throw new Exception("Invaild Colour Code");
                        }
                    }
                
                } 
                
            }
            
            //Doing the math for the resistance
            out = (num[0]*10 + num[1])*(Math.pow(10, num[2]));
            //Final output
            System.out.println("You inputed " + input + " The Code Value is " + out);   
        }
        catch(Exception e){
            System.err.println("An invalid colour was entered");
        }
        
    }
    
}
