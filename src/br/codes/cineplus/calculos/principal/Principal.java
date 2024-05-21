package br.codes.cineplus.calculos.principal;

import br.codes.cineplus.calculos.CalculadoraDeTempo;
import br.codes.cineplus.calculos.FiltroRecomendacao;
import br.com.codes.cineplus.modelos.Episodio;
import br.com.codes.cineplus.modelos.Filme;
import br.com.codes.cineplus.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("Dungeons and dragons", 2023);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("Duração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

        Serie lost = new Serie("Lost", 2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(12);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println(" Duração para maratonar a serie: " + lost.getDuracaoEmMinutos());

        Filme outroilme = new Filme("Run", 2020);
        outroilme.setDuracaoEmMinutos(65);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroilme);
        calculadora.inclui(lost);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmaDoItalo = new Filme("Os Condenados de Shawshank", 1994);
        filmaDoItalo.setDuracaoEmMinutos(200);
        // filmaDoItalo.avalia(9);

        ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
        listaDeFilmes.add(filmaDoItalo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroilme);
        System.out.println(" Tamanho da lista " + listaDeFilmes.size());
        System.out.println(" Primeiro filme " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);

    }

}