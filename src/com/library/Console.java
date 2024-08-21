package com.library;
import com.library.persons.Reader;

import java.util.Objects;
import java.util.Scanner;

public class Console {
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen kayıtlı olan ID'nizi giriniz:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Reader user = Library.checkUser(id);
        while (true) {

            if (user != null) {

                System.out.println(
                        "Hoşgeldin " + user.getName() + "\n" +
                        """
                        Lütfen yapmak istediğiniz işlemi seçiniz:\s
                        Kitap satın almak için: 1
                        Kitap teslim etme için: 2
                        Kitap ödünç alma için: 3
                        Puanımı göster: 4
                        Kitaplarımı göster: 5
                        Çıkmak için: 0""");

                int input = scanner.nextInt();
                scanner.nextLine();

                switch (input) {
                    case 0:
                        System.out.println("Sistemden çıkılıyor...");
                        return;
                    case 1:
                        System.out.println("Lütfen satın almak istediğiniz istediğiniz kitabı belirtiniz:");
                        String bookToPurchaseName = scanner.nextLine().trim();
                        if (Library.findBook(bookToPurchaseName).isPresent()) {
                            user.purchaseBook(Library.findBook(bookToPurchaseName).get());
                        } else {
                            System.out.println("Aradığınız kitap kütüphanemizde bulunmamaktadır.");
                        }
                        break;
                    case 2:
                        System.out.println("Lütfen teslim etmek istediğiniz kitabın ismini giriniz:");
                        String bookToReturnName = scanner.nextLine().trim();
                        if (Library.findBook(bookToReturnName).isPresent()) {
                            user.returnBook(Library.findBook(bookToReturnName).get());
                        } else {
                            System.out.println("Aradığınız kitap kütüphanemizde bulunmamaktadır.");
                        }
                        break;
                    case 3:
                        System.out.println("Lütfen ödünç almak istediğiniz kitabın ismini giriniz:");
                        String bookToBorrowName = scanner.nextLine().trim();
                        if (Library.findBook(bookToBorrowName).isPresent()) {
                            user.borrowBook(Library.findBook(bookToBorrowName).get());
                        } else {
                            System.out.println("Aradığınız kitap kütüphanemizde bulunmamaktadır.");
                        }
                        break;
                    case 4:
                        System.out.println(user.getPoints());
                        break;
                    case 5:
                        if(user.booksToString().isEmpty()) System.out.println("Kitabınız bulunmamaktadır.");
                        else System.out.println(user.booksToString());
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir işlem seçiniz.");
                        break;
                }

            } else {
                System.out.println("Lütfen kayıt olmak için isminizi giriniz:");
                String newRegister = scanner.nextLine();
                if(Objects.equals(newRegister, "") || newRegister == null || newRegister.equals(" ")) {
                    System.out.println("Lütfen geçerli bir isim giriniz.");
                }
                Reader newMember = new Reader(Library.getReaders().size() + 1, newRegister);

                Library.addReader(newMember);
                user = newMember;
                System.out.println("ID'niz: " + user.getId());
            }
        }
    }
}