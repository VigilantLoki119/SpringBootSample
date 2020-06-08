package com.bootsamplewithdata.springbootwithdata.coursepackage;

import java.util.List;
import java.util.Optional;

import com.bootsamplewithdata.springbootwithdata.topicpackage.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController {

    @Autowired
    private CoursesServices courseservices;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Courses> getAllCourses(@PathVariable String id) {
        return courseservices.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Courses> getcourse(@PathVariable String id) {
        return courseservices.getCourses(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addcourse(@RequestBody Courses course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId , "", ""));
        courseservices.addCourses(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updatecourse(@RequestBody Courses course, @PathVariable String topicId, @PathVariable String id) {
        course.setTopic(new Topic(topicId , "", ""));
        courseservices.updateCourses(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deletecourse(@PathVariable String id){
        courseservices.deleteCourses(id);
    }
}