package omok;
public class Board {
	 	int size;
	    String[][] map;
	    boolean run;
	   
	   
	    Board(int size) {
	        this.size = size;
	        map = new String[size][size];
	        run = true;
	        for (int row = 0; row < size; row++) {
	            for (int col = 0; col < size; col++) {
	                map[row][col] = ".";
	            }
	        }
	    }
	   
	    public void print() {
	        for (int row = 0; row < size + 1; row++) {
	        	
	        	if (row < size) {
	        		System.out.print(row < 10 ? " " + row : row );
//	        		System.out.print(" ");
	        	} else {
//	        		System.out.print("    ");
	        		System.out.print("   ");
	        	}
	        	for (int col = 0; col < size; col++) {
	        		
	                if (row < size) {
	                	System.out.print(" " + map[row][col]);
	                } else {
	       
	                	char c = (char) (65 + col);
	                	System.out.print(c + " ");
	                }
	               
	            }
	            System.out.println();
	           
	        }
	     
	    }
	   
	    public void enterPosition(String position, Player player) {
	    	String[] pos = position.split(" ");
	    	int x = (int)(pos[0].toUpperCase().charAt(0))-65;
	    	int y = Integer.parseInt(pos[1]);
	    	
	    	
	    	map[y][x] = player.stone;
	    	
	    	run = !checkOmok(y, x, player);
	    	
	    	
	    }
	   
	    private boolean checkOmok(int y, int x, Player player) {
	    	 int[][] dirs = {
	    		        {1,0}, {0,1}, {1,1}, {1,-1}   //가로, 세로, 대각선 2개 
	    		    };
		    for (int[] d : dirs) {
		        int count = 1;
		        count += countDir(x, y, d[0], d[1], player); //정방향
		       
		        count += countDir(x, y, -d[0], -d[1], player); //역방향
		        //총합이 5이상이면 오목의 조건 만족하여 true return 
		        if (count >= 5) return true;
	    		    }
		    return false;
	    }
	   
	    private int countDir(int x, int y, int dx, int dy, Player player) {
	    	int cnt = 0;
	    	//while로 탐색하면서 연속된 돌이 몇개인지 카운팅
	    	while (true) {
	    		x += dx;
	    		y += dy;
	    		if (x < 0 || x >= size || y < 0 || y >= size) break;
	    		if (map[y][x] != player.stone) break;
	    		cnt++;
	    	}
	    	return cnt;
	    }
}