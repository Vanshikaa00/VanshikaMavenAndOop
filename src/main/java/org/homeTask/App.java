package org.homeTask;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        int i,j,chocwt,chocqt,candywt,candyqt;
        String chocname,candyname;
        App a=new App();
        System.out.println("Enter number of chocolates/candies:");
        int no=sc.nextInt();
        System.out.println("Out of candy/chocolate, which one you want to make gift box of?");
        String ch=sc.next();
        chocolate chocarr[] = new chocolate[no];
        candy candyarr[]=new candy[no];
        if(ch.equals("chocolate")){
            for(i=0;i<no;i++)
            {
                chocarr[i]=new chocolate();
                System.out.println("Enter chocolate name:");
                chocname=sc.next();
                chocarr[i].setChocolateName(chocname);
                System.out.println("Enter chocolate weight:");
                chocwt=sc.nextInt();
                chocarr[i].setWeight(chocwt);
                System.out.println("Enter chocolate quantity:");
                chocqt=sc.nextInt();
                chocarr[i].setChocquan(chocqt);
            }
        }
        else if(ch.equals("candy"))
        {
            for(i=0;i<no;i++)
            {
                candyarr[i]=new candy();
                System.out.println("Enter candy name:");
                candyname=sc.next();
                candyarr[i].setCandyName(candyname);
                System.out.println("Enter candy weight:");
                candywt=sc.nextInt();
                candyarr[i].setWeight(candywt);
                System.out.println("Enter candy quantity:");
                candyqt=sc.nextInt();
                candyarr[i].setCandyquan(candyqt);
            }
        }
        else
        {
            System.out.println("wrong value entered! try again!");
            return ;
        }
        System.out.println( "******************************* MENU **********************************" );
        System.out.println("press 1 to get total weight of the gift box\n" +
                "press 2 to sort the contents of gift\n" +
                "press 3 to find candy/chocolate in the gift corresponding to selected option\n" +
                "press 4 to exit");
        boolean exit=false;
        do {
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    if(ch.equals("chocolate")){
                        int totalwt=a.getChocolateGiftBoxWt(chocarr,no);
                        if(totalwt>=1000) {
                            int tw = totalwt / 1000;
                            int twg=totalwt%1000;
                            System.out.println("Total weight of the chocolate gift box is: " + tw+"kg "+twg+"g");
                        }else
                        {
                            System.out.println("Total weight of the chocolate gift box is: " + totalwt+"g");
                        }
                    }
                    else if(ch.equals("candy")){
                        int totalwt=a.getCandyGiftBoxWt(candyarr,no);
                        if(totalwt>=1000) {
                            int tw = totalwt / 1000;
                            int twg=totalwt%1000;
                            System.out.println("Total weight of the candy gift box is: " + tw+"kg "+twg+"g");
                        }
                        else
                        {
                            System.out.println("Total weight of the candy gift box is: " + totalwt+"g");
                        }
                    }
                    break;
                case 2:
                    if(ch.equals("chocolate"))
                    {
                        System.out.println("Enter criteria upon which you want to sort chocolates(name/quan/wt): ");
                        String sortCriteria=sc.next();
                        a.sortChocolates(sortCriteria,no,chocarr);
                    }
                    else if(ch.equals("candy"))
                    {
                        System.out.println("Enter criteria upon which you want to sort candies(name/quan/wt): ");
                        String sortCriteria=sc.next();
                        a.sortCandies(sortCriteria,no,candyarr);
                    }
                    break;
                case 3:
                    if(ch.equals("chocolate"))
                    {
                        System.out.println("Enter the criteria on which you want to find the chocolate:name/wt/quan");
                        String criteria2=sc.next();
                        a.findChocolate(chocarr,criteria2,no);
                    }
                    else if(ch.equals("candy"))
                    {
                        System.out.println("Enter the criteria on which you want to find the candy:name/wt/quan");
                        String criteria2=sc.next();
                        a.findCandy(candyarr,criteria2,no);
                    }
                    break;
                case 4:
                    exit=true;
                    break;
            }
        }while(exit!=true);
System.out.println("Program complete!");
    }

    private int getCandyGiftBoxWt(candy[] candyarr, int no) {
        int totalwt=0,i;
        int wt,q;
        for(i=0;i<no;i++)
        {
            wt=candyarr[i].getWeight();
            q=candyarr[i].getCandyquan();
            totalwt=totalwt+(wt*q);
        }
        return totalwt;
    }

    private int getChocolateGiftBoxWt(chocolate [] chocarr,int no) {
        int totalwt=0,i;
        int wt,q;
        for(i=0;i<no;i++)
        {
            wt=chocarr[i].getWeight();
            q=chocarr[i].getChocquan();
            totalwt=totalwt+(wt*q);
        }
        return totalwt;
    }

    private void findCandy(candy[] candyarr, String criteria2, int no) {
int i;
Scanner sc=new Scanner(System.in);
        if(criteria2.equals("name"))
        {
            System.out.println("Enter candy name:");
            String candyname=sc.next();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyName.equals(candyname)){
                    System.out.println("Candy "+candyname+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity in gift box is: "+candyarr[i].candyquan);
                }
            }
        }
        else if(criteria2.equals("wt")){
            System.out.println("Enter chocolate weight:");
            int candywt=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyweight==candywt){
                    System.out.println("Candy name: "+candyarr[i].candyName+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity is: "+candyarr[i].candyquan);
                }
            }
        }
        else if(criteria2.equals("quan")){
            System.out.println("Enter chocolate quan:");
            int candyqn=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(candyarr[i].candyquan==candyqn){
                    System.out.println("Candy name: "+candyarr[i].candyName+" found and it's weight is : "+candyarr[i].candyweight+" and it's quantity is: "+candyarr[i].candyquan);
                }
            }
        }
    }

    private void findChocolate(chocolate[] chocarr, String criteria2,int no) {
int i;
        Scanner sc=new Scanner(System.in);
        if(criteria2.equals("name"))
        {
            System.out.println("Enter chocolate name:");
            String choccname=sc.next();
            for(i=0;i<no;i++)
            {
                if(chocarr[i].chocolateName.equals(choccname)){
                    System.out.println("Chocolate "+choccname+" found and it's weight is : "+chocarr[i].chocweight+" and it's quantity is: "+chocarr[i].chocquan);
                }
            }
        }
        else if(criteria2.equals("wt")){
            System.out.println("Enter chocolate weight:");
            int choccwt=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(chocarr[i].chocweight==choccwt){
                    System.out.println("Chocolate name: "+chocarr[i].chocolateName+" found and it's weight is : "+chocarr[i].chocweight+" and it's quantity is: "+chocarr[i].chocquan);
                }
            }
        }
        else if(criteria2.equals("quan")){
            System.out.println("Enter chocolate quan:");
            int choccqn=sc.nextInt();
            for(i=0;i<no;i++)
            {
                if(chocarr[i].chocquan==choccqn){
                    System.out.println("Chocolate name: "+chocarr[i].chocolateName+" found and it's weight is : "+chocarr[i].chocweight+" and it's quantity is: "+chocarr[i].chocquan);
                }
            }
        }
    }

    private void sortChocolates(String sortCriteria, int no, chocolate[] chocarr) {
        int i,j;
        if(sortCriteria.equals("quan"))
        {
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(chocarr[i].chocquan>chocarr[j].chocquan)
                    {
                        int temp=chocarr[i].chocquan;
                        chocarr[i].chocquan=chocarr[j].chocquan;
                        chocarr[j].chocquan=temp;
                        String temp1=chocarr[i].chocolateName;
                        chocarr[i].chocolateName=chocarr[j].chocolateName;
                        chocarr[j].chocolateName=temp1;
                        int temp2=chocarr[i].chocweight;
                        chocarr[i].chocweight=chocarr[j].chocweight;
                        chocarr[j].chocweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF QUANTITY!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+chocarr[i].chocolateName+" , QUANTITY: "+chocarr[i].chocquan+" WEIGHT: "+chocarr[i].chocweight);
            }
        }
        else if(sortCriteria.equals("wt")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(chocarr[i].chocweight>chocarr[j].chocweight)
                    {
                        int temp=chocarr[i].chocquan;
                        chocarr[i].chocquan=chocarr[j].chocquan;
                        chocarr[j].chocquan=temp;
                        String temp1=chocarr[i].chocolateName;
                        chocarr[i].chocolateName=chocarr[j].chocolateName;
                        chocarr[j].chocolateName=temp1;
                        int temp2=chocarr[i].chocweight;
                        chocarr[i].chocweight=chocarr[j].chocweight;
                        chocarr[j].chocweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF WEIGHT!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+chocarr[i].chocolateName+" , QUANTITY: "+chocarr[i].chocquan+" WEIGHT: "+chocarr[i].chocweight);
            }
        }
        else if(sortCriteria.equals("name")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    String s1=chocarr[i].chocolateName;
                    String s2=chocarr[j].chocolateName;
                    if(s1.compareTo(s2)>0)
                    {
                        int temp=chocarr[i].chocquan;
                        chocarr[i].chocquan=chocarr[j].chocquan;
                        chocarr[j].chocquan=temp;
                        String temp1=chocarr[i].chocolateName;
                        chocarr[i].chocolateName=chocarr[j].chocolateName;
                        chocarr[j].chocolateName=temp1;
                        int temp2=chocarr[i].chocweight;
                        chocarr[i].chocweight=chocarr[j].chocweight;
                        chocarr[j].chocweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF NAMES!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+chocarr[i].chocolateName+" , QUANTITY: "+chocarr[i].chocquan+" WEIGHT: "+chocarr[i].chocweight);
            }
        }
    }

    private void sortCandies(String sortCriteria, int no, candy[] candyarr) {
        int i,j;
        if(sortCriteria.equals("quan"))
        {
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(candyarr[i].candyquan>candyarr[j].candyquan)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF QUANTITY!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
        else if(sortCriteria.equals("wt")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    if(candyarr[i].candyweight>candyarr[j].candyweight)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF WEIGHT!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
        else if(sortCriteria.equals("name")){
            for(i=0;i<no;i++)
            {
                for(j=i+1;j<no;j++)
                {
                    String s1=candyarr[i].candyName;
                    String s2=candyarr[j].candyName;
                    if(s1.compareTo(s2)>0)
                    {
                        int temp=candyarr[i].candyquan;
                        candyarr[i].candyquan=candyarr[j].candyquan;
                        candyarr[j].candyquan=temp;
                        String temp1=candyarr[i].candyName;
                        candyarr[i].candyName=candyarr[j].candyName;
                        candyarr[j].candyName=temp1;
                        int temp2=candyarr[i].candyweight;
                        candyarr[i].candyweight=candyarr[j].candyweight;
                        candyarr[j].candyweight=temp2;
                    }
                }
            }
            System.out.println("!!SORTED ON THE BASIS OF NAMES!!");
            for(i=0;i<no;i++)
            {
                System.out.println("NAME: "+candyarr[i].candyName+" , QUANTITY: "+candyarr[i].candyquan+" WEIGHT: "+candyarr[i].candyweight);
            }
        }
    }

}
