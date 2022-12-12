/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routerrental_package;

import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Mariam Hesham
 */
/**
 *Interface contains all functions customer can do.
 */
 interface Functions {
 void Display();
 double calculatefees(double fees,String type);

}
/**
 *Exception class handles any wrong input user can enter.
 */
 class InvalidInput extends Exception{
 public InvalidInput (String msg){
        super(msg);
    }
}
/**
 *Date class is used to set any date entered by user and add days to any given date.
 * @see <a href ="https://www.geeksforgeeks.org/calendar-settime-method-in-java-with-examples/"> Date</a>
 */
 class date {
    int day;
    int month;
    int year;
    Date d;
/**
  * @param d sets date.
 */
    public date(Date d) {
        this.d = d;
    }
/**
  * @return returns date.
 */
    public Date getD() {
        return d;
    }
/**
  * @return returns day.
 */
    public int getDay() {
        day=d.getDate();
        return day;
    }
/**
  * @return returns month.
 */
    public int getMonth() {
        month=d.getMonth()+1;
        return month;
    }
/**
  * @return returns year.
 */
    public int getYear() {
        year=d.getYear()+1900;
        return year;
    }
/**
 *Set date function is used to set any given date in calender and returns this date.
 * @param day An integer number of day from 1 to 31.
 * @param month An integer number of month from 1 to 12.
 * @param year An integer number of year greater than or equal 2020.
 * @return returns a date after setting it to a calender.
 */
    public Date Setdate(int day,int month,int year){
        Calendar cal1 = (Calendar)Calendar.getInstance();
        cal1.set(Calendar.MONTH, month-1); 
        cal1.set(Calendar.YEAR, year); 
        cal1.set(Calendar.DAY_OF_MONTH, day); 
        Date dt = cal1.getTime(); 
       return dt;
    }
    
 /**
 *Add date function is used to set any given date in calender and takes string variable to indicate if user want the reservation daily or weekly or monthly and returns date.
 * @param day An integer number of day from 1 to 31.
 * @param month An integer number of month from 1 to 12.
 * @param year An integer number of year greater than or equal 2020.
 * @param type A string which is daily or weekly or monthly to calculate the auto-generated-date.
 * @return returns a date after setting it to a calender.
 */
    public Date adddate(int day,int month,int year,String type){
        Calendar cal1 = (Calendar)Calendar.getInstance();
        Calendar cal2 = (Calendar)Calendar.getInstance(); 
        cal1.set(Calendar.MONTH, month-1); 
        cal1.set(Calendar.YEAR, year); 
        cal1.set(Calendar.DAY_OF_MONTH, day); 
        Date dt = cal1.getTime(); 
        cal2.setTime(dt); 
           switch (type) {
            case "daily":
                cal2.add(Calendar.DAY_OF_MONTH, 1);
                dt = cal2.getTime();
                break;
            case "weekly":
                cal2.add(Calendar.WEEK_OF_YEAR, 1);
                dt = cal2.getTime();
                break;
            case "monthly":
                cal2.add(Calendar.MONTH, 1);
                dt = cal2.getTime();
                break;
            default:
                break;
        }
           return dt;
       }
}
/**
 *Router class is used to define components of router as serial number, model, number of ports, price.
 */
 class Router {
    private int serialnumber;
    private String model;
    private int number_of_ports;
    private double price;
    private static int routercount=0;
    /**
  * @param serial_number sets serial number for router.
  * @param model sets model for router.
  * @param numberofports sets number of ports for router.
  * @param price sets price for router.
 */

    public  Router(int serial_number,String model,int numberofports,double price){
    serialnumber = serial_number;
    this.model=model;
    this.number_of_ports=numberofports;
    this.price=price;
    routercount++;
}
/**
  * @return returns serial number of router.
 */
    public int getSerialnumber() {
        return serialnumber;
    }
/**
  * @return returns model of router.
 */
    public String getModel() {
        return model;
    }
/**
  * @return returns number of ports of router.
 */
    public int getNumber_of_ports() {
        return number_of_ports;
    }
/**
  * @return returns price of router.
 */
    public double getPrice() {
        return price;
    }
/**
  * @param serialnumber sets serial number for router.
 */
    public void setSerialnumber(int serialnumber) {
        this.serialnumber = serialnumber;
    }
/**
  * @param model sets model for router.
 */
    public void setModel(String model) {
        this.model = model;
    }
/**
  * @param number_of_ports sets number of ports for router.
 */
    public void setNumber_of_ports(int number_of_ports) {
        this.number_of_ports = number_of_ports;
    }
/**
  * @param price sets price for router.
 */
    public void setPrice(double price) {
        this.price = price;
    }
/**
 *Get router count function is a Static method used to count how many router we have in our system.
 * @return returns integer number defining the routers count in system
 */
    public static int getRoutercount() {
        return routercount;
    }
 /**
 *Display function is used to display data of any router.
 * @param r router.
 */
    public void display(Router r) {
             System.out.println("\t\t Router Details");
             System.out.println("Router's Serial Number: "+r.getSerialnumber());
             System.out.println("Router's Model: "+r.getModel());
             System.out.println("Router's Number of Ports:"+r.getNumber_of_ports());
             System.out.println("Router's Price:"+r.getPrice());
         }
 /**
 *To String function is used to display data of any router
 * @return string defining all details of router
 */
    @Override
    public String toString() {
        return "Router{" + "Serial Number=" + serialnumber + ", Model=" + model + ", Number of Ports=" + number_of_ports + ", Price=" + price + '}';
    }
}
/**
 *Reservation class is used to make reservation details for any customer as what router customer has chosen, reservation number, reservation date, start date, 
 * type, generated due date
 */
  class Reservation{
    private Router router;
    private int number;
    private Date reservation_date;
    private Date start_date;
    private String type;
    private Date generated_date;
    Customer c;
/**
  * @param router sets certain router for reservation.
  * @param number sets a reservation number for customer for reservation.
  * @param reservation_date sets reservation date for reservation.
  * @param start_date sets start date for reservation.
  * @param type sets type for reservation.
  * @param generated_date sets generated date for reservation.
  * @param c sets certain customer for reservation.
 */
    public Reservation(Router router, int number, Date reservation_date, Date start_date, String type, Date generated_date, Customer c) {
        this.router = router;
        this.number = number;
        this.reservation_date = reservation_date;
        this.start_date = start_date;
        this.type = type;
        this.generated_date = generated_date;
        this.c = c;
    }
/**
  * @return returns c for any reservation.
 */
    public Customer getC() {
        return c;
    }
/**
  * @param generated_date sets generated date for reservation.
 */
    public void setGenerated_date(Date generated_date) {
        this.generated_date = generated_date;
    }
/**
  * @param c sets certain customer for reservation.
 */
    public void setC(Customer c) {
        this.c = c;
    }
   /**
  * @return returns router for any customer.
 */
    public Router getRouter() {
        return router;
    }
/**
  * @return returns reservation number for any customer.
 */
    public int getNumber() {
        return number;
    }
/**
  * @return returns reservation date for any customer.
 */
    public Date getReservarion_date() {
        return reservation_date;
    }
/**
  * @return returns start date for any customer.
 */
    public Date getStart_date() {
        return start_date;
    }
/**
  * @return returns type of reservation for any customer.
 */
    public String getType() {
        return type;
    }
/**
  * @param router sets certain router for reservation.
 */
    public void setRouter(Router router) {
        this.router = router;
    }
 /**
  * @param number sets a reservation number for customer for reservation.
 */
    public void setNumber(int number) {
        this.number = number;
    }
/**
  * @param reservation_date sets reservation date for reservation.
 */
    public void setReservarion_date(Date reservation_date) {
        this.reservation_date = reservation_date;
    }
/**
  * @param start_date sets start date for reservation.
 */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }
/**
  * @param type sets type for reservation.
 */

    public void setType(String type) {
        this.type = type;
    }
/**
  * @return returns generated date for any customer.
 */
    public Date getGenerated_date() {
        return generated_date;
    }
/**
 *Display function is used to display data of customer reservation details.
 * @param r reservation reference to display reservation details. 
 */
 public void display(Reservation r){
        System.out.println("Reservation number:"+r.getNumber());
        System.out.println("The Start Date of Your Usage:"+r.getStart_date());
        System.out.println("Your Rental Expiration Date:"+r.getGenerated_date());
    }
}
 /**
 *Invoice class is used to take data of any customer and reservation details to make an invoice for any customer.
 */
 class Invoice {
    private double fees;
    private Customer c;
    private Reservation r;
 /**
 *@param  fees for an Invoice to a customer.
 * @param c Customer to make invoice.
 * @param r to put reservation details in invoice.
 */
    public Invoice(double fees, Customer c, Reservation r) {
        this.fees = fees;
        this.c = c;
        this.r = r;
    }
 /**
  * @return returns renting fees for any customer.
 */
    public double getFees() {
        return fees;
    }
 /**
  * @return returns customer.
 */
    public Customer getC() {
        return c;
    }
 /**
 *@param  fees final renting fees for any customer.
 */
    public void setFees(double fees) {
        this.fees = fees;
    }
 /**
 *@param  c for an Invoice to a customer.
 */
    public void setC(Customer c) {
        this.c = c;
    }
    
 /**
 *Display Invoices function is used to display data of an invoice which includes reservation details ,router details and renting fees to any customer.
 */
    public void DisplayInvoices(){
        System.out.println("Router's Details For Cutomer's Name: "+c.getName());
        System.out.println("Customers's Phone: "+c.getPhone());
        System.out.println("Start Date: "+r.getStart_date()+" Due Date: "+r.getGenerated_date()+" Reservation Number: "+r.getNumber());
        System.out.println("Router's Model "+r.getRouter().getModel()+" Router's Serial Number "+r.getRouter().getSerialnumber()+" Router's Number of Ports "+r.getRouter().getNumber_of_ports()+" Router's Price "+r.getRouter().getPrice());
        System.out.println("feeses "+fees);
    }
}
/**
 *Abstract class for customer has the details of customer like phone number and name.
 */
 abstract class Customer implements Functions{
    protected String name;
    protected  int phone;
   /**
 *@param  name for any customer.
 * @param phone for any customer.
 */
    public Customer(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }
    /**
 *@return name for any customer.
 */
    public String getName() {
        return name;
    }
/**
 *@return phone for any customer.
 */
    public int getPhone() {
        return phone;
    }
/**
 *@param  name for any customer.
 */
    public void setName(String name) {
        this.name = name;
    }
/**
 *@param  phone for any customer.
 */
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
 /**
 *Rent router function is used to rent router for user takes details of all routers and customers 
 * user can choose his preferred model of router, cancel the rent, extend duration of renting, change the router model, 
 * make technical issue user want report.
 * @param r ArrayList of routers to make customer choose any one of them
 * @param p ArrayList of customers to loop over the router make each customer choose
 * any router he want.
 */
    public void RentRouter(ArrayList<Router> r,ArrayList<Customer> p) {
         Date d=new Date();
         date d1=new date(d);
         
         int day=-1,month=-1,year=-1;
         int number=0;
         ArrayList<Invoice>inv=new ArrayList<>();
         double price=0;
         String type;
         boolean b=false;
         String n=null;
         boolean cancel=false;
         int duration=0;
         Scanner input=new Scanner (System.in);
         int serial=-1;
         for(int j=0;j<p.size();j++){
             do{
                 p.get(j).Display();
                 if(r.isEmpty()){
                     System.out.println("We Are Very Sorry There is No Available Routers");
                     break;
                 }
             while (b!=true){
             System.out.println("Enter Serial Number of your Prefered Model:");
             boolean error4=false;
             while(error4!=true){
                 try{
                  serial=input.nextInt();
                 error4=true;
                 }
                 catch(InputMismatchException c){
                      System.out.println("Please Enter Serial Number in Integer Format as mentioned");
                 }
                 finally{
                        input.nextLine();
                 }
             }
                  b=CheckSerial(r, serial);
             }
             b=false;
             System.out.println("Do You Want to Change Router Model?(y/n)");
              while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                               n=input.next();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Letter in Correct Format as mentioned");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(n.equals("y")||n.equals("Y")||n.equals("N")||n.equals("n")){
                           break;
                       }
                        else if(!n.equals("n")||!n.equals("N")||!n.equals("Y")||!n.equals("N")){
                        try{
                     throw new InvalidInput("Please Enter Letter in Correct Format as mentioned");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Letter in Correct Format as mentioned");
                 }
                       
                        } 
                }
         if(n.equals("Y")||n.equals("y")){
             serial=ChangeRouterModel(r);
           }
         for(int i=0;i<r.size();i++) {
             if(serial==r.get(i).getSerialnumber()) {
                  System.out.println("Enter Start Date:");
                    while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                              System.out.print("Day:");
                              day=input.nextInt();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Day in Integrer Formate");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(day>31||day<0){
                        try{
                     throw new InvalidInput("Day Can't be greater than 31");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Number Less Than or Equal 31");
                 }
                       }
                       else 
                           break;
                    }
                     while(true){
                        boolean error2=false;
                       while(error2!=true){
                          try{
                              System.out.print("Month:");
                              month=input.nextInt();
                               error2=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Month in Integrer Formate");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                        if(month>12||month<0){
                        try{
                     throw new InvalidInput("Month Can't be greater than 12");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Number Less Than or Equal 12");
                  
                 }
                       }
                       else 
                           break;
               }
                     while(true){
                        boolean error3=false;
                       while(error3!=true){
                          try {
                              System.out.print("Year:");
                              year=input.nextInt();
                               error3=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Year in Integrer Formate");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                        if(year<2020||year<0){
                        try{
                           throw new InvalidInput("Year Can't be less than 2020");
                         }
                        catch(InvalidInput ex){
                           System.out.println ("Please Enter Number More Than or Equal 2020");
                         }
                       }
                        else 
                            break;
             }
                  System.out.println("Enter The Type of Your Reservation \"daily\" or \"weekly\" or \"monthly\"");
                  while (true){
                  System.out.println("Enter Type:");
                  type=input.next();
                  if(type.equals("monthly")||type.equals("weekly")||type.equals("daily"))
                      break;
                 else if(!type.equals("daily")){
                      try {
                          throw new InvalidInput("Please Enter Type in Correct Format as Mentioned");
                      }
                      catch(InvalidInput ex){
                           System.out.println("Please Enter Type in Correct Format as Mentioned");
                      }
                  }
                 else if(!type.equals("monthly")){
                          try {
                          throw new InvalidInput("Please Enter Type in Correct Format as Mentioned");
                      }
                      catch(InvalidInput ex){
                           System.out.println("Please Enter Type in Correct Format as Mentioned");
                      }
                  }
                 else if(!type.equals("weekly")) {
                                  try{
                          throw new InvalidInput("Please Enter Type in Correct Format as Mentioned");
                      }
                      catch(InvalidInput ex) {
                           System.out.println("Please Enter Type in Correct Format as Mentioned");
                      }
                          }
                  }
                  number=randomGenerator(100);
                  Reservation k=new Reservation(r.get(i), number, d, d1.Setdate(day, month, year), type, d1.adddate(day, month, year, type),p.get(j));
                  System.out.println("Do You Want to Cancel The operation?(y/n)");
                         while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                               n=input.next();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Letter in Correct Format as mentioned");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(n.equals("y")||n.equals("Y")||n.equals("N")||n.equals("n")){
                           break;
                       }
                        else if(!n.equals("n")||!n.equals("N")||!n.equals("Y")||!n.equals("y")){
                        try{
                     throw new InvalidInput("Please Enter Letter in Correct Format as mentioned");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Letter in Correct Format as mentioned");
                 } 
               } 
            }
                  if(n.equals("y")||n.equals("Y")) {
                      if( CancelRent(k.getStart_date())){
                             System.out.println("Cancelled");
                             p.remove(p.get(j));
                             System.out.println("\t\t\tAvailable Routers");
                     for(int il=0;il<r.size();il++){
                             System.out.println("\t\t"+r.get(il).toString());
                     }
                                    break;
                               }
                      
                      else{
                          System.out.println("Can't Cancel Before 2 Days from Start Date ");
                          n="n";
                      }
                  }
                  if(n.equals("n")||n.equals("N")) {
                      System.out.println("Do You Want to Extend Duration of Your Reservation?(y/n)");
                      while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                              n=input.next();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Letter in Correct Format as mentioned");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(n.equals("y")||n.equals("Y")||n.equals("N")||n.equals("n")){
                           break;
                       }
                        else if(!n.equals("n")||!n.equals("N")||!n.equals("Y")||!n.equals("y")){
                        try{
                     throw new InvalidInput("Please Enter Letter in Correct Format as mentioned");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Letter in Correct Format as mentioned");
                 } 
               } 
            }
                      if(n.equals("y")||n.equals("Y")){
                          System.out.println("Enter Duration in Days:");
                          duration=input.nextInt();
                          Date dn=p.get(j).ExtendDuration(duration,k.getGenerated_date());
                          k.setGenerated_date(dn);
                      }
                      if(p.get(j) instanceof Foreigners ){
                         Foreigners f=(Foreigners)p.get(j);
                        
                         System.out.println("\t\tThe Invoice\t\t\t Today's Date: "+k.getReservarion_date());
                         r.get(i).display(r.get(i));
                         k.display(k);
                         if(n.equals("y")||n.equals("Y")){
                          price=f.calculatefees(r.get(i).getPrice(), type, duration);
                          Invoice iv =new Invoice(price,p.get(j),k);
                          inv.add(iv);
                         System.out.println("Your Price: "+iv.getFees());
                         }
                         else{
                             price=f.calculatefees(r.get(i).getPrice(), type);
                             Invoice iv =new Invoice(price,p.get(j),k);
                             inv.add(iv);
                         System.out.println("Your Price: "+iv.getFees());
                      }
                         r.remove(r.get(i));
                        }
                      else if( p.get(j) instanceof Residents) {
                        // Invoice iv =new Invoice(r.get(i).getPrice(),p.get(j),k);
                         Residents l=(Residents) p.get(j);
                         System.out.println("\t\tThe Invoice\t\t\t Today's Date: "+k.getReservarion_date());
                         r.get(i).display(r.get(i));
                         k.display(k);
                         if(n.equals("y")||n.equals("Y")){
                        price=l .calculatefees(r.get(i).getPrice(), type, duration);
                          Invoice iv =new Invoice(price,p.get(j),k);
                          inv.add(iv);
                         System.out.println("Your Price: "+iv.getFees());
                         }
                         else{
                        
                             price=l.calculatefees(r.get(i).getPrice(), type);
                             Invoice iv =new Invoice(price,p.get(j),k);
                             inv.add(iv);
                             System.out.println("Your Price: "+iv.getFees());
                       }
                          r.remove(r.get(i));
                         }
                      System.out.println("Do you Want to make feedback?(y/n)");
                      String ch=null;
                                     while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                              ch=input.next();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Letter in Correct Format as mentioned");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(ch.equals("y")||ch.equals("Y")||ch.equals("N")||ch.equals("n")){
                           break;
                       }
                        else if(!ch.equals("n")||!ch.equals("N")||!ch.equals("Y")||!ch.equals("y")){
                        try{
                     throw new InvalidInput("Please Enter Letter in Correct Format as mentioned");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Letter in Correct Format as mentioned");
                 } 
               } 
            }
                              if(ch.equals("Y")||ch.equals("y")){
                                  ReportFeedback();
                              }
                      System.out.println("Do You Want To Rent again?(y/n)");
                    while(true){
                       boolean error=false;
                       while(error!=true){
                          try{
                              n=input.next();
                               error=true;
                           }   
                          catch(InputMismatchException c){
                              System.out.println("Please Enter Letter in Correct Format as mentioned");
                           }
                          finally {  
                                 input.nextLine();
                          }
                        }
                       if(n.equals("y")||n.equals("Y")||n.equals("N")||n.equals("n")){
                           break;
                       }
                        else if(!n.equals("n")||!n.equals("N")||!n.equals("Y")||!n.equals("y")){
                        try{
                     throw new InvalidInput("Please Enter Letter in Correct Format as mentioned");
                 }
                 catch(InvalidInput ex){
                     System.out.println ("Please Enter Letter in Correct Format as mentioned");
                 } 
               } 
            }
                      if(n.equals("Y")||n.equals("y")){
                        if(r.size()!=0){
             System.out.println("\t\t\tAvailable Routers");
             }
                 for(int g=0;g<r.size();g++){
                          System.out.println("\t\t"+r.get(g).toString());
                               }
                  }
                      }
                 }
            }
         }while(n.equals("Y")||n.equals("y"));
             if(r.size()!=0){
             System.out.println("\t\t\tAvailable Routers");
             }
                     for(int i=0;i<r.size();i++){
                             System.out.println("\t\t"+r.get(i).toString());
                     }
         }
          displayInvoices(inv);
         }
    /**
     *  Random Generator function generates number from 1 to entered number as a parameter in the function to Generate Random reservation number for a user.
     * @param num Any number.
     * @return returns random generated number form 1 to given number in parameter of the function.
     */
    public int randomGenerator(int num) {
           return (int) Math.floor((Math.random()*num+1)); 
    } 
  /**
 *Display invoices function is used to display all data of customers and their reservation details 
 * and what router the customer has chosen and it's details.
 * @param inv ArrayList of invoices to display invoice for all customers.
 */
     public void displayInvoices(ArrayList<Invoice>inv){
         System.out.println("\t\tReservation Details For All Customers ");
              for(int i=0;i<inv.size();i++){
               inv.get(i).DisplayInvoices();
               System.out.println();
              }
    }
  /**
 *Cancel rent function is used to cancel the rent of customer if the start date is less than the reservation date 
 * that he has reserved the router by two days so it's okay to cancel the rent if not he can't cancel.
 * @param d start date of the rent.
 * @return returns true if the difference between the reservation date and start date of the rent is two days or more
 * or returns false if the difference between the reservation date and start date of the rent is less than two days.
*/
    public boolean CancelRent(Date d){
            int day=d.getDate();
            int month=d.getMonth()+1;
            int year=d.getYear()+1900;
            Calendar cal1 = (Calendar)Calendar.getInstance(); 
            cal1.set(Calendar.MONTH, month-1); 
            cal1.set(Calendar.YEAR, year); 
            cal1.set(Calendar.DAY_OF_MONTH, day); 
            Date dt = cal1.getTime(); 
            Date d1=new Date();
            long diff = dt.getTime() - d1.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            if(diffDays>=2)
                return true;
            return false;
        }
    
 /**
 *Change router model function is used to change the customer's choice in choosing any of the available routers.
 * @param r ArrayList of routers to make customer choose one of them to change what he has chosen.
 * @return returns serial number of the chosen router by the customer.
 */
    public int ChangeRouterModel(ArrayList<Router> r) {
         Scanner input=new Scanner (System.in);
         boolean ok=false;
         int serial=0;
         for (int i=0;i<r.size();i++){
             System.out.println("\t\t"+r.get(i).toString());
         }
          while (ok!=true){
             System.out.println("Enter Serial Number of your Preferred Model:");
            boolean error4=false;
             while(error4!=true){
                 try{
                  serial=input.nextInt();
                 error4=true;
                 }
                 catch(InputMismatchException c){
                      System.out.println("Please Enter Serial Number in Integer Format as mentioned");
                 }
                 finally{
                        input.nextLine();
                 }
             }
                ok =CheckSerial(r, serial);
                if(ok==true)
                    return serial;
             }
          return -1;
    }
 /**
 *Check serial function is used to check if the entered serial number of routers is available or not.
 * @param r ArrayList of routers.
 * @param serial to check if this serial number is available or not.
 * @return returns true if serial number of router is available
 * and return false if serial number of router is not available.
 */
    public  boolean CheckSerial(ArrayList<Router> r,int serial){
         for (int i=0;i<r.size();i++){
            if(serial==r.get(i).getSerialnumber())
                return true;
        }
                return false;
    }
    
  /**
 *Extended duration function is used to extend duration of reservation the router 
 * and takes duration in days.
 * @param duration takes duration of the extended time in days
 * @param d the generated due date for any customer.
 * @return returns generated extended date after adding the duration over the generated due date.
 */
public Date ExtendDuration(int duration,Date d) {
            int day=d.getDate();
            int month=d.getMonth()+1;
            int year=d.getYear()+1900;
            Calendar cal1 = (Calendar)Calendar.getInstance(); 
            cal1.set(Calendar.MONTH, month-1); 
            cal1.set(Calendar.YEAR, year); 
            cal1.set(Calendar.DAY_OF_MONTH, day); 
            cal1.add(Calendar.DAY_OF_MONTH, duration);
            Date dt = cal1.getTime();
            return dt;
    }
   
  /**
 *Report feedback function is used to make customer report any feedback or technical issue.
 */
    public void ReportFeedback() {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Your FeedBack");
        String feedback=input.next();
        System.out.println("Thanks for Your Feedback We Will Make Good Use of It");
    }
    @Override
    public abstract double calculatefees(double fees,String type);
}
 /**
 *Foreigner class is inherited from the abstract customer class defines type of customer which is foreigner customers.
 */
 class Foreigners extends Customer implements Functions {

   final private double discount=0;
   private double feeses;
    public Foreigners(String name, int phone) {
        super(name, phone);
    }
  /**
 *Calculate fees function is an over ridden function from Functions interface calculates fees for foreigner customer takes price of router and type of reservation
 * which is daily or weekly or monthly.
 * @param fees price of the router.
 * @param type type of reservation which is daily or weekly or monthly.
 * @return returns renting fees for the customer.
 */
   @Override
    public double calculatefees(double fees,String type){
        if (type.equals("weekly")){
            feeses=(fees*7)-(discount*fees*7);
            return feeses;
        }
        else if(type.equals("monthly")){
            feeses=(fees*30)-(discount*fees*30);
        return feeses;
        }
        feeses=(fees*1)-(discount*fees*1);
       return feeses;
        }
/**
 *Calculate fees function is an overloaded function calculates fees for foreigner customer takes price of router, type of reservation
 * which is daily or weekly or monthly and extended duration.
 * @param fees price of the router.
 * @param type type of reservation which is daily or weekly or monthly.
 * @param ExtendedDuration duration entered by customer to extend auto generated due date.
 * @return returns renting fees for the customer.
 */
       public double calculatefees(double fees,String type,int ExtendedDuration){
        if (type.equals("weekly")){
            feeses=(fees*(7+ExtendedDuration))-(discount*fees*(7+ExtendedDuration));
            return feeses;
        }
        else if(type.equals("monthly")){
            feeses=(fees*(30+ExtendedDuration))-(discount*fees*(30+ExtendedDuration));
        return feeses;
        }
        feeses= (fees*(1+ExtendedDuration))-(discount*fees*(1+ExtendedDuration));
       return feeses;
    }
 /**
 *@return Final method returns discount for foreigner customer.
 */
    public final double getDiscount() {
        return discount;
    }
 /**
 *@return renting fees for resident customer.
 */
    public double getFeeses() {
        return feeses;
    }
 /**
 *Display function is an over ridden function from Functions interface displays data of customer.
 */
    @Override
    public void Display() {
    System.out.println("\tCustomer's Details");
    System.out.println("Name:"+getName());
    System.out.println("Phone:"+getPhone());
    
    }

}
/**
 *Resident class is inherited from the abstract customer class defines type of customer which is resident customers
 */
class Residents extends Customer implements Functions{
   final private double discount=0.25;
   private double feeses;
    public Residents(String name, int phone) {
        super(name, phone);
    }
/**
 *Calculate fees function is an over ridden function from Functions interface calculates fees for resident customer takes price of router and type of reservation
 * which is daily or weekly or monthly.
 * @param fees price of the router.
 * @param type type of reservation which is daily or weekly or monthly.
 * @return returns renting fees for the customer.
 */
    @Override
    public double calculatefees(double fees,String type){
        if (type.equals("weekly")){
            feeses=(fees*7)-(discount*fees*7);
            return feeses;
        }
        else if(type.equals("monthly")){
            feeses=(fees*30)-(discount*fees*30);
        return feeses;
        }
        feeses=(fees*1)-(discount*fees*1);
       return feeses;
        }
/**
 *Calculate fees function is an overloaded function calculates fees for resident customer takes price of router, type of reservation
 * which is daily or weekly or monthly and extended duration.
 * @param fees price of the router.
 * @param type type of reservation which is daily or weekly or monthly.
 * @param ExtendedDuration duration entered by customer to extend auto generated due date.
 * @return returns renting fees for the customer.
 */
    public double calculatefees(double fees,String type,int ExtendedDuration){
            if (type.equals("weekly")){
            feeses=(fees*(7+ExtendedDuration))-(discount*fees*(7+ExtendedDuration));
            return feeses;
        }
            else if(type.equals("monthly")){
            feeses=(fees*(30+ExtendedDuration))-(discount*fees*(30+ExtendedDuration));
            return feeses;
        }
            feeses= (fees*(1+ExtendedDuration))-(discount*fees*(1+ExtendedDuration));
            return feeses;
    }
 /**
 *@return Final method returns discount for resident customer.
 */
    public final double getDiscount() {
        return discount;
    }
 /**
 *@return renting fees for resident customer.
 */
    public double getFeeses() {
        return feeses;
    }
 /**
 *Display function is an over ridden function from Functions interface displays data of customer.
 */
    @Override
    public void Display() {
    System.out.println("\tCustomer's Details");
    System.out.println("Name:"+getName());
    System.out.println("Phone:"+getPhone());
    
    }

}
public class RouterRental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner input=new Scanner(System.in);
         Router r1=new Router(1,"WE",5,100);
         Router r2=new Router(2,"Vodafone",6,200);
         Router r3=new Router(3,"Orange",4,300);
         Router r4=new Router(4,"Etisalate",7,400);
         ArrayList<Router> r=new ArrayList<>();
         r.add(r1);
         r.add(r2);
         r.add(r3);
         r.add(r4);
         System.out.println("\t\t\t\tAvailabe Routers");
         for (int i=0;i<r.size();i++){
             System.out.println("\t\t"+r.get(i).toString());
         }
         ArrayList<Customer> c=new ArrayList<>();
         Customer c1 = new Foreigners("Ahmed", 24095822);
         Customer c2 = new Foreigners("Omar", 25097406);
         Customer c3 = new Residents("Farah", 27098631);
         Customer c4 = new Residents("Mariam", 23074569);
         c.add(c1);
         c.add(c2);
         c.add(c3);
         c.add(c4);
         c1.RentRouter(r, c);
        }
}
