package com.bootsamplewithdata.springbootwithdata.coursepackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursesServices {

    @Autowired
    private CoursesRepository courseRepository;

    public List<Courses> getAllCourses(String topicId) {

        List<Courses> courses = new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Courses> getCourses(String id) {

        return courseRepository.findById(id);
    }

    public void addCourses(Courses courses2) {

        courseRepository.save(courses2);
    }

    public void updateCourses(Courses courses2) {

        courseRepository.save(courses2);
    }

    public void deleteCourses(String id) {

        courseRepository.deleteById(id);
	}
}