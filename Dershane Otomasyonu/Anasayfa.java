package odev2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Anasayfa {

	static ArrayList<Kurs> Kurslar = new ArrayList<>();
	static ArrayList<Kursiyer> Kursiyerler = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);
	static Scanner verial = new Scanner(System.in);
	static File dosya = new File("C:\\Users\\EXCALIBUR\\Desktop\\kurs.txt");
	static File dosya2 = new File("C:\\Users\\EXCALIBUR\\Desktop\\kursiyer.txt");
	static FileWriter fw;
	static FileWriter fw2;

	static void Kursekle() {
		System.out.println("Kursun adını giriniz: ");
		String eklenen = verial.nextLine();
		Kurs kurslar = new Kurs(eklenen);
		Kurslar.add(kurslar);

		// Dosyaya yazma işlemleri
		try (FileWriter fw2 = new FileWriter(dosya); BufferedWriter bw2 = new BufferedWriter(fw2)) {

			for (Kurs i : Kurslar) {
				bw2.write(i.getKursId() + "+" + i.getKursAd() + "\n");
			}

			bw2.flush(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void kurslistele() {
		System.out.println("Kurs Id\tKurs Adı");
		for (int i = 0; i < Kurslar.size(); i++) {
			System.out.println(Kurslar.get(i).getKursId() + "\t" + Kurslar.get(i).getKursAd());

		}
	}

	static void kursara() {

		System.out.println("Aranacak kursun adını Giriniz:");
		String aranan = verial.nextLine();

		for (int h = 0; h < Kurslar.size(); h++) {
			if (aranan.equals(Kurslar.get(h).getKursAd())) {
				Kurslar.get(h).yazdir();

			}
		}
	}

	static void kurssil() {
		System.out.println("Silinecek kursun adını giriniz: ");
		String Silinecek = verial.nextLine();
		boolean kursBulundu = false;

		for (int i = 0; i < Kurslar.size(); i++) {
			if (Silinecek.equals(Kurslar.get(i).getKursAd())) {
				kursBulundu = true;

				// Kursun kursiyerler listesinde kullanılıp kullanılmadığını kontrol et
				boolean kullaniliyor = false;
				for (int j = 0; j < Kursiyerler.size(); j++) {
					for (int k = 0; k < Kursiyerler.get(j).kurslar.size(); k++) {
						if (Silinecek.equals(Kursiyerler.get(j).kurslar.get(k).getKursAd())) {
							kullaniliyor = true;
							break;
						}
					}
					if (kullaniliyor) {
						break;
					}
				}

				if (!kullaniliyor) {
					Kurslar.remove(i);
					System.out.println("Kurs silindi!");

					// Dosyaya yazma işlemleri
					try (FileWriter fw2 = new FileWriter(dosya); BufferedWriter bw2 = new BufferedWriter(fw2)) {

						for (Kurs gez : Kurslar) {
							bw2.write(gez.getKursId() + "+" + gez.getKursAd() + "\n");
						}

						bw2.flush(); 

					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Kurs, bir kursiyer tarafından kullanıldığından silinemez.");
				}

				break; 
			}
		}

		if (!kursBulundu) {
			System.out.println("Kurs Bulunamadı!!!");
		}
	}

	static void kursiyerekle() {
		System.out.println("Eklenecek kursiyerin Adını ve Soyadını Giriniz: ");
		String yenikursiyer = scanner.nextLine();
		System.out.println("eklenecek kursiyerin Yaşını Giriniz:");
		int yeniYas = scanner.nextInt();
		scanner.nextLine();
		Kursiyer kursiyer = new Kursiyer(yeniYas, yenikursiyer);
		Kursiyerler.add(kursiyer);
		System.out.println("kursiyerin Alacağı kurs Sayısını Giriniz:");
		int kursSayisi = scanner.nextInt();
		scanner.nextLine(); 
		for (int i = 0; i < kursSayisi; i++) {
			System.out.println("Eklenecek kursiyerin Aldığı kursu Giriniz:");
			String kurss = scanner.nextLine();
			kursiyer.kurslar.add(new Kurs(kurss));
		}
	}

	static void kursiyerara() {
		boolean c = true;
		System.out.println("Aranacak Kursiyerin İsmini Giriniz:");
		String aranan = verial.nextLine();

		for (int i = 0; i < Kursiyerler.size(); i++) {
			if (aranan.equals(Kursiyerler.get(i).getKursiyerAdSoyad())) {
				Kursiyerler.get(i).kursiyeryazdir();
				c = false;
			}
		}
		if (c) {
			System.out.println("Aranan Bulunamadı!!!");
		}
	}

	static void kursiyersil() {
		System.out.println("Silinecek kursiyerin Idsini Giriniz");
		int Id = verial.nextInt();
		boolean s = true;

		for (int j = 0; j < Kursiyerler.size(); j++) {
			if (Kursiyerler.get(j).getKursiyerId() == Id) {
				s = false;
				Kursiyerler.remove(j);
				System.out.println("Silindi");
			}
		}
		if (s) {
			System.out.println("Aranan Bulunamadı");
		}
	}

	static void kursiyerlistele() {
		System.out.println("Kursiyerler");
		for (int j = 0; j < Kursiyerler.size(); j++) {
			Kursiyerler.get(j).kursiyeryazdir();
		}
	}

	static void kursiyerayrıntılılistele() {
	    System.out.println("Tüm liste");
	    int k = Kursiyerler.size();
	    for (int i = 0; i < k; i++) {
	        Kursiyer kursiyer = Kursiyerler.get(i);
	        kursiyer.kursiyeryazdir();
	        
	        int x = kursiyer.kurslar.size();
	        for (int j = 0; j < x; j++) {
	            System.out.print("\t");
	            kursiyer.kurslar.get(j).yazdir();
	        }
	    }
	}


	static void BorcHesapla() {
		boolean d = true;
		System.out.println("Ödeyeceği Tutarı Hesaplanacak KURSİYERİN Idsini Giriniz:");
		int aranankursiyerId = verial.nextInt();

		for (int h = 0; h < Kursiyerler.size(); h++) {
			if (aranankursiyerId == Kursiyerler.get(h).getKursiyerId()) {
				d = false;
				int aylikUcret = (Kursiyerler.get(h).kurslar.size() * 500) * 4;

				if (Kursiyerler.get(h).kurslar.size() == 1) {
					System.out
							.println("Kursiyer Sadece 1 Kurs Aldığından Kampanya Uygulanmamıştır.\nAylık Ödenecek Tutar "
									+ (aylikUcret) + " TL");
				} else if (Kursiyerler.get(h).kurslar.size() == 2) {
					System.out.println("Kursiyer 2 Kurs Aldığından Kampanya 1 Uygulanmıştır.\nAylık Ödenecek Tutar "
							+ aylikUcret * 0.80 + " TL");
				} else if (Kursiyerler.get(h).kurslar.size() == 3) {
					System.out.println("Kursiyer 3 Kurs Aldığından Kampanya 2 Uygulanmıştır.\nAylık Ödenecek Tutar "
							+ aylikUcret * 0.75 + " TL");
				} else if (Kursiyerler.get(h).kurslar.size() > 3) {
					System.out.println(
							"Öğrenci 3 ve Üzeri Kurs Aldığından Kampanya 3 Uygulanmamıştır.\nAylık Ödenecek Tutar "
									+ aylikUcret * 0.90 + " TL");
				} else {
					System.out.println("kurs almıyor!!!");
				}
			}
		}
		if (d) {
			System.out.println("Ödeyeceği Tutarı Hesaplanacak Kursiyer Bulunamadı!!!");
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Scanner scanner = new Scanner(System.in);

		// Kursları dosyadan okuma işlemi

		try (BufferedReader br1 = new BufferedReader(new FileReader(dosya))) {
			String line1;

			while ((line1 = br1.readLine()) != null) {

				Kurs kurslar = new Kurs();
				String[] x = line1.split("\\+");
				int kursId = Integer.parseInt(x[0]);
				kurslar.setKursAd(x[1]);
				kurslar.setKursId(kursId);
				Kurslar.add(kurslar);

			}
		} catch (FileNotFoundException e) {
			System.out.println("Kurs dosyası bulunamadı: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Dosya okuma hatası: " + e.getMessage());
		}

	
		// Kursiyerleri ve aldıkları kursları dosyadan okuma işlemi
		try (BufferedReader br2 = new BufferedReader(new FileReader(dosya2))) {
		    String line2;
		    Kursiyer kursiyer = null;

		    while ((line2 = br2.readLine()) != null) {
		        if (line2.startsWith("%")) {
		            String[] a = line2.substring(1).split("\\+");
		            if (a.length >= 3) {
		                kursiyer = new Kursiyer();
		                kursiyer.setKursiyerId(Integer.parseInt(a[0]));
		                kursiyer.setKursiyerAdSoyad(a[1]);
		                kursiyer.setKursiyerYas(Integer.parseInt(a[2]));
		                Kursiyerler.add(kursiyer);
		            }
		        } else if (line2.startsWith("*")) {
		            String[] kursBilgi = line2.substring(1).split("\\+");
		            if (kursBilgi.length >= 2 && kursiyer != null) {
		                for (int i = 0; i < Kurslar.size(); i++) {
		                    if (Integer.parseInt(kursBilgi[0]) == Kurslar.get(i).getKursId()) {
		                        kursiyer.kurslar.add(Kurslar.get(i));
		                    }
		                }
		            }
		        }
		    }
		} catch (FileNotFoundException e) {
		    System.out.println("Kursiyer dosyası bulunamadı: " + e.getMessage());
		} catch (IOException e) {
		    System.out.println("Dosya okuma hatası: " + e.getMessage());
		}



		int secim;
		do {
			System.out.println("\n------------------MENÜ---------------");
			System.out.println("1 – Kurs Ekle");
			System.out.println("2 – Kurs Listele");
			System.out.println("3 – Kurs Ara");
			System.out.println("4 – Kurs Sil");
			System.out.println("5 – Kursiyer Ekle");
			System.out.println("6 – Kursiyer Ara");
			System.out.println("7 – Kursiyer Sil");
			System.out.println("8 – Kursiyerleri Listele");
			System.out.println("9 – Kursiyerleri Ayrıntılı Listele");
			System.out.println("10 – Kursiyerin Ödeyeceği Tutarı Hesapla");
			System.out.println("11 – Çıkış");
			System.out.print("Seçiminiz: ");
			secim = scanner.nextInt();
			switch (secim) {
			case 1:
				Kursekle();
				break;
			case 2:
				kurslistele();
				break;
			case 3:
				kursara();
				break;
			case 4:
				kurssil();
				break;
			case 5:
				kursiyerekle();
				break;
			case 6:
				kursiyerara();
				break;
			case 7:
				kursiyersil();
				break;
			case 8:
				kursiyerlistele();
				break;
			case 9:
				kursiyerayrıntılılistele();
				break;
			case 10:
				BorcHesapla();
				break;
			case 11:

				try {
					fw= new FileWriter(dosya);

					BufferedWriter bw2 = new BufferedWriter(fw);
					for (int c = 0; c < Kurslar.size(); c++) {
						bw2.write(Kurslar.get(c).getKursId() + "+" + Kurslar.get(c).getKursAd() + "\n");
					}
					bw2.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}

				fw.close();
		

				try {

					fw2 = new FileWriter(dosya2);
					BufferedWriter bw1 = new BufferedWriter(fw2);
					for (int i = 0; i < Kursiyerler.size(); i++) {
					    bw1.write("%" + Kursiyerler.get(i).getKursiyerId() + "+" + Kursiyerler.get(i).getKursiyerAdSoyad()
					            + "+" + Kursiyerler.get(i).getKursiyerYas() + "\n");

					    // İç döngüye girmeden önce kurslar listesinin null olmadığını kontrol et
					    if (Kursiyerler.get(i).kurslar != null) {
					        for (int j = 0; j < Kursiyerler.get(i).kurslar.size(); j++) {
					            bw1.write("*" + Kursiyerler.get(i).kurslar.get(j).getKursId() + "+"
					                    + Kursiyerler.get(i).kurslar.get(j).getKursAd() + "\n");
					        }
					    }
					}

					bw1.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				fw2.close();

				System.out.println("Menüden Çıkış Yapıldı");
				return;
			default:
				System.out.println("Geçersiz seçim");
			}

		} while (secim != 11);

		scanner.close();
	}

}