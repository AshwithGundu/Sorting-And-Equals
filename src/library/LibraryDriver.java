/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import enums.Genre;
import enums.MPAA_Rating;
import exceptions.MaximumItemsReachedException;
import exceptions.UnderAgeException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Ashwith Gundu
 */
public class LibraryDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, MaximumItemsReachedException, UnderAgeException {
        // TODO code application logic here        // TODO code application logic here
        Scanner sc = new Scanner(new File("library.txt"));
        LibraryManagement libman = new LibraryManagement();
        FacultyList fList = new FacultyList();
        ArrayList<Student> studentList = new ArrayList<>();
        ArrayList<Device> deviceList = new ArrayList<>();
        ArrayList<Book> bookList = new ArrayList<>();
        while (sc.hasNext()) {
            String sss = sc.next();
            if (sss.toLowerCase().trim().equals("student")) {
                String s, ss;
                s = sc.next();
                int i = sc.nextInt();
                sc.nextLine();
                ss = sc.nextLine();
                Student student = new Student(s, i, ss);
                while (sc.hasNext()) {
                    String type = sc.next();
                    if (type.toLowerCase().equals("book")) {
                        sc.nextLine();
                        String[] b1 = sc.nextLine().split(",");
                        String[] b2;
                        Author[] author = new Author[b1.length];
                        String fName,lName,mName;        
                        int index = 0;
                        for (String author1 : b1) {
                            b2 = author1.split(" ");
                            if (b2.length == 3) {
                                author[index] = new Author(b2[0], b2[1], b2[2]);
                            } else if (b2.length == 2) {
                                author[index] = new Author(b2[0], b2[1]);
                            }
                            index++;
                        }

                        String title,
                                genre;
                        int copyRight = sc.nextInt(),
                                edition = sc.nextInt();
                        genre = sc.next().toUpperCase();
                        sc.nextLine();
                        title = sc.nextLine();
                        try {
                            Book book = new Book(author, copyRight, edition, Genre.valueOf(genre), title);
                            bookList.add(book);
                            student.addItems(book);
                            book.setTitle(book.getTitle().toUpperCase());
                        } catch (MaximumItemsReachedException m) {
                        } catch (UnderAgeException c) {
                        }

                    } else if (type.toLowerCase().equals("dvd")) {
                        MPAA_Rating mpp = MPAA_Rating.valueOf(sc.next().toUpperCase());
                        double storage = sc.nextDouble();
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            DVD dvd = new DVD(mpp, storage, title);
                            //dvd.generateUniqueID();
                            student.addItems(dvd);
                            // System.out.println(dvd);
                        } catch (MaximumItemsReachedException m) {
                            //    System.out.println(m);
                        } catch (UnderAgeException c) {
                            //  System.out.println(c);
                        }
                    } else if (type.toLowerCase().equals("device")) {
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            Device device = new Device(title);
                            //device.generateUniqueID();
                            //device.generateRackID();
                            student.addItems(device);
                            deviceList.add(device);
                            // System.out.println(device);
                        } catch (MaximumItemsReachedException m) {
                            //  System.out.println(m);
                        } catch (UnderAgeException c) {
                            //System.out.println(c);
                        }

                    } else if (type.toLowerCase().equals("dates")) {
                        sc.nextLine();
                        String dueDate = sc.nextLine(), returnDate = sc.nextLine();
                        // System.out.println(dueDate);
                        //System.out.println(returnDate);
                        LibraryManagement lm1 = new LibraryManagement(student, dueDate, returnDate);
//                        System.out.println("**********************************");
//                        System.out.println(libman1);
//                        System.out.println("**********************************");
                        libman.addMembers(student);
                        //  System.out.println("\n");
                        //            System.out.println("---------"+libman.getMemberList());
                        studentList.add(student);

                        break;
                    }
                }

            } else if (sss.trim().toLowerCase().equals("faculty")) {
                sc.nextLine();
                String dep = sc.nextLine(), name = sc.nextLine();
                int age = sc.nextInt();
                Faculty faculty = new Faculty(dep, name, age);
                //faculty.generateMemberID();
                while (sc.hasNext()) {
                    String type = sc.next();
                    if (type.toLowerCase().equals("book")) {
                        sc.nextLine();
                        String[] b1 = sc.nextLine().split(",");
                        String[] b2;
                        Author[] author = new Author[b1.length];
                        String fName,
                                lName,
                                mName;
                        int index = 0;
                        for (String author1 : b1) {
                            b2 = author1.split(" ");
                            if (b2.length == 3) {
                                author[index] = new Author(b2[0], b2[1], b2[2]);
                            } else if (b2.length == 2) {
                                author[index] = new Author(b2[0], b2[1]);
                            }
                            index++;
                        }

                        String title,
                                genre;
                        int copyRight = sc.nextInt(),
                                edition = sc.nextInt();
                        genre = sc.next().toUpperCase();
                        sc.nextLine();
                        title = sc.nextLine();
                        try {

                            Book book = new Book(author, copyRight, edition, Genre.valueOf(genre), title);
                            // book.setTitle(book.getTitle().toUpperCase());
                            //  book.generateUniqueID();
                            // book.generateRackID();
                            bookList.add(book);
                            faculty.addItems(book);
                            book.setTitle(book.getTitle().toUpperCase());
                            // System.out.println(student);
                        } catch (MaximumItemsReachedException m) {
                            // System.out.println(m);
                        } catch (UnderAgeException c) {
                            //System.out.println(c);
                        }

                    } else if (type.toLowerCase().equals("dvd")) {
                        MPAA_Rating mpp = MPAA_Rating.valueOf(sc.next().toUpperCase());
                        double storage = sc.nextDouble();
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            DVD dvd = new DVD(mpp, storage, title);
                            //dvd.generateUniqueID();
                            faculty.addItems(dvd);
                            // System.out.println(dvd);
                        } catch (MaximumItemsReachedException m) {
                            //    System.out.println(m);
                        } catch (UnderAgeException c) {
                            //  System.out.println(c);
                        }
                    } else if (type.toLowerCase().equals("device")) {
                        sc.nextLine();
                        String title = sc.nextLine();

                        try {
                            Device device = new Device(title);
                            //device.generateUniqueID();
                            //device.generateRackID();
                            faculty.addItems(device);
                            deviceList.add(device);
                            // System.out.println(device);
                        } catch (MaximumItemsReachedException m) {
                            // System.out.println(m);
                        } catch (UnderAgeException c) {
                            //System.out.println(c);
                        }

                    } else if (type.toLowerCase().equals("dates")) {
                        sc.nextLine();
                        String dueDate = sc.nextLine(), returnDate = sc.nextLine();
                        // System.out.println(dueDate);
                        //System.out.println(returnDate);
                        LibraryManagement libman1 = new LibraryManagement(faculty, dueDate, returnDate);
//                        System.out.println("**********************************");
//                        System.out.println(libman1);
//                        System.out.println("**********************************");
                        //System.out.println("\n");
                        libman.addMembers(faculty);
                        //            System.out.println("---------"+libman.getMemberList());
                        fList.addFaculty(faculty);
                        fList.addFacultyNames(faculty.getName());
                        break;
                    }
                }

            }

        }
        System.out.println("--------------------------------------\n"
                + "Printing Student details\n"
                + "--------------------------------------");
        for (Member s : libman.getMemberList()) {
            if (s instanceof Student) {
                System.out.println(s);
                // System.out.println("**********************************");
                System.out.print("\n");

            }

        }
        System.out.println("--------------------------------------\n"
                + "Printing Faculty details\n"
                + "--------------------------------------");
        for (Member s : libman.getMemberList()) {
            if (s instanceof Faculty) {
                System.out.println(s);
                //System.out.println("**********************************");
                System.out.print("\n");
            }

        }
        System.out.println("----------Checking Comparable Interface Implementation---------\n"
                + "-------------------------------------------------------------\n"
                + "Printing Student details sorting in natural order by their ID\n"
                + "-------------------------------------------------------------");
        Collections.sort(studentList);
        for (Student s : studentList) {
            System.out.println(s);
            System.out.print("\n");
        }
        System.out.println("---------------------------------------------------------------\n"
                + "Printing Faculty details sorting in natural order by their name\n"
                + "---------------------------------------------------------------");
        Collections.sort(fList.getFacultyList());
        for (Faculty f : fList.getFacultyList()) {
            System.out.println(f.toString());
            System.out.print("\n");
        }
        System.out.println("--------Checking the Comparator Interface Implementation-------\n"
                + "------------------------------------------------------------\n"
                + "Printing List of Books by descending order of their edition\n"
                + "------------------------------------------------------------");
        Collections.sort(bookList,
                new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                BookComparator b = new BookComparator();
                return b.compare(o1, o2);
            }
        });
        for (Book b : bookList) {
            System.out.println(b);
            // System.out.print("\n");
        }
        System.out.println("----------------Anonymous Class Implementation-----------------\n"
                + "------------------------------------------------------\n"
                + "Devices that are issued\n"
                + "------------------------------------------------------");
        AnonymousDeviceList anonymousDList = new AnonymousDeviceList() {
            @Override
            public String deviceList() {
                String listOfDevices = "";
                for (Device d : deviceList) {
                    listOfDevices = listOfDevices + d.getTitle().toLowerCase() + "\n";
                }
                return listOfDevices;
            }

        };
        System.out.println(anonymousDList.deviceList());

        System.out.println("-------Checking the overrided equals and hashCode methods------");
        System.out.println("For Equals Test Case : First Test case has passed because the output of the test case is false and Second Test has failed because the output of the second test case is true");
        System.out.println("For HashCode Test Case: First Test case is failed because the output of this test case is false and Second Test has passed because the output of this test case is false");
        System.out.println("All the tests were failed because, we passed different strings we have different hashcode values");
        System.out.println("All the test cases were failed the tests because we passed different strings and compared two strings were lexicographically and also hashcode references");

    }

}
