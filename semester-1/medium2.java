/* Doctor Strange sedang menjelajahi dimensi Mirror Realm, sebuah ruang berlapis di mana energi sihir berfluktuasi secara liar, kadang memperkuat kekuatan mistisnya, kadang justru menyerapnya habis.
Setiap titik dimensi memiliki tingkat energi yang bisa:
* positif → meningkatkan kekuatan sihirnya,
* nol → netral,
* negatif → merusak kestabilan sihir dan menyedot kekuatannya.
Strange harus menemukan jalur energi paling stabil, yaitu rangkaian titik berurutan di Mirror Realm yang menghasilkan total energi sihir tertinggi.
Namun, jika Strange melewati titik-titik dengan energi negatif secara terus-menerus, kekuatannya akan terkuras, dan ia harus me-reset mantra-nya (memulai pencarian dari titik energi berikutnya).
Bantulah Doctor Strange menemukan jalur sihir paling kuat di dimensi tersebut.
Sebuah jalur dianggap jalur energi maksimum jika memiliki total kekuatan tertinggi dari semua jalur berurutan yang mungkin.
Jika terdapat lebih dari satu jalur dengan total kekuatan yang sama:
1. Pilih jalur dengan panjang paling pendek, karena jalur singkat lebih stabil secara magis.
2. Jika panjangnya juga sama, pilih jalur yang muncul lebih awal di dimensi.
*/

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int power [] = new int[n];
        for (int i = 0; i < n; i++) {
            power[i] = in.nextInt();
        }

        int maxSum = power[0];
        int currentSum = power[0];
        int mulai = 0, end = 0;
        int indexawal = 0;

        // Menentukan kekuatan maksimum
        for (int i = 1; i < n; i++) {
            if (currentSum < 0) {
                currentSum = power[i];
                indexawal = i;
            } else currentSum += power[i];

            // Menentukan jalan tercepat
            if (currentSum > maxSum || (currentSum == maxSum && (i - indexawal < end - mulai))) {
                maxSum = currentSum;
                mulai = indexawal;
                end = i;
            }
        }
        System.out.println("Kekuatan maksimum = " + maxSum);
        System.out.print("Jalur energi =");
        for (int i = mulai; i <= end; i++) {
            System.out.print(" " + power[i]);
        }
    }
}
