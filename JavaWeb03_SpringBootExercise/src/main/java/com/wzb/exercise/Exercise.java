package com.wzb.exercise;

import java.util.*;

public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] split = input.split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        String in = sc.nextLine();
        String[] split1 = in.split(" ");
        int[] array = new int[n];
        for (int i = 0; i < split1.length; i++) {
            array[i] = Integer.parseInt(split1[i]);
        }
        ArrayList<Integer> list = solution(n, k, array);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    public static ArrayList<Integer> solution(int n, int k, int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i <= n - k; i++) {
            temp.clear();
            for (int j = i; j < i + k; j++) {
                temp.add(array[j]);
                if (temp.size() == k) {
                    list.add(maxNumber(temp));
                }
            }
        }
        return list;
    }

    public static Integer maxNumber(ArrayList<Integer> temp) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer i : temp) {
            map.put(i, true);
        }
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                if (Objects.equals(temp.get(i), temp.get(j))) {
                    map.put(temp.get(i), false);
                }
            }
        }
        for (Integer i : map.keySet()) {
            if (map.get(i)) {
                arrayList.add(i);
            }
        }
        if (!arrayList.isEmpty()) {
            return Collections.max(arrayList);
        } else {
            return -1;
        }
    }
}
