package com.library;

import com.library.books.Book;
import com.library.persons.Reader;

import java.util.Scanner;

public class Console {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen isminizi giriniz:");
        String name = scanner.nextLine();
        Reader user = Library.checkUser(name);
        if (user.getName() != null) {
            System.out.println("""
                    Lütfen yapmak istediğiniz işlemi seçiniz:\s
                    Kitap satın almak için: 1
                    Kitap teslim etme için: 2
                    Kitap ödünç alma için: 3""");

            //TODO findBook metotlarını direkt olarak purchaseBook, returnBook, borrowBook metotları içerisine entegre et.

            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Lütfen satın almak istediğiniz istediğiniz kitabı belirtiniz:");
                    String bookToPurchaseName = scanner.nextLine().trim();
                    Book bookToPurchase = Library.findBook(bookToPurchaseName).get();
                case 2:
                    System.out.println("Lütfen teslim etmek istediğiniz kitabın ismini giriniz:");
                    String bookToReturnName = scanner.nextLine().trim();
                    Book bookToReturn = Library.findBook(bookToReturnName).get();
                    user.returnBook(bookToReturn);
                case 3:
                    System.out.println("Lütfen ödünç almak istediğiniz kitabın ismini giriniz:");
                    String bookToBorrowName = scanner.nextLine().trim();
                    Book bookToBorrow = Library.findBook(bookToBorrowName).get();
                    user.borrowBook(bookToBorrow);
            }
        }
    }

}
