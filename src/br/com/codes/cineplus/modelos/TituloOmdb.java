package br.com.codes.cineplus.modelos;

import com.google.gson.annotations.SerializedName;

public class TituloOmdb {
    @SerializedName("Title")
    private String title;
    @SerializedName("Year")
    private String year;
    @SerializedName("Runtime")
    private String runtime;

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getRuntime() {
        return runtime;
    }
}
