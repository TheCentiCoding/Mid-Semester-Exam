/*
Muel dan adiknya memiliki satu set balok lego yang terdiri dari N balok.
Setiap balok memiliki warnanya masing-masing yang ditandai secara acak
dengan angka terurut (misalnya, 1=merah, 2=kuning, 3 hijau, ... dst).
Muel dan adiknya ingin membuat satu menara vertikal setinggi mungkin dari semua balok-balok lego itu.

Namun ada beberapa aturan yang mereka terapkan. Aturan tersebut antara lain:
1. Warna dengan nomor terkecil selalu berada dibawah warna dengan nomor yang lebih besar
2. Balok lego untuk warna yang digunakan harus seimbang secara jumlah
3. Menara boleh menggunakan semua atau beberapa warna saja asalkan memenuhi aturan ke-2

Tugasmu adalah membantu Muel untuk mencari berapa tinggi menara paling maksimal dengan syarat
di atas kemudian tampilkan susunan balok legonya dari yang paling atas sampai yang paling bawah.
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String warna [] = new String[n];
        int kode [] = new int[n];
        for (int i = 0; i<n; i++) {
            warna[i] = in.next();
            kode[i] = in.nextInt();
        }
        
        // Mendata jenis-jenis blok
        String listWarna [] = new String[n];
        int listKode [] = new int[n];
        int jenisCount [] = new int[n];
        int jenis = 0;
        for (int i = 0; i<n; i++) {
            boolean newBlock = false;
            for (int j = 0; j<jenis; j++) {
                if (kode[i] == listKode[j]) {
                    jenisCount[j]++;
                    newBlock = true;
                    break;
                }
            }
            if (!newBlock) {
                listWarna[jenis] = warna[i];
                listKode[jenis] = kode[i];
                jenisCount[jenis] = 1;
                jenis++;
            }
        }
        
        // Mendata banyak blok tiap jenis
        for (int i = 0; i<jenis-1; i++) {
            for (int j = 0; j<jenis-i-1; j++) {
                if (listKode[j] > listKode[j+1]) {
                    int kodeBlok = listKode[j];
                    listKode[j] = listKode[j+1];
                    listKode[j+1] = kodeBlok;
                    
                    String namaBlok = listWarna[j];
                    listWarna[j] = listWarna[j+1];
                    listWarna[j+1] = namaBlok;
                    
                    int jumlahBlok = jenisCount[j];
                    jenisCount[j] = jenisCount[j+1];
                    jenisCount[j+1] = jumlahBlok;
                }
            }
        }
        
        // Menentukan blok minimal
        int min = jenisCount[0];
        for (int i = 1; i<jenis; i++) {
            if (jenisCount[i] < min) min = jenisCount[i];
        }
        
        // Print
        int max = min*jenis;
        System.out.println(max);
        for (int i = jenis-1; i>=0; i--) {
            for (int j = 0; j<min; j++) {
                System.out.println(listWarna[i]);
            }
        }
    }
}

