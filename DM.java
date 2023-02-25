import java.util.Scanner;

public class DM {
    public static int displayMenu(Scanner input) {
        System.out.println("\n" + "MOTORPH PAYROLL SYSTEM");
        System.out.println(",______________________________,");
        System.out.printf( "| 1) EMPLOYEE RECORD           |\n", " ");
        System.out.printf( "| 2) TIMEKEEPING               |\n", " ");
        System.out.printf( "| 3) PAYROLL COMPUTATION       |\n", " ");
        System.out.printf( "| 4) LOGOUT                    |\n", " ");
        System.out.println("|______________________________|");
        System.out.print("Enter Selection: ");
        return input.nextInt();
    }

    //Presents the individual Employee Records using a filereader and scanner to read 2 text files:
    //One showing Employee profile and another one for compensation packages of each employee.
    public static int emprec() {
        Scanner input = new Scanner(System.in);
        System.out.println(",__________________________,");
        System.out.printf("|VIEW EMPLOYEE RECORD      |\n", " ");
        System.out.printf("|   1-Employee Profile     |\n", " ");
        System.out.printf("|   2-Compensation Package |\n", " ");
        System.out.printf("|   3-Back                 |\n", " ");
        System.out.println("|__________________________|");
        System.out.print("Enter Selection: ");
        return input.nextInt();
    }

    //Timekeeping summary includes the total hours worked per day, OT hours, and Late/Asence/UT hours for the week.
    // (Individually presented per week and a gross total report of all the weeks).
    public static int timekeeping() {
        Scanner input = new Scanner(System.in);
        System.out.println(",_________________________,");
        System.out.printf( "|GENERATE TIME RECORD     |\n", " ");
        System.out.printf( "|    1-Week # 1 Timelogs  |\n", " ");
        System.out.printf( "|    2-Week # 2 Timelogs  |\n", " ");
        System.out.printf( "|    3-Week # 3 Timelogs  |\n", " ");
        System.out.printf( "|    4-Week # 4 Timelogs  |\n", " ");
        System.out.printf( "|    5-Total Timelogs     |\n", " ");
        System.out.printf( "|    6-Back               |\n", " ");
        System.out.println("|_________________________|");
        System.out.print("Enter Selection: ");
        return input.nextInt();
    }


    //Payroll summary includes the computation of gross earnings, total deductions, and net pay
    // (Individually computed per week and a gross total report of all the weeks).
    public static int payrollCOMPU() {
        Scanner input = new Scanner(System.in);
        System.out.println(",_________________________________,");
        System.out.printf( "|GENERATE PAYROLL SUMMARY         |\n", " ");
        System.out.printf( "|    1-Week # 1 Computation       |\n", " ");
        System.out.printf( "|    2-Week # 2 Computation       |\n", " ");
        System.out.printf( "|    3-Week # 3 Computation       |\n", " ");
        System.out.printf( "|    4-Week # 4 Computation       |\n", " ");
        System.out.printf( "|    5-Total Payroll Computation  |\n", " ");
        System.out.printf( "|    6-Back                       |\n", " ");
        System.out.println("|_________________________________|");
        System.out.print("Enter Selection: ");
        return input.nextInt();
    }

}
