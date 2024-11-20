package org.example;

import java.util.List;

//일급컬렉션 -> 하나의 변수만 가지고 역할, 책임을 가지는 메소드 생성 -> 여기서는 리스트 형태의 변수를 가지고 합계와 학점의 합을 구하는 메소드 생성
public class Courses {

    private final List<Course> courses;

    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double multiplyCreditAndCourseGrade() {
        double multipliedCreditAndCourseGrade = 0.0;
        for(Course course : courses) {
            multipliedCreditAndCourseGrade += course.multiplyCreditAndCourseGrade();
        }
        return multipliedCreditAndCourseGrade;
    }

    public int calculateTotalCompletedCredit() {
        return courses.stream()
            .mapToInt(Course::getCredit)
            .sum();
    }
}
