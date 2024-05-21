package br.codes.cineplus.calculos.principal;

import br.com.codes.cineplus.modelos.Filme;
import br.com.codes.cineplus.modelos.Serie;
import br.com.codes.cineplus.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(" Dungeons and dragons ", 2023);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme(" Os Condenados de Shawshank ", 2023);
        meuFilme.avalia(10);
        var filmeDoItalo = new Filme(" Run ", 2003);
        meuFilme.avalia(7);
        Serie lost = new Serie(" Lost ", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoItalo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println(" Clafissicacao " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Tim Robbins");
        buscaPorArtista.add("Chris Pine");
        buscaPorArtista.add("Sarah Paulsen");

        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Depois da Ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);
    }
}
