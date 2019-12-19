package id.ac.polinema.uasandroid2019.activities;

public class SoalEssay {
    //membuat array untuk pertanyaan
    public String pertanyaan[] = {
            "Siapa nama presiden Indonesia yang pertama ?",
            "apa nama pulau di atas ...",
            "candi borobudur terletak di ...",
            "jam di atas menunjukkan pukul ...",
            "bahasa inggris dari gajah adalah ?",
    };

    //membuat array untuk set gambar
    private String image[] = {
            "soal1",
            "soal2",
            "soal3",
            "soal4",
            "soal5",
    };

    //membuat array jawaban benar
    private String jawabanBenar[] = {
            "soekarno",
            "kalimantan",
            "jawa tengah",
            "16.30",
            "elephant",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }

    public String getStringGambar(int x){
        String gambar = image[x];
        return gambar;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
