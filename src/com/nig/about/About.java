package com.nig.about;

import javax.swing.*;
import java.awt.*;


/**
 * Created by marcos on 02/11/16.
 */
public class About extends JFrame{

    private JPanel contentPane;
    private JPanel layout;

    private JPanel panel_title;

    private   JPanel panel_p1;
    private   JPanel panel_p2;
    private  JPanel panel_p3;

    private JLabel lb0;
    private JLabel lb1;
    private JLabel lb2;

    private JLabel lb3;
    private JLabel lb4;

    private JLabel lb5;
    private JLabel lb6;

    private ImageIcon img_ic;

    private static final String path_marcos = "../res/Imagens/tabuleiro/About/marcos"+".png";
    private static final String path_edson = "../res/Imagens/tabuleiro/About/ic_default"+".png";
    private static final String path_bunda = "../res/Imagens/tabuleiro/About/ic_default"+".png";

    private int WIDTH;
    private int HEIGTH;

    private  void redimensionarLabel(String res,int largura, int altura){

        ImageIcon imageIcon = new ImageIcon(getClass().getResource(res)); // load the image to a imageIcon

        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(largura, altura,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        img_ic  = new ImageIcon(newimg);  // transform it back
    }


    private void configureComponets(int width,int heigth){

        contentPane.setSize(width,heigth);
        contentPane.setLayout(new GridLayout(1,1));
        contentPane.setBackground(new Color(225, 39, 84)); //207,207, 207));


        int x=15;
        int y=0;

        int layout_width = contentPane.getWidth() - 30;
        int layout_heigth = contentPane.getHeight();

        layout.setBounds(x,y,layout_width,layout_heigth);
        layout.setLayout(null);
        layout.setBorder(BorderFactory.createEtchedBorder());




        /**----Tamanho dos paineis**/

        int SCALE_x = 30;
        int SCALE_y = 20;

        int size_w_panel_title = layout.getWidth() - 60;
        int size_h_panel_title = 50;



        lb0.setText("Desenvolvedores");
        lb0.setSize(size_w_panel_title,size_h_panel_title);
        lb0.setForeground(new Color(255,255,255));

        panel_title.add(lb0);
        panel_title.setBounds(SCALE_x, SCALE_y,size_w_panel_title,size_h_panel_title);
        panel_title.setBackground(new Color(62,96,207                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   ));
        layout.add(panel_title);



        //------------------------p1-------------------------//

        int x_lb1 = (size_w_panel_title - size_h_panel_title-10);
        int y_p1 = SCALE_y + panel_title.getHeight()+ SCALE_y;

        lb1.setBounds(x_lb1,0,size_h_panel_title,size_h_panel_title);

        String autor1 = "MARCOS VINICIUS - Programmmer";
        lb2.setText(autor1);
        lb2.setForeground(new Color(255,255,255));
        lb2.setBounds(10,0,200,size_h_panel_title);

        redimensionarLabel(path_marcos,lb1.getHeight(),lb1.getHeight());

        lb1.setIcon(img_ic);

        panel_p1.setLayout(null);
        panel_p1.add(lb2);
        panel_p1.add(lb1);
        panel_p1.setBounds(SCALE_x,y_p1,size_w_panel_title,size_h_panel_title);
        panel_p1.setBackground(new Color(62,96,207));
        layout.add(panel_p1);

        //-----------------------------------------------------------------//


        //----------------------------__p2__------------------------------//

        int y_p2 = SCALE_y + panel_title.getHeight() + y_p1;


        lb3.setBounds(x_lb1,0,size_h_panel_title,size_h_panel_title);

        String autor2 = "EDSON DAMASCENO - Engenheiro";
        lb4.setText(autor2);
        lb4.setForeground(new Color(255,255,255));
        lb4.setBounds(10,0,200,size_h_panel_title);

        redimensionarLabel(path_edson,lb1.getHeight(),lb1.getHeight());

        lb3.setIcon(img_ic);

        panel_p2.setLayout(null);
        panel_p2.add(lb4);
        panel_p2.add(lb3);
        panel_p2.setBounds(SCALE_x,y_p2,size_w_panel_title,size_h_panel_title);
        panel_p2.setBackground(new Color(62,96,207));
        layout.add(panel_p2);


        //-----------------------------------------------------------------//


        //----------------------------__p3__------------------------------//


        int y_p3 = SCALE_y + panel_title.getHeight() + y_p2;

        lb5.setBounds(x_lb1,0,size_h_panel_title,size_h_panel_title);

        String autor3 = "ANTONIO JUNIOR - Fez o café ";
        lb6.setText(autor3);
        lb6.setForeground(new Color(255,255,255));
        lb6.setBounds(10,0,200,size_h_panel_title);

        redimensionarLabel(path_bunda,lb1.getHeight(),lb1.getHeight());

        lb5.setIcon(img_ic);

        panel_p3.setLayout(null);
        panel_p3.add(lb6);
        panel_p3.add(lb5);
        panel_p3.setBounds(SCALE_x,y_p3,size_w_panel_title,size_h_panel_title);
        panel_p3.setBackground(new Color(62,96,207));
        layout.add(panel_p3);

        contentPane.add(layout);



        //-----------------------------------------------------------------//


    }

    private void initComponents(){

        contentPane = new JPanel();

        layout = new JPanel();

        panel_title = new JPanel();

        panel_p1 = new JPanel();
        panel_p2 = new JPanel();
        panel_p3 = new JPanel();

        lb0 = new JLabel();
        lb1 = new JLabel();
        lb2 = new JLabel();

        lb3 = new JLabel();
        lb4 = new JLabel();

        lb5 = new JLabel();
        lb6 = new JLabel();

    }

    public void showWindows(){
        this.setVisible(true);
    }

    public About(){

        initComponents();

        configureComponets(400,300);


        this.setTitle("About");
        this.add(contentPane);
        //this.setResizable(false);
        this.setSize(contentPane.getWidth(),contentPane.getHeight());
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(218, 225, 107));
        showWindows();



    }



}

//http://docs.oracle.com/javase/1.5.0/docs/api/javax/swing/BorderFactory.html