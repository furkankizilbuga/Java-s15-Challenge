package com.library.persons;

import com.library.Library;
import com.library.books.Book;
import com.library.enums.Status;

import java.time.LocalDate;
import java.util.Set;

public class Reader extends Person {

    private int points;

    public Reader(int id, String name) {
        super(id,name);
        points = 5;
        Library.getReaders().put(this, super.getBooks());
    }



    public int getPoints() {
        return points;
    }

    /*@Override
    public void purchaseBook(Book book) {
        if(!Library.getBooks().contains(book)) {
            System.out.println("Kütüphanemiz aradığınız kitaba sahip değil.");
        } else if(book.getStatus() == Status.IN_USE) {
            System.out.println("İstediğiniz kitap şu anda başkası tarafından kullanılıyor: " + book.getOwner().getName());
        } else {
            if(points >= 2) {
                //this.getBooks().add(book);
            *//*
                Direkt satın aldığı için sistemde kimde olduğu kaydına gerek yok diye düşündüm.
                (Geri getirme yükümlülüğü olmayacağı için.)
            *//*
                points -= 2;
                System.out.println("Tebrikler! Satın alma işleminiz başarılı.");
                Library.getBooks().remove(book);
            } else {
                System.out.println("Yetersiz bakiye.");
            }
        }

    }*/


    public void purchaseBook(Book book) {
        if(book.getStatus() == Status.IN_USE) {
            System.out.println("İstediğiniz kitap şu anda başkası tarafından kullanılıyor: " + book.getOwner().getName());
        } else {
            if(points >= 2) {
                //this.getBooks().add(book);
            /*
                Direkt satın aldığı için sistemde kimde olduğu kaydına gerek yok diye düşündüm.
                (Geri getirme yükümlülüğü olmayacağı için.)
            */
                points -= 2;
                System.out.println("Tebrikler! Satın alma işleminiz başarılı.");
                Library.getBooks().remove(book);
            } else {
                System.out.println("Yetersiz bakiye.");
            }
        }

    }


    public void borrowBook(Book book) {
        if(book.getStatus() == Status.IN_USE) {
            System.out.println("İstediğiniz kitap şu anda başkası tarafından kullanılıyor: " + book.getOwner().getName());
        } else {
            if(getBooks().size() >= 5) {
                System.out.println("En fazla 5 kitap ödünç alabilirsiniz.");
            } else {
                if(points >= 1) {
                    book.setStatus(Status.IN_USE);

                    LocalDate lendDate = LocalDate.now();
                    book.setDateOfPurchase(lendDate);

                    points -= 1;
                    getBooks().add(book);
                    book.setOwner(this);

                    Library.getReaders().put(this, getBooks());

                    System.out.println("Kitap başarıyla ödünç alınmıştır.");
                } else {
                    System.out.println("Yetersiz bakiye.");
                }
            }
        }
    }

    public void returnBook(Book book) {
        if(!getBooks().contains(book)) {
            System.out.println("Bu kitabı daha önce ödünç almadığınız için teslim edemezsiniz.");
        } else {
            getBooks().remove(book);
            book.setStatus(Status.AVAILABLE);
            points += 1;
            System.out.println("Kitap başarıyla teslim edilmiştir.");
        }
    }

    /*@Override
    public void borrowBook(Book book) {
        if(!Library.getBooks().contains(book)) {
            System.out.println("Ödünç almaya çalıştığınız kitap bulunmamaktadır.");
        } else if(book.getStatus() == Status.IN_USE) {
            System.out.println("İstediğiniz kitap şu anda başkası tarafından kullanılıyor: " + book.getOwner().getName());
        } else {
            if(getBooks().size() >= 5) {
                System.out.println("En fazla 5 kitap ödünç alabilirsiniz.");
            } else {
                if(points >= 1) {
                    book.setStatus(Status.IN_USE);

                    LocalDate lendDate = LocalDate.now();
                    book.setDateOfPurchase(lendDate);

                    points -= 1;
                    getBooks().add(book);
                    book.setOwner(this);

                    Library.getReaders().put(this, getBooks());

                    System.out.println("Kitap başarıyla ödünç alınmıştır.");
                } else {
                    System.out.println("Yetersiz bakiye.");
                }
            }
        }
    }*/

    /*public void returnBook(Book book) {
        if(!getBooks().contains(book)) {
            System.out.println("Bu kitabı daha önce ödünç almadığınız için teslim edemezsiniz.");
        } else {
            getBooks().remove(book);
            book.setStatus(Status.AVAILABLE);
            points += 1;
            System.out.println("Kitap başarıyla teslim edilmiştir.");
        }
    }*/

    @Override
    public String toString() {
        return "Person{" +
                " Name:'" + super.getName() + '\'' +
                ", Books in possession: " + booksToString() +
                ", Points: " + getPoints() +
                '}';
    }

}
