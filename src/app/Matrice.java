
public class Matrice {
    private final int R;             // numero di righe[n]
    private final int C;             // numero di colonne[m]
    private final double [][] dati;   // matrice di R-C

    public Matrice(){ //Costruttore di default
        R=10;
        C=10;
        dati = new double[R][C];
    }
    public Matrice(int R, int C) { //Costruttore master
        this.R = R;
        this.C = C;
        dati = new double[R][C];
        //throw new RuntimeException("Dimensione della matrice non accettabile");
    }
    public Matrice(Matrice m){ //Costruttore copia
        this(m.getR(), m.getC());
        for (int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++){
                dati[r][c]=m.getElemento(r,c);
            }
        }
    }
    public String toString(){
        String s="";
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                s+=String.format(" %8.2f",dati[r][c]);
            }
            s+=System.lineSeparator();
        }
        return s;
    }

    public int getC() {
        return C;
    }

    public int getR() {
        return R;
    }

    public void setElemento(double elemento, int r, int c){
        if(r < R && c < C){
            dati[r][c]=elemento;
        }
    }

    public double getElemento(int r, int c){
        return dati[r][c];
    }
    public void setIdentita(){
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                dati[r][c]=0;
            }
        }
        for (int i = 0; i < R; i++) {
            dati[i][i]=1;
        }
    }
    public boolean isIdentita(){
        boolean controllo=true;
        int r=0, c=0;
        while(r<R /*&& c<N*/ && controllo/*==true*/){
            if(r==c){
                if(dati[r][c]!=1){ // diagonale --> val==1
                    controllo=false;
                }
            }
            else{
                if(dati[r][c]!=0){ // non diagonale --> val==0
                    controllo=false;
                }
            }//
            if(c==C-1){
                r++;
                c=0;
            }
            else{
                c++;
            }
        }
        return controllo;
    }
    
    public void setTrasposta(){
        double tmp;
        if(R==C){
            for (int r = 0; r < R; r++) {
                for (int c = r; c < C; c++) {
                    tmp=dati[r][c];
                    dati[r][c]=dati[c][r];
                    dati[c][r]=tmp;
                }
            }
        }
    }

    public Matrice setTrasposta2(){
        Matrice m = new Matrice(C, R);
        for (int r = 0; r < C; r++) {
            for (int c = 0; c < R; c++) {
                m.dati[r][c]=dati[c][r];
            }
        }
        return m;
    }
    public void invertiRighe(int riga1, int riga2){
        double tmp;
        for (int i = 0; i < C; i++) {
            tmp=dati[riga1][i];
            dati[riga1][i]=dati[riga2][i];
            dati[riga2][i]=tmp;
        }
    }
    public void invertiColonne(int col1, int col2){
        double tmp;
        for (int i = 0; i < R; i++) {
            tmp=dati[i][col1];
            dati[i][col1]=dati[i][col2];
            dati[i][col2]=tmp;
        }
    }
    public double sommaRiga(int r){
        double somma=0;
        for (int c = 0; c < C; c++) {
            somma+=dati[r][c];
        }
        return somma;
    }
    public double sommaColonna(int c){
        double somma=0;
        for (int r = 0; r < R; r++) {
            somma+=dati[r][c];
        }
        return somma;
    }

    public void sommaMatrice(){
        for (int r = 0; r < R-1; r++) {
            dati[r][C-1]=0;
            dati[r][C-1]=sommaRiga(r);
        }
        for (int c = 0; c < C-1; c++) {
            dati[R-1][c]=0;
            dati[R-1][c]=sommaColonna(c);
        }
        dati[R-1][C-1]=0;
        if(R==C){
            for (int i = 0; i < R-1; i++) {
                dati[R-1][C-1]+=dati[i][i];
            }
        }
    }

    public Matrice moltCelle(Matrice m){
        if(R==m.R && C==m.C){
            Matrice molt=new Matrice(R, C);
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    molt.dati[r][c]=dati[r][c]*m.dati[r][c];
                }
            }
            return molt;
        } else {
            return null;
        }
    }
    public Matrice moltMatrice(Matrice m){
        if(C==m.R){
            Matrice prodotto=new Matrice(R, m.C);
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < m.C; c++) {
                    for (int i = 0; i < C; i++) {
                        prodotto.dati[r][c]+=dati[r][i]*m.dati[i][c];
                    }
                }
            }
            return prodotto;
        } else {
            return null;
        }
    }
    //calcolo determinante ITERATTIVO
    public double det(Matrice m){
        double det=0;
        //se matrice è 1X1
        if(R==1 && C==1){
            det=m.dati[0][0];
        }else if (R==2 && C==2){
            det=(m.dati[0][0]*m.dati[1][1]-m.dati[1][0]*m.dati[0][1]);
        }else{
            Matrice m2 = new Matrice(getR()-1, getC()-1);
            for(int i = 0; i < m.getC(); i++) {
                for (int j = 0;  j< m2.getR(); j++) {
                    for (int k = 0; k < m2.getC(); k++) {
                     if(k>=i){
                        m2.setElemento(m.getElemento(j+1, k+1), j, k);
                     }
                     else{
                        m2.setElemento(m.getElemento(j+1, k), j, k);
                        }
                    }
                }
                det+=Math.pow(-1, i)*m.dati[0][i]*det(m2);
            }
            
        }
        
        
        return det;

    }
    
    //MODO ITERATTIVO
    public double det3(Matrice A){
        double detmin=0;
        double det=0;
        double detmed=0;
        double detfin=0;

        if(R==1 && C==1){
            det=dati[0][0];
        }

        if(R==3 && C==3){
            for (int i = 0; i < dati.length; i++) {
                for (int j = 0; j < dati.length; j++) {
                    detmin=((dati[1][1]*dati[2][2])-(dati[1][2]*dati[2][1]));
                }
                detmin*=(-1)*dati[0][0];
            }
            for (int i = 0; i < dati.length; i++) {
                for (int j = 0; j < dati.length; j++) {
                    detmed=((dati[0][1]*dati[2][2])-(dati[1][2]*dati[0][2]));
                    
                }
                detmed*=(-1)*dati[0][1];
            }

            for (int j = 0; j < dati.length; j++) {
                for (int j2 = 0; j2 < dati.length; j2++) {
                    detfin=((dati[0][1]*dati[1][2])-(dati[1][1]*dati[0][2]));
                    
                }
                detfin=(-1)*dati[0][2];
            }
            det=detmin+detmed+detfin;
        }
        return detfin;
    }
}
