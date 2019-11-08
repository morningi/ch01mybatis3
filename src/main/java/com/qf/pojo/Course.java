package com.qf.pojo;

public class Course {
    private int courseId;
    private String courseName;
    private String courseHour;

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseHour() {
        return courseHour;
    }

    public void setCourseHour(String courseHour) {
        this.courseHour = courseHour;
    }

    public Course(int courseId, String courseName, String courseHour) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseHour = courseHour;
    }

    public Course(int courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseHour='" + courseHour + '\'' +
                '}';
    }
}
