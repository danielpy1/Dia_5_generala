import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dado dados[]=new Dado[5];
        Dado dados_auxi[]=new Dado[5];
        int input_dados;
        String input_datos2;
        Scanner input=new Scanner(System.in);
        System.out.println("**** Bootcamp Roshka DIA 5 ****");
        System.out.print("Ejercicio 1\nIntroduzca valor:");
        input_datos2=input.nextLine();
        try {
            input_dados=Integer.valueOf(input_datos2);
        } catch(Exception e) {
            System.out.println("Respuesta: INVALIDO");
            return;
        }
        for(int i=0;i<5;i++){
            dados[i]=new Dado();
            dados[i].setValor(Character.getNumericValue(input_datos2.charAt(i)));
        }
        dados_auxi=dados;
        if(dados[4].getValor()==1){
            dados_auxi[4].setValor(7);
        }
        int bandera1=1,bandera2=dados[0].getValor(),bandera3;
        String caso="";
        for(int i=1;i<5;i++){
            if(bandera2==dados[i].getValor()){
                bandera1++;
            }
        }
        if(bandera1==5){
            caso="GENERALA";
        }else if(bandera1==4){
            caso="POKER";
        }else if((dados[0].getValor()==dados[1].getValor() && dados[1].getValor()==dados[2].getValor()) && (dados[3].getValor()==dados[4].getValor())){
            caso="FULL";
        }else{
            bandera3=0;
            for(int i=0;i<4;i++){
                bandera3=0;
                if((dados[i].getValor()+1)!=dados[i+1].getValor()){
                    bandera3=1;
                    break;
                }
            }
            if(bandera3==0){
                caso="ESCALERA";
            }else{
                dados=ordenar(dados_auxi);
                bandera3=0;
                for(int i=0;i<4;i++){
                    bandera3=0;
                    if((dados[i].getValor()+1)!=dados[i+1].getValor()){
                        bandera3=1;
                        break;
                    }
                }
            }
        }
        if(caso.equals("")){
            caso="NADA";
        }
        System.out.println("\nResultado: "+caso);
    }
    public static void impresion(Dado D[]){
        System.out.println("Dados: ");
        for(int i=0;i<5;i++){
            System.out.print(D[i].getValor()+" ");
        }
    }
    public static Dado[] ordenar(Dado D[]){
        int valor_auxiliar;
        for(int i=0;i<(D.length)-1;i++){
            for(int j=i+1;j<D.length;j++){
                if(D[j].getValor()<D[i].getValor()){
                    valor_auxiliar=D[i].getValor();
                    D[i].setValor(D[j].getValor());
                    D[j].setValor(valor_auxiliar);
                }
            }
        }
        return D;
    }
}