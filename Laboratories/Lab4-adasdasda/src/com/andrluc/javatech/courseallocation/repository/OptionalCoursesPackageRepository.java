package com.andrluc.javatech.courseallocation.repository;

import com.andrluc.javatech.courseallocation.model.OptionalCoursesPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OptionalCoursesPackageRepository extends PostgreSQLModelRepository<OptionalCoursesPackage> {
    @Override
    public int count() {
        int result = -1;
        try {
            final Connection dbConnection = getDBConnection();
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) FROM optional_courses_package");

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
    public void save(OptionalCoursesPackage entity) {
        final Connection dbConnection = getDBConnection();

        try {
            final Statement statement = dbConnection.createStatement();

            String sqlStatement = String.format("INSERT INTO optional_courses_package VALUES (\'%s\', \'%s\', %s, %s, %s);",
                    entity.getId(), entity.getName(), entity.getYear(), entity.getSemester(), entity.getCoursesCount());

            statement.executeUpdate(sqlStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OptionalCoursesPackage findById(String id) {
        return null;
    }

    @Override
    public List<OptionalCoursesPackage> findAll() {
        List<OptionalCoursesPackage> result = new ArrayList<>();
        try {
            final Connection dbConnection = getDBConnection();
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM optional_courses_package");

            while (rs.next()) {
                OptionalCoursesPackage  optionalCoursesPackage = new OptionalCoursesPackage();

                optionalCoursesPackage.setId(rs.getString(1));
                optionalCoursesPackage.setName(rs.getString(2));
                optionalCoursesPackage.setYear(rs.getInt(3));
                optionalCoursesPackage.setSemester(rs.getInt(4));
                optionalCoursesPackage.setCoursesCount(rs.getInt(5));

                result.add(optionalCoursesPackage);
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
