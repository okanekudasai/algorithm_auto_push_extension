
import java.io.*;
import java.util.*;

class Job {
    int duration;
    int timeLimit;
    Job (int duration, int timeLimit) {
        this.duration = duration;
        this.timeLimit = timeLimit;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String [] data = new String[N];
        for (int i = 0; i < N; i++) {
            data[i] = br.readLine();
        }
        System.out.println(solution(N, data));
    }
    static int solution(int N, String [] data) {
        PriorityQueue<Job> jobs = refineData(N, data);
        Job firstJob = jobs.poll();
        int laborStart = firstJob.timeLimit - firstJob.duration;
        int laborFinish = firstJob.timeLimit;
        if (laborStart < 0) return -1;
        while (!jobs.isEmpty()) {
            Job job = jobs.poll();
            if (laborFinish <= job.timeLimit - job.duration) {
                laborFinish += job.duration;
            } else {
                int laborDuration = laborFinish - laborStart;
                laborFinish = job.timeLimit;
                laborStart = laborFinish - laborDuration - job.duration;
                if (laborStart < 0) return -1;
            }
        }
        return laborStart;
    }
    static PriorityQueue<Job> refineData(int N, String [] data) {
        PriorityQueue<Job> jobs = new PriorityQueue<>((o1, o2) -> o1.timeLimit - o2.timeLimit);
        for (int i = 0; i < N; i++) {
            String [] s = data[i].split(" ");
            jobs.offer(new Job(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
        }
        return jobs;
    }
}