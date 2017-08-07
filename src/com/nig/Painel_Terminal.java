package com.nig;

import com.nig.res.Fontes.Fontes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marcos on 24/10/16.
 */
public class Painel_Terminal {

    JPanel painel_esq;
    JPanel painel_redimensionavel;
    JScrollPane scroll;



     Fontes ft;


    public void AdicionarLabelPainelRedimensionavel(JPanel panel,String logs) {


        JPanel p;
        JLabel l;

        l = new JLabel(logs);
        l.setFont(ft.Lucida);


        p = new JPanel();
        p.add(l);


        p.setBackground(new Color(255,255,255));
        p.setMaximumSize(new Dimension(panel.getWidth() - 10, p.getMinimumSize().height)); //width - Integer.MAX_VALUE
        p.setVisible(true);


        panel.add(Box.createRigidArea(new Dimension(0, 4)));
        panel.add(p);
        panel.getRootPane().revalidate();

    }

    public void actionLog(String log){
        System.out.println("Clicado");
        AdicionarLabelPainelRedimensionavel(painel_redimensionavel,log);
    }


    public void configurando_terminal(int x, int y,int largura, int altura){

        ft = new Fontes();

        painel_esq = new JPanel(); //painel onde sera colocado a scroll
        painel_esq.setLayout(null);
        painel_esq.setBounds(x,y,largura,altura);
        painel_esq.setBackground(new Color(62,96,207)); //62,96,207 //80,80,80
        painel_esq.setVisible(true);

        scroll = new JScrollPane();
        scroll.setLocation(10,20);

        int a = painel_esq.getWidth()-20;
        int l = painel_esq.getHeight()-40;

        painel_redimensionavel = new JPanel();
        painel_redimensionavel.setLayout(new BoxLayout(painel_redimensionavel, BoxLayout.Y_AXIS));
        painel_redimensionavel.setSize(new Dimension(a, l));
        painel_redimensionavel.setBackground(new Color(221,221,224)); //zinza
        scroll.setViewportView(painel_redimensionavel);

        scroll.setSize(painel_redimensionavel.getSize());

        JLabel titulo_cordenadas = new JLabel("Movimentos");
        titulo_cordenadas.setForeground(new Color(255,255,255));
        titulo_cordenadas.setBounds(100,5,100,15);


        painel_esq.add(titulo_cordenadas);
        painel_esq.add(scroll);

    }



    public Painel_Terminal(){


    }


}
