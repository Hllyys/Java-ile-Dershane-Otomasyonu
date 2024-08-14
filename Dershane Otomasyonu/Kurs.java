package odev2;

import java.io.File;

public class Kurs {
	private static int syc=1;
	private int kursId;
	private String kursAd;
	public Kurs(String kursAd) {
		super();
		this.kursId = syc++;
		this.kursAd = kursAd;
	}
   
	public Kurs() {
		super();
	}
	
	public int getKursId() {
		return kursId;
	}
	public void setKursId(int kursId) {
		this.kursId = kursId;
	}
	public String getKursAd() {
		return kursAd;
	}
	public void setKursAd(String kursAd) {
		this.kursAd = kursAd;
	}

    public void yazdir() {
			System.out.println(kursId + "      " + kursAd);
    }


}
