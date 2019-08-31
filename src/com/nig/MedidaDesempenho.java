
package com.nig;

import com.nig.res.Fontes.Fontes;

import javax.swing.*;
import java.awt.*;

/**
 * Created by marcos on 07/11/16.
 */
public class MedidaDesempenho {

    /**-------------OBJETOS------------*/

    JPanel view;
    JPanel sombra;

    JLabel label_info;

    Fontes ft;

    /**-------------INTEIROS------------*/

    private int width;
    private int heigth;

    private int p_x;
    private int p_y;


    /**------------FUNCOES------------*/

    public void setPontos(String pt){
        label_info.setText(" Medidas de Desempenho = "+pt+" ");
    }

    private void configLabel(String value){

        label_info.setForeground(new Color(255,255,255));
        label_info.setFont(ft.SanFrancisco);
        label_info.setText(" Medidas de Desempenho = "+value+" ");

    }

    private void _addToView_(){

        configLabel(" 0 ");

        view.add(label_info);


    }


    private void def_tamanhos(int x,int y, int w, int h){
        p_x = x;
        p_y = y;
        width = w;
        heigth = h;
    }

    private void _configView_(){

        sombra.setBackground(new Color(195,195,195));
        sombra.setBounds(p_x,(p_y+heigth),width,(heigth * 10 / 100));

        view.setBounds(p_x, p_y, width,heigth);
        view.setBackground(new Color(74, 74, 78));
    }

    private void _init_(){

        ft = new Fontes();

        view = new JPanel();
        sombra = new JPanel();
        label_info = new JLabel();

    }



    public MedidaDesempenho(int x,int y, int w, int h){

        _init_();

        def_tamanhos(x,y,w,h);

        _configView_();

        _addToView_();

    }

}
