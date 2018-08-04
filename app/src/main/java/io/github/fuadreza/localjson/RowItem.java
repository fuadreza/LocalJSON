package io.github.fuadreza.localjson;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 04/08/2018.
 */
public class RowItem {
    private int id;
    private String kategori,judul,konten;

    public RowItem(int id, String kategori, String judul, String konten){
        this.id = id;
        this.kategori = kategori;
        this.judul = judul;
        this.konten = konten;
    }

}
