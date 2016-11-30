package com.example.madi.coach.controleur;

import com.example.madi.coach.modele.Profil;

/**
 * Created by madi on 16/11/2016.
 */

public final class Controle {
    private static Controle instance = null;
    private Profil profil;
    private Controle(){
        super();
    }

    public static final Controle getInstance(){
        if(Controle.instance == null ){
            Controle.instance = new Controle();
        }
        return Controle.instance;
    }

    /**
     * création du profil
     * @param poids
     * @param taille
     * @param age
     * @param sexe
     */
    public void creerProfil(Integer poids, Integer taille, Integer age,Integer sexe){
        this.profil = new Profil(poids,taille,age,sexe);
    }

    /**
     * retourn l'img du profil
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * retourne le message du profil
     * @return
     */
    public String getMessage(){
        return profil.getMessage();
    }
}
