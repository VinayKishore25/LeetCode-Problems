class Solution {
    int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public void fillDates(String startDate, String endDate,int[] year) {
        int startMonth = Integer.parseInt(startDate.substring(0, 2));
        int startDay = Integer.parseInt(startDate.substring(3, 5));

        int endMonth = Integer.parseInt(endDate.substring(0, 2));
        int endDay = Integer.parseInt(endDate.substring(3, 5));

        int start = startDay - 1;
        int end = endDay - 1;

        for (int i = 0; i < startMonth - 1; i++) {
            start += months[i];
        }

        for (int i = 0; i < endMonth - 1; i++) {
            end += months[i];
        }

        for (int i = start; i <= end; i++) {
            year[i] = 1;
        }
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] aliceYear = new int[366];
        int[] bobYear = new int[366];
        int days = 0;

        fillDates(arriveAlice,leaveAlice,aliceYear);
        fillDates(arriveBob,leaveBob,bobYear);

        for(int i = 0 ; i < 366 ; i++){
            if(aliceYear[i] == 1 && bobYear[i] == 1){
                days++;
            }
        }

        return days;
    }
}