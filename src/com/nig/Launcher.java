

package com.nig;

import com.nig.res.Fontes.Fontes;
import com.nig.res.Representation.Valores_Inteiros;
import com.nig.res.Strings.Strings;
import com.nig.about.About;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by marcos on 10/10/16.
 */



public class Launcher implements ActionListener {


    private void print(String m){
        System.out.println(m);
    }

    //****************************


    /*----Instancias de classe do java------*/

    JFrame window; //- frame root of app

    JPanel contentPainel; // - painel root of app
    JPanel painel_menu; //

    ImageIcon ic_sound;
    ImageIcon ic_no_sound;

    Painel_Terminal pt;
    JPanel background_caverna;

    Thread t;
    boolean cheack_thread = false;

    JButton bt_restar;
    JButton bt_sair;
    JButton bt_verMatriz;
    JButton bt_pause;
    JButton bt_entrada;
    JButton bt_about;
    JButton bt_settings;


    /*------------------------------------------*/


    /*-----instancias de classes minhas---------*/

    Tabuleiro tb;
    About ab;
    MedidaDesempenho md;
    Fontes ft;
    Valores_Inteiros vi;

    Strings str;

    /*------------------------------------------*/



    /*-----Variaveis primitivas-----------*/

    private int azul[] = new int[3];
    private int azul_claro[] = new int[3];

    //variaveis de tamanho e posicoes

    private int LARGURA;
    private int ALTURA;

     int caverna_x = 0;
     int caverna_y = 0;

     int DIM = 0;

    //variaveis outras

    private int SCALE;

    /*------------------------------------------*/




    /**-------------------FUNCOES-----------------------------------*/

    public void alert(String log){
        JOptionPane.showMessageDialog(null,log);
    }



    private void configurandoBackgroundCaverna(){

        background_caverna =  new JPanel();

        //calculo


        int x =  ((52 * LARGURA) / 100);

        int y = ((81 * ALTURA) / 100);

        caverna_x = x;
        caverna_y = y;

        print("\nVAlor de x =" +caverna_x+ " && valor de y = "+caverna_y);

        DIM = x / 4;

        print("DIM = 4");

        background_caverna.setBounds(50,50,caverna_x,caverna_y);


    }



    //funcao para adicionar as coordenadas do personagem a uma lista
    /**--------PAINEL TERMINAL-----------------*/
    private void AddCordenadas_A_Lista(){

        tb.terminal = new Painel_Terminal();
        tb.terminal.configurando_terminal(590,50,350,530);
        contentPainel.add(tb.terminal.painel_esq);

    }


    private void RedimensionarImagem(int x, int y){
        //icone com sound

        ImageIcon imageIcon = new ImageIcon(getClass().getResource(str.path_icon_sound)); // load the image to a imageIcon

        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        ic_sound = new ImageIcon(newimg);  // transform it back

        //icone sem sound

        ImageIcon imageIcon1 = new ImageIcon(getClass().getResource(str.path_icon_no_sound)); // load the image to a imageIcon

        Image image1 = imageIcon1.getImage(); // transform it

        Image newimg1 = image1.getScaledInstance(x, y,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        ic_no_sound = new ImageIcon(newimg1);  // transform it back


    }


    /*------configurações de botoes-----------*/
    private void configButton(){

        SCALE = 10;


        //configurações do butão restart

        int x = 10;
        int y = 2;
        int altura = (painel_menu.getHeight() - 4);
        int largura = 100;

        bt_restar = new JButton("Start");
        bt_restar.setFont(ft.Lucida);
        bt_restar.setBounds(x,y,largura,altura);
        bt_restar.setForeground(new Color(255,255,255));
        bt_restar.setBorder(null);
        bt_restar.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_restar.addActionListener(this);

        int x_p = bt_restar.getWidth() + (SCALE);

        bt_pause = new JButton("Pause");
        bt_pause.setFont(ft.Lucida);
        bt_pause.setBounds(x_p,y,largura,altura);
        bt_pause.setForeground(new Color(255,255,255));
        bt_pause.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_pause.setBorder(null);
        bt_pause.addActionListener(this);


        int x_vm = x_p  + bt_pause.getWidth() + SCALE;

        bt_verMatriz = new JButton("Ver Matriz");
        bt_verMatriz.setFont(ft.Lucida);
        bt_verMatriz.setBorder(null);
        bt_verMatriz.setBounds(x_vm,y,largura,altura);
        bt_verMatriz.setForeground(new Color(255,255,255));
        bt_verMatriz.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_verMatriz.addActionListener(this);

        int x_entrada = x_vm  + bt_verMatriz.getWidth() + SCALE;

        bt_entrada = new JButton("Entrada Hack");
        bt_entrada.setFont(ft.Lucida);
        bt_entrada.setBorder(null);
        bt_entrada.setBounds(x_entrada,y,largura,altura);
        bt_entrada.setForeground(new Color(255,255,255));
        bt_entrada.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_entrada.addActionListener(this);

        int x_a = (x_entrada + bt_entrada.getWidth() + SCALE);


        bt_about = new JButton("Sobre");
        bt_about.setFont(ft.Lucida);
        bt_about.setBounds(x_a,y,largura,altura);
        bt_about.setForeground(new Color(255,255,255));
        bt_about.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_about.setBorder(null);
        bt_about.addActionListener(this);
        painel_menu.add(bt_about);



        int x_s = (x_a + bt_about.getWidth() + SCALE);


        bt_sair = new JButton("Sair");
        bt_sair.setFont(ft.Lucida);
        bt_sair.setBounds(x_s,y,largura,altura);
        bt_sair.setForeground(new Color(255,255,255));
        bt_sair.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_sair.setBorder(null);
        bt_sair.addActionListener(this);


        int x_bt_settings = painel_menu.getWidth() - (largura/2);
        bt_settings = new JButton();
        bt_settings.setBounds(x_bt_settings,y,altura,altura);


        RedimensionarImagem(bt_settings.getWidth(),bt_settings.getWidth());


        bt_settings.setIcon(ic_sound);
        bt_settings.setBorder(null);
        bt_settings.setBackground(new Color(azul[0],azul[1],azul[2]));
        bt_settings.addActionListener(this);


    }


    /*------configura o painel------------*/
    private void setConfigPainel(){


        contentPainel.setLayout(null);
        contentPainel.setSize(LARGURA,ALTURA);


        //painel menu

        int x = 0;
        int y = 0;
        int largura = contentPainel.getWidth();
        int altura = contentPainel.getHeight();


        altura *= 0.05;

        painel_menu = new JPanel();
        painel_menu.setBackground(new Color(azul[0],azul[1],azul[2]));
        painel_menu.setBounds(x,y,largura,altura);
        painel_menu.setLayout(null);


        configButton();

        painel_menu.add(bt_restar);
        painel_menu.add(bt_verMatriz);
        painel_menu.add(bt_sair);
        painel_menu.add(bt_pause);
        painel_menu.add(bt_entrada);
        painel_menu.add(bt_settings);


        contentPainel.add(painel_menu);
        contentPainel.setBackground(new Color(255,255,255));
        contentPainel.setVisible(true);



    }


    //configuracoes do tamanho dos componentes
    private void definir_tamanhos(){

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension tamTela = kit.getScreenSize();

        int x = tamTela.width;
        int y = tamTela.height;

        x *= 0.7;
        y *= 0.8;

        LARGURA = x;
        ALTURA = y;

        print("LARGURA = "+LARGURA+" ALTURA = "+ALTURA);
        print("\n\nVendo tamaho do painel >> ");

        configurandoBackgroundCaverna();

    }


    //configurações de elementos dinamicos na janela
    private void initComponets(){

        definir_tamanhos();

        vi = new Valores_Inteiros();

        str = new Strings();


        ft = new Fontes();

       // redimensionarImagem();

        //adiciona o tabuleiro do wumpus ao painel dessa view
        tb = new Tabuleiro(DIM);

        print("valor de cx = "+caverna_x+"  && cy = "+caverna_y);

        tb.painel.setBounds(50,80,caverna_x,caverna_y);


        /**--------painel onde estara as medidas de desemenho-------------*/

        md = new MedidaDesempenho(50,40,caverna_x,30);

        contentPainel.add(md.view);
        contentPainel.add(md.sombra);


        //azul do vetor
        azul[0] = 62; azul[1] = 96; azul[2] = 207; //62,96,207

        azul_claro[0] = 0;
        azul_claro[1] = 191;
        azul_claro[2] = 255;

        contentPainel.add(tb.painel);


    }





    //configuraçoes de elementos estaticos na janela
    private void windows(){

        contentPainel = new JPanel();

        //instancia para criacao da janela
        window = new JFrame();
        window.setResizable(false);


        initComponets();

        //painel background do window(JFrame)
        setConfigPainel();

        AddCordenadas_A_Lista();


        //configurações da janela - window (JFrame)

        window.setTitle("Wumpus");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(contentPainel.getWidth(),contentPainel.getHeight());
        window.add(contentPainel);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

    //construtor
    public Launcher(){
        windows();
    }


    //funcao para tratamento do clique do botao com o mouse
    @Override
    public void actionPerformed(ActionEvent e) {


        /**________Botao Start_____________**/

        if (e.getSource() == bt_restar) {


                print("Instanciando a Thread!");
                t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        print("Iniciando a Thread");

                        tb.setIntancia(md);
                        tb.initComponetes();
                        tb.Racionais();
                        pt.actionLog("Init componets");
                    }
                });

                t.start();
                print("Thread Iniciada");

            print("O id no  = "+t.getId());



        }



        /**________Botao Pause_____________**/

        if(e.getSource() == bt_pause){


            if(t == null){
               // alert("A busca ainda não começou!");
                print("VALIDAR A INSTANCIA DA THREAD SE FOR NULL");
            }
            else{

                if(!cheack_thread){
                    bt_pause.setText("Resumir");

                    print("Interrompendo a Thread");
                    cheack_thread = true;
                }
                else if(cheack_thread){

                    bt_pause.setText("Pause");
                    print("Resumindo a Thread!");
                    cheack_thread = false;


                }
            }

            JOptionPane.showMessageDialog(null,tb.stringMatrizCont());
            /**=================================================*/


        }



        /**________Botao Ver Matriz_____________**/

        if(e.getSource() == bt_verMatriz){

            String matriz = "+--------Matriz-------+ \n";

            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if( j == 3){

                        matriz = matriz + " "+ tb.matriz[i][j]+" "+"\n";
                    }
                    else{
                        matriz = matriz + " "+ tb.matriz[i][j]+" ";
                    }
                }
            }
           JOptionPane.showMessageDialog(null,matriz);
        }



        /**________Botao Entrada_____________**/

        if(e.getSource() == bt_entrada){

            tb.setIntancia(md);
           new Entrada(tb);

        }


        /**________Botao Sobre_____________**/

        if(e.getSource() == bt_about){

            if(ab == null) {
                print("Instanciando About() ");
                ab = new About();
                ab.showWindows();
            }
            else{
                print("A bout() ja instanciado Instanciado");
                ab.showWindows();
                }

        }


        /**________Botao Sair_____________**/

        if(e.getSource() == bt_sair){
            System.exit(0);
        }



        /**--------Botao settings-----------*/

        if(e.getSource() == bt_settings){
            if(tb.tc.getSound_on_off()){
                tb.tc.setSound_on_off();
                bt_settings.setIcon(ic_no_sound);
            }else{
                tb.tc.setSound_on_off();
                bt_settings.setIcon(ic_sound);
            }
        }


    }




} /**End Class**/
