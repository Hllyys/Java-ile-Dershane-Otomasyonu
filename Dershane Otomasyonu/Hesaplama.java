package odev2;

import java.util.ArrayList;


interface Hesaplamaa {
    double borcHesapla(ArrayList<Kurs> kurslar);
}

public class Hesaplama implements Hesaplamaa {
   
    @Override
    public double borcHesapla(ArrayList<Kurs> kurslar) {
        double haftalikUcretPerKurs = 500;

        double toplamBorc = kurslar.size() * haftalikUcretPerKurs * 4; 
        if (kurslar.size() == 2) {
            toplamBorc *= 0.80; 
        } else if (kurslar.size() == 3) {
            toplamBorc *= 0.75; 
        } else if (kurslar.size() > 3) {
            toplamBorc *= 0.90; 
        }

        return toplamBorc;
    }
}
