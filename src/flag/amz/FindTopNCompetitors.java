package flag.amz;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by muni on 2019/12/9
 */
public class FindTopNCompetitors {

    public static void main(String[] args) {
        List<String> competitors = Arrays.asList("newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular");
        List<String> reviews = Arrays.asList("newshop is providing good services in the city, everyone should use newshop", "best services by newshop", "fashionbeats has great services in the city", "I am proud to have fashionbeats","mymarket has awesome services", "Thanks Newshop for the quick delivery.");
        System.out.println(new FindTopNCompetitors().findTopN(6,2, competitors, 6, reviews));
        System.out.println(new FindTopNCompetitors().findTopN2(6,2, competitors, 6, reviews));
    }

    public List<String> findTopN(int numCompetitors, int topNCompetitors, List<String> competitors, int numReviews, List<String> reviews) {
        Map<String, Integer> map = new HashMap<>();
        for (String review : reviews) {
            for (String comp : competitors) {
                if (review.toLowerCase().contains(comp.toLowerCase())) {
                    map.put(comp, map.getOrDefault(comp, 0) + 1);
                }
            }
        }

        List<String>[] lists = new List[numReviews];
        for (String comp : map.keySet()) {
            if (lists[map.get(comp)] == null) {
                lists[map.get(comp)] = new ArrayList<>();
            }
            lists[map.get(comp)].add(comp);
        }

        String[] rst = new String[topNCompetitors];
        int index = 0;
        for (int i=numReviews-1; i>=0; i--) {
            if (lists[i] == null) continue;
            Collections.sort(lists[i]);
            for (String comp : lists[i]) {
                rst[index++] = comp;
                if (index == topNCompetitors) return Arrays.asList(rst);
            }
        }
        // rst size less than N
        return Arrays.asList(rst);
    }

    public List<String> findTopN2(int numCompetitors, int topNCompetitors, List<String> competitors, int numReviews, List<String> reviews) {
        Map<String, Integer> compCount = new HashMap<>();

        // loop over each review, and for each review check if its in the string
        // contains is fast enough, it uses .indexOf() under the hood
        for (String review : reviews) {
            for (String comp : competitors) {
                if (review.toLowerCase().contains(comp.toLowerCase())) {
                    int count = compCount.getOrDefault(comp, 0);
                    compCount.put(comp, count + 1);
                    break; // we found one, if we can assume single count per review and only one mentioned we're done
                }
            }
        }

        return compCount.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())) // first sort each Map.Entry in Descending Order (greatest -> least mentions
                .limit(topNCompetitors) //limit the stream to only the elements we need
                .map(Map.Entry::getKey) // map each value back to its original key
                .collect(Collectors.toList()); // collect and return the list
        }
    }
