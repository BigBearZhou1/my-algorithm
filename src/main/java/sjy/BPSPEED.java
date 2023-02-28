package sjy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BP1 {
    class Info {
        int time;
        int real;
        int traingd;
        int traingdx;
        int trainlm;

        public Info(int time, int real, int traingd, int traingdx, int trainlm) {
            this.time = time;
            this.real = real;
            this.traingd = traingd;
            this.traingdx = traingdx;
            this.trainlm = trainlm;
        }

        @Override
        public String toString() {
            return "[" +
                    "" + time +
                    "," + real +
                    "," + traingd +
                    "," + traingdx +
                    ", " + trainlm + "]";
        }
    }

    public List<Info> genBPInfo(List<Integer> realDatas,List<Integer> traingds) {
        List<Info> infos = new ArrayList<>();
        Random random = new Random();

        int time = 5;
        for (int i = 0; i < realDatas.size(); i++) {
            Integer real = realDatas.get(i);
            Integer traingd = traingds.get(i);
            Info info = new Info(time, real, traingd, traingd - random.nextInt(3), traingd - random.nextInt(3));
            infos.add(info);
            time = time + 5;
        }
        return infos;
    }

    public static void main(String[] args) {
        List<Integer> realData = Arrays.asList(95, 94, 103, 96, 93, 91, 92, 93, 94, 102, 101, 97, 93, 94, 96, 92);
        List<Integer> traingds = Arrays.asList(94, 94, 97, 95, 87, 85, 89, 90, 91, 92, 90, 89, 91, 90, 91, 90);
        BP1 bp1 = new BP1();
        List<Info> infos = bp1.genBPInfo(realData,traingds);
        System.out.println(infos);
    }
}
