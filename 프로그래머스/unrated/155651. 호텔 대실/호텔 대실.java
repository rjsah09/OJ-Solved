import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        int[][] convertedList = getConvertedList(book_time);
        Arrays.sort(convertedList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < convertedList.length; i++) {
            if (pq.size() == 0) {
                pq.add(convertedList[i][1]);
                continue;
            }
            
            //새로 대실할 방이 가장 빨리 끝나는 방 목록에 이어 붙일 수 있는 경우, poll시켜 그 방에 이어 붙임 
            if (convertedList[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.add(convertedList[i][1]);
            
        }
        
        
        return pq.size();
    }
    
    public int getConvertedTime(String time) {
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        
        return hour * 60 + minute;
    }
    
    public int[][] getConvertedList(String[][] book_time) {
        int[][] convertedList = new int[book_time.length][2];
        
        for (int i = 0; i < convertedList.length; i++) {
            convertedList[i][0] = getConvertedTime(book_time[i][0]);
            convertedList[i][1] = getConvertedTime(book_time[i][1]) + 10;
        }
        
        return convertedList;
    }
    
    public void print(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i][0] + " / " + list[i][1]);
        }
    }
    
}