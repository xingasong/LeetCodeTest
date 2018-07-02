public class SolveTheEquation {
    public String solveEquation(String equation) {
        int leftX = 0, rightX = 0, leftV = 0, rightV = 0;
        for(int i=0; i<equation.length(); i++){
            if(i<equation.indexOf("=")){
                if(equation.charAt(i)=='x'){
                    if(i==0||equation.charAt(i-1)=='+'){
                        leftX++;
                    }
                    if(equation.charAt(i-1)>='0'&&(i-1==0||equation.charAt(i-2)=='+')){
                        leftX += equation.charAt(i-1) - '0';
                    }
                    if(equation.charAt(i-1)=='-'){
                        leftX--;
                    }
                    if(equation.charAt(i-1)>='0'&&equation.charAt(i-2)=='-'){
                        leftX -= equation.charAt(i-1) - '0';
                    }
                }
                if(equation.charAt(i)>='0'){
                    if(i==equation.length()-1||equation.charAt(i+1)!='x'){  //is number
                        //if(equation.charAt())
                    }
                }
            }
        }
        return equation;
    }
}
