import java.util.Scanner;
class Book{
String author;
String title;
String publisher;
}
class BookInfo extends Book{
double price;
int stock_in_position;
}
class BookSales extends BookInfo{
int noofcopiessold;
void accept(){
Scanner sc=new Scanner(System.in);
System.out.print("Enter Title: ");
title=sc.nextLine();
System.out.print("Enter Author: ");
author=sc.nextLine();
System.out.print("Enter Publisher: ");
publisher=sc.nextLine();
System.out.print("Enter Price: ");
price=sc.nextDouble();
System.out.print("Enter Stock in Position: ");
stock_in_position=sc.nextInt();
System.out.print("Enter Number of Copies Sold: ");
noofcopiessold=sc.nextInt();
}
double RevenueGenerated(){
return price*noofcopiessold;
}
void AllShow(){
System.out.println("\n--- Book Details ---");
System.out.println("Title: "+title);
System.out.println("Author: "+author);
System.out.println("Publisher: "+publisher);
System.out.println("Price: "+price);
System.out.println("Stock in Position: "+stock_in_position);
System.out.println("Copies Sold: "+noofcopiessold);
System.out.println("Total Revenue Generated: "+RevenueGenerated());
}
}
public class exp2{
public static void main(String[] args){
BookSales bs=new BookSales();
bs.accept();
bs.AllShow();
}
}