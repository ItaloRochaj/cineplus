package br.codes.cineplus.calculos.principal;

import br.com.codes.cineplus.excecao.ErroDeConversaoDeAnoException;
import br.com.codes.cineplus.modelos.Titulo;
import br.com.codes.cineplus.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        while (true) {
            System.out.println("Digite um filme para busca (ou digite 'sair' para encerrar):");
            busca = leitura.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            String endereco = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=a6a9191d";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);

                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("Titulo já convertido");
                System.out.println(meuTitulo);

                titulos.add(meuTitulo);

                try (FileWriter escrita = new FileWriter("Filmes.txt", true)) {
                    escrita.write(meuTitulo.toString() + System.lineSeparator());
                }

            } catch (NumberFormatException e) {
                System.out.println("Aconteceu um erro:");
                System.out.println(e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println("Algum erro de argumento na busca, verifique o endereço!");
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Lista de títulos:");

        System.out.println(titulos);


        FileWriter escrita = new FileWriter("filmes.gson");
        escrita.write(gson.toJson(titulos));
        System.out.println("O programa finalizou corretamente");
    }
}
