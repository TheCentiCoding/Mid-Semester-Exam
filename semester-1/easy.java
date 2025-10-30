/*
Sebuah kapal antariksa memiliki sensor suhu yang merekam suhu setiap jam (°C).
Program harus mendeteksi dan mencetak salah satu pesan berikut berdasarkan data suhu:
"Alarm kritis!" — jika terdapat 5 suhu berturut-turut semuanya > 50°C.
"Alarm aktif!" — jika terdapat 3 suhu berturut-turut semuanya > 50°C (dan tidak ada kasus "Alarm kritis!" yang lebih prioritas).
"Alarm error!" — pola bergantian antara di atas 50 dan di bawah atau sama dengan 50, contohnya:
>50, ≤50, >50, ≤50, >50 atau ≤50, >50, ≤50, >50, ≤50
"Alarm tidak aktif." — jika tidak ada kondisi di atas.
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int suhu[] = new int[n];
        int trigger = 0;
        int alarm = 0;
        boolean damaged = false;           // Kondisi alarm OK atau error
        
        for (int i = 0;i<n;i++) {
            suhu[i] = in.nextInt();
        }
        
        if (n >= 5) {
            for (int i = 0;i<n-4;i++) {
                if (suhu[i]<50 && suhu[i+1]>50 && suhu[i+2]<50 && suhu[i+3]>50 && suhu[i+4]<50) {
                    damaged = true;
                    break;
                }
                else if (suhu[i]>50 && suhu[i+1]<50 && suhu[i+2]>50 && suhu[i+3]<50 && suhu[i+4]>50) {
                    damaged = true;
                    break;
                }
                else damaged = false;
            }
        }
        
        if (damaged) {
            System.out.println("Alarm error!");
        } else {
            for (int i = 0;i<n;i++) {
                if (suhu[i] > 50) {
                    trigger += 2;
                }
                else {
                    trigger *= 0;
                }
                if (trigger > alarm) alarm = trigger;
                if (trigger >= 10) break;                   // Alarm berhenti bekerja jika lima kali di-trigger
            }
            if (alarm >= 6 && alarm < 10) {
                System.out.println("Alarm aktif!");
            } else if (alarm >= 10) {
                System.out.println("Alarm kritis!");
            } else if (alarm < 6) {
                System.out.println("Alarm tidak aktif.");
            }
        }
    }
}
