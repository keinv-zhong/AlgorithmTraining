package calculate;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MinTrace {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}, {6, 8, 10}};
        System.out.println(solution(grid));

        HashMap<String, String> hashMap = new HashMap<>(16);
        hashMap.put("qwe", "111");
        int hashSize = hashMap.size();

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>(16);
        concurrentHashMap.put("aaa", "value");
        concurrentHashMap.put("aaa", "value2");
        concurrentHashMap.put("aaa", "value3");
//        concurrentHashMap.put("bbb", "value3");
//        concurrentHashMap.get("aaa");
//        concurrentHashMap.remove("aaa");
        int size = concurrentHashMap.size();
        System.out.println(size);

        ReentrantLock lock = new ReentrantLock();
        try {
            boolean getLock = lock.tryLock(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        int initialCapacity = 18;
//        int initSize = tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1);
//        System.out.println(initSize);
    }

    private static int solution(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }

    private static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}
