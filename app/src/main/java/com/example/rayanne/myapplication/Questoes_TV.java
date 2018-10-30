package com.example.rayanne.myapplication;

import java.util.ArrayList;
import java.util.List;

class Questoes_TV {

    private static String[] idPerguntas  = {
            "1",
            "2",
            "3",
            "4"
    };

    private static String[] Perguntas  = {
            "Quais são as qualidades que você mais admira em uma pessoa?",
            "Na escola, quais disciplinas você mais gosta?",
            "Com quais práticas sua vida fica melhor?",
            "Desempatando as questões, já que são 3 áreas."
    };

    private static String[][] Respostas  = {
            {"Inteligência, raciocínio", "Carisma, capacidade de lidar com as pessoas", "Sabedoria, experiência de vida"},
            {"Matemática, física", "Esportes, biologia, química", "História, geografia, artes"},
            {"Com regras bem definidas e disciplina", "Interagindo com todo tipo de pessoa", "Com tempo para meditar"},
            {"exatas", "biológicas", "humanas"}
    };

    static String getidPerg(int a) {
        return idPerguntas[a];
    }

    static String getPerg(int a) {
        return Perguntas[a];
    }

    static String getRespA(int a) {
        return Respostas[a][0]; //EXATAS
    }

    static String getRespB(int a) {
        return Respostas[a][1]; //BIO
    }

    static String getRespC(int a) {
        return Respostas[a][2]; //HUMANAS
    }

}
