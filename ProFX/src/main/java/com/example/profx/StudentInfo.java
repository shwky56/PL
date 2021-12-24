package com.example.profx;

public class StudentInfo {
    private String courseName,courseId;
    private int yourCourseGrade,maxCourseGrade,examTime;

    public StudentInfo(String courseName, String courseId, int yourCourseGrade, int maxCourseGrade, int examTime) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.yourCourseGrade = yourCourseGrade;
        this.maxCourseGrade = maxCourseGrade;
        this.examTime = examTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getYourCourseGrade() {
        return yourCourseGrade;
    }

    public void setYourCourseGrade(int yourCourseGrade) {
        this.yourCourseGrade = yourCourseGrade;
    }

    public int getMaxCourseGrade() {
        return maxCourseGrade;
    }

    public void setMaxCourseGrade(int maxCourseGrade) {
        this.maxCourseGrade = maxCourseGrade;
    }

    public int getExamTime() {
        return examTime;
    }

    public void setExamTime(int examTime) {
        this.examTime = examTime;
    }
}
