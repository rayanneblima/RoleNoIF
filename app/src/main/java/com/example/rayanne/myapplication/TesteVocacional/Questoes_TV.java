package com.example.rayanne.myapplication.TesteVocacional;

import java.util.ArrayList;
import java.util.List;

class Questoes_TV {

    String[] Cursos = {
            "Agropecuária", "Alimentos", "Informática", "Meio Ambiente", "Zootecnia"
    };

    private static String[] idPerguntas  = {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "10",
            "11",
            "12",
            "13"
    };

    private static String[] Perguntas  = {
            "Você gosta de saber como os alimentos chegam até a nossa mesa? (Por exemplo: por quais etapas o bife de hambúrguer " +
                    "passou até chegar ao seu sanduíche)",
            "Você se preocupa com a natureza e o meio ambiente?",
            "Você gosta de orientar as pessoas sobre algo que você conhece bem? (Por exemplo: " +
                    "ajudar sua mãe a usar o Whatsapp.)",
            "Qual dessas três matérias você prefere?",
            "Você prefere fazer trabalho sozinho ou em grupo?",
            "Você se interessa por máquinas e como elas funcionam?",
            "Você se interessa por leis, regras e observa quando alguma coisa não está de acordo com elas?",
            "Quando está diante de um conflito entre duas pessoas, você, normalmente, tenta fazer " +
                    "com que as duas se entendam e fiquem “de bem”?",
            "Você é daquele tipo que, quando se interessa muito por alguma coisa, consegue até aprender sozinho(a)?",
            "Numa propriedade rural, você se interessa mais por:",
            "Você acha que uma indústria seria um ambiente de trabalho legal?",
            "Você tem curiosidade em conhecer os códigos de programação que fazem este " +
                    "aplicativo funcionar?",
            "Você se interessaria pelo cultivo de plantas, condições do solo e do clima?"
    };

    private static String[][] Respostas  = {
            {"Sim, me interesso muito", "Não", "Não sei, talvez seja interessante"},
            {"Muito, amo a natureza e gosto de me envolver com ela", "Não", "Um pouco"},
            {"Sim, tenho paciência e gosto de mostrar o que sei", "Não", ""},
            {"Química", "Biologia", "Inglês"},
            {"Sozinho", "Em grupo", ""},
            {"Sim", "Não", ""},
            {"Sim", "Não", ""},
            {"Sim", "Não", ""},
            {"Sim", "Não", ""},
            {"Pelo bem-estar dos animais, de quê se alimentam, qual o melhor ambiente para cada um, etc", "Pelas construções, " +
                    "barragens, máquinas, como é feita a irrigação, etc", "Pela forma como estão explorando a natureza (de onde vem" +
                    "a água, como cuidam da terra, se algum animal está sendo prejudicado etc)"},
            {"Sim, com certeza", "Não", "Não sei"},
            {"Sim", "Não", ""},
            {"Sim", "Não", ""}
    };

    static String getidPerg(int a) {
        return idPerguntas[a];
    }

    static String getPerg(int a) {
        return Perguntas[a];
    }

    static String getRespA(int a) {
        return Respostas[a][0];
    }

    static String getRespB(int a) {
        return Respostas[a][1];
    }

    static String getRespC(int a) {
        return Respostas[a][2];
    }

}
