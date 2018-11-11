package com.andrluc.javatech.courseallocation.beans;

import com.andrluc.javatech.courseallocation.model.OptionalCoursesPackage;
import com.andrluc.javatech.courseallocation.repository.OptionalCoursesPackageRepository;

import javax.faces.bean.ManagedBean;
import java.util.List;
import java.util.stream.Collectors;

@ManagedBean(name = "OptionalCoursesPackage")
public class OptionalCoursesPackageBean {
    private final OptionalCoursesPackageRepository optionalCoursesPackageRepository =
            new OptionalCoursesPackageRepository();

    public List<String> getAll() {
        return optionalCoursesPackageRepository.findAll().stream()
                .map(OptionalCoursesPackage::toString)
                .collect(Collectors.toList());
    }
}
