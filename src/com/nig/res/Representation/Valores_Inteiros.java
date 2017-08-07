
package com.nig.res.Representation;

/**
 * Created by marcos on 27/10/16.
 */
public class Valores_Inteiros {


    /**---------componentes puros----------------------**/

    public static int cs_branco = 0;
    public static int wumpus = 1;
    public static int fedor = 2;
    public static int poco = 3;
    public static int brisa = 4;
    public static int ouro = 5;
    public static int personagem = 6;
    public static int parede = 404;


    /**---------combinações de fedor ouro e brisa-----**/

    public static int fedor_brisa = 24;
    public static int fedor_ouro = 25;
    public static int brisa_ouro = 45;
    public static int fedor_brisa_ouro = 245;


    /**---------casas com rastro - press add 10--------------*/

    public static int brisa_press = 40;
    public static int fedor_press = 20;
    public static int fedor_brisa_press = 240;
    public static int limpo_press = 10;
    public static int wumpus_dead_press = 100;


    /**---------casas com personagem - sobre - add 6----------*/

    public static int p_brisa = 64;
    public static int p_fedor = 62;
    public static int p_fedor_brisa = 624;
    public static int p_wumpus_dead = 61;


    /**---------casas com ouro e personagem - achou 56--------s*/

    // fedor + brisa = 6

    public static int p_brisa_ouro = 564;
    public static int p_fedor_ouro = 562;
    public static int p_fedor_brisa_ouro = 566;
    public static int p_ouro = 56;


    /**---------casas com personagem que ja foram presionadas------*/

    public static int p_brisa_press = 640;
    public static int p_fedor_press = 620;
    public static int p_fedor_brisa_press = 6240;
    public static int p_limpo_press = 610;
    public static int p_wumpus_dead_press = 6100;


    /**-------------Matriz para o personagem saber sobre o ambiente---------------*/

    public int matrixCont[][] = new int[4][4];


    /**--------------Valor para medida de desempenho------------------------------*/

    public int ponto_desempenho = 0;


}
