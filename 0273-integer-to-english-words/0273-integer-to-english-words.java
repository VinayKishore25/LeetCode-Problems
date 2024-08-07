class Solution {
    public String ones(int n){
        if(n == 1) return " One";
        if(n == 2) return " Two";
        if(n == 3) return " Three";
        if(n == 4) return " Four";
        if(n == 5) return " Five";
        if(n == 6) return " Six";
        if(n == 7) return " Seven";
        if(n == 8) return " Eight";
        if(n == 9) return " Nine";
        return "";
    }
    public String teens(int n){
        if(n == 11) return " Eleven";
        if(n == 12) return " Twelve";
        if(n == 13) return " Thirteen";
        if(n == 14) return " Fourteen";
        if(n == 15) return " Fifteen";
        if(n == 16) return " Sixteen";
        if(n == 17) return " Seventeen";
        if(n == 18) return " Eighteen";
        if(n == 19) return " Nineteen";
        return "";
    }
    public String tens(int n){
        if(n == 1) return " Ten";
        if(n == 2) return " Twenty";
        if(n == 3) return " Thirty";
        if(n == 4) return " Forty";
        if(n == 5) return " Fifty";
        if(n == 6) return " Sixty";
        if(n == 7) return " Seventy";
        if(n == 8) return " Eighty";
        if(n == 9) return " Ninety";
        return "";
    }
    public String numToHund(int n)
    {    
        String res = "";
        int one = n%10;
        n /= 10;
        int ten = n%10;
        n /= 10;
        int huns = n%10;
        if(huns != 0) res += ones(huns) + " Hundred";
        int value = ten*10 + one;
        if(value >= 11 && value <= 19){
            res += teens(value);
        }
        else if(value%10 == 0 && ten!=0)
        {
            res += tens(ten);
        }
        else{
            res += tens(ten) +ones(one); 
        }
        return res;
    }
    public String numberToWords(int num) 
    {
        if( num == 0) return "Zero";
        String res = "";
        int o = num%1000;
        num = num/1000;
        int thou = num%1000;
        num = num/1000;
        int milli = num%1000;
        num = num/1000;
        int billi = num%1000;
        if(billi != 0) res += numToHund(billi) + " Billion";
        if(milli != 0) res += numToHund(milli) + " Million";
        if(thou != 0) res += numToHund(thou) + " Thousand";
        if(o != 0) res += numToHund(o);

        return res.substring(1);
    }
}