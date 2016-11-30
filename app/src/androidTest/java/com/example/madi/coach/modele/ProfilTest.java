package com.example.madi.coach.modele;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by madi on 16/11/2016.
 */
public class ProfilTest {

    // création d'un profil : femme de 67kg, 1m65, 35 ans private
    Profil profil = new Profil(60, 190, 18, 1);
    // résultat de l'img correspondant
    private float img = (float)7.85;
    // message correspondant
    private String message = "trop faible" ;
    @Test
    public void getImg() throws Exception {
        assertEquals(img, profil.getImg(), (float)0.1);
    }

    @Test
    public void getMessage() throws Exception {
        assertEquals(message, profil.getMessage());
    }

}