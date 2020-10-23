/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Soal.Chatting2;

/**
 *
 * @author Alfin
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;



public class client {
    public static void main(String args[]) throws Exception
 {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Masukkan IP Address : ");
                String ip = sc.nextLine();
                System.out.print("Masukkkan Socket Server : ");
                int socket = sc.nextInt();
                Socket sk=new Socket(ip, socket);
  BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
  PrintStream sout=new PrintStream(sk.getOutputStream());
  BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
  String s;
  while (  true )
  {
   System.out.print("Client : ");
   s = stdin.readLine();
   sout.println(s);
   s = sin.readLine();
   System.out.print("Server : "+s+"\n");
     if ( s.equalsIgnoreCase("BYE") )
       break;
  }
   sk.close();
   sin.close();
   sout.close();
   stdin.close();
            } catch (Exception e) {
                System.out.println("Unable to connect to server \nMay be your ip or socket is not correct");
            }
  
 }
}
