/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author ram
 */
public class Main {

  
    public static void main(String[] args) {

        // java.awt.EventQueue.invokeLater(new Runnable() {

        //     @Override
        //     public void run() {
        //         new TambahPesanan().setVisible(true);;
        //     }
            
        // });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ReadDataFrame readDataFrame = new ReadDataFrame();
                readDataFrame.setLocationRelativeTo(null);
                readDataFrame.setVisible(true);
            }
        });

  

       
    }
   
}
