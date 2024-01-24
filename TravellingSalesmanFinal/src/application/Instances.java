package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class Instances {

    static Integer INF = 1000000;

	
    static ArrayList<ArrayList<Integer>> adjacencyMatrix4 = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(0, 1, 15, 6)),
            new ArrayList<>(Arrays.asList(2, 0, 7, 3)),
            new ArrayList<>(Arrays.asList(9, 6, 0, 12)),
            new ArrayList<>(Arrays.asList(10, 4, 8, 0))
    ));

    static ArrayList<ArrayList<Integer>> adjacencyMatrix5 = new ArrayList<>(Arrays.asList(
    		new ArrayList<>(Arrays.asList(0, 10, INF, 30, 40)),
			new ArrayList<>(Arrays.asList(10, 0, 50, INF, 70)),
			new ArrayList<>(Arrays.asList(INF, 50, 0, 80, INF)),
			new ArrayList<>(Arrays.asList(30, INF, 80, 0, 100)),
			new ArrayList<>(Arrays.asList(40, 70, INF, 100, 0))
     ));

    static ArrayList<ArrayList<Integer>> adjacencyMatrix10 = new ArrayList<>(Arrays.asList(
             new ArrayList<>(Arrays.asList(0, 10, INF, 30, 40, 50, 60, 70, 80, 90)),
             new ArrayList<>(Arrays.asList(10, 0, 50, INF, 70, 80, 90, 100, 110, 120)),
             new ArrayList<>(Arrays.asList(INF, 50, 0, 80, INF, 100, 110, 120, 130, 140)),
             new ArrayList<>(Arrays.asList(30, INF, 80, 0, 100, 110, 120, 130, 140, 150)),
             new ArrayList<>(Arrays.asList(40, 70, INF, 100, 0, 120, 130, 140, 150, 160)),
             new ArrayList<>(Arrays.asList(50, 80, 100, 110, 120, 0, 140, 150, 160, 170)),
             new ArrayList<>(Arrays.asList(60, 90, 110, 120, 130, 140, 0, 160, 170, 180)),
             new ArrayList<>(Arrays.asList(70, 100, 120, 130, 140, 150, 160, 0, 180, 190)),
             new ArrayList<>(Arrays.asList(80, 110, 130, 140, 150, 160, 170, 180, 0, 200)),
             new ArrayList<>(Arrays.asList(90, 120, 140, 150, 160, 170, 180, 190, 200, 0))
     ));

     static ArrayList<ArrayList<Integer>> adjacencyMatrix15 = new ArrayList<>(Arrays.asList(
             new ArrayList<>(Arrays.asList(0, 10, INF, INF, INF, INF, INF, 18, INF, INF, 22, INF, INF, INF, 25)),
             new ArrayList<>(Arrays.asList(10, 0, 50, INF, INF, 22, 22, INF, INF, INF, INF, 32, INF, INF, INF)),
             new ArrayList<>(Arrays.asList(INF, 50, 0, 80, INF, INF, INF, INF, 56, INF, 44, INF, 66, INF, 66)),
             new ArrayList<>(Arrays.asList(INF, INF, 80, 0, 100, INF, 22, 11, 22, INF, 25, INF, INF, INF, INF)),
             new ArrayList<>(Arrays.asList(INF, INF, INF, 100, 0, 120, INF, 32, INF, INF, INF, INF, 12, INF, 66)),
             new ArrayList<>(Arrays.asList(INF, INF, INF, INF, 120, 0, 140, INF, INF, 22, 44, INF, INF, INF, INF)),
             new ArrayList<>(Arrays.asList(222, INF, INF, 12, INF, 140, 0, 160, INF, INF, INF, 22, 66, INF, INF)),
             new ArrayList<>(Arrays.asList(INF, 11, 4, INF, 19, 44, 160, 0, 180, 22, INF, INF, 32, INF, INF)),
             new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, 180, 0, 200, INF, INF, INF, INF, INF)),
             new ArrayList<>(Arrays.asList(223, INF, INF, 33, INF, INF, INF, INF, 200, 0, 220, INF, INF, 22, 66)),
             new ArrayList<>(Arrays.asList(INF, 2000, 44, INF, INF, 22, 33, INF, INF, 220, 0, 240, INF, 33, INF)),
             new ArrayList<>(Arrays.asList(33, INF, INF, INF, 33, INF, INF, INF, INF, INF, 240, 0, 260, INF, INF)),
             new ArrayList<>(Arrays.asList(INF, INF, INF, 90, INF, INF, 33, INF, INF, 99, INF, 260, 0, 280, INF)),
             new ArrayList<>(Arrays.asList(INF, INF, 55, INF, INF, 11, 22, INF, INF, 999, INF, 44, 280, 0, 300)),
             new ArrayList<>(Arrays.asList(25, INF, INF, INF, 52, INF, INF, INF, INF, INF, 44, INF, INF, 300, 0))
     ));
	
}
