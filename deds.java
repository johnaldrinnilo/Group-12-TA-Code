public class deds {
    static double taxablebase;
    //With value reassignment on the main class for dynamic computation.
    static double mbs;
    //With value reassignment on the main class for dynamic computation.
    static double wtax() {
//to compute weekly withholding tax
        if (taxablebase < 4808.00)
            return 0.00;
        else if (taxablebase < 7692.00)
            return ((taxablebase-4808.00)*20.00)/100.00;
        else if (taxablebase < 15385.00)
            return ((((taxablebase-7692.00)*25.00)/100.00)+576.92);
        else if (taxablebase < 38462.00)
            return ((((taxablebase-15385.00)*30.00)/100.00)+2500.00);
        else if (taxablebase < 153846.00)
            return ((((taxablebase-38462.00)*32.00)/100.00)+9423.08);
        else if (taxablebase > 153846.00)
            return ((((taxablebase-153846.00)*35.00)/100.00)+ 46346.15);
        else return 0.00;
    }
    static double hdmf() {
//to compute weekly HDMF ee share
        if (mbs <= 1500.00)
            return (mbs * 1.00) / 100.00;
        else {
            return (100.00 / 4.00);
        }
    }
        static double sss() {
//to compute weekly SSS share
            if (mbs < 3250.00)
                return (135.00/4.00);
            if (mbs >= 24750.00)
                return (1125.00 / 4.00);

            double filler=0.00, abovemin=157.50;

            for (double bs=3250.00; bs<=24750;bs +=500)
            {
                if (mbs>=bs && mbs < bs+500.00)
                {
                    filler=abovemin;
                    break;
                }
                abovemin+=22.50;
            }
            return (filler/4.00);
        }
    static double ph() {
//to compute weekly PHIC ee share
        if (mbs <= 10000.00)
            return (150.00/4.00);
        else if (mbs <= 59999.99)
            return ((mbs*1.50)/100)/4.00;
        else
            return (900.00/4.00);
    }

}
