import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        //creazione Matrice m1, set elelemnto in Matrice e stampa
        Matrice m=new Matrice (2, 2);
        m.setElemento(1, 0, 0);
        m.setElemento(3, 0, 1);
        m.setElemento(4, 1, 0);
        m.setElemento(5, 1, 1);
        System.out.println("\n"+"|MATRICE 2X2|");
        System.out.println(m.toString());
        System.out.println(m.det(m));

        Matrice m2 = new Matrice (3,3);
        m2.setElemento(1, 0, 0);
        m2.setElemento(0, 0, 1);
        m2.setElemento(5, 0, 2);
        m2.setElemento(2, 1, 0);
        m2.setElemento(-1, 1, 1);
        m2.setElemento(0, 1, 2);
        m2.setElemento(7, 2, 0);
        m2.setElemento(-2, 2, 1);
        m2.setElemento(0, 2, 2);
        System.out.println("\n"+"|MATRICE 3X3|");
        System.out.println(m2.toString());
        System.out.println(m2.det(m2));

/*         m.setElemento(12, 2, 1);
        System.out.println("Matrice 1:\n"+m);

        //Creazione matrice m2, setIndentità,stampa
        Matrice m2=new Matrice(5, 5);
        m2.setIdentita();
        System.out.print("Matrice identità:\n"+m2);
        if(m2.isIdentita()){
            System.out.println("La matrice è di tipo identità");
        } else{
            System.out.println("La matrice non è di tipo identità");
        }s
        //m2 setElemento,setTrasposta e stampa
        m2.setElemento(2, 2, 1);
        m2.setElemento(3, 1, 0);
        System.out.println("\nMatrice 2:\n"+m2);
        m2.setTrasposta();
        System.out.println("Matrice 2 trasposta:\n"+m2);
        //Creazione Matrice m3, setElemento e stampa
        Matrice m3 = new Matrice (3, 3);
        m3.setElemento(1, 0, 0);
        m3.setElemento(2, 0, 1);
        m3.setElemento(3, 0, 2);
        m3.setElemento(4, 1, 0);
        m3.setElemento(5, 1, 1);
        m3.setElemento(6, 1, 2);
        m3.setElemento(7, 2, 0);
        m3.setElemento(8, 2, 1);
        m3.setElemento(9, 2, 2);
        System.out.println("Matrice 3:\n"+m3);
        //m3 metodo invertirighe e inverticolonne
        m3.invertiRighe(0, 2);
        System.out.println("Matrice 3 con righe 0 e 2 inverite:\n"+m3);
        m3.invertiColonne(0, 2);
        System.out.println("Matrice 3 con colonne 0 e 2 inverite:\n"+m3);

        //Somma righe e sommacolonne m3
        System.out.println("La somma della riga " +" è "+m3.sommaRiga(sc.nextInt()));
        System.out.println("La somma della colonna 1 è "+m3.sommaColonna(1));
        //Creazione Matrice m4 e SetElemento nella matrice
        Matrice m4 = new Matrice(4, 4);
        m4.setElemento(1, 0, 0);
        m4.setElemento(2, 0, 1);
        m4.setElemento(3, 0, 2);
        m4.setElemento(4, 1, 0);
        m4.setElemento(5, 1, 1);
        m4.setElemento(6, 1, 2);
        m4.setElemento(7, 2, 0);
        m4.setElemento(8, 2, 1);
        m4.setElemento(9, 2, 2);
        System.out.println("Matrice 4:\n"+m4);
        m4.sommaMatrice();
        System.out.println("Matrice 4 sommata:\n"+m4);
        Matrice trasposta=m4.setTrasposta2();
        System.out.println("Matrice 4 sommata e trasposta:\n"+trasposta);
        System.out.println("Moltiplicazione celle:\n"+m4.moltCelle(trasposta));
        Matrice m5=new Matrice(2, 3);
        Matrice m6=new Matrice(3, 2);
        m5.setElemento(1, 0, 0);
        m5.setElemento(2, 0, 2);
        m5.setElemento(3, 1, 1);
        m5.setElemento(-1, 1, 2);
        m6.setElemento(4, 0, 0);
        m6.setElemento(1, 0, 1);
        m6.setElemento(-2, 1, 0);
        m6.setElemento(2, 1, 1);
        m6.setElemento(3, 2, 1);
        System.out.println("Moltiplicazione matrici:\n"+m5.moltMatrice(m6)); */
    }
}