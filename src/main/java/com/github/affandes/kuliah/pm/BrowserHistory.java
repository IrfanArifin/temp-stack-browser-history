package com.github.affandes.kuliah.pm;
import java.util.LinkedList;
import java.util.Scanner;

public class BrowserHistory {
  private LinkedList<String> history; 

  public BrowserHistory() {
      history = new LinkedList<>();
  }

  //menampilkan semua history browser dari yang paling baru
  public void view() {
      if (history.isEmpty()) {
          System.out.println("History kosong.");
          return;
      }
      System.out.println("Browser History (terbaru):");
      for (int i = history.size() - 1; i >= 0; i--) {
          System.out.println(history.get(i));
      }
  }

  //menambahkan website baru ke dalam daftar history
  public void browse(String url) {
      history.add(url);
      System.out.println("Browsing: " + url);
  }

  //untuk kembali ke website sebelumnya dan menghapus history terakhir
  public void back() {
      if (history.isEmpty()) {
          System.out.println("Tidak ada history untuk kembali");
          return;
      }
      //Menghapus website terakhir dari history
      String lastVisited = history.removeLast(); 
      System.out.println("Kembali dari: " + lastVisited);
  }

  public static void main(String[] args) {
      BrowserHistory browserHistory = new BrowserHistory();
      Scanner scanner = new Scanner(System.in);
      String command;

      System.out.println("Selamat datang di Browser History");

      do {
          System.out.println("\nPerintah: view, browse <url>, back, exit");
          System.out.print("Masukkan Perintah ");
          command = scanner.nextLine();

          if (command.startsWith("browse")) {
              String url = command.substring(7); // Mengambil URL setelah kata 'browse'
              browserHistory.browse(url);
          } else if (command.equals("view")) {
              browserHistory.view();
          } else if (command.equals("back")) {
              browserHistory.back();
          } else if (!command.equals("exit")) {
              System.out.println("Perintah invalid. Mohon coba lagi.");
          }

      } while (!command.equals("exit"));

      System.out.println("Keluar dari Browser History");
      scanner.close();
  }
}
