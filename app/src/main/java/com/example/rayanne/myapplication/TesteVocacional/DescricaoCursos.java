package com.example.rayanne.myapplication.TesteVocacional;

class DescricaoCursos {

    static String[] nomeCursos = {
            "Técnico em Agropecuária", "Técnico em Alimentos", "Técnico em Informática", "Técnico em Meio Ambiente", "Técnico em Zootecnia"
    };

    static String[] descricaoCursos  = {
            "Já se imaginou com a enxada na mão, né? Calma... A Agropecuária pode te surpreender.\n" +
                    "Neste curso, você aprende não apenas sobre criação de animais e produção vegetal, mas também sobre a agroindústria. Assim, depois de formado, poderá trabalhar com projetos de propriedades rurais, acompanhar a criação de novos produtos, orientar o trabalho nas indústrias e até lidar com máquinas agrícolas. Vamos dar um rolê pela Agro? \n" +
                    "Assista aos depoimentos, vídeos e muito mais.\n",
            "No curso de Alimentos, você aprende a trabalhar com as formas de transformação, conservação e controle de qualidade de alimentos e bebidas. Poderá trabalhar com o planejamento e correção de falhas na produção, ou ainda, fiscalizar indústrias alimentícias, conferindo se a higienização está correta, entre outras tarefas.",
            "Neste curso, você aprende sobre tudo que envolve o mundo dos computadores, desde os componentes físicos (placas, conexões, acessórios) até a lógica dos códigos de programação e desenvolvimento de sistemas e banco de dados para empresas, por exemplo. Além disso, estará capacitado para o conserto de máquinas e desenvolvimento de websites e aplicativos.\n",
            "Neste curso, você não aprende apenas como promover desenvolvimento com respeito à natureza. O técnico em Meio Ambiente é capaz de criar e executar planos que minimizem impactos negativos, incentivando o desenvolvimento sustentável. Para isto, o aluno terá noções de gestão de resíduos sólidos, manejo de bacias hidrográficas e gestão ambiental. Poderá atuar na conscientização de pessoas e até na educação ambiental de diversos grupos, como escolas e empresas.\n",
            "Neste curso, você aprende sobre qualidade nas criações de animais de diversas espécies, aplicando técnicas de manejo, nutrição e melhoramento genético. Os estudantes desenvolvem atividades científicas e tecnológicas nas áreas de avicultura, suinocultura, bovinocultura, piscicultura, entre outras. Assim, depois de formados, poderão planejar, administrar e executar tarefas nas propriedades rurais.\n",

    };

    static String getnomeCursos(int a) {
        return nomeCursos[a];
    }

    static String getdescricaoCursos(int a) {
        return descricaoCursos[a];
    }

}