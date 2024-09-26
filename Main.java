// Kelas abstrak Handphone
abstract class Handphone {
    protected String merk;
    protected String model;

    public Handphone(String merk, String model) {
        this.merk = merk;
        this.model = model;
    }

    // Metode abstrak yang harus diimplementasikan oleh subclass
    public abstract void nyalakan();
    public abstract void matikan();
    public abstract void telepon(String nomor);
}

// Kelas Smartphone, turunan dari Handphone
class Smartphone extends Handphone {
    public Smartphone(String merk, String model) {
        super(merk, model);
    }

    @Override
    public void nyalakan() {
        System.out.println(merk + " " + model + " sedang dinyalakan.");
    }

    @Override
    public void matikan() {
        System.out.println(merk + " " + model + " sedang dimatikan.");
    }

    @Override
    public void telepon(String nomor) {
        System.out.println(merk + " " + model + " sedang menelepon " + nomor + " melalui jaringan 4G.");
    }

    // Metode khusus untuk Smartphone
    public void aksesInternet() {
        System.out.println(merk + " " + model + " sedang mengakses internet.");
    }
}

// Kelas FeaturePhone, turunan dari Handphone
class FeaturePhone extends Handphone {
    public FeaturePhone(String merk, String model) {
        super(merk, model);
    }

    @Override
    public void nyalakan() {
        System.out.println(merk + " " + model + " sedang dinyalakan.");
    }

    @Override
    public void matikan() {
        System.out.println(merk + " " + model + " sedang dimatikan.");
    }

    @Override
    public void telepon(String nomor) {
        System.out.println(merk + " " + model + " sedang menelepon " + nomor + " melalui jaringan 2G.");
    }

    // Metode khusus untuk FeaturePhone
    public void mainGameSnake() {
        System.out.println(merk + " " + model + " sedang memainkan game Snake.");
    }
}

// Kelas Main untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        // Membuat array dari Handphone
        Handphone[] daftarHandphone = new Handphone[2];
        // Mengisi array dengan objek Smartphone dan FeaturePhone
        daftarHandphone[0] = new Smartphone("Samsung", "Galaxy S21");
        daftarHandphone[1] = new FeaturePhone("Nokia", "3310");

        // Loop untuk memanggil metode secara polimorfik
        for (Handphone hp : daftarHandphone) {
            hp.nyalakan();
            hp.telepon("08123456789");
            hp.matikan();
            System.out.println();
        }

        // Mengakses metode khusus dengan casting
        for (Handphone hp : daftarHandphone) {
            if (hp instanceof Smartphone) {
                // Cast aman untuk akses metode khusus di Smartphone
                Smartphone smartphone = (Smartphone) hp;
                smartphone.aksesInternet();
            } else if (hp instanceof FeaturePhone) {
                // Cast aman untuk akses metode khusus di FeaturePhone
                FeaturePhone featurePhone = (FeaturePhone) hp;
                featurePhone.mainGameSnake();
            }
        }
    }
}
