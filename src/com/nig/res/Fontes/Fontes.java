
package com.nig.res.Fontes;

import com.nig.res.Strings.Strings;

import java.awt.*;
import java.io.File;

/**
 * Created by marcos on 07/11/16.
 */
public class Fontes {

    Strings str;
    String log  = "pacote res.Fontes";

    public Font SanFrancisco;
    public Font Lucida;
    public Font Helvetica;

    private void print(String m){
        System.out.println(m);
    }

    private void loading_fontes(){

        try {
            SanFrancisco = Font.createFont(Font.BOLD, new File(str.pathFont_SanFrancisco)).deriveFont(Font.BOLD, 28);
            print("Fonte SanFrancis carregada");
        }catch(Exception erro){
            print("Erro ao carregar a fonte san francisco."+log);
        }

        //Lucida Grande

        try {
            Lucida = Font.createFont(Font.BOLD, new File(str.pathFont_Lucida)).deriveFont(Font.BOLD, 28);
            print("Fonte Lucida carregada");
        }catch(Exception erro){
            print("Erro ao carregar a fonte lucida."+log);
        }

        //Helvetica

        try {
            Helvetica = Font.createFont(Font.TRUETYPE_FONT, new File(str.pathFont_Helvetica)).deriveFont(Font.BOLD, 28);
            print("Fonte Helvetica carregada");
        }catch(Exception erro){
            print("Erro ao carregar a fonte helvetica."+log);
        }
    }

    public Fontes(){
        //san francisco

        str = new Strings();

        loading_fontes();

    }






}
