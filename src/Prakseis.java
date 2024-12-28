public class Prakseis {

    double Plus(double a,double b){
        return a+b;
    }

    double Minus(double a,double b){
        return  a-b;
    }

    double Div(double a,double b){
        if(a!=0 && b!=0){
            return a/b;
        }else{
            return -1;
        }
    }

    double Multiply(double a,double b){
        return a*b;
    }

    double PlusMinus(double a ){
        return -1*a;
    }

    double Percentage(double a){
        return a/100;
    }






}
