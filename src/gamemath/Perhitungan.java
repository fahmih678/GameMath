/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamemath;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Fahmi Habibi
 */
public class Perhitungan {
    
    Random rand_bil = new Random();
    Scanner input = new Scanner(System.in);
    
    int bil1;
    int bil2;
    int level = 1;
    int lives = 3;
    int skor = 0;
    String sbil1;
    String sbil2;
    String nama;
    
    void penjumlahan(){
        int hasil_penjumlahan;
        int jawaban;
        
        
        System.out.println("*************************");
        System.out.println("Game Math - Penjumlahan");
        System.out.println("*************************");
         
        do{    
            randomLevel();
            System.out.println("Berapakah hasil dari" + sbil1 + "+" + sbil2 + "? ");
            System.out.print("Jawab: ");
            jawaban = input.nextInt();
            input.nextLine();
            hasil_penjumlahan = this.bil1+this.bil2;
            if (jawaban == hasil_penjumlahan){
                this.skor += 5;
                hasil(1);
            } else {
                this.lives -=1;
                this.skor -=2;
                hasil(2);
            }
            if (skor >= 300){
                System.out.println("");
                System.out.println("Selamat " + this.nama +", Anda telah menyelesaikan soal penjumlahan, dicoba juga soal pengurangan ya");
                break;
            }
            System.out.println("---------------------------");
        } 
        while(this.lives > 0);
        System.out.println("");
        opening();
        menu();
        
    }
    
    void pengurangan(){
        int hasil_pengurangan;
        int jawaban;
        
        
        System.out.println("***************************");
        System.out.println("* Game Math - Pengurangan *");
        System.out.println("***************************");
         
        do{
            if (level == 1){
                randomLevel();
                if (bil1 - bil2 < 0){
                    continue;
                }
            } else{
                randomLevel();
            }
            hasil_pengurangan = this.bil1-this.bil2;
            System.out.println("Berapakah hasil dari" + sbil1 + "-" + sbil2 + "? ");
            System.out.print("Jawab: ");
            jawaban = input.nextInt();
            input.nextLine();
            
            
            if (jawaban == hasil_pengurangan){
                this.skor += 5;
                hasil(1);
            } else {
                this.lives -=1;
                this.skor -=2;
                hasil(2);
            }
            if (skor >= 300){
                System.out.println("");
                System.out.println("Selamat " + this.nama +", Anda telah menyelesaikan soal pengurangan, dicoba juga soal penjumlahan ya");
                break;
            }
            System.out.println("---------------------------");
        } 
        while(this.lives > 0);
        if (lives == 0){
            System.out.println("Hai " + this.nama + ", jangan menyerah ya untuk coba lagi, Tetap semangat !!!");
        }
        System.out.println("");
        opening();
        menu();
    }
    
    void randomLevel(){
        
        if (skor < 101){
                // Random Level 1
                this.bil1 = 0 + rand_bil.nextInt(10 - 0) + 1;
                this.bil2 = 0 + rand_bil.nextInt(10 - 0) + 1;
                
            } else if (skor < 201) {
                // Random Level 2
                this.level = 2; 
                this.bil1 = -10 + rand_bil.nextInt((-1) - (-10)) + 1;
                this.bil2 = -10 + rand_bil.nextInt((-1) - (-10)) + 1;
                
            } else {
                // Random Level 3
                this.level = 3;
                this.bil1 = -10 + rand_bil.nextInt(10 - (-10)) + 1;
                this.bil2 = -10 + rand_bil.nextInt(10 - (-10)) + 1;
                
            } 
        
        // memberi tanda () bila bilangan negatif
        if (bil1< 0 ){
            sbil1 = " (" + bil1 + ") ";
        } else {
            sbil1 = " " + bil1 + " ";
        }
        
        if (bil2< 0 ){
            sbil2 = " (" + bil2 + ") ";
        } else {
            sbil2 = " " + bil2 + " ";
        }
    }
    
    void hasil(int hasil){
        switch(hasil){
            case 1:
                System.out.println("Selamat " + this.nama + ", Anda benar");
                System.out.println("[Skor: "+ this.skor + "]" + ", [Lives: " + this.lives + "]" + ", [Level: " + this.level + "]");
                break;
            case 2:
                System.out.println("Wah, salah deh");
                System.out.println("[Skor: "+ this.skor + "]" + ", [Lives: " + this.lives + "]" + ", [Level: " + this.level + "]");
                break;
            default:
                break;
        }
    }
    
    void namaPemain(){
        System.out.print("Masukkan Nama Anda: ");
        this.nama = input.nextLine();
    }
    
    void menu(){
        int option;
        this.level = 1;
        this.lives = 3;
        this.skor = 0;
        
        System.out.println("Menu:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Keluar");
        System.out.print("Pilihan menu: ");
        option = input.nextInt();
        input.nextLine();
        
        switch (option){
            case 1:
                penjumlahan();
                break;
            case 2:
                pengurangan();
                break;
            case 3:
                break;
            default:
                menu();
        }
    }
    
    void opening(){
        System.out.println("**************************");
        System.out.println("*        Game Math       *");
        System.out.println("**************************");
    }
    
    void output(){
        opening();
        namaPemain();
        opening();
        menu();
        

    }
}
