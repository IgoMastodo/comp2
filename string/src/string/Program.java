package string;

public class Program {

	public static void main(String[] args) {
		
		String str = "AAAAAA bbbbb CcCcCcC Rio   ";
        String min , mai , trin , sub, rep , strs;
        int i=str.indexOf("b");
        int k=str.lastIndexOf("b");
       
        min=str.toLowerCase();
        System.out.println("Minúsculo:"    +  "-" +  min + "-");
        
        mai=str.toUpperCase();
        System.out.println("Maiusculo:"    +  "-" + mai + "-");
        
        trin=str.trim();
        System.out.println("Trincada:"    +  "-" +trin + "-");
        
        sub=str.substring(6,10);
        System.out.println("Substring:"    +  "-" +sub + "-");
       
        rep=str.replace('A','X');
        System.out.println("Letra Trocada:"    +  "-" +rep + "-");
        
        strs=str.replace("Rio","Agua");
        System.out.println("String Trocada:"    +  "-" +strs + "-");
        
        System.out.println("Endereço de 'b':"    +  "-" +i+ "-");
        
        System.out.println("Ultimo endereço de 'b':"    +  "-" +k + "-");
        
        String splito="limao laranja banana";
       
        String[] vect = splito.split(" ");
        String p0= vect[0];
        String p1= vect[1];
        String p2= vect[2];
        
        System.out.println(p0);
        System.out.println(p1);
        System.out.println(p2);
	}

}
