import java.util.ArrayList;
import java.util.Collections;
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

        int diAtasRataRata = 0;

        for (int nilai : daftar) {
            if (nilai > rataRata) {
                diAtasRataRata++;
            }
        }

        System.out.println("Di atas rata2 : " + diAtasRataRata + " orang");

        int[] jumlahGrade = new int[5];

        for (int nilai : daftar) {

            if (nilai >= 80) {
                jumlahGrade[0]++;
            } else if (nilai >= 70) {
                jumlahGrade[1]++;
            } else if (nilai >= 60) {
                jumlahGrade[2]++;
            } else if (nilai >= 50) {
                jumlahGrade[3]++;
            } else {
                jumlahGrade[4]++;
            }
        }

        char[] grade = {'A', 'B', 'C', 'D', 'E'};

        System.out.print("Distribusi : ");

        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(grade[i] + "=" + jumlahGrade[i] + " ");
        }

        System.out.println();

        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Terurut     : " + terurut);
        System.out.println("Urutan asli : " + daftar);

        input.close();
    }
}

