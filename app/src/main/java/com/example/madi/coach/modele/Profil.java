package com.example.madi.coach.modele;

/**
 * Created by madi on 16/11/2016.
 */

public class Profil {
   private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;
    // constantes
    private static final Integer minFemme = 15;// maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 10; // maigre si en dessous
    private static final Integer maxHomme = 25; // gros si au dessus


    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        calculIMG();
        resultIMG();
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }
    private void calculIMG(){
        float tailleFloat = (float) taille/100;
        img = (float) ((1.2 * poids/(tailleFloat*tailleFloat)) + (0.23 * age) - (10.83 * sexe) - 5.4);
    }
    private void resultIMG(){
        if (sexe == 0) {
            if (img < minFemme) {
                message = "trop faible";
            }else if (img > maxFemme) {
                message = "trop élevé";
            } else {
                message = "super ! c'est normal";
            }
        }else{
            if (img < minHomme) {
                message = "trop faible";
            }else if(img > maxHomme) {
                message = "trop élevé";
            } else {
                message = "super ! c'est normal";
            }
        }
    }


}
