package com.andrluc.javatech.courseallocation.repository;

import com.andrluc.javatech.courseallocation.model.Course;
import com.andrluc.javatech.courseallocation.model.Lecturer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CoursesRepository extends PostgreSQLModelRepository<Course>{

    @Override
    public int count() {
        int result = -1;
        try {
            final Connection dbConnection = getDBConnection();
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM courses");

            while (rs.next()) {
                result = rs.getInt(1);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void save(Course entity) {
        final Connection dbConnection = getDBConnection();

        try {
            final Statement statement = dbConnection.createStatement();

            String sqlStatement = String.format("INSERT INTO public.courses VALUES (\'%s\', \'%s\', \'%s\', %s, %s, \'%s\', \'%s\', \'%s\', %s);",
                    entity.getId(), entity.getShortName(), entity.getName(), entity.getYear(), entity.getSemester(),
                    entity.getLecturer(), entity.getUrl(), entity.getOptionalPackageName(), entity.getStudyGroupsCount());

            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Course findById(String id) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        List<Course> result = new ArrayList<>();
        try {
            final Connection dbConnection = getDBConnection();
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM courses");

            while (rs.next()) {
                Course course = new Course();

                course.setId(rs.getString(1));
                course.setShortName(rs.getString(2));
                course.setName(rs.getString(3));
                course.setYear(rs.getInt(4));
                course.setSemester(rs.getInt(5));
                course.setLecturer(new Lecturer(rs.getString(6)));
                course.setUrl(rs.getString(7));
                course.setOptionalPackageName(rs.getString(8));
                course.setStudyGroupsCount(rs.getInt(9));

                result.add(course);
            }

            rs.close();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean existsById(String id) {
        return false;
    }

    @Override
    public void delete() {

    }

    @Override
    public void deleteById(String id) {

    }
}
