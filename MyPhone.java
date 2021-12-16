/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;

/**
 *
 * @author Muhamad Yamin
 */
public class MyPhone {
    static boolean isClosed = false;
    static String answer;
    static Phone phoneofChoice;
    
    public static void main(String[] args) {
        Phone SamsungNote9 = new Samsung();
        Phone XiaomiMix4 = new Xiaomi();
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("==========Pilihan HP Yang tersedia=========");
        System.out.println("1. Samsung Note 9" );
        System.out.println("2. Xiaomi Mix 4" );
        
        System.out.println("Pilih menu : ");
        answer = input.next();
        
        switch(answer) {
            case "1":
                phoneofChoice = SamsungNote9;
                break;
            case "2":
                phoneofChoice = XiaomiMix4;
                break;
            default:
                System.out.println("Pilihan Tidak Tersedia");
        }
        
        PhoneUser sam = new PhoneUser(phoneofChoice);
        while(!isClosed){
            System.out.println("============MAIN MENU============");
            System.out.println("1. Hidupkan Smartphone");
            System.out.println("2. Matikan Smartphone");
            System.out.println("3. Besarkan Volume");
            System.out.println("4. Kecilkan Volume");
            System.out.println("5. Keluar aplikasi");
            System.out.println("=================================");
            
            System.out.println("Pilih menu : ");
            answer = input.next();
            
            switch(answer){
                case "1":
                    sam.turnOn();
                    break;
                case "2":
                    sam.turnOff();
                    break;
                case "3":
                    sam.makeFullVolume();
                    break;
                case "4":
                    sam.makeMinusVolume();
                    break;
                case "5":
                    isClosed = true;
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
            }                                  
        }
    }
}

interface Phone{
    int MAX_VOLUME = 100;
    int MIN_VOLUME = 0;
    
    void powerOn();
    void powerOff();
    void volumeUp();
    void  volumeDown();

    public void makeFullVolume();

    public void makeMinusVolume();
    }

class PhoneUser{
    Phone phone;
    
    public PhoneUser(Phone phone) {
        this.phone = phone;
    }
    
    void turnOn(){
        phone.powerOn();
    }
    void  turnOff(){
        phone.powerOff();
    }
    void makeFullVolume(){
        phone.makeFullVolume();
    }
    void makeMinusVolume(){
        phone.makeMinusVolume();
    }    
}

 class Xiaomi implements Phone{
    int volume;
    boolean isPower;

    public Xiaomi() {
        volume = 70;
    }
    public String getString(){
        return "Samsung";
    }
    
    @Override
    public void  powerOn(){
        isPower = true;
        System.out.println("Smarthone melakukan Booting");
        System.out.println("Samsung Note 9 Powered by Android");
    }
    @Override
    public void powerOff(){
        isPower=false;
        System.out.println("Smartphone proses mematikan");
    }
    
    @Override
    public void volumeUp(){
        if (isPower){
            if (volume == MAX_VOLUME){
                System.out.println("Volume maksimal 100%");
            }
            
            else{
                volume += 10;
                System.out.println(" Volume sekarang " + getVolume() + "%");
            }
            
        }else{
            System.out.println("Hidupkan terlebih dahulu Smartphone");
        }
    }
    
    @Override
    public void volumeDown(){
        if (isPower) {
            if (volume == MIN_VOLUME){
                System.out.println("Volume suara 0%");
            }
            
            else{
                volume -=10;
                System.out.println(" Volume sekarang " + getVolume() + "%");
            }
            
        }else{
            System.out.println("Hidupkan terlebih dahulu smartphone");
        }
    }
    
    public int getVolume(){
        return volume;
    }

    @Override
    public void makeFullVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeMinusVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class Samsung implements Phone {
    int volume;
    boolean isPower;

    public Samsung() {
        volume = 70;
    }
    public String getString(){
        return "Samsung";
    }
    
    @Override
    public void  powerOn(){
        isPower = true;
        System.out.println("Smarthone melakukan Booting");
        System.out.println("Samsung Note 9 Powered by Android");
    }
    @Override
    public void powerOff(){
        isPower=false;
        System.out.println("Smartphone proses mematikan");
    }
    
    @Override
    public void volumeUp(){
        if (isPower){
            if (volume == MAX_VOLUME){
                System.out.println("Volume maksimal 100%");
            }
            
            else{
                volume += 10;
                System.out.println(" Volume sekarang " + getVolume() + "%");
            }
            
        }else{
            System.out.println("Hidupkan terlebih dahulu Smartphone");
        }
    }
    
    @Override
    public void volumeDown(){
        if (isPower) {
            if (volume == MIN_VOLUME){
                System.out.println("Volume suara 0%");
            }
            
            else{
                volume -=10;
                System.out.println(" Volume sekarang " + getVolume() + "%");
            }
            
        }else{
            System.out.println("Hidupkan terlebih dahulu smartphone");
        }
    }
    
    public int getVolume(){
        return volume;
    }

    @Override
    public void makeFullVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeMinusVolume() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
