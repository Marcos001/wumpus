
package com.nig;

import com.nig.res.Representation.Valores_Inteiros;
import com.nig.res.Strings.Strings;
import com.nig.res.Representation.Valores_Inteiros;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static javax.swing.BorderFactory.createEtchedBorder;

/**
 * Created by marcos on 09/10/16.
 */
public class Tabuleiro {


    /**+====================OBJETOS======================+**/

    TocarSom tc;

    Painel_Terminal terminal;

    JPanel painel = new JPanel();

    Strings sr;

    Valores_Inteiros vi;

    MedidaDesempenho mdd;

    private boolean log = false;


    JLabel l0 = new JLabel();
    JLabel l1 = new JLabel();
    JLabel l2 = new JLabel();
    JLabel l3 = new JLabel();

    JLabel l4 = new JLabel();
    JLabel l5 = new JLabel();
    JLabel l6 = new JLabel();
    JLabel l7 = new JLabel();

    JLabel l8 = new JLabel();
    JLabel l9 = new JLabel();
    JLabel l10 = new JLabel();
    JLabel l11 = new JLabel();

    JLabel l12 = new JLabel();
    JLabel l13 = new JLabel();
    JLabel l14 = new JLabel();
    JLabel l15 = new JLabel();

    /**+====================____________======================+**/




    /**+======================VALORES PRIMITIVOS========================+*/

    int matriz[][] = new int[4][4];

    private boolean achou_ouro = false;
    private boolean sem_saida = false;

    int DIM;
    int MAIOR=0;
    private int contador=0;

    private String str_sensor = "";

    /**+====================____________======================+**/



    /**+=======================FUNCOES====================+**/



    /**----------------AUXILIARES-----------------**/

    private static void Tempo(int segundos){

        int total = segundos * 1000;

        int i=0;


        try {
            new Thread().sleep(total);
            print("proseguindo >\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }

    public static void print(String m){
        System.out.println(m);
    }

    private void alert(String m){

        if (log)
            JOptionPane.showMessageDialog(null,m);
    }

    /**-----------------------------------------------------------**/



    /**-----------------_______VIEW________-------------------**/

    public void interfaceGrafica(){



        painel.setLayout(new GridLayout(4,4));


        painel.add(l0);
        painel.add(l1);
        painel.add(l2);
        painel.add(l3);

        painel.add(l4);
        painel.add(l5);
        painel.add(l6);
        painel.add(l7);

        painel.add(l8);
        painel.add(l9);
        painel.add(l10);
        painel.add(l11);

        painel.add(l12);
        painel.add(l13);
        painel.add(l14);
        painel.add(l15);

    }

    private void getLabel(int bt,String res){

        ImageIcon imageIcon = new ImageIcon(getClass().getResource(res)); // load the image to a imageIcon

        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(DIM, DIM,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        ImageIcon img_ic = new ImageIcon(newimg);  // transform it back


        switch (bt){

            case 0:
                l0.setIcon(img_ic);
                break;
            case 1:
                l1.setIcon(img_ic);
                break;
            case 2:
                l2.setIcon(img_ic);
                break;
            case 3:
                l3.setIcon(img_ic);
                break;

            case 4:
                l4.setIcon(img_ic);
                break;
            case 5:
                l5.setIcon(img_ic);
                break;
            case 6:
                l6.setIcon(img_ic);
                break;
            case 7:
                l7.setIcon(img_ic);
                break;

            case 8:
                l8.setIcon(img_ic);
                break;
            case 9:
                l9.setIcon(img_ic);
                break;
            case 10:
                l10.setIcon(img_ic);
                break;
            case 11:
                l11.setIcon(img_ic);
                break;


            case 12:
                l12.setIcon(img_ic);
                break;
            case 13:
                l13.setIcon(img_ic);
                break;
            case 14:
                l14.setIcon(img_ic);
                break;
            case 15:
                l15.setIcon(img_ic);
                break;

            default:
                JOptionPane.showMessageDialog(null,"Cordenada Não Encontrada");

        }
    }

    /**-----------------------------------------------------------**/





    /**------------------___________________CONTROLLER____________--------------**/

    public void clear_console(){

    }


    /**
     * Esta funcao dado um vaalor da matriz desenha o mesmo na tabela*/

    private void LogicaWitchLayout(){

        int i=0,j;

        while (i<4){
            j=0;
            while(j<4){

                if(matriz[i][j] == vi.cs_branco){
                    setIconLabel(getId(i,j),sr.str_branco);
                }

                if(matriz[i][j] == vi.wumpus){
                    setIconLabel(getId(i,j),sr.str_wumpus);
                }

                if(matriz[i][j] == vi.fedor){
                    setIconLabel(getId(i,j),sr.str_fedor);
                }

                if(matriz[i][j] == vi.poco){
                    setIconLabel(getId(i,j),sr.str_poco);
                }

                if(matriz[i][j] == vi.brisa){
                    setIconLabel(getId(i,j),sr.str_brisa);
                }

                if(matriz[i][j] == vi.personagem){
                    setIconLabel(getId(i,j),sr.str_personagem);
                }


                if(matriz[i][j] == vi.fedor_brisa){
                    setIconLabel(getId(i,j),sr.str_fedor_brisa);
                }

                if(matriz[i][j] == vi.ouro){
                    setIconLabel(getId(i,j),sr.str_ouro);
                }

                if(matriz[i][j] == vi.fedor_ouro){
                    setIconLabel(getId(i,j),sr.str_fedor_ouro);
                }

                if(matriz[i][j] == vi.brisa_ouro){
                    setIconLabel(getId(i,j),sr.str_brisa_ouro);
                }

                if(matriz[i][j] == vi.fedor_brisa_ouro){
                    setIconLabel(getId(i,j),sr.str_fedor_brisa_ouro);
                }


                //novas combinaçoes

                //casas com rastro - press add 10

                if(matriz[i][j] == vi.limpo_press){
                    setIconLabel(getId(i,j),sr.str_press_cs_branco);
                }

                if(matriz[i][j] == vi.brisa_press){
                    setIconLabel(getId(i,j),sr.str_press_brisa);
                }

                if(matriz[i][j] == vi.fedor_press){
                    setIconLabel(getId(i,j),sr.str_press_fedor);
                }

                if(matriz[i][j] == vi.fedor_brisa_press){
                    setIconLabel(getId(i,j),sr.str_press_fedor_brisa);
                }

                if(matriz[i][j] == vi.wumpus_dead_press){
                    setIconLabel(getId(i,j),sr.str_press_wumpus_dead);
                }

                if(matriz[i][j] == vi.p_wumpus_dead){
                    setIconLabel(getId(i,j),sr.str_p_wumpus_dead);
                }

                if(matriz[i][j] == vi.p_wumpus_dead_press){
                    setIconLabel(getId(i,j),sr.str_p_wumpus_dead_press);
                }




                //casas com personagem - sobre - add 6

                if(matriz[i][j] == vi.p_brisa){
                    setIconLabel(getId(i,j),sr.str_p_brisa);
                }

                if(matriz[i][j] == vi.p_fedor){
                    setIconLabel(getId(i,j),sr.str_p_fedor);
                }

                if(matriz[i][j] == vi.p_fedor_brisa){
                    setIconLabel(getId(i,j),sr.str_p_fedor_brisa);
                }

                if(matriz[i][j] == vi.p_fedor){
                    setIconLabel(getId(i,j),sr.str_p_fedor);
                }



                //casas com ouro e personagem - achou 56

                // fedor + brisa = 6

                //p_brisa_ouro = 564;
                if(matriz[i][j] == vi.p_brisa_ouro){
                    setIconLabel(getId(i,j),sr.str_p_brisa_ouro);
                }

                // p_fedor_ouro = 562;
                if(matriz[i][j] == vi.p_fedor_ouro){
                    setIconLabel(getId(i,j),sr.str_p_fedor_ouro);
                }

                //p_fedor_brisa_ouro = 566;
                if(matriz[i][j] == vi.p_brisa_ouro){
                    setIconLabel(getId(i,j),sr.str_p_brisa_ouro);
                }

                // p_ouro = 56;
                if(matriz[i][j] == vi.p_ouro){
                    setIconLabel(getId(i,j),sr.str_p_ouro);
                }

                //fedor brisa ouro e personagem
                if(matriz[i][j] == vi.p_fedor_brisa_ouro){
                    setIconLabel(getId(i,j),sr.str_p_fedor_brisa_ouro);
                }


                // p_brisa_press = 640;
                if(matriz[i][j] == vi.p_brisa_press){
                    setIconLabel(getId(i,j),sr.str_p_brisa_press);
                }

                //p_fedor_press = 620;
                if(matriz[i][j] == vi.p_fedor_press){
                    setIconLabel(getId(i,j),sr.str_p_fedor_press);
                }

                //p_fedor_brisa_press = 6240;
                if(matriz[i][j] == vi.p_fedor_brisa_press){
                    setIconLabel(getId(i,j),sr.str_p_fedor_brisa_press);
                }

                // p_limpo_press = 610;
                if(matriz[i][j] == vi.p_limpo_press){
                    setIconLabel(getId(i,j),sr.str_p_limpo_press);
                }


                j++;
            }
            i++;
        }
    }


    private void initMarizTabuleiro(){

        int i=0,j;

        while (i<4){
            j=0;
            while (j<4){
                matriz[i][j] = 0;
                j++;
            }
            i++;
        }

    }



    private void initMarizCont(){

        int i=0,j;

        while (i<4){
            j=0;
            while (j<4){
                vi.matrixCont[i][j] = 0;
                j++;
            }
            i++;
        }

    }

    private void viewMatriz(){

        int i =0,j;


        print("+-----Matriz-------+\n");

        while(i<4){
            j=0;
            while (j < 4){
                System.out.print("  "+matriz[i][j]+" ");
                j++;
            }
            print("");
            i++;
        }

        print("\n+------------------+");
    }


    private void viewMatrizCont(){

        int i =0,j;


        print("+-----Matriz-------+\n");

        while(i<4){
            j=0;
            while (j < 4){
                System.out.print("  "+vi.matrixCont[i][j]+" ");
                j++;
            }
            print("");
            i++;
        }

        print("\n+------------------+");
    }

    private void initMatrizCont(){
        initMarizCont();
        viewMatrizCont();
    }

    public String stringMatrizCont(){
        String mat = "+--------Matriz Count-------+ \n";

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if( j == 3){

                    mat = mat + " "+ vi.matrixCont[i][j]+" "+"\n";
                }
                else{
                    mat = mat + " "+ vi.matrixCont[i][j]+" ";
                }
            }
        }

        atribuiMAIOR();

        mat = mat + "\nMAIOR = "+ MAIOR;

        return mat;
    }




    public int atribuiMAIOR(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(vi.matrixCont[i][j] > MAIOR){
                    MAIOR = vi.matrixCont[i][j];
                }
            }
        }
        print("MAIOR = "+MAIOR);
        return MAIOR;
    }



    public int getCasa(){

        int p=0;
        boolean achou = false;
        Random rd = new Random();

        while (!achou){
            p = rd.nextInt(16);
            if(compara(p,0) == true){
                achou = true;
            }
            else{
                print("Nao valido");
            }
        }

        return p;
    }

    private int getId(int linha, int coluna){


        //1 linha

        if(linha==0 && coluna == 0){
            return 0;
        }

        if(linha==0 && coluna == 1){
            return 1;
        }

        if(linha==0 && coluna == 2){
            return 2;
        }

        if(linha==0 && coluna == 3){
            return 3;
        }

        //2 linha

        if(linha==1 && coluna == 0){
            return 4;
        }

        if(linha==1 && coluna == 1){
            return 5;
        }

        if(linha==1 && coluna == 2){
            return 6;
        }

        if(linha==1 && coluna == 3){
            return 7;
        }

        //2 linha

        if(linha==2 && coluna == 0){
            return 8;
        }

        if(linha==2 && coluna == 1){
            return 9;
        }

        if(linha==2 && coluna == 2){
            return 10;
        }

        if(linha==2 && coluna == 3){
            return 11;
        }


        //3 linha

        if(linha==3 && coluna == 0){
            return 12;
        }

        if(linha==3 && coluna == 1){
            return 13;
        }

        if(linha==3 && coluna == 2){
            return 14;
        }

        if(linha==3 && coluna == 3){
            return 15;
        }

        return 100;
    }

    private void setIconLabel(int casa, String res){

        switch (casa){

            case 0:
                 getLabel(0,res);
                break;
            case 1:
                getLabel(1,res);
                break;
            case 2:
                getLabel(2,res);
                break;
            case 3:
                getLabel(3,res);
                break;

            case 4:
                getLabel(4,res);
                break;
            case 5:
                getLabel(5,res);
                break;
            case 6:
                getLabel(6,res);
                break;
            case 7:
                getLabel(7,res);
                break;

            case 8:
                getLabel(8,res);
                break;
            case 9:
                getLabel(9,res);
                break;
            case 10:
                getLabel(10,res);
                break;
            case 11:
                getLabel(11,res);
                break;


            case 12:
                getLabel(12,res);
                break;
            case 13:
                getLabel(13,res);
                break;
            case 14:
                getLabel(14,res);
                break;
            case 15:
                getLabel(15,res);
                break;

            default:
                alert("Cordenada Não Encontrada");

        }
    }

    private boolean compara(int casa,int atributo){

        boolean achou = true;

        int linha=0;
        int coluna=0;

        switch (casa){

            case 0:
                linha = 0;
                coluna = 0;
                break;
            case 1:
                linha = 0;
                coluna = 1;
                break;
            case 2:
                linha = 0;
                coluna = 2;
                break;
            case 3:
                linha = 0;
                coluna = 3;
                break;

            case 4:
                linha = 1;
                coluna = 0;
                break;
            case 5:
                linha = 1;
                coluna = 1;
                break;
            case 6:
                linha = 1;
                coluna = 2;
                break;
            case 7:
                linha = 1;
                coluna = 3;
                break;

            case 8:
                linha = 2;
                coluna = 0;
                break;
            case 9:
                linha = 2;
                coluna = 1;
                break;
            case 10:
                linha = 2;
                coluna = 2;
                break;
            case 11:
                linha = 2;
                coluna = 3;
                break;


            case 12:
                linha = 3;
                coluna = 0;
                break;
            case 13:
                linha = 3;
                coluna = 1;
                break;
            case 14:
                linha = 3;
                coluna = 2;
                break;
            case 15:
                linha = 3;
                coluna = 3;
                break;

        }

        if(matriz[linha][coluna] == atributo){
            print("Matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna] +" == "+atributo);
            achou = true;
        }
        else{
            achou = false;
        }

        return achou;
    }

    private void attCoordenada(int casa,int atributo){

        switch (casa){

            case 0:
                matriz[0][0] = atributo;
                break;
            case 1:
                matriz[0][1] = atributo;
                break;
            case 2:
                matriz[0][2] = atributo;
                break;
            case 3:
                matriz[0][3] = atributo;
                break;

            case 4:
                matriz[1][0] = atributo;
                break;
            case 5:
                matriz[1][1] = atributo;
                break;
            case 6:
                matriz[1][2] = atributo;
                break;
            case 7:
                matriz[1][3] = atributo;
                break;

            case 8:
                matriz[2][0] = atributo;
                break;
            case 9:
                matriz[2][1] = atributo;
                break;
            case 10:
                matriz[2][2] = atributo;
                break;
            case 11:
                matriz[2][3] = atributo;
                break;


            case 12:
                matriz[3][0] = atributo;
                break;
            case 13:
                matriz[3][1] = atributo;
                break;
            case 14:
                matriz[3][2] = atributo;
                break;
            case 15:
                matriz[3][3] = atributo;
                break;

            default:
                JOptionPane.showMessageDialog(null,"Cordenada Não Encontrada");

        }
    }


    private void atribuirFedor() {

        int i = 0, j;

        while (i < 4) {
            j = 0;
            while (j < 4) {

                //colocar o fedor ao redos do wumpus -falta unir com o ouro

                if (matriz[i][j] == vi.wumpus) {


                    //left i != 0
                    int a = j, b = j;
                    int c = i, d = i;


                    //left
                    if (a != 0) {
                        if (matriz[i][a - 1] != vi.personagem && matriz[i][a - 1] != vi.poco) {

                            if (matriz[i][a - 1] == 0) {
                                matriz[i][a - 1] = vi.fedor;
                            } else if (matriz[i][a - 1] == vi.ouro) {
                                matriz[i][a - 1] = vi.fedor_ouro;
                            }
                        }
                    }


                    //rigth
                    if (b != 3) {
                        if (matriz[i][b + 1] != vi.personagem && matriz[i][b + 1] != vi.poco) {

                            if (matriz[i][b + 1] == 0) {
                                matriz[i][b + 1] = vi.fedor;
                            } else if (matriz[i][b + 1] == vi.ouro) {
                                matriz[i][b + 1] = vi.fedor_ouro;
                            }
                        }
                    }


                    //up
                    if (c != 0) {
                        if (matriz[c - 1][j] != vi.personagem && matriz[c - 1][j] != vi.poco) {

                            if (matriz[c - 1][j] == 0) {
                                matriz[c - 1][j] = vi.fedor;
                            } else if (matriz[c - 1][j] == vi.ouro) {
                                matriz[c - 1][j] = vi.fedor_ouro;
                            }
                        }
                    }

                    //down
                    if (d != 3) {
                        if (matriz[d + 1][j] != vi.personagem && matriz[d + 1][j] != vi.poco) {

                            if (matriz[d + 1][j] == 0) {
                                matriz[d + 1][j] = vi.fedor;
                            } else if (matriz[d + 1][j] == vi.ouro) {
                                matriz[d + 1][j] = vi.fedor_ouro;
                            }
                        }
                    }

                }//end if

                j++;
            }//end while j
            i++;
        }//end while i
    }

    private void atribuirbrisa () {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {


                if (matriz[i][j] == vi.poco) {

                    //left i != 0
                    int a = j, b = j;
                    int c = i, d = i;


                    //bug 1 up i-1, j = 1 0


                    //left
                    if (a != 0) {
                        if (matriz[i][a - 1] != vi.personagem && matriz[i][a - 1] != vi.wumpus && matriz[i][a - 1] != vi.poco) {

                            if (matriz[i][a - 1] == 0) {
                                matriz[i][a - 1] = vi.brisa;
                            }
                            else if (matriz[i][a - 1] == vi.fedor) {
                                matriz[i][a - 1] = vi.fedor_brisa;
                            }
                            else if (matriz[i][a - 1] == vi.ouro) {
                                matriz[i][a - 1] = vi.brisa_ouro;
                            }
                            else if (matriz[i][a - 1] == vi.fedor_ouro) {
                                matriz[i][a - 1] = vi.fedor_brisa_ouro;
                            }
                        }
                    }


                    //rigth
                    if (b != 3) {
                        if (matriz[i][b + 1] != vi.personagem && matriz[i][b + 1] != vi.wumpus && matriz[i][b + 1] != vi.poco) {

                            if (matriz[i][b + 1] == 0) {
                                matriz[i][b + 1] = vi.brisa;
                            }

                            else if (matriz[i][b + 1] == vi.fedor) {
                                matriz[i][b + 1] = vi.fedor_brisa;
                            }

                            else if (matriz[i][b + 1] == vi.ouro) {
                                matriz[i][b + 1] = vi.brisa_ouro;
                            }

                            else if (matriz[i][b + 1] == vi.fedor_ouro) {
                                matriz[i][b + 1] = vi.fedor_brisa_ouro;
                            }
                        }
                    }


                    //up i |bug 1 [1,0] |
                    if (c != 0) {
                        if (matriz[c - 1][j] != vi.personagem && matriz[c-1][j] != vi.wumpus && matriz[c-1][j] != vi.poco) {

                            if (matriz[c - 1][j] == vi.fedor) {
                                matriz[c - 1][j] = vi.fedor_brisa;
                            } else if (matriz[c - 1][j] == 0) {
                                matriz[c - 1][j] = vi.brisa;
                            } else if (matriz[c - 1][j] == vi.ouro) {
                                matriz[c - 1][j] = vi.brisa_ouro;
                            } else if (matriz[c - 1][j] == vi.fedor_ouro) {
                                matriz[c - 1][j] = vi.fedor_brisa_ouro;
                            }
                        }
                    }

                    //down i
                    if (d != 3) {
                        if (matriz[d + 1][j] != vi.personagem && matriz[d+1][j] != vi.wumpus && matriz[d+1][j] != vi.poco) {

                            if (matriz[d + 1][j] == vi.fedor) {
                                matriz[d + 1][j] = vi.fedor_brisa;
                            } else if (matriz[d + 1][j] == 0) {
                                matriz[d + 1][j] = vi.brisa;
                            } else if (matriz[d + 1][j] == vi.ouro) {
                                matriz[d + 1][j] = vi.brisa_ouro;
                            } else if (matriz[d + 1][j] == vi.fedor_ouro) {
                                matriz[d + 1][j] = vi.fedor_brisa_ouro;
                            }


                        }
                    }

                }//end if de poco
            }
        }
    }


    private boolean verificaLinhaColuna(int linha, int coluna){

        boolean b_linha = false;
        boolean b_coluna = false;

        print("VerificarLinhaColuna >>> linha = "+linha+" && coluna = "+coluna+"\n");

        if(linha == 0 || linha == 1 || linha == 2 || linha == 3){
            b_linha = true;
        }

        if(coluna == 0 || coluna == 1 || coluna == 2 || coluna == 3){
            b_coluna = true;
        }

        if(b_linha && b_coluna){
            return true;
        }

        return false;
    }




    private int Find(int linha, int coluna){

        // 9 possibilidades

        //blindagem caso o indice ou coluna nao seja valido


        if(verificaLinhaColuna(linha,coluna)){

            print("Valido i:["+linha+"]  j:["+coluna+"] ");

            //casa em branco

            /***=====================DEMAIS CASOS VALIDOS==========================*/


            if(matriz[linha][coluna] == vi.cs_branco){
                return vi.cs_branco;
            }

            //ameca encontrada

            if(matriz[linha][coluna] == vi.wumpus){
                //encontrou o wumpus
                return vi.wumpus;
            }

            if (matriz[linha][coluna] == vi.poco){
                //controu o poco
                return vi.poco;
            }

            //sensores encontrados

            if(matriz[linha][coluna] == vi.fedor){
                //encontrou o fedor
                return vi.fedor;
            }

            if(matriz[linha][coluna] == vi.brisa){
                //encontrou a brisa
                return  vi.brisa;
            }

            if(matriz[linha][coluna] == vi.fedor_brisa){
                //encontrou fedor brisa
                return vi.fedor_brisa;
            }


            //ouro encontrado


            if(matriz[linha][coluna] == vi.fedor_ouro){
                //finalmente encontrou o ouro
                return vi.fedor_ouro;
            }

            if(matriz[linha][coluna] == vi.brisa_ouro){
                //finnalmente encontrou o ouro
                return  vi.brisa_ouro;
            }

            if(matriz[linha][coluna] == vi.fedor_brisa_ouro){
                //finalmente encontrou o ouro
                return vi.fedor_brisa_ouro;
            }

            if(matriz[linha][coluna] == vi.ouro){
                //finalmente encontrou o ouro
                return vi.ouro;
            }


            //===================================================// novas combinacoes


            //casas com rastro - press add 10

            if(matriz[linha][coluna] == vi.brisa_press){
                return vi.brisa_press;
            }

            if(matriz[linha][coluna] == vi.fedor_press){
                return vi.fedor_press;
            }

            if(matriz[linha][coluna] == vi.fedor_brisa_press){
                return vi.fedor_brisa_press;
            }

            if(matriz[linha][coluna] == vi.limpo_press){
                return vi.limpo_press;
            }

            if(matriz[linha][coluna] == vi.wumpus_dead_press){
                return vi.wumpus_dead_press;
            }



            //casas com personagem - sobre - add 6

            if(matriz[linha][coluna] == vi.p_brisa){
                return vi.p_brisa;
            }

            if(matriz[linha][coluna] == vi.p_fedor){
                return vi.p_fedor;
            }

            if(matriz[linha][coluna] == vi.p_fedor_brisa){
                return vi.p_fedor_brisa;
            }

            if(matriz[linha][coluna] == vi.p_wumpus_dead){
                return vi.p_wumpus_dead;
            }


            //casas com ouro e personagem - achou 56

            // fedor + brisa = 6

            if(matriz[linha][coluna] == vi.p_brisa_ouro){
                return vi.p_brisa_ouro;
            }

            if(matriz[linha][coluna] == vi.p_fedor_ouro){
                return vi.p_fedor_ouro;
            }

            if(matriz[linha][coluna] == vi.p_fedor_brisa_ouro){
                return vi.p_fedor_brisa_ouro;
            }

            if(matriz[linha][coluna] == vi.p_ouro){
                return vi.p_ouro;
            }

        }

        else{
            print("Nao Valido");
            return vi.parede;
        }

        return 408;
    }


    //- sem interface

    private int verAcima(int linha, int coluna){

        //procurar por sensores e retornar uma posicao

        int acima_i = linha-1;
        int acima_j = coluna;


        return Find(acima_i,acima_j);

    } //fim acima

    private int verAbaixo(int linha, int coluna){

        //procurar por sensores e retornar uma posicao

        int acima_i = linha+1;
        int acima_j = coluna;

        return Find(acima_i,acima_j);

    }

    private int verDireita(int linha, int coluna){
        //procurar por sensores e retornar uma posicao

        int acima_i = linha;
        int acima_j = coluna+1;

        return Find(acima_i,acima_j);

    }

    private int verEsquerda(int linha, int coluna){
        //procurar por sensores e retornar uma posicao

        int acima_i = linha;
        int acima_j = coluna-1;

        return Find(acima_i,acima_j);
    }


    /**--------Controler para saber de uma casa irrelevante*/

    private boolean tunelIrrevelente(int linha, int coluna) {

        int li;
        int ci;
        int contadorBool = 0;
        int vet[] = new int[4];

        for(int i=0;i<4;i++){
            vet[i] = 0;
        }

        //verificar acima
        li = linha -1;
        ci = coluna;

             if(Find(li,ci) == vi.parede || Find(li,ci) == vi.poco){
                 vet[0] = -1;
             }

        //verificar esquerda
        li = linha;
        ci = coluna-1;

            if(Find(li,ci) == vi.parede || Find(li,ci) == vi.poco){
                vet[1] = -1;
            }

        //verificar direita
        li = linha;
        ci = coluna+1;

        if(Find(li,ci) == vi.parede || Find(li,ci) == vi.poco){
                vet[2] = -1;
            }

        //verificar abaixo
        li = linha+1;
        ci = coluna;

        if(Find(li,ci) == vi.parede || Find(li,ci) == vi.poco){
                vet[3] = -1;
            }


        print("Saida do vetor de cs_irrevelevante");
        for(int i=0;i<4;i++){
            print("Vet["+i+"] = "+vet[i]);
            if(vet[i] == -1){
                contadorBool++;
            }
        }

        print("Valor de contadorBoll = "+contadorBool);

        if(contadorBool == 3){
            return true;
        }


        return false;
    }


    //LARGURA = 956 ALTURA = 614
    //VAlor de x =497 && valor de y = 497

    /**==================================*/
    /**================MAIOR============*/
    /**==================================*/

    private void log(String direcao,int indice,int vetor[],int li, int ci, int linha, int coluna){

        String casa_atual = "PERSONAGEM = matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]+ " | Quantidade de Passos = mc["+linha+"]["+coluna+"] = "+vi.matrixCont[linha][coluna];
        String casa_possibilidade = "\nPode se mover para  = matriz["+li+"]["+ci+"] = "+matriz[li][ci]+ " | Quantidade de Passos = mc["+li+"]["+ci+"] = "+vi.matrixCont[li][ci];
        String posicao = "\nUsado o vetor["+indice+"] = "+vetor[indice] +" -> Para "+direcao;

        alert(stringMatrizCont()+"\n"+casa_atual+casa_possibilidade+posicao);
    }



    private int verificarPassadasAoredores(int vetor[],int i,int linha, int coluna)
    {

        //encontra a posicao atual do elemento e retrna ela

        int li;
        int ci;

        //o bug é aki - ok : tracking

        if(i == 0){
            print("Cima em arredores");

            //veridicando pra cima

            li = linha-1;
            ci = coluna;

            if(li >= 0){
                if(matriz[li][ci] == vetor[i]){

                    log("Acima",i,vetor,li,ci,linha,coluna);

                    return vi.matrixCont[li][ci];
                }
            }
        }

        if(i == 1){
            //veridicando pra baixo
            print("baixo em arredores");
            li = linha+1;
            ci = coluna;

            if(li <= 3){
                if(matriz[li][ci] == vetor[i]){

                    log("Baixo",i,vetor,li,ci,linha,coluna);

                    return vi.matrixCont[li][ci];
                }
            }
        }

        if(i == 2){
            //veridicando pra esquerda
            print("Esquerda em arredores");

            li = linha;
            ci = coluna-1;

            if(ci >= 0){
                if(matriz[li][ci] == vetor[i]){

                    log("Esquerda",i,vetor,li,ci,linha,coluna);

                    return vi.matrixCont[li][ci];
                }
            }
        }


        if(i == 3){

            //veridicando pra direita
            print("Direita em arredores");

            li = linha;
            ci = coluna+1;

            if(ci <= 3){
                if(matriz[li][ci] == vetor[i]){

                    log("Direita",i,vetor,li,ci,linha,coluna);

                    return vi.matrixCont[li][ci];
                }
            }
        }


        return 9090;
    }

    private String getSensor(int sensor){


        if(sensor == vi.cs_branco){
            return " Sem Rastro ";
        }

        if(sensor == vi.wumpus){
            return " Wumpus ";
        }

        if(sensor == vi.fedor){
            return "  Fedor ";
        }

        if(sensor == vi.poco){
            return "Poco ";
        }

        if(sensor == vi.brisa){
            return "Brisa ";
        }

        if(sensor == vi.ouro){
            return " Ouro ";
        }

        if(sensor == vi.parede){
            return "Parede ";
        }


        /**---------combinações de fedor ouro e brisa-----**/


        if(sensor == vi.fedor_brisa){
            return " Fedor / Brisa ";
        }

        if(sensor == vi.fedor_ouro){
            return " Fedor / Ouro ";
        }

        if(sensor == vi.brisa_ouro){
            return " Brisa / Ouro ";
        }

        if(sensor == vi.fedor_brisa_ouro){
            return "Fedor / Brisa / Ouro ";
        }


        /**---------casas com rastro - press add 10--------------*/

        if(sensor == vi.brisa_press){
            return " Brisa / Pegadas ";
        }

        if(sensor == vi.fedor_press){
            return " Fedor / Pegadas";
        }

        if(sensor == vi.fedor_brisa_press){
            return " Fedor / Brisa / Pegadas";
        }

        if(sensor == vi.limpo_press){
            return " Pegadas";
        }

        if(sensor == vi.wumpus_dead_press){
            return " Wumpus Morto / Pegadas";
        }


        return " Sem id = ["+sensor+"]";
    }


    /**==========================================================================================*/
    /***===================funcao que retorna qual casa andar de acordo com prioridades==========*/
    /**==========================================================================================*/

    private int prioridades(int vetor[], int linha, int coluna){

        print("O GAMEPLAY ESTA EM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);

        //retorna o valor de maior prioridade



        print("\n\nRecebido...\n");

        //prioridade é a busca pela ouro

        for(int i=0;i<4;i++){

            if(vetor[i] == vi.ouro || vetor[i] == vi.fedor_ouro || vetor[i] == vi.brisa_ouro || vetor[i] == vi.fedor_brisa_ouro){
                //retorna o ouro
                str_sensor = getSensor(vetor[i]);
                return i;

            }

        }

        //se nao achou busca uma casa em branco para andar

        for(int i=0;i<4;i++){
             if(vetor[i] == vi.cs_branco){
                 str_sensor = getSensor(vetor[i]);
                 return i;
            }
        }



        //senao apela pra andar pelo fedor

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.fedor){

                str_sensor = getSensor(vetor[i]);
                return i;
            }
        }

        //senao apela pra andar pelo brisa

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.brisa){
                str_sensor = getSensor(vetor[i]);
                return i;
            }
        }


        //anda por uma casa com fedor e brisa

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.fedor_brisa){
                str_sensor = getSensor(vetor[i]);
                return i;
            }
        }


        if(vi.matrixCont[linha][coluna] > 1){
            for(int i=0;i<4;i++){
                if(vetor[i] == vi.wumpus){
                    str_sensor = getSensor(vetor[i]);
                    return i;
                }
            }
        }


        /**==========================CONDICAO DE SELECAO POR CONTAGEM========================*/

        //anda por uma casa pisada

        for(int i=0;i<4;i++){

            if(vetor[i] == vi.limpo_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em limpo press "+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if( tmp != -1 && tmp < MAIOR){
                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }

            }
        }

        //senao apela pra andar pelo fedor pisada

        for(int i=0;i<4;i++){

            if(vetor[i] == vi.fedor_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em fedor press "+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if( tmp != -1 && tmp < MAIOR){
                    print(">>>>> matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }

            }
        }

        //senao apela pra andar pelo brisa pisada

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.brisa_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em brisa press vetor["+i+"]"+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if(tmp != -1 && tmp < MAIOR){

                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    print("Foi retornado vetor["+i+"] = "+vetor[i]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
            }
        }

        //faltando fedor brisa press

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.fedor_brisa_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em brisa press vetor["+i+"]"+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if(tmp != -1 && tmp < MAIOR){

                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    print("Foi retornado vetor["+i+"] = "+vetor[i]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
            }
        }


        for(int i=0;i<4;i++){
            if(vetor[i] == vi.wumpus_dead_press){
                str_sensor = getSensor(vetor[i]);

                return i;
            }
        }

        //anda por uma casa pisada

        /**===========================================================================*/


        for(int i=0;i<4;i++){

            if(vetor[i] == vi.wumpus){
                //encontrou o wumpus
                str_sensor = getSensor(vetor[i]);
                return i;
            }
        }

        //se entrar em loop de maior

        for(int i=0;i<4;i++){

            if(vetor[i] == vi.limpo_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em limpo press "+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if( tmp != -1 && tmp < MAIOR){
                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
                else if(tmp <= MAIOR){
                    return i;
                }

            }
        }

        //senao apela pra andar pelo fedor pisada

        for(int i=0;i<4;i++){
            str_sensor = getSensor(vetor[i]);
            if(vetor[i] == vi.fedor_press){

                print("Entrou em fedor press "+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if( tmp != -1 && tmp < MAIOR){
                    print(">>>>> matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
                else if(tmp <= MAIOR){
                    return i;
                }

            }
        }

        //senao apela pra andar pelo brisa pisada

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.brisa_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em brisa press vetor["+i+"]"+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if(tmp != -1 && tmp < MAIOR){

                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    print("Foi retornado vetor["+i+"] = "+vetor[i]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
                else if(tmp <= MAIOR){
                    return i;
                }
            }
        }

        for(int i=0;i<4;i++){
            if(vetor[i] == vi.fedor_brisa_press){
                str_sensor = getSensor(vetor[i]);
                print("Entrou em brisa press vetor["+i+"]"+vetor[i]);

                int tmp = verificarPassadasAoredores(vetor,i,linha,coluna);

                if(tmp != -1 && tmp < MAIOR){

                    print(">>>>>PERSONAGEM matriz["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
                    print("Foi retornado vetor["+i+"] = "+vetor[i]);

                    return i;
                }
                else if(tmp != -1 && vi.matrixCont[linha][coluna] == -1){
                    return i;
                }
                else if(tmp <= MAIOR){
                    return i;
                }
            }
        }


        return 410;
    }


    /**======================================================================================*/


    private void verificacaoAchouOuro(int linha_atual, int coluna_atual){

        //todas as possibilidades do ouro com od demais componetes

        if(matriz[linha_atual][coluna_atual] == vi.p_ouro ){
            achou_ouro = true;
        }

        if(matriz[linha_atual][coluna_atual] == vi.p_brisa_ouro){
            achou_ouro = true;
        }

        if(matriz[linha_atual][coluna_atual] == vi.p_fedor_ouro){
            achou_ouro = true;
        }

        if(matriz[linha_atual][coluna_atual] == vi.p_fedor_brisa_ouro){
            achou_ouro = true;
        }


    }

    private void modificarCasaAnterior(int l_anterior, int c_anterior){

        /****CASA ANTERIOR*/


        if(matriz[l_anterior][c_anterior] == vi.personagem){
            matriz[l_anterior][c_anterior] = vi.limpo_press;
        }


        if(matriz[l_anterior][c_anterior] == vi.p_limpo_press){
            matriz[l_anterior][c_anterior] = vi.limpo_press;
        }


        if(matriz[l_anterior][c_anterior] == vi.p_fedor){
            matriz[l_anterior][c_anterior] = vi.fedor_press;
        }

        if(matriz[l_anterior][c_anterior] == vi.p_fedor_press){
            matriz[l_anterior][c_anterior] = vi.fedor_press;
        }


        if(matriz[l_anterior][c_anterior] == vi.p_brisa || matriz[l_anterior][c_anterior] == vi.p_brisa_press){
            matriz[l_anterior][c_anterior] = vi.brisa_press;
        }


        if(matriz[l_anterior][c_anterior] == vi.p_fedor_brisa || matriz[l_anterior][c_anterior] == vi.p_fedor_brisa_press){
            matriz[l_anterior][c_anterior] = vi.fedor_brisa_press;
        }

        if(matriz[l_anterior][c_anterior] == vi.p_wumpus_dead){
            matriz[l_anterior][c_anterior] = vi.wumpus_dead_press;
        }







        //casas pisadas jah------------------------------


    }

    private void modificarCasaPisada(int l_atual, int c_atual){

            /**CASA A QUE O PERSONAGEM SE MOVEU**/

        /***POSSIBILIDAES COM OS DEMAIS COMPONESTES SEM O OURO*/

        //casa em branco deixando ela pisada
        if(matriz[l_atual][c_atual] == vi.cs_branco){
            matriz[l_atual][c_atual] = vi.personagem;
        }

        //casas normais----------------------------

        //casa pisada - permanece pisada
        if(matriz[l_atual][c_atual] == vi.limpo_press){
            matriz[l_atual][c_atual] = vi.p_limpo_press;
        }

        //casa com fedor - personagem com fedor
        if(matriz[l_atual][c_atual] == vi.fedor){
            matriz[l_atual][c_atual] = vi.p_fedor;
        }

        //casa com brisa - personagem brisado
        if(matriz[l_atual][c_atual] == vi.brisa){
            matriz[l_atual][c_atual] = vi.p_brisa;
        }

        //casa com fedor brisa - personagem brisado com fedor
        if(matriz[l_atual][c_atual] == vi.fedor_brisa){
            matriz[l_atual][c_atual] = vi.p_fedor_brisa;
        }


        //casas pisadas jah------------------------------


        //casa com fedor - personagem com fedor
        if(matriz[l_atual][c_atual] == vi.fedor_press){
            matriz[l_atual][c_atual] = vi.p_fedor_press;
        }

        //casa com brisa - personagem brisado
        if(matriz[l_atual][c_atual] == vi.brisa_press){
            matriz[l_atual][c_atual] = vi.p_brisa_press;
        }

        //casa com fedor brisa - personagem brisado com fedor
        if(matriz[l_atual][c_atual] == vi.fedor_brisa_press){
            matriz[l_atual][c_atual] = vi.p_fedor_brisa_press;
        }




        /***POSSIBILIDADES COM O OURO***/


        //casa com ouro - personagem brisado
        if(matriz[l_atual][c_atual] == vi.ouro){
            matriz[l_atual][c_atual] = vi.p_ouro;
            //+------------------para a busca-------------------+
        }

        if(matriz[l_atual][c_atual] == vi.fedor_ouro){
            matriz[l_atual][c_atual] = vi.p_fedor_ouro;
            //+------------------para a busca-------------------+
        }

        if(matriz[l_atual][c_atual] == vi.brisa_ouro){
            matriz[l_atual][c_atual] = vi.p_brisa_ouro;
            //+------------------para a busca-------------------+
        }

        if(matriz[l_atual][c_atual] == vi.fedor_brisa_ouro){
            matriz[l_atual][c_atual] = vi.p_fedor_brisa_ouro;
            //+------------------para a busca-------------------+
        }

        /**===========================La muerte de Wumpus=====================*/

        if(matriz[l_atual][c_atual] == vi.wumpus ){
            //tocar som de la muerte
            tc.tocar_gritar_wumpus();
            matriz[l_atual][c_atual] = vi.p_wumpus_dead;

        }

        /**==================================================================*/

        /*DEPOIS DE ENCONTRADO O OURO - QUANDO FOR VOLTAR TIRA O OURO DA CASA*/



    }

    private void marcarTunelIrrelevante(int linha, int coluna){
        if(tunelIrrevelente(linha,coluna)){
            alert("Tunel Irrelevante");
            vi.matrixCont[linha][coluna] = -1;
        }
    }



    private void updateMedidasDesempenho(int number){
        vi.ponto_desempenho += number;
        mdd.setPontos(""+vi.ponto_desempenho);
    }



    /**-----------LADOS-----------------------------**/

    private void mover_cima(int linha, int coluna){

        print("mover para cima");

        modificarCasaAnterior(linha,coluna);
        modificarCasaPisada((linha-1),coluna);

        //terminal.actionLog("Antes =  m["+linha+"]["+coluna+"] = "+matriz[linha][coluna]);
        //terminal.actionLog("Movido para cima =  m["+(linha-1)+"]["+coluna+"] = "+matriz[(linha-1)][coluna]);

        marcarTunelIrrelevante(linha-1,coluna);

        if(vi.matrixCont[linha-1][coluna] != -1){
            vi.matrixCont[linha-1][coluna] += 1;
        }

        tc.tocar_pulo();

        verificacaoAchouOuro((linha-1), coluna);

        updateMedidasDesempenho(-1);


    }

    private void mover_baixo(int linha, int coluna){
        //mover para abaixo
        print("mover para abaixo");

        modificarCasaAnterior(linha,coluna);
        modificarCasaPisada((linha+1),coluna);

        marcarTunelIrrelevante(linha+1,coluna);

        if(vi.matrixCont[linha+1][coluna] != -1){
            vi.matrixCont[linha+1][coluna] += 1;
        }

        tc.tocar_pulo();

        verificacaoAchouOuro((linha+1), coluna);

        updateMedidasDesempenho(-1);
    }

    private void mover_esquerda(int linha, int coluna){
        //mover para esquerda
        print("mover para esquerda");
        modificarCasaAnterior(linha,coluna);
        modificarCasaPisada(linha,(coluna-1));


        marcarTunelIrrelevante(linha,coluna-1);

        if(vi.matrixCont[linha][coluna-1] != -1){
            vi.matrixCont[linha][coluna-1] += 1;
        }

        tc.tocar_pulo();

        verificacaoAchouOuro(linha, (coluna-1));

        updateMedidasDesempenho(-1);
    }

    private void mover_direita(int linha, int coluna){
        //mover para direita
        print("mover para direita");
        modificarCasaAnterior(linha,coluna);
        modificarCasaPisada(linha,(coluna+1));

        marcarTunelIrrelevante(linha,coluna+1);

        if(vi.matrixCont[linha][coluna+1] != -1){
            vi.matrixCont[linha][coluna+1] += 1;
        }


        tc.tocar_pulo();

        verificacaoAchouOuro(linha, (coluna+1));

        updateMedidasDesempenho(-1);

    }



    private boolean semSaida(int vetor[]){

        if(vetor[0] == vi.poco && vetor[1] == vi.parede && vetor[2] == vi.parede && vetor[3] == vi.poco){
            return true;
        }

        return false;
    }

    /**-----------------------------------------------------------**/


    public void setIntancia(MedidaDesempenho md){

        print("primeirramente a instancia md nula ? ...: ");
        if(mdd == null){
            System.out.print(" YES. ");
        }
        else{
            System.out.print(" NO. ");
        }
        mdd = md;

        print("Depois do set esta nula ? ...: ");
        if(mdd == null){
            System.out.print(" YES. ");
        }
        else{
            System.out.print(" NO. ");
        }

    }


    /**______________________________________________________________________________________________**/
    /*********************_____FUNCAO PARA CONTROLE DE FLUXO _ RUNNING _***********************************/
    public void Racionais(){


        /***loop de movimentos*/


        /**Implementar la muerte del wumpus**/


        /*
        * Dois métodos
        *
        * 1-> andar e verificar casa por casa
        *
        * 2-> achar o ouro e colocar em um vetor para andar so de uma vez
        *
        * */


        /**========VARIABLES========*/

            int linha=195;
            int coluna=195;
            int vetor[] = new int[4];

        /**===========================*/

        //jsbdfudfiosldfnjsdbfjldsbfljdbfjksdb

        /**========Obtem a Posicao do Personagem=======================**/

            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){

                    if(matriz[i][j] == vi.personagem){
                        print("Personagem na casa["+i+"]["+j+"] - P ");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_brisa){
                        print("Personagem na casa["+i+"]["+j+"] - P_BRISA");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_fedor){
                        print("Personagem na casa["+i+"]["+j+"] - P_FEDOR");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_fedor_brisa){
                        print("Personagem na casa["+i+"]["+j+"] - P_FEDOR_BRISA");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_limpo_press){
                        print("Personagem na casa["+i+"]["+j+"] - P_LIMPO_PRESS");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_brisa_press){
                        print("Personagem na casa["+i+"]["+j+"] - P_BRISA_PRESS");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_fedor_press){
                        print("Personagem na casa["+i+"]["+j+"] - P_FEDOR_PRESS");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_wumpus_dead){
                        print("Personagem na casa["+i+"]["+j+"] - p_wumpus_dead");
                        linha = i;
                        coluna = j;
                    }

                    else if(matriz[i][j] == vi.p_wumpus_dead_press){
                        print("Personagem na casa["+i+"]["+j+"] - p_wumpus_dead_press");
                        linha = i;
                        coluna = j;
                    }

                }
            } //--localizacao obtida

            vetor[0] = verAcima(linha,coluna);

            vetor[1] = verAbaixo(linha,coluna);

            vetor[2] = verEsquerda(linha,coluna);

            vetor[3] = verDireita(linha,coluna);




            print("Exibindo o vetor com as localizações >>>");

            print("Foi achado acima = "+vetor[0]+" : vetor[0]");

            print("Foi achado abaixo = "+vetor[1]+" : vetor[1]");

            print("Foi achado Esquerda = "+vetor[2]+" : vetor[2]");

            print("Foi achado Direita = "+vetor[3]+" : vetor[3]");




        print("++++++++++++++++++++++CONTADOR is ["+contador+"] !!! ");


        //??????????????????????????????????????????????????????????????????????????????


        //trocar condicao por funcao que ver todas as possibilidades

        if(semSaida(vetor)){
            alert("Sem saida");
            sem_saida = true;
        }

        /**==============================================================*/



        /**===================AVALIAR QUAL MELHOR CAMINHO=======================**/


            //recebe as posicoes em um vetor e compara qual a melhor

            int indiceEscolhido = prioridades(vetor,linha,coluna);

                 if(indiceEscolhido == 410){
                       print("SEM SAIDA ____(saida de prioridades a 'escolha' : "+indiceEscolhido+")");
                 }else {
                     print("saida de prioridades a 'escolha' : " + indiceEscolhido);
                 }



        boolean defineUm = false; //entrar so uma vez em um dos lacos

        //depois pode ser definido um random ou prioritar

        if(indiceEscolhido == 0 && !defineUm){
            if(vetor[0] == vi.wumpus){
                //alert("Matar o wumpus ");
                updateMedidasDesempenho(-10);

                mover_cima(linha,coluna);
            }
            else{
                mover_cima(linha,coluna);
            }

            defineUm = true;
          linha -= 1;
        }

        if(indiceEscolhido == 1 && !defineUm){
            if(vetor[1] == vi.wumpus){
                updateMedidasDesempenho(-10);
                mover_baixo(linha,coluna);
            }
            else{
                mover_baixo(linha,coluna);
            }

            defineUm = true;
            linha += 1;
        }

        if(indiceEscolhido == 2 && !defineUm){
            if(vetor[2] == vi.wumpus){
                updateMedidasDesempenho(-10);
                mover_esquerda(linha,coluna);
            }
            else{
                mover_esquerda(linha,coluna);
            }
            defineUm = true;
          coluna -= 1;
        }

        if(indiceEscolhido == 3 && !defineUm){
            if(vetor[3] == vi.wumpus){
                updateMedidasDesempenho(-10);
                mover_direita(linha,coluna);
            }
            else{
                mover_direita(linha,coluna);
            }
         coluna += 1;
        }


        /**====================================================================**/






            /**============Atualizando O Layout de acordo com a Matriz**/

            terminal.actionLog("Ação => "+"Casa["+linha+"]["+coluna+"]  -|-  "+str_sensor);

            LogicaWitchLayout();


            /***========================================================*/






            /**================Condicao de Parada para a busca do ouro==================**/

            if(achou_ouro){

                updateMedidasDesempenho(1000);
                tc.tocar_encontrou();
                terminal.actionLog(sr.sen_encontrou_ouro);

            }

            else if(sem_saida){

               alert("Sem saida");
               tc.tocar_nao_encontrado();
               terminal.actionLog(sr.sen_sem_saida);

            }


            else if (!achou_ouro && !sem_saida){
                print("Dando um tempo..");
                Tempo(3);
                Racionais();
            }

            /**=================================================================**/

    }

    /**______________________________________________________________________________________________**/





    /**_______________________Partes de inicialização__________________________________________*/

    private void initBasics(){

        sem_saida = false;
        achou_ouro = false;
        MAIOR=0;
        contador=0;

        initMarizTabuleiro();
    }

    private void Add_Wumpus_Poco_Ouro(){

        attCoordenada(getCasa(), vi.wumpus);
        print("Atribuido wupus");
        viewMatriz();

        //sortear a posicao dos 3 pocos

        attCoordenada(getCasa(), vi.poco);
        attCoordenada(getCasa(), vi.poco);
        attCoordenada(getCasa(), vi.poco);

        print("Atribuido pocos[" + vi.poco + "] e ouro[" + vi.ouro + "]");

        attCoordenada(getCasa(), vi.ouro);
    }



    public void initComponetes(){

        initBasics();

        matriz[3][0] = vi.personagem;


        Add_Wumpus_Poco_Ouro();

        viewMatriz();

        initMatrizCont();

        //colocar os sensores

        //colocar o fedor e combinar com o ouro

        //colocar a brisa e combinar com fedor ou ouro

        atribuirFedor();
        atribuirbrisa();

        //colocar a brisa ao redos dos pocos - falta unir com o fedor - unido


        print(" Vendo o fedor[2] e a Brisa[4] and fedor_brisa[" + vi.fedor_brisa + "] ");
        viewMatriz();


        print("Chamando Interface grafica");


        interfaceGrafica();

        //conciliar os elementos da matriz com a interface

        LogicaWitchLayout();

        //pronto - agora vem a logica do game - tanks

    }

    public void EntradaHack(Entrada i){

        //so faz isso se as entradas forem validas

        initBasics();


        matriz[i.wumpus_linha][i.wumpus_coluna] = vi.wumpus;
        matriz[i.poco_1_linha][i.pocp_1_coluna] = vi.poco;
        matriz[i.poco_2_linha][i.pocp_2_coluna] = vi.poco;
        matriz[i.poco_3_linha][i.pocp_3_coluna] = vi.poco;
        matriz[i.ouro_linha][i.ouro_coluna] = vi.ouro;
        matriz[3][0] = vi.personagem;



        initMatrizCont();

        atribuirFedor();
        atribuirbrisa();

        print("Vendo MAtriz em Entrada");
        viewMatriz();
        print("Vendo Matriz em Entrada");

        interfaceGrafica();

        LogicaWitchLayout();

        alert("Iniciando o Game");

        Racionais();

    }

    /**_________________________________________________________________________________________**/





    /*********************************************************************************************************/
    /**________________________________________CONSTRUTOR___________________________________________________**/
    /*********************************************************************************************************/

        public Tabuleiro(int dim) {

            painel.setBorder(createEtchedBorder(new Color(200),new Color(62,96,207)));

            // inserir a imagem aqui para ficar como background
            painel.setBackground(new Color(115, 132, 207));

            tc = new TocarSom();

            vi = new Valores_Inteiros();

            sr = new Strings();

            terminal = new Painel_Terminal();

            DIM = dim;


        }

    /*********************************************************************************************************/
    /*********************************************************************************************************/

        }




    /*

    1 -> Medida de desempenho: +1.000 por pegar ouro, -1.000 se cair em um
    poço ou for devorado pelo Wumpus, -1 para cada ação executada, -10 pelo
    uso da flecha.


    2-> Atuadores: O agente pode mover-se para frente, virar à esquerda, virar à
     direita, agarrar um objeto e atirar a flecha.


    3-> Sensores: fedor (quadrados adjacentes ao Wumpus, exceto diagonal),
    brisa (quadrados adjacentes a um poço, exceto diagonal), brilho (quadrados
    onde existe ouro), impacto (ao caminhar para uma parede) e audição
    (percebe o grito do Wumpus quando ele é morto).


    */