package com.nig;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by marcos on 29/10/16.
 */
public class Entrada extends JFrame implements ActionListener{

    Tabuleiro tb;

    Thread t;

    JPanel contentPane;
    JPanel LinearLayout_vertical;


    JPanel painel_aviso;
    JPanel painel_info;
    JPanel painel_wumpus;
    JPanel painel_poco_1;
    JPanel painel_poco_2;
    JPanel painel_poco_3;
    JPanel painel_ouro;
    JPanel painel_space;
    JPanel painel_botao;

    JLabel lb_space;

    JLabel lb_info;

    JLabel lb_wumpus;
    JLabel lb_poco_1;
    JLabel lb_poco_2;
    JLabel lb_poco_3;
    JLabel lb_ouro;

    JLabel lb_tipo;
    JLabel lb_linha;
    JLabel lb_coluna;


    JComboBox cmBox_wumpus_linha;
    JComboBox cmBox_wumpus_coluna;

    JComboBox cmBox_poco_1_linha;
    JComboBox cmBox_poco_1_coluna;

    JComboBox cmBox_poco_2_linha;
    JComboBox cmBox_poco_2_coluna;

    JComboBox cmBox_poco_3_linha;
    JComboBox cmBox_poco_3_coluna;

    JComboBox cmBox_ouro_linha;
    JComboBox cmBox_ouro_coluna;


    JButton bt_validar;
    JButton bt_valores_padrao;

    /**===============INTEIROS==================*/

    public int per_linha;
    public int per_coluna;

    public int wumpus_linha;
    public int wumpus_coluna;

    public int poco_1_linha;
    public int pocp_1_coluna;

    public int poco_2_linha;
    public int pocp_2_coluna;

    public int poco_3_linha;
    public int pocp_3_coluna;

    public int ouro_linha;
    public int ouro_coluna;




    /**=========================================*/


    /**---------------------VIEW------------------------*/

    private void initLabels(){

        lb_info = new JLabel("Informe a linha e coluna para cada peça!");

        lb_wumpus = new JLabel("WUMPUS");

        lb_poco_1 = new JLabel("POCO 1");
        lb_poco_2 = new JLabel("POCO 2");
        lb_poco_3 = new JLabel("POCO 3");

        lb_ouro = new JLabel("OURO");

        lb_tipo = new JLabel("Peça");
        lb_coluna = new JLabel("Coluna");
        lb_linha = new JLabel("Linha");

        lb_space = new JLabel();

        bt_validar = new JButton("Inserir");
        bt_validar.addActionListener(this);

        bt_valores_padrao = new JButton("Valores Padrão");
        bt_valores_padrao.addActionListener(this);

    }

    private void initTextField(){

        cmBox_wumpus_linha = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_wumpus_linha.addItem(i);
        }

        cmBox_wumpus_coluna = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_wumpus_coluna.addItem(i);
        }

        //linhas

        cmBox_poco_1_linha = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_1_linha.addItem(i);
        }

        cmBox_poco_1_coluna = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_1_coluna.addItem(i);
        }

        cmBox_poco_2_linha = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_2_linha.addItem(i);
        }

        cmBox_poco_2_coluna = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_2_coluna.addItem(i);
        }

        cmBox_poco_3_linha = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_3_linha.addItem(i);
        }

        cmBox_poco_3_coluna = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_poco_3_coluna.addItem(i);
        }

        //ouro
        cmBox_ouro_linha = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_ouro_linha.addItem(i);
        }

        cmBox_ouro_coluna = new JComboBox();
        for(int i=0;i<4;i++){
            cmBox_ouro_coluna.addItem(i);
        }



    }

    private void AddComponetsToPanel(){

        initLabels();
        initTextField();

        painel_space = new JPanel();
        painel_space.setLayout(new GridLayout(1,1));
        painel_space.add(lb_space);


        painel_aviso = new JPanel();
        painel_aviso.setLayout(new GridLayout(1,1));
        painel_aviso.add(lb_info);


        painel_info = new JPanel();
        painel_info.setLayout(new GridLayout(1,3));
        painel_info.add(lb_tipo);
        painel_info.add(lb_linha);
        painel_info.add(lb_coluna);



        painel_wumpus = new JPanel();
        painel_wumpus.setLayout(new GridLayout(1,3));
        painel_wumpus.add(lb_wumpus);
        painel_wumpus.add(cmBox_wumpus_linha);
        painel_wumpus.add(cmBox_wumpus_coluna);


        painel_poco_1 = new JPanel();
        painel_poco_1.setLayout(new GridLayout(1,3));
        painel_poco_1.add(lb_poco_1);
        painel_poco_1.add(cmBox_poco_1_linha);
        painel_poco_1.add(cmBox_poco_1_coluna);

        painel_poco_2 = new JPanel();
        painel_poco_2.setLayout(new GridLayout(1,3));
        painel_poco_2.add(lb_poco_2);
        painel_poco_2.add(cmBox_poco_2_linha);
        painel_poco_2.add(cmBox_poco_2_coluna);

        painel_poco_3 = new JPanel();
        painel_poco_3.setLayout(new GridLayout(1,3));
        painel_poco_3.add(lb_poco_3);
        painel_poco_3.add(cmBox_poco_3_linha);
        painel_poco_3.add(cmBox_poco_3_coluna);


        painel_ouro = new JPanel();
        painel_ouro.setLayout(new GridLayout(1,3));
        painel_ouro.add(lb_ouro);
        painel_ouro.add(cmBox_ouro_linha);
        painel_ouro.add(cmBox_ouro_coluna);

        painel_botao = new JPanel();
        painel_botao.setLayout(new GridLayout());
        painel_botao.add(bt_validar);
        painel_botao.add(bt_valores_padrao);



    }

    private void addLinearLayout(){

        AddComponetsToPanel();

        LinearLayout_vertical = new JPanel();
        LinearLayout_vertical.setLayout(new GridLayout(11,1));

        LinearLayout_vertical.add(painel_aviso);
        LinearLayout_vertical.add(painel_info);
        LinearLayout_vertical.add(painel_wumpus);

        LinearLayout_vertical.add(painel_poco_1);
        LinearLayout_vertical.add(painel_poco_2);
        LinearLayout_vertical.add(painel_poco_3);
        LinearLayout_vertical.add(painel_ouro);

        LinearLayout_vertical.add(painel_space);

        LinearLayout_vertical.add(painel_botao);


        int largura = LinearLayout_vertical.getWidth();
        int altura = LinearLayout_vertical.getHeight();

        System.out.println("Altura  = "+altura+" e Largura = "+largura);


        LinearLayout_vertical.setBounds(10,10,300,200);

        contentPane.add(LinearLayout_vertical);
    }

    private void initComponets(){


        contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setSize(320,220);

        addLinearLayout();


    }

    /**-------------------------------------------------*/



    /**---------------------CONTROLLER------------------------*/

    public boolean itensSelecionados(){



        for(int i=0;i<4;i++){

            if(cmBox_wumpus_linha.getSelectedIndex() == i){
                this.wumpus_linha = i;
            }
            if(cmBox_wumpus_coluna.getSelectedIndex() == i){
                this.wumpus_coluna = i;
            }

            if(cmBox_poco_1_linha.getSelectedIndex() == i){
                this.poco_1_linha = i;
            }
            if(cmBox_poco_1_coluna.getSelectedIndex() == i){
                this.pocp_1_coluna = i;
            }

            if(cmBox_poco_2_linha.getSelectedIndex() == i){
                this.poco_2_linha = i;
            }
            if(cmBox_poco_2_coluna.getSelectedIndex() == i){
                this.pocp_2_coluna = i;
            }

            if(cmBox_poco_3_linha.getSelectedIndex() == i){
                this.poco_3_linha = i;
            }
            if(cmBox_poco_3_coluna.getSelectedIndex() == i){
                this.pocp_3_coluna = i;
            }

            if(cmBox_ouro_linha.getSelectedIndex() == i){
                this.ouro_linha = i;
            }
            if(cmBox_ouro_coluna.getSelectedIndex() == i){
                this.ouro_coluna = i;
            }

        }


        int mat[][] = new int[4][4];

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++) {
                mat[i][j] = 0;
            }
        }


        String msg = " ";
        msg = msg +" Wumpus linha = "+ wumpus_linha+"\n";
        msg = msg +" Wumpus Coluna = "+ wumpus_coluna+"\n";
        msg = msg +" Poco 1 Linha = "+ poco_1_linha+"\n";
        msg = msg +" Poco 1 Coluna = "+ pocp_1_coluna+"\n";
        msg = msg +" Poco 2 Linha = "+ poco_2_linha+"\n";
        msg = msg +" Poco 2 Coluna = "+ pocp_2_coluna+"\n";
        msg = msg +" Poco 3 Linha = "+ poco_3_linha+"\n";
        msg = msg +" Poco 3 Coluna = "+ pocp_3_coluna+"\n";
        msg = msg +" Ouro Linha = "+ ouro_linha+"\n";
        msg = msg +" Ouro Coluna = "+ ouro_coluna+"\n";


             per_linha = 3;
             per_coluna = 0;

            mat[per_linha][per_coluna] = 1;

            if(mat[wumpus_linha][wumpus_coluna] == 0){
                mat[wumpus_linha][wumpus_coluna] = 1;
            }
            else{
                return false;
            }

            if(mat[poco_1_linha][pocp_1_coluna] == 0){
                mat[poco_1_linha][pocp_1_coluna] = 1;
            }
            else{
                return false;
            }

            if(mat[poco_2_linha][pocp_2_coluna] == 0){
                mat[poco_2_linha][pocp_2_coluna] = 1;
            }
            else{
                return false;
            }

            if(mat[poco_3_linha][pocp_3_coluna] == 0){
                mat[poco_3_linha][pocp_3_coluna] = 1;
            }
            else{
                return false;
            }

            if(mat[ouro_linha][ouro_coluna] == 0){
                mat[ouro_linha][ouro_coluna] = 1;
            }
            else{
                return false;
            }


        JOptionPane.showMessageDialog(null,""+msg);

        return true;

    }

    public void vaulesDefault(){

        wumpus_linha = 1;
        wumpus_coluna = 3;

        poco_1_linha = 2;
        pocp_1_coluna = 0;

        poco_2_linha = 0;
        pocp_2_coluna = 1;

        poco_3_linha = 1;
        pocp_3_coluna = 2   ;

        ouro_linha = 0;
        ouro_coluna = 2;

    }

    /**--------------------------------------------------------*/


    /**===============CONSTRUTOR=====================*/

    public Entrada(Tabuleiro tb){

        this.tb = tb;

        initComponets();

        this.setTitle("Entrada");
        this.add(contentPane);
        this.setSize(contentPane.getWidth(),contentPane.getHeight());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {

        Entrada en = this;


        if(e.getSource() == bt_validar){

            if(itensSelecionados()){
            super.dispose();

                t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        tb.EntradaHack(en);
                    }
                });

                t.start();

            }
            else{
                JOptionPane.showMessageDialog(null,"Valores Invalidos");
            }

            //verificar se todos sao diferentes
        }


        if(e.getSource() == bt_valores_padrao){
            super.dispose();

            t = new Thread(new Runnable() {
                @Override
                public void run() {
                    vaulesDefault();
                    tb.EntradaHack(en);
                }
            });

            t.start();

        }

    }


    /**https://terminaldeinformacao.com/2013/05/22/entendendo-os-principais-componentes-de-um-jframe/mega**/

}
