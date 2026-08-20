class Book{
String author;
String title;
String publisher;
}
class BookInfo extends Book{
double price;
int stockPosition;
void setDetails(String a,String t,String pub,double pr,int sp){
author=a;
title=t;
publisher=pub;
price=pr;
stockPosition=sp;
}
void show(){
System.out.println("Title: "+title);
System.out.println("Author: "+author);
System.out.println("Publisher: "+publisher);
System.out.println("Price: $"+price);
System.out.println("Stock Position: "+stockPosition);
System.out.println("---------------------------");
}
}
public class exp1{
public static void main(String[] args){
BookInfo book1=new BookInfo();
book1.setDetails("J.K. Rowling","Harry Potter","Bloomsbury",29.99,15);
BookInfo book2=new BookInfo();
book2.setDetails("George Orwell","1984","Secker & Warburg",19.50,8);
BookInfo book3=new BookInfo();
book3.setDetails("J.R.R. Tolkien","The Hobbit","George Allen & Unwin",24.99,20);
book1.show();
book2.show();
book3.show();
}
}