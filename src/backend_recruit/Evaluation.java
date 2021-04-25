package backend_recruit;


import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class Evaluation {
    private Integer id;
    private String name;
    private String date;
    private Float gpa;
    private Integer advanced_mathematics;
    private Integer liner_algebra;
    private Integer c_programming;
    private List<Association> associations;
    private String opinion_of_university;
    private String frequency_of_library_or_self_study_room;
    private List<Algorithm> algorithms;
    private Float data_structure;


    private static class Association {
        private String name;
        private Float score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }
    }

    private static class Algorithm {
        private String name;
        private Float score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Float getScore() {
            return score;
        }

        public void setScore(Float score) {
            this.score = score;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }

    public Integer getAdvanced_mathematics() {
        return advanced_mathematics;
    }

    public void setAdvanced_mathematics(Integer advanced_mathematics) {
        this.advanced_mathematics = advanced_mathematics;
    }

    public Integer getLiner_algebra() {
        return liner_algebra;
    }

    public void setLiner_algebra(Integer liner_algebra) {
        this.liner_algebra = liner_algebra;
    }

    public Integer getC_programming() {
        return c_programming;
    }

    public void setC_programming(Integer c_programming) {
        this.c_programming = c_programming;
    }

    public List<Association> getAssociations() {
        return associations;
    }

    public void setAssociations(List<Association> associations) {
        this.associations = associations;
    }

    public String getOpinion_of_university() {
        return opinion_of_university;
    }

    public void setOpinion_of_university(String opinion_of_university) {
        this.opinion_of_university = opinion_of_university;
    }

    public String getFrequency_of_library_or_self_study_room() {
        return frequency_of_library_or_self_study_room;
    }

    public void setFrequency_of_library_or_self_study_room(String frequency_of_library_or_self_study_room) {
        this.frequency_of_library_or_self_study_room = frequency_of_library_or_self_study_room;
    }

    public List<Algorithm> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(List<Algorithm> algorithms) {
        this.algorithms = algorithms;
    }

    public Float getData_structure() {
        return data_structure;
    }

    public void setData_structure(Float data_structure) {
        this.data_structure = data_structure;
    }

    private static class Student {
        private String name;
        private Double score;

        public Student(String name, Double score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\IdeaProjects\\leetcode\\src\\backend_recruit\\后台选人.json"), "gbk"))) {
            int i = -1;
            while ((i = bufferedReader.read()) != -1) {
                stringBuilder.append((char) i);
            }
        }
        List<Evaluation> evaluations = JSONObject.parseArray(stringBuilder.toString(), Evaluation.class);

//        List<String> names = new ArrayList<>(evaluations.size());
//        List<Double> scores = new ArrayList<>(evaluations.size());
        List<Student> students = new ArrayList<>(evaluations.size());
        for (int i = 0; i < evaluations.size(); i++) {
                students.add(new Student(evaluations.get(i).getName(),solve(evaluations.get(i))));
        }
        students.sort((v1,v2)-> (int) (v2.score-v1.score));
        for (int i = 0; i < evaluations.size(); i++) {
            System.out.println(students.get(i));
        }
    }
    /*
    绩点(15%)+成绩(20%)+社团(12%)+图书馆自习室学习频率(23%)+算法(23%)+其他基础(7%)
     */

    /*
    (ok)符健概 2729879244@qq.com
    (ok)李燕婷 Wsry20130@163.com
    (ok)何红梅 1069595987@qq.com
    (ok)方浩男 1973113668@qq.com
    (ok)张晨   2218920625@qq.com
    (ok)杨育谦 1135704315@qq.com
    (x)林坦熙 2598034040@qq.com
    (x)颜显翔 2433516004@qq.com
     */
    private static double solve(Evaluation evaluation) {
        String frequencyOfLibraryOrSelfStudyRoom = evaluation.getFrequency_of_library_or_self_study_room();
        String[] fre = frequencyOfLibraryOrSelfStudyRoom.split("/");
        double gpa = (evaluation.getGpa() / 4.0) * 0.15;
        double courseScores = (evaluation.getAdvanced_mathematics() + evaluation.getLiner_algebra() + evaluation.getC_programming()) / 300.0 * 0.20;
        double freq = Integer.parseInt(fre[0]) / (float) Integer.parseInt(fre[1]) * 0.23;
        double algo = solveAlgorithm(evaluation.getAlgorithms()) * 0.23;
        double dataStructure = evaluation.getData_structure() / 100.0 * 0.07;
        double association = solveAssociation(evaluation.getAssociations()) * 0.12;
        return (gpa + courseScores + freq + algo + dataStructure + association) * 100;
    }

    private static float solveAssociation(List<Association> associations) {
        if (associations.size() == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < associations.size(); i++) {
            sum += associations.get(i).getScore();
        }
        return (float) sum / (associations.size() * 100);
    }

    private static float solveAlgorithm(List<Algorithm> algorithms) {
        float sum = 0;
        for (int i = 0; i < algorithms.size(); i++) {
            sum += algorithms.get(i).getScore();
        }
        return sum / (algorithms.size() * 100);
    }
}
