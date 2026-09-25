import java.util.Scanner;

public class NilaiAkhir {
    public static void main(String[] args) {
        // Empat bobot disimpan sebagai konstanta double, bukan diketik
        // langsung di dalam rumus
        final double BOBOT_PRAKTIKUM = 0.30;
        final double BOBOT_TUGAS = 0.20;
        final double BOBOT_MID = 0.20;
        final double BOBOT_FINAL = 0.30;SS

        Scanner input = new Scanner(System.in);

        System.out.print("Nilai praktikum : ");
        double praktikum = input.nextDouble();
        System.out.print("Nilai tugas      : ");
        double tugas = input.nextDouble();
        System.out.print("Nilai MID        : ");
        double mid = input.nextDouble();
        System.out.print("Nilai final      : ");
        double finalNilai = input.nextDouble(); // "final" keyword Java, jadi dipakai nama finalNilai

        // ===== 2. Coba dulu versi int =====
        int praktikumInt = (int) praktikum;
        int tugasInt = (int) tugas;
        int midInt = (int) mid;
        int finalInt = (int) finalNilai;

        // Rumus yang sama, tapi semua bertipe int -> setiap suku dibagi
        // sebagai int/int dulu, jadi pecahannya sudah dibuang SEBELUM
        // keempat suku dijumlahkan. Jebakan yang sama dengan 1024 vs
        // 1024.0 minggu lalu.
        int akhirVersiInt = praktikumInt * 30 / 100 + tugasInt * 20 / 100
                + midInt * 20 / 100 + finalInt * 30 / 100;
        System.out.println();
        System.out.println("Percobaan versi int : " + akhirVersiInt
                + "  <- bukan 79.1, karena tiap (* lalu / 100) dibulatkan ke bawah duluan");

        // ===== 1 & 3. Nilai akhir versi double (yang sebenarnya dipakai) =====
        // Satu ekspresi, tanpa satu pun kurung: '*' sudah dikerjakan lebih
        // dulu daripada '+' oleh Java, jadi urutannya otomatis benar tanpa
        // perlu kurung sama sekali.
        double akhir = praktikum * BOBOT_PRAKTIKUM + tugas * BOBOT_TUGAS + mid * BOBOT_MID;
        akhir += finalNilai * BOBOT_FINAL; // augmented assignment untuk komponen final

        // ===== 4. Memotong vs membulatkan =====
        int dipotong = (int) akhir;          // memotong ke arah nol, pecahannya dibuang
        long dibulatkan = Math.round(akhir); // membulatkan ke bilangan bulat terdekat
        double selisih = akhir - dibulatkan;
        // Di sini dipotong == dibulatkan (sama-sama 79) karena pecahannya 0.1
        // lebih kecil dari 0.5. Keduanya baru beda kalau pecahannya >= 0.5,
        // misalnya akhir = 79.6 -> dipotong jadi 79, dibulatkan jadi 80.

        // ===== 5. Status kelulusan, langsung boolean, tanpa if =====
        boolean lulus = akhir >= 60;

        System.out.println();
        System.out.println("===== NILAI AKHIR =====");
        System.out.println("Praktikum           : " + praktikum + " (30%)");
        System.out.println("Tugas               : " + tugas + " (20%)");
        System.out.println("MID                 : " + mid + " (20%)");
        System.out.println("Final               : " + finalNilai + " (30%)");
        System.out.println("Nilai akhir         : " + akhir);
        System.out.println("Dipotong   (int)    : " + dipotong);
        System.out.println("Dibulatkan (round)  : " + dibulatkan);
        System.out.println("Selisih             : " + selisih);
        System.out.println("Lulus (>=60)        : " + lulus);

        input.close();
    }
}