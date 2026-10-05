import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {

    static final int SELESAI = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            int nilai = input.nextInt();

            if (nilai == SELESAI) {
                break;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);

        } while (true);

        System.out.println("Nilai tersimpan : " + daftar);

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang tersimpan.");
            input.close();
            return;
        }

        int total = 0;

        for (int nilai : daftar) {
            total += nilai;
        }

        double rataRata = (double) total / daftar.size();

        System.out.printf("Rata-rata : %.2f%n", rataRata);

        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);

        for (int i = 1; i < daftar.size(); i++) {
            int nilai = daftar.get(i);

            if (nilai > tertinggi) {
                tertinggi = nilai;
            }

            if (nilai < terendah) {
                terendah = nilai;
            }
        }

        System.out.println("Tertinggi : " + tertinggi);
        System.out.println("Terendah  : " + terendah);

        input.close();
    }
}