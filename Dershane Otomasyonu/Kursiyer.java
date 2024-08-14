package odev2;

import java.util.ArrayList;

public class Kursiyer {
	private static int syc1 = 1;
	private int kursiyerId;
	private int kursiyerYas;
	private String kursiyerAdSoyad;
	public ArrayList<Kurs> kurslar = new ArrayList<Kurs>();
	
	
	
	
	
	public Kursiyer(ArrayList<Kurs> kurslar) {
		super();
		this.kurslar = kurslar;
	}
	public Kursiyer() {
		super();
	}
	public Kursiyer(int kursiyerYas, String kursiyerAdSoyad) {
		super();
		this.kursiyerId = syc1++;
		this.kursiyerYas = kursiyerYas;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}
	
	
	public int getKursiyerId() {
		return kursiyerId;
	}
	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}
	public int getKursiyerYas() {
		return kursiyerYas;
	}
	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}
	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}
	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}
	
	public ArrayList<Kurs> getKurslar() {
		return kurslar;
	}
	public void setKurslar(ArrayList<Kurs> kurslar) {
		this.kurslar = kurslar;
	}

	 public void kursiyeryazdir() {
	        System.out.println("Kursiyer ID: " + kursiyerId + "\tAd Soyad: " + kursiyerAdSoyad + "\tYaş: " +kursiyerYas);
	    }
	interface Hesaplama {
	    double BorcHesapla(ArrayList<Kurs> alinanKurslar);
	}
	
	
}
