
package com.nig;

import com.nig.res.Strings.Strings;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;


/**
 * Created by marcos on 24/10/16.
 */


public class TocarSom {

    Strings rc;

    private boolean sound_on = true;


    private void tocarpuloWav(){

        if(sound_on){
            try {

                URL url = getClass().getResource(rc.path_sound_pulo);
                AudioClip audio = Applet.newAudioClip(url);
                audio.play();

                System.out.println("Audio pulo carregado");

            }catch (Exception erro){
                System.out.println("Não foi possivel carregar o audio pulo");
            }
        }

    }



    public void tocar_pulo(){

        if(sound_on){

            try{
                tocarpuloWav();
                //tocarpulo_mp3();
                System.out.println("Pulou");
            }catch (Exception erro){
                System.out.println("Erro ao carregar o arquivo em tocar_pulo().");
            }
        }
    }


    public void tocar_encontrou(){


        JOptionPane.showMessageDialog(null,"Encontrou o ouro");


        if(sound_on){

            try {
                //URL url = getClass().getResource(rc.path_sound_encontrou);
                //AudioClip audio = Applet.newAudioClip(url);
                //audio.play();
            }
            catch (Exception erro){
                System.out.println("Não foi possivel carregar o audio encontrou");
            }
        }
    }


    public void tocar_gritar_wumpus(){


        if(sound_on){
            try {
                URL url = getClass().getResource(rc.path_sound_grito_wumpus);
                AudioClip audio = Applet.newAudioClip(url);
                audio.play();

            }catch (Exception erro){
                System.out.println("Não foi possivel carregar o audio grito wumpus");
            }
        }

    }

    public void tocar_nao_encontrado(){


        if(sound_on){
            try {
                URL url = getClass().getResource(rc.path_sound_noEncontrou);
                AudioClip audio = Applet.newAudioClip(url);
                audio.play();

            }catch (Exception erro){
                System.out.println("Não foi possivel carregar o audio nao encontrou");
            }
        }

    }

    public  TocarSom(){
      rc = new Strings();
    }




    /*-----GET && SET do booleano do ativador do som-------*/

    public void setSound_on_off(){
        if(sound_on){
            sound_on = false;
        }
        else{
            sound_on = true;
        }
    }

    public boolean getSound_on_off(){


        return this.sound_on;
    }




}
