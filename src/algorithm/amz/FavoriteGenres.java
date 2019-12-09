package algorithm.amz;

import java.util.*;

/**
 * Created by muni on 2019/12/9
 */
public class FavoriteGenres {
    public static void main(String[] args) {
        FavoriteGenres fg = new FavoriteGenres();
        Map<String, List<String>> userMap = new HashMap<>();
        userMap.put("David", Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        userMap.put("Emma", Arrays.asList("song5", "song6", "song7"));

        Map<String, List<String>> genreMap = new HashMap<>();
        genreMap.put("Rock", Arrays.asList("song1", "song3"));
        genreMap.put("Dubstep", Arrays.asList("song7"));
        genreMap.put("Techno", Arrays.asList("song2", "song4"));
        genreMap.put("Pop", Arrays.asList("song5", "song6"));
        genreMap.put("Jazz", Arrays.asList("song8", "song9"));
        Map<String, List<String>> rst = fg.favoriteGenres(userMap, genreMap);
        for (String user : rst.keySet()) {
            System.out.println(user);
            System.out.println(rst.get(user));
            System.out.println("---");
        }
    }

    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String, String> song2genre = new HashMap<>();
        for (String genre : genreMap.keySet()) {
            List<String> songs = genreMap.get(genre);
            for (String song : songs) {
                song2genre.put(song, genre);
            }
        }

        Map<String, List<String>> rst = new HashMap<>();
        for (String user : userMap.keySet()) {
            int max = 0;
            Map<String, Integer> genreCountMap = new HashMap<>();
            List<String> songs = userMap.get(user);
            for (String song : songs) {
                String genre = song2genre.get(song);
                int count = genreCountMap.getOrDefault(genre, 0) + 1;
                genreCountMap.put(genre, count);
                max = Math.max(max, count);
            }
            for (String genre : genreCountMap.keySet()) {
                if (genreCountMap.get(genre) == max) {
                    rst.putIfAbsent(user, new ArrayList<>());
                    rst.get(user).add(genre);
                }
            }
        }
        return rst;
    }

//    public Map<String, List<String>> favoriteGenres(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
//        Map<String, List<String>> res = new HashMap<>();
//        Map<String, String> songstogenre = new HashMap<>();
//
//        for(String genre : genreMap.keySet()) {
//            List<String> songs = genreMap.get(genre);
//            for(String song : songs) {
//                songstogenre.put(song, genre);
//            }
//        }
//        Map<String, Integer> count = new HashMap();
//        int max = 0;
//        for(String user : userMap.keySet()) {
//            count = new HashMap();
//            max = 0;
//            res.put(user, new ArrayList());
//            List<String> songs = userMap.get(user);
//            for(String song : songs) {
//                String genre = songstogenre.get(song);
//                int c = count.getOrDefault(genre, 0) + 1;
//                count.put(genre, c);
//                max = Math.max(c, max);
//            }
//            for (String key : count.keySet()) {
//                if (count.get(key) == max) {
//                    res.get(user).add(key);
//                }
//            }
//        }
//        return res;
//    }
}
