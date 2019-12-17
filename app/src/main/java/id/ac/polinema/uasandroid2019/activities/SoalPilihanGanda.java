package id.ac.polinema.uasandroid2019.activities;

public class SoalPilihanGanda {

    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Apa warna bendera Indonesia ?",
            "Indonesia adalah negara ...",
            "Bhinneka Tunggal Ika artinya ...",
            "Ibukota negara Indonesia ada di pulau ...",
            "Dibawah ini yang termasuk pahlawan tanpa tanda jasa adalah ...",
    };

    //membuat array untuk pilihan jawaban
    private String pilihanJawaban[][] = {
            {"Hitam Merah","Hijau Kuning","Merah Putih"},
            {"Kepulauan","Maju","Islam"},
            {"Bersama selamanya","Berbeda-beda tetapi tetap satu jua","Bersatu teguh bercerai runtuh"},
            {"Sulawesi","Kalimantan","Jawa"},
            {"Guru","Superman","Maling"},
    };

    //membuat array untuk jawaban benar
    private String jawabanBenar[] = {
            "Merah Putih",
            "Kepulauan",
            "Berbeda-beda tetapi tetap satu jua",
            "Jawa",
            "Guru",

    };

    //membuat getter untuk mengambil pertanyaan
    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    //membuat getter untuk mengambil pilihan jawaban 1
    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    //membuat getter untuk mengambil pilihan jawaban 2
    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    //membuat getter untuk mengambil pilihan jawaban 3
    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    //membuat getter untuk mengambil jawaban benar
    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
