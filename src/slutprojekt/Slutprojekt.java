/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package slutprojekt;


import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author valter.karlsson
 */
public class Slutprojekt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Här är mina första variablar som är p vilket är spelarens hälsa och runda som jag använder för att räkna antal rundor
        int p=0 ;
        int runda=0;
        int antalr=0;
        System.out.println("*DING DING DING*");
        System.out.println("Klockan slår och du tittar in i din motståndares ögon");
    
        //Jag använde en for loop här för att spelat ska köras tills man gjort tio skada på motståndaren vilket här sparas i variabeln i
    for (int i=0 ; i<10; ){
       
        //här checkar spelet om spelaren själv tagit mer än 10 skada, isf avslutas spelet
        if(p>10)   
        {
            System.out.println("YOU LOST!");
            break;
        }
        //Kod för att räkna antal rundor samt val av attack där olika attacker har olika förutsättningar
        runda++;
        
        //För att få spelaren att göra fler riskabla val (attack 2) så får hen lite tidspress genom att motståndarens liv återhämtar sig efter var femte runda. Variabeln "antalr" räknar hur många rundor som gått och om den överstiger 5 så får motståndaren ett hp.
        antalr++;
        if(antalr>5){
            i--;
            System.out.println("Matchen drar ut på tiden och din motståndare samlar kraft:\n+1 HP för motståndaren");
            antalr=antalr-5;
            System.out.println("Motståndarens HP = "+(10-i)+"\n");
        }
        Scanner tangent = new Scanner(System.in);
        System.out.println("*DING DING DING*");
        System.out.println("RUNDA: "+ runda);
        System.out.println("Välj action genom att klicka på antingen 1, 2 eller 3.\n 1. Clear left: AT: 1 MC: 10 \n 2. Kick: AT: 2 MC: 30 \n 3. Focus: Tar bort en skada från dig själv");
        //Man skriver in sitt val i switchen som sedan skickar ner de olika variablerna till metoden "Missräknare"
        int val = tangent.nextInt();
        int mc=0;
        int at=0;
        switch (val){
            case 1:
                mc = 30;
                at = 1;
                break;
            case 2:
                mc = 70;
                at = 2; 
                break;
            case 3:
                p--;
                mc = 40;
                break;
            default: System.out.println("Fel val");
        }
        
        //Här tas resultatet från missräknaren in och om det är under hundra träffar attacken och om det är över hundra så missar attacken
        int svar = missräknare(mc);
        if (svar<100) {
            //Om attacken lyckas så gör man så mycket skada som den attack man valt, den siffran lagras i variabeln at.
            i=i+at;
            System.out.println("Ditt val lyckas och du gör "+at+" skada på din motståndare.");
        }
        else if(svar>100) {
            p++;
            System.out.println("Ditt val misslyckas och din motståndare tar chansen \noch slår tillbaka. Du tar skada");
        }
        //två rader kod som visar hur mycket liv både spelare och motståndaren har kvar efter varje runda
         System.out.println("\nMotståndarens HP = "+(10-i));
         System.out.println("Ditt HP = "+(10-p)+"\n");
        }
        
        //När motståndares tagit 10 skada eller mer så avbryts loopen och denna text kommer upp för att deklarera spelaren som vinnare
        System.out.println("\nDin sista attack fäller motståndaren och \ndu går hem som segrare i matchen");
    
        }
    
    
        
    
    //Denna metod tar in variabeln mc vilket står för "miss chance" och drar sedan ett tal mellan 1-100 och adderar detta med MC, för att sedan skicka tillbaka ett tal
    static int missräknare(int mc)
    {
        Random r = new Random();
        int misschance =r.nextInt(100) + 1;
        int miss = misschance + mc; 
        return miss;
    }



}