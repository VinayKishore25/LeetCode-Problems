class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] directionX = {0,1,0,-1};
        int[] directionY = {1,0,-1,0};
        int way = 0;
        int pointX = 0;
        int pointY = 0;
        int n = commands.length;
        int res = Integer.MIN_VALUE;
        HashSet<String> hs = new HashSet<>();
        int l = obstacles.length;
        for(int i = 0 ; i < l ; i++){
            hs.add(obstacles[i][0] + " " + obstacles[i][1]);
        }
        System.out.println(hs);
        for(int i = 0 ; i < n ; i++){
            if(commands[i] == -1){
                way = (way+1)%4;
                continue;
            }
            else if(commands[i] == -2){
                way = (way-1+4)%4;
                continue;
            }
            else{
                for(int j = 1 ; j <= commands[i] ; j++){
                    if(!hs.contains((pointX+directionX[way]) + " " + (pointY+directionY[way])))
                    {
                        pointX += directionX[way];
                        pointY += directionY[way];
                    }
                    else{
                        break;
                    }
                }
                res = Math.max(res,pointX * pointX + pointY * pointY);
            }
        }
        return res;
    }
}