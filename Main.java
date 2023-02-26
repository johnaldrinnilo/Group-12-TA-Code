import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.File;
public class Main {
       public static void main(String[] args) throws IOException {

           //File file = new File("TimeLogsAllTotal.txt");
           //file.createNewFile();

//Login for the Payroll System
        System.out.println("MotorPH Payroll System"+"\n");
        Scanner input = new Scanner(System.in);
        String CorpCode="", UserName="", Password="";
        int retry = 3;
        while (retry>0){
            Scanner x = new Scanner(System.in);
            System.out.print("Corporate Code: ");
            CorpCode = x.nextLine();
            System.out.print("User Name: ");
            UserName = x.nextLine();
            System.out.print("Password: ");
            Password = x.nextLine();
            System.out.print("\n");
            if (CorpCode.equals("motorph143") && UserName.equals("Admin") && Password.equals("mmdc"))
                break;
            else
                System.out.println("You have entered an incorrect credential...");
            retry--;}

        if (retry>0){
            System.out.print("\n" + "Welcome " + UserName + "! Please select a value from the Display Menu:" + "\n");

        //TO DISPLAY MAIN MENU
            int mainmenu=0;
            do {
              mainmenu = DM.displayMenu(input);
                switch (mainmenu) {

                    case 1://EMPLOYEE RECORDS
                        int EmpRec=0;
                        do{
                        EmpRec=DM.emprec();
                        switch(EmpRec) {
                            case 1://Employee Profile
                                FileReader fremp = new FileReader("Emp-Profile.txt");
                                Scanner infileemp = new Scanner (fremp);
                                while(infileemp.hasNextLine()) {
                                    String line=infileemp.nextLine();
                                    System.out.println(line);}
                                infileemp.close();
                            break;

                            case 2://Employee Compensation Packages
                                double hr, bp, rs, pa, ca, smr;
                                int empno;
                                String name;
                                FileReader freader = new FileReader("Emp-Compensation.txt");
                                Scanner inFileee = new Scanner(freader);

                                PrintWriter outFile = new PrintWriter("Emp-Output.txt");
                                while (inFileee.hasNext())
                                {
                                    name = inFileee.next(); empno = inFileee.nextInt(); hr = inFileee.nextDouble();bp = inFileee.nextDouble();rs = inFileee.nextDouble();pa = inFileee.nextDouble();ca = inFileee.nextDouble();smr = inFileee.nextDouble();
                                    outFile.println("\n"+"COMPENSATION PACKAGE");
                                    outFile.println("Employee Name: " + name);
                                    outFile.println("Employee Number: " + empno);
                                    outFile.printf("Compensation Breakdown " +
                                            "%n     Hourly Rate: Php %,1.2f " +
                                            "%n     Basic Salary: Php %,1.2f " +
                                            "%n     Rice Subsidy: Php %,1.2f " +
                                            "%n     Phone Allowance: Php %,1.2f " +
                                            "%n     Clothing Allowance: Php %,1.2f " +
                                            "%n     Gross Semi-monthly Rate: Php %,1.2f %n", hr, bp, rs, pa,ca,smr);}
                                inFileee.close();
                                outFile.close();
                                FileReader fremp1 = new FileReader("Emp-Output.txt");
                                Scanner infile1 = new Scanner (fremp1);
                                while(infile1.hasNextLine()) {
                                    String line=infile1.nextLine();
                                    System.out.println(line);}
                                infile1.close();
                                break;
                            case 3:
                                break;
                            default:
                                System.out.print("Error! Please enter a valid option!");
                                break;
                            }
                        } while (EmpRec!=3);
                        break;

                    case 2://TIMEKEEPING
                        int timekeeping = 0;
                        double w1d1, w1d2, w1d3, w1d4, w1d5, w1d6, w1d7; //Week#1
                        double w2d1, w2d2, w2d3, w2d4, w2d5, w2d6, w2d7; //Week#2
                        double w3d1, w3d2, w3d3, w3d4, w3d5, w3d6, w3d7; //Week#3
                        double w4d1, w4d2, w4d3, w4d4, w4d5, w4d6, w4d7; //Week#4
                        double w1TH = 0.00, w2TH=0.00, w3TH=0.00, w4TH=0.00;
                        String name, name2;
                        int EmpNo, EmpNo2;
                        do {
                            timekeeping=DM.timekeeping();
                            switch (timekeeping){
                                case 1: //Timekeeping-WEEK # 1
                                FileReader freader = new FileReader("TimelogsAll.txt");
                                Scanner inFile = new Scanner(freader);
                                PrintWriter outFile = new PrintWriter("TimelogsOutput.txt");

                                while (inFile.hasNext()){
                                    name = inFile.next(); EmpNo=inFile.nextInt();
                                    outFile.println("\n"+"TIMEKEEPING");
                                    outFile.println("September 1 to 7, 2022");
                                    outFile.println("Employee Name: " + name);
                                    outFile.println("Employee Number: " + EmpNo);

                                    w1d1 = inFile.nextDouble();w1d2 = inFile.nextDouble();w1d3 = inFile.nextDouble();w1d4 = inFile.nextDouble();w1d5 = inFile.nextDouble();w1d6 = inFile.nextDouble();w1d7 = inFile.nextDouble();
                                    w2d1 = inFile.nextDouble();w2d2 = inFile.nextDouble();w2d3 = inFile.nextDouble();w2d4 = inFile.nextDouble();w2d5 = inFile.nextDouble();w2d6 = inFile.nextDouble();w2d7 = inFile.nextDouble();
                                    w3d1 = inFile.nextDouble();w3d2 = inFile.nextDouble();w3d3 = inFile.nextDouble();w3d4 = inFile.nextDouble();w3d5 = inFile.nextDouble();w3d6 = inFile.nextDouble();w3d7 = inFile.nextDouble();
                                    w4d1 = inFile.nextDouble();w4d2 = inFile.nextDouble();w4d3 = inFile.nextDouble();w4d4 = inFile.nextDouble();w4d5 = inFile.nextDouble();w4d6 = inFile.nextDouble();w4d7 = inFile.nextDouble();

                                    outFile.printf("Hours Worked: " +
                                        "%n         Sept 1,22         %1.2f " +
                                        "%n         Sept 2,22         %1.2f " +
                                        "%n         Sept 3,22         %1.2f " +
                                        "%n         Sept 4,22         %1.2f " +
                                        "%n         Sept 5,22         %1.2f " +
                                        "%n         Sept 6,22         %1.2f " +
                                        "%n         Sept 7,22         %1.2f %n", w1d1, w1d2, w1d3, w1d4,w1d5,w1d6,w1d7);
                                    w1TH = (w1d1+w1d2+w1d3+w1d4+w1d5+w1d6+w1d7);
                                    //for computation of hours worked
                                    whours.TAH=w1TH;

                                    outFile.printf("Total Hours Worked:       %1.2f %n", w1TH);
                                    outFile.printf("Regular Working Hours:    %1.2f %n", whours.RWH);
                                    outFile.printf("Overtime Hours Worked:     %1.2f %n", whours.OTHours());
                                    outFile.printf("Absence/Late/UT Hours:     %1.2f %n",  whours.LateUTHours());
                                    outFile.println();
                                    outFile.println("***** Captured via a Biometric Recognition System. *****");
                                    outFile.println();}
                                inFile.close();
                                outFile.close();
                                FileReader fr = new FileReader("TimelogsOutput.txt");
                                Scanner infile = new Scanner (fr);
                                while(infile.hasNextLine()) {
                                    String line=infile.nextLine();
                                    System.out.println(line);}
                                infile.close();
                                break;

                                case 2://Timekeeping-WEEK # 2
                                FileReader freader1 = new FileReader("TimelogsAll.txt");
                                Scanner inFile1 = new Scanner(freader1);
                                PrintWriter outFile1 = new PrintWriter("TimelogsOutput.txt");

                                    while (inFile1.hasNext()){
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile1.println("\n"+"TIMEKEEPING");
                                        outFile1.println("September 8 to 14, 2022");
                                        outFile1.println("Employee Name: " + name);
                                        outFile1.println("Employee Number: " + EmpNo);

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        outFile1.printf("Hours Worked: " +
                                                "%n        Sept  8,22         %1.2f " +
                                                "%n        Sept  9,22         %1.2f " +
                                                "%n        Sept 10,22         %1.2f " +
                                                "%n        Sept 11,22         %1.2f " +
                                                "%n        Sept 12,22         %1.2f " +
                                                "%n        Sept 13,22         %1.2f " +
                                                "%n        Sept 14,22         %1.2f %n", w2d1, w2d2, w2d3, w2d4,w2d5,w2d6,w2d7);
                                        w2TH = (w2d1+w2d2+w2d3+w2d4+w2d5+w2d6+w2d7);
                                        //for computation of hours worked
                                        whours.TAH=w2TH;

                                        outFile1.printf("Total Hours Worked:       %1.2f %n", w2TH);
                                        outFile1.printf("Regular Working Hours:    %1.2f %n", whours.RWH);
                                        outFile1.printf("Overtime Hours Worked:     %1.2f %n", whours.OTHours());
                                        outFile1.printf("Absence/Late/UT Hours:     %1.2f %n",  whours.LateUTHours());
                                        outFile1.println();
                                        outFile1.println("***** Captured via a Biometric Recognition System. *****");
                                        outFile1.println();}
                                    inFile1.close();
                                    outFile1.close();
                                    FileReader fr1 = new FileReader("TimelogsOutput.txt");
                                    Scanner infile1 = new Scanner (fr1);
                                    while(infile1.hasNextLine()) {
                                        String line=infile1.nextLine();
                                        System.out.println(line);}
                                    infile1.close();
                                    break;

                                case 3://Timekeeping-WEEK # 3
                                    freader1 = new FileReader("TimelogsAll.txt");
                                    inFile1 = new Scanner(freader1);
                                    outFile1 = new PrintWriter("TimelogsOutput.txt");

                                    while (inFile1.hasNext()){
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile1.println("\n"+"TIMEKEEPING");
                                        outFile1.println("September 15 to 21, 2022");
                                        outFile1.println("Employee Name: " + name);
                                        outFile1.println("Employee Number: " + EmpNo);

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        outFile1.printf("Hours Worked: " +
                                                "%n        Sept 15,22         %1.2f " +
                                                "%n        Sept 16,22         %1.2f " +
                                                "%n        Sept 17,22         %1.2f " +
                                                "%n        Sept 18,22         %1.2f " +
                                                "%n        Sept 19,22         %1.2f " +
                                                "%n        Sept 20,22         %1.2f " +
                                                "%n        Sept 21,22         %1.2f %n", w3d1, w3d2, w3d3, w3d4,w3d5,w3d6,w3d7);
                                        w3TH = (w3d1+w3d2+w3d3+w3d4+w3d5+w3d6+w3d7);
                                        //for computation of hours worked
                                        whours.TAH=w3TH;

                                        outFile1.printf("Total Hours Worked:       %1.2f %n", w3TH);
                                        outFile1.printf("Regular Working Hours:    %1.2f %n", whours.RWH);
                                        outFile1.printf("Overtime Hours Worked:     %1.2f %n", whours.OTHours());
                                        outFile1.printf("Absence/Late/UT Hours:     %1.2f %n",  whours.LateUTHours());
                                        outFile1.println();
                                        outFile1.println("***** Captured via a Biometric Recognition System. *****");
                                        outFile1.println();}
                                    inFile1.close();
                                    outFile1.close();
                                    fr1 = new FileReader("TimelogsOutput.txt");
                                    infile1 = new Scanner(fr1);
                                    while(infile1.hasNextLine()) {
                                        String line=infile1.nextLine();
                                        System.out.println(line);}
                                    infile1.close();
                                    break;

                                case 4://Timekeeping WEEK # 4
                                    freader1 = new FileReader("TimelogsAll.txt");
                                    inFile1 = new Scanner(freader1);
                                    outFile1 = new PrintWriter("TimelogsOutput.txt");

                                    while (inFile1.hasNext()){
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile1.println("\n"+"TIMEKEEPING");
                                        outFile1.println("September 22 to 28, 2022");
                                        outFile1.println("Employee Name: " + name);
                                        outFile1.println("Employee Number: " + EmpNo);

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        outFile1.printf("Hours Worked: " +
                                                "%n        Sept 22,22         %1.2f " +
                                                "%n        Sept 23,22         %1.2f " +
                                                "%n        Sept 24,22         %1.2f " +
                                                "%n        Sept 25,22         %1.2f " +
                                                "%n        Sept 26,22         %1.2f " +
                                                "%n        Sept 27,22         %1.2f " +
                                                "%n        Sept 28,22         %1.2f %n", w4d1, w4d2, w4d3, w4d4,w4d5,w4d6,w4d7);
                                        w4TH = (w4d1+w4d2+w4d3+w4d4+w4d5+w4d6+w4d7);
                                        //for computation of hours worked
                                        whours.TAH=w4TH;

                                        outFile1.printf("Total Hours Worked:       %1.2f %n", w4TH);
                                        outFile1.printf("Regular Working Hours:    %1.2f %n", whours.RWH);
                                        outFile1.printf("Overtime Hours Worked:     %1.2f %n", whours.OTHours());
                                        outFile1.printf("Absence/Late/UT Hours:     %1.2f %n",  whours.LateUTHours());
                                        outFile1.println();
                                        outFile1.println("***** Captured via a Biometric Recognition System. *****");
                                        outFile1.println();}
                                    inFile1.close();
                                    outFile1.close();
                                    fr1 = new FileReader("TimelogsOutput.txt");
                                    infile1 = new Scanner(fr1);
                                    while(infile1.hasNextLine()) {
                                        String line=infile1.nextLine();
                                        System.out.println(line);}
                                    infile1.close();
                                    break;

                                case 5://Timekeeping Total
                                    freader1 = new FileReader("TimelogsAllTotal.txt");
                                    inFile1 = new Scanner(freader1);
                                    outFile1 = new PrintWriter("TimelogsOutput.txt");

                                    while (inFile1.hasNext()){
                                        outFile1.println("\n"+"TIMEKEEPING");
                                        outFile1.println("Weekly Employee Logs");

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                       outFile1.printf("%nWeek # 1 - Hours Worked: " +
                                                "%n        Sept 1,22            %1.2f " +
                                                "%n        Sept 2,22             %1.2f " +
                                                "%n        Sept 3,22            %1.2f " +
                                                "%n        Sept 4,22            %1.2f " +
                                                "%n        Sept 5,22            %1.2f " +
                                                "%n        Sept 6,22            %1.2f " +
                                                "%n        Sept 7,22            %1.2f %n", w1d1, w1d2, w1d3, w1d4,w1d5,w1d6,w1d7);
                                        w1TH = (w1d1+w1d2+w1d3+w1d4+w1d5+w1d6+w1d7);
                                        outFile1.printf("        Total for the Week  %1.2f %n",w1TH);
                                        outFile1.printf("%nWeek # 2 - Hours Worked: " +
                                                "%n        Sept  8,22           %1.2f " +
                                                "%n        Sept  9,22            %1.2f " +
                                                "%n        Sept 10,22           %1.2f " +
                                                "%n        Sept 11,22           %1.2f " +
                                                "%n        Sept 12,22           %1.2f " +
                                                "%n        Sept 13,22           %1.2f " +
                                                "%n        Sept 14,22           %1.2f %n", w2d1, w2d2, w2d3, w2d4,w2d5,w2d6,w2d7);
                                        w2TH = (w2d1+w2d2+w2d3+w2d4+w2d5+w2d6+w2d7);
                                        outFile1.printf("        Total for the Week  %1.2f %n",w2TH);
                                        outFile1.printf("%nWeek # 3 - Hours Worked: " +
                                                "%n        Sept 15,22           %1.2f " +
                                                "%n        Sept 16,22            %1.2f " +
                                                "%n        Sept 17,22           %1.2f " +
                                                "%n        Sept 18,22           %1.2f " +
                                                "%n        Sept 19,22           %1.2f " +
                                                "%n        Sept 20,22           %1.2f " +
                                                "%n        Sept 21,22           %1.2f %n", w3d1, w3d2, w3d3, w3d4,w3d5,w3d6,w3d7);
                                        w3TH = (w3d1+w3d2+w3d3+w3d4+w3d5+w3d6+w3d7);
                                        outFile1.printf("        Total for the Week  %1.2f %n",w3TH);
                                        outFile1.printf("%nWeek # 4 - Hours Worked: " +
                                                "%n        Sept 22,22           %1.2f " +
                                                "%n        Sept 23,22            %1.2f " +
                                                "%n        Sept 24,22           %1.2f " +
                                                "%n        Sept 25,22           %1.2f " +
                                                "%n        Sept 26,22           %1.2f " +
                                                "%n        Sept 27,22           %1.2f " +
                                                "%n        Sept 28,22           %1.2f %n", w4d1, w4d2, w4d3, w4d4,w4d5,w4d6,w4d7);
                                        w4TH = (w4d1+w4d2+w4d3+w4d4+w4d5+w4d6+w4d7);
                                        outFile1.printf("        Total for the Week  %1.2f %n",w4TH);

                                        double wTotals=(w1TH+w2TH+w4TH+w3TH);

                                        outFile1.printf("%nTotal Hours Worked:       %,1.2f %n",wTotals );
                                        outFile1.printf("Regular Working Hours:    %,1.2f %n", whours.RWH*10*4);
                                        outFile1.printf("Overtime Hours Worked:        %1.2f %n", 6.00);
                                        outFile1.printf("Absence/Late/UT Hours:        %1.2f %n", 8.00);
                                        outFile1.println();
                                        outFile1.println("***** Captured via a Biometric Recognition System. *****");
                                        outFile1.println();}
                                    inFile1.close();
                                    outFile1.close();
                                    fr1 = new FileReader("TimelogsOutput.txt");
                                    infile1 = new Scanner(fr1);
                                    while(infile1.hasNextLine()) {
                                        String line=infile1.nextLine();
                                        System.out.println(line);}
                                    infile1.close();
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.print("Error! Please enter a valid option!");
                                    break;
                            }
                            }while(timekeeping!=6);
                        break;

                    case 3: //PAYROLL COMPUTATION
                        int payroll = 0;
                        do {
                            payroll=DM.payrollCOMPU();
                            switch (payroll){
                                case 1://Week # 1-PayrollComputation

                                    FileReader filereader = new FileReader("TimelogsAll.txt");
                                    Scanner inFile1 = new Scanner(filereader);
                                    PrintWriter outFile = new PrintWriter("PayrollOutputs.txt");
                                    FileReader freader = new FileReader("Emp-Compensation.txt");
                                    Scanner inFile = new Scanner(freader);

                                    while (inFile.hasNext() && inFile1.hasNext()) {
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile.println("WEEKLY SALARY COMPUTATION");
                                        outFile.println("Covered Period: September 1 to 7, 2022");
                                        outFile.println("Employee Name: "+name);
                                        outFile.println("Employee Name: "+EmpNo+"\n");

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        name2=inFile.next();
                                        EmpNo2=inFile.nextInt();
                                        double hourlyrate = inFile.nextDouble();
                                        double mbs = inFile.nextDouble();
                                        double rice = (inFile.nextDouble()/4.00);
                                        double phone = (inFile.nextDouble()/4.00);
                                        double clothing = (inFile.nextDouble()/4.00);
                                        double semimonhtly = (inFile.nextDouble()/2.00);

                                        //Compensation basis for the contributions
                                        deds.mbs= mbs;
                                        w1TH=w1d1+w1d2+w1d3+w1d4+w1d5+w1d6+w1d7;
                                        whours.TAH=w1TH;

                                        double WBPay = (whours.reghours()*hourlyrate);
                                        double OTPay=(hourlyrate* whours.OTHours()*whours.regOTRate());
                                        double totalearnings=(WBPay+rice+phone+clothing+OTPay);

                                        //computation basis for weekly witholding tax
                                        double tbase=totalearnings-(deds.sss()+ deds.ph()+ deds.hdmf());
                                        deds.taxablebase=tbase;

                                        double totalded=(deds.wtax()+ deds.sss()+ deds.ph()+ deds.hdmf());
                                        double netpay=(totalearnings-totalded);

                                        outFile.println("Employee and Log Details");
                                        outFile.printf("   Total Hours Worked for the Week:  %,1.2f Hours %n", w1TH);
                                        outFile.printf("   OT Hours Worked for the Week:     %,1.2f Hours %n", whours.OTHours());
                                        outFile.printf("   Rate per Hour:                Php %,1.2f %n", hourlyrate);
                                        outFile.println("Gross Wage");
                                        outFile.printf("   Basic Pay for the Week:       Php %,1.2f %n", WBPay);
                                        outFile.printf("   Rice Subsidy:                 Php %,1.2f %n", rice);
                                        outFile.printf("   Phone Allowance:              Php %,1.2f %n", phone);
                                        outFile.printf("   Clothing Allowance:           Php %,1.2f %n", clothing);
                                        outFile.printf("   Overtime Pay:                 Php %,1.2f %n", OTPay);
                                        outFile.printf("   Total Earnings:               Php %,1.2f %n", totalearnings);
                                        outFile.println("Deductions");
                                        outFile.printf("   Withholding Tax:              Php %,1.2f %n", deds.wtax());
                                        outFile.printf("   SSS Contribution:             Php %,1.2f %n", deds.sss());
                                        outFile.printf("   PHIC Contribution:            Php %,1.2f %n", deds.ph());
                                        outFile.printf("   HDMF Contribution:            Php %,1.2f %n", deds.hdmf());
                                        outFile.printf("   Total Deductions:             Php %,1.2f %n", totalded);
                                        outFile.printf("Net Wage for the Week            Php %,1.2f %n", netpay);
                                        outFile.println();
                                        outFile.println("Prepared by:                  Verified by:                 Approved by:" +"\n"+
                                                        "\n"+
                                                        "Joward Dahryll Malabja        John Aldrin P. Nilo          Joanne Cristine Franco"+"\n"+
                                                        "*****  This is a computer-generated document. No signature is required. *****");
                                        outFile.println();}
                                    inFile.close();
                                    inFile1.close();
                                    outFile.close();
                                    FileReader fr = new FileReader("PayrollOutputs.txt");
                                    Scanner infile = new Scanner (fr);
                                    while(infile.hasNextLine()) {
                                        String line=infile.nextLine();
                                        System.out.println(line);}
                                    infile.close();
                                    break;

                                case 2://Week # 2-PayrollComputation
                                    filereader = new FileReader("TimelogsAll.txt");
                                    inFile1 = new Scanner(filereader);
                                    outFile = new PrintWriter("PayrollOutputs.txt");
                                    freader = new FileReader("Emp-Compensation.txt");
                                    inFile = new Scanner(freader);

                                    while (inFile.hasNext() && inFile1.hasNext()) {
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile.println("WEEKLY SALARY COMPUTATION");
                                        outFile.println("September 8 to 14, 2022");
                                        outFile.println("Employee Name: "+name);
                                        outFile.println("Employee Name: "+EmpNo+"\n");

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        name2=inFile.next();
                                        EmpNo2=inFile.nextInt();
                                        double hourlyrate = inFile.nextDouble();
                                        double mbs = inFile.nextDouble();
                                        double rice = (inFile.nextDouble()/4.00);
                                        double phone = (inFile.nextDouble()/4.00);
                                        double clothing = (inFile.nextDouble()/4.00);
                                        double semimonhtly = (inFile.nextDouble()/2.00);

                                        //Compensation basis for the contributions
                                        deds.mbs= mbs;
                                        w2TH=w2d1+w2d2+w2d3+w2d4+w2d5+w2d6+w2d7;
                                        whours.TAH=w2TH;

                                        double WBPay = (whours.reghours()*hourlyrate);
                                        double OTPay=(hourlyrate* whours.OTHours()*whours.regOTRate());
                                        double totalearnings=(WBPay+rice+phone+clothing+OTPay);

                                        //computation basis for weekly witholding tax
                                        double tbase=totalearnings-(deds.sss()+ deds.ph()+ deds.hdmf());
                                        deds.taxablebase=tbase;

                                        double totalded=(deds.wtax()+ deds.sss()+ deds.ph()+ deds.hdmf());
                                        double netpay=(totalearnings-totalded);

                                        outFile.println("Employee and Log Details");
                                        outFile.printf("   Total Hours Worked for the Week:  %,1.2f Hours %n", w2TH);
                                        outFile.printf("   OT Hours Worked for the Week:     %,1.2f Hours %n", whours.OTHours());
                                        outFile.printf("   Rate per Hour:                Php %,1.2f %n", hourlyrate);
                                        outFile.println("Gross Wage");
                                        outFile.printf("   Basic Pay for the Week:       Php %,1.2f %n", WBPay);
                                        outFile.printf("   Rice Subsidy:                 Php %,1.2f %n", rice);
                                        outFile.printf("   Phone Allowance:              Php %,1.2f %n", phone);
                                        outFile.printf("   Clothing Allowance:           Php %,1.2f %n", clothing);
                                        outFile.printf("   Overtime Pay:                 Php %,1.2f %n", OTPay);
                                        outFile.printf("   Total Earnings:               Php %,1.2f %n", totalearnings);
                                        outFile.println("Deductions");
                                        outFile.printf("   Withholding Tax:              Php %,1.2f %n", deds.wtax());
                                        outFile.printf("   SSS Contribution:             Php %,1.2f %n", deds.sss());
                                        outFile.printf("   PHIC Contribution:            Php %,1.2f %n", deds.ph());
                                        outFile.printf("   HDMF Contribution:            Php %,1.2f %n", deds.hdmf());
                                        outFile.printf("   Total Deductions:             Php %,1.2f %n", totalded);
                                        outFile.printf("Net Wage for the Week            Php %,1.2f %n", netpay);
                                        outFile.println();
                                        outFile.println("Prepared by:                  Verified by:                 Approved by:" +"\n"+
                                                "\n"+
                                                "Joward Dahryll Malabja        John Aldrin P. Nilo          Joanne Cristine Franco"+"\n"+
                                                "*****  This is a computer-generated document. No signature is required. *****");
                                        outFile.println();}
                                    inFile.close();
                                    inFile1.close();
                                    outFile.close();

                                    fr = new FileReader("PayrollOutputs.txt");
                                    infile = new Scanner(fr);
                                    while(infile.hasNextLine()) {
                                        String line=infile.nextLine();
                                        System.out.println(line);}
                                    infile.close();
                                    break;

                                case 3://Week # 3-PayrollComputation
                                    filereader = new FileReader("TimelogsAll.txt");
                                    inFile1 = new Scanner(filereader);
                                    outFile = new PrintWriter("PayrollOutputs.txt");
                                    freader = new FileReader("Emp-Compensation.txt");
                                    inFile = new Scanner(freader);

                                    while (inFile.hasNext() && inFile1.hasNext()) {
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile.println("WEEKLY SALARY COMPUTATION");
                                        outFile.println("September 15 to 21, 2022");
                                        outFile.println("Employee Name: "+name);
                                        outFile.println("Employee Name: "+EmpNo+"\n");

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        name2=inFile.next();
                                        EmpNo2=inFile.nextInt();
                                        double hourlyrate = inFile.nextDouble();
                                        double mbs = inFile.nextDouble();
                                        double rice = (inFile.nextDouble()/4.00);
                                        double phone = (inFile.nextDouble()/4.00);
                                        double clothing = (inFile.nextDouble()/4.00);
                                        double semimonhtly = (inFile.nextDouble()/2.00);

                                        //Compensation basis for the contributions
                                        deds.mbs= mbs;
                                        w3TH=w3d1+w3d2+w3d3+w3d4+w3d5+w3d6+w3d7;
                                        whours.TAH=w3TH;

                                        double WBPay = (whours.reghours()*hourlyrate);
                                        double OTPay=(hourlyrate* whours.OTHours()*whours.regOTRate());
                                        double totalearnings=(WBPay+rice+phone+clothing+OTPay);

                                        //computation basis for weekly witholding tax
                                        double tbase=totalearnings-(deds.sss()+ deds.ph()+ deds.hdmf());
                                        deds.taxablebase=tbase;

                                        double totalded=(deds.wtax()+ deds.sss()+ deds.ph()+ deds.hdmf());
                                        double netpay=(totalearnings-totalded);

                                        outFile.println("Employee and Log Details");
                                        outFile.printf("   Total Hours Worked for the Week:  %,1.2f Hours %n", w3TH);
                                        outFile.printf("   OT Hours Worked for the Week:     %,1.2f Hours %n", whours.OTHours());
                                        outFile.printf("   Rate per Hour:                Php %,1.2f %n", hourlyrate);
                                        outFile.println("Gross Wage");
                                        outFile.printf("   Basic Pay for the Week:       Php %,1.2f %n", WBPay);
                                        outFile.printf("   Rice Subsidy:                 Php %,1.2f %n", rice);
                                        outFile.printf("   Phone Allowance:              Php %,1.2f %n", phone);
                                        outFile.printf("   Clothing Allowance:           Php %,1.2f %n", clothing);
                                        outFile.printf("   Overtime Pay:                 Php %,1.2f %n", OTPay);
                                        outFile.printf("   Total Earnings:               Php %,1.2f %n", totalearnings);
                                        outFile.println("Deductions");
                                        outFile.printf("   Withholding Tax:              Php %,1.2f %n", deds.wtax());
                                        outFile.printf("   SSS Contribution:             Php %,1.2f %n", deds.sss());
                                        outFile.printf("   PHIC Contribution:            Php %,1.2f %n", deds.ph());
                                        outFile.printf("   HDMF Contribution:            Php %,1.2f %n", deds.hdmf());
                                        outFile.printf("   Total Deductions:             Php %,1.2f %n", totalded);
                                        outFile.printf("Net Wage for the Week            Php %,1.2f %n", netpay);
                                        outFile.println();
                                        outFile.println("Prepared by:                  Verified by:                 Approved by:" +"\n"+
                                                "\n"+
                                                "Joward Dahryll Malabja        John Aldrin P. Nilo          Joanne Cristine Franco"+"\n"+
                                                "*****  This is a computer-generated document. No signature is required. *****");
                                        outFile.println();}
                                    inFile.close();
                                    inFile1.close();
                                    outFile.close();

                                    fr = new FileReader("PayrollOutputs.txt");
                                    infile = new Scanner(fr);
                                    while(infile.hasNextLine()) {
                                        String line=infile.nextLine();
                                        System.out.println(line);}
                                    infile.close();
                                    break;

                                case 4://Week # 4-PayrollComputation
                                    filereader = new FileReader("TimelogsAll.txt");
                                    inFile1 = new Scanner(filereader);
                                    outFile = new PrintWriter("PayrollOutputs.txt");
                                    freader = new FileReader("Emp-Compensation.txt");
                                    inFile = new Scanner(freader);

                                    while (inFile.hasNext() && inFile1.hasNext()) {
                                        name = inFile1.next(); EmpNo=inFile1.nextInt();
                                        outFile.println("WEEKLY SALARY COMPUTATION");
                                        outFile.println("September 22 to 28, 2022");
                                        outFile.println("Employee Name: "+name);
                                        outFile.println("Employee Name: "+EmpNo+"\n");

                                        w1d1 = inFile1.nextDouble();w1d2 = inFile1.nextDouble();w1d3 = inFile1.nextDouble();w1d4 = inFile1.nextDouble();w1d5 = inFile1.nextDouble();w1d6 = inFile1.nextDouble();w1d7 = inFile1.nextDouble();
                                        w2d1 = inFile1.nextDouble();w2d2 = inFile1.nextDouble();w2d3 = inFile1.nextDouble();w2d4 = inFile1.nextDouble();w2d5 = inFile1.nextDouble();w2d6 = inFile1.nextDouble();w2d7 = inFile1.nextDouble();
                                        w3d1 = inFile1.nextDouble();w3d2 = inFile1.nextDouble();w3d3 = inFile1.nextDouble();w3d4 = inFile1.nextDouble();w3d5 = inFile1.nextDouble();w3d6 = inFile1.nextDouble();w3d7 = inFile1.nextDouble();
                                        w4d1 = inFile1.nextDouble();w4d2 = inFile1.nextDouble();w4d3 = inFile1.nextDouble();w4d4 = inFile1.nextDouble();w4d5 = inFile1.nextDouble();w4d6 = inFile1.nextDouble();w4d7 = inFile1.nextDouble();

                                        name2=inFile.next();
                                        EmpNo2=inFile.nextInt();
                                        double hourlyrate = inFile.nextDouble();
                                        double mbs = inFile.nextDouble();
                                        double rice = (inFile.nextDouble()/4.00);
                                        double phone = (inFile.nextDouble()/4.00);
                                        double clothing = (inFile.nextDouble()/4.00);
                                        double semimonhtly = (inFile.nextDouble()/2.00);

                                        //Compensation basis for the contributions
                                        deds.mbs= mbs;
                                        w4TH=w4d1+w4d2+w4d3+w4d4+w4d5+w4d6+w4d7;
                                        whours.TAH=w4TH;

                                        double WBPay = (whours.reghours()*hourlyrate);
                                        double OTPay=(hourlyrate* whours.OTHours()*whours.regOTRate());
                                        double totalearnings=(WBPay+rice+phone+clothing+OTPay);

                                        //computation basis for weekly witholding tax
                                        double tbase=totalearnings-(deds.sss()+ deds.ph()+ deds.hdmf());
                                        deds.taxablebase=tbase;

                                        double totalded=(deds.wtax()+ deds.sss()+ deds.ph()+ deds.hdmf());
                                        double netpay=(totalearnings-totalded);

                                        outFile.println("Employee and Log Details");
                                        outFile.printf("   Total Hours Worked for the Week:  %,1.2f Hours %n", w4TH);
                                        outFile.printf("   OT Hours Worked for the Week:     %,1.2f Hours %n", whours.OTHours());
                                        outFile.printf("   Rate per Hour:                Php %,1.2f %n", hourlyrate);
                                        outFile.println("Gross Wage");
                                        outFile.printf("   Basic Pay for the Week:       Php %,1.2f %n", WBPay);
                                        outFile.printf("   Rice Subsidy:                 Php %,1.2f %n", rice);
                                        outFile.printf("   Phone Allowance:              Php %,1.2f %n", phone);
                                        outFile.printf("   Clothing Allowance:           Php %,1.2f %n", clothing);
                                        outFile.printf("   Overtime Pay:                 Php %,1.2f %n", OTPay);
                                        outFile.printf("   Total Earnings:               Php %,1.2f %n", totalearnings);
                                        outFile.println("Deductions");
                                        outFile.printf("   Withholding Tax:              Php %,1.2f %n", deds.wtax());
                                        outFile.printf("   SSS Contribution:             Php %,1.2f %n", deds.sss());
                                        outFile.printf("   PHIC Contribution:            Php %,1.2f %n", deds.ph());
                                        outFile.printf("   HDMF Contribution:            Php %,1.2f %n", deds.hdmf());
                                        outFile.printf("   Total Deductions:             Php %,1.2f %n", totalded);
                                        outFile.printf("Net Wage for the Week            Php %,1.2f %n", netpay);
                                        outFile.println();
                                        outFile.println("Prepared by:                  Verified by:                 Approved by:" +"\n"+
                                                "\n"+
                                                "Joward Dahryll Malabja        John Aldrin P. Nilo          Joanne Cristine Franco"+"\n"+
                                                "*****  This is a computer-generated document. No signature is required. *****");
                                        outFile.println();}
                                    inFile.close();
                                    inFile1.close();
                                    outFile.close();

                                    fr = new FileReader("PayrollOutputs.txt");
                                    infile = new Scanner(fr);
                                    while(infile.hasNextLine()) {
                                        String line=infile.nextLine();
                                        System.out.println(line);}
                                    infile.close();
                                    break;
                                case 5://Overall-PayrollComputation
                                    outFile = new PrintWriter("PayrollOutputs.txt");
                                    freader = new FileReader("PayrollAll.txt");
                                    inFile = new Scanner(freader);

                                    while (inFile.hasNext() ) {
                                        String week = inFile.next();
                                        outFile.println("WEEKLY SALARY COMPUTATION");
                                        outFile.println(week+"\n");

                                        double RegHours = inFile.nextDouble();
                                        double OTHours = inFile.nextDouble();
                                        double WBPay = inFile.nextDouble();
                                        double rice = inFile.nextDouble();
                                        double phone = inFile.nextDouble();
                                        double clothing = inFile.nextDouble();
                                        double OTPay = inFile.nextDouble();
                                        double totalearnings = inFile.nextDouble();
                                        double wtax = inFile.nextDouble();
                                        double sss = inFile.nextDouble();
                                        double ph = inFile.nextDouble();
                                        double hdmf = inFile.nextDouble();
                                        double totalded = inFile.nextDouble();
                                        double netpay = inFile.nextDouble();

                                        double twh=RegHours+OTHours;

                                        outFile.println("Log Details");
                                        outFile.printf("   Regular Hours Worked:   %,1.2f Hours %n", RegHours);
                                        outFile.printf("   OT Hours Worked:        %,1.2f Hours %n", OTHours);
                                        outFile.printf("   Total Hours Worked:     %,1.2f Hours %n", twh);
                                        outFile.println("Gross Wage");
                                        outFile.printf("   Basic Pay:                    Php %,1.2f %n", WBPay);
                                        outFile.printf("   Rice Subsidy:                 Php %,1.2f %n", rice);
                                        outFile.printf("   Phone Allowance:              Php %,1.2f %n", phone);
                                        outFile.printf("   Clothing Allowance:           Php %,1.2f %n", clothing);
                                        outFile.printf("   Overtime Pay:                 Php %,1.2f %n", OTPay);
                                        outFile.printf("   Gross Earnings:               Php %,1.2f %n", totalearnings);
                                        outFile.println("Deductions");
                                        outFile.printf("   Withholding Tax:              Php %,1.2f %n", wtax);
                                        outFile.printf("   SSS Contribution:             Php %,1.2f %n", sss);
                                        outFile.printf("   PHIC Contribution:            Php %,1.2f %n", ph);
                                        outFile.printf("   HDMF Contribution:            Php %,1.2f %n", hdmf);
                                        outFile.printf("   Total Deductions:             Php %,1.2f %n", totalded);
                                        outFile.printf("Net Pay                          Php %,1.2f %n", netpay);
                                        outFile.println();
                                        outFile.println("Prepared by:                  Verified by:                 Approved by:" +"\n"+
                                                "\n"+
                                                "Joward Dahryll Malabja        John Aldrin P. Nilo          Joanne Cristine Franco"+"\n"+
                                                "*****  This is a computer-generated document. No signature is required. *****");
                                        outFile.println();}
                                    inFile.close();
                                    outFile.close();

                                    fr = new FileReader("PayrollOutputs.txt");
                                    infile = new Scanner(fr);
                                    while(infile.hasNextLine()) {
                                        String line=infile.nextLine();
                                        System.out.println(line);}
                                    infile.close();
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.print("Error! Please enter a valid option!");
                                    break;
                            }
                        }while(payroll!=6);
                        break;

                    case 4: //LOGOUT
                        System.out.println("Thank you and Goodbye " + UserName + "!");
                        break;
                    default:
                        System.out.println("Please enter a value between 1 to 4");
                        break;
                }
            } while (mainmenu != 4);}
        else
        {
            System.out.println("Ooops! The Third time is the charm!!! (-_-)" + "\n"+
                    "Please reRUN the program and try again!");
        }
    } //publicstaticmainclass (Closing Curly Brackets)

}
