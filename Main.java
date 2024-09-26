public class Main {
    public static void main(String[] args) {
        // Membuat array atau list dari Handphone
        Handphone[] daftarHandphone = new Handphone[2];

        // Mengisi array dengan objek Smartphone dan FeaturePhone
        daftarHandphone[0] = new Smartphone("I Phone", "XR");
        daftarHandphone[1] = new FeaturePhone("OPPO", "A5s");

        // Menggunakan loop untuk memanggil metode secara polimorfik
        for (Handphone hp : daftarHandphone) {
            hp.nyalakan();
            hp.telepon("081388119609");
            hp.matikan();
            System.out.println();
        }

        // Mengakses metode khusus dengan casting
        for (Handphone hp : daftarHandphone) {
            if (hp instanceof Smartphone) {
                ((Smartphone) hp).aksesInternet();
            } else if (hp instanceof FeaturePhone) {
                ((FeaturePhone) hp).mainMobileLegend();
            }
        }
    }
}
