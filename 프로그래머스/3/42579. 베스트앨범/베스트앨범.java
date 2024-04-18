import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        //장르별 플레이 횟수
        Map<String, Integer> genrePlayMap = new HashMap<>();
        //장르별 수록 곡 수
        Map<String, Integer> includeMap = new HashMap<>();
        
        //장르별 플레이 횟수
        for (int i = 0; i < plays.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            list.add(i);
        }
        
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (genrePlayMap.get(genres[o1]) != genrePlayMap.get(genres[o2])) {
                    return genrePlayMap.get(genres[o2]) - genrePlayMap.get(genres[o1]);
                } else if (genrePlayMap.get(genres[o1]) == genrePlayMap.get(genres[o2])
                            && plays[o1] != plays[o2]) {
                    return plays[o2] - plays[o1];   
                } else {
                    return o1 - o2;
                }
            }
        });
        
        List<Integer> finalList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int count = includeMap.getOrDefault(genres[list.get(i)], 0);
            if (count < 2) {
                includeMap.put(genres[list.get(i)], includeMap.getOrDefault(genres[list.get(i)], 0) + 1);
                finalList.add(list.get(i));
            }
        }
        
        answer = new int[finalList.size()];
        
        for (int i = 0; i < finalList.size(); i++) {
            answer[i] = finalList.get(i);
        }
        
        
        
        return answer;
    }
}