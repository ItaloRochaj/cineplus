package br.codes.cineplus.calculos;

import br.com.codes.cineplus.modelos.Filme;
import br.com.codes.cineplus.modelos.Serie;
import br.com.codes.cineplus.modelos.Titulo;

import java.io.File;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {

        return tempoTotal;
    }

    // public void inclui(Filme f) {
    //
    //      this.tempoTotal += f.getDuracaoEmMinutos();
    //  }
    //
    // public void inclui(Serie s) {
    //
    //     this.tempoTotal += s.getDuracaoEmMinutos();
    //   }

    // ...

    public void inclui(Titulo titulo) {
        System.out.println("Adicionando duração em minutos de " + titulo);
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }

// ...

}
