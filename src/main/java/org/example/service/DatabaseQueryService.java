package org.example.service;

import org.example.Database;
import org.example.dto.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class DatabaseQueryService {
    private final List<MaxProjectsClient> mpc = new LinkedList<>();
    private final List<MaxSalaryWorker> msw = new LinkedList<>();
    private final List<YoungestEldestWorker> yew = new LinkedList<>();
    private final List<LongestProject> lp = new LinkedList<>();
    private final LinkedList<ProjectPrices> pj = new LinkedList<>();

    public List<MaxProjectsClient> findMaxProjectsClient() throws SQLException {
        String sql = getSql(new File(
                "/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/find_max_projects_client.sql"));
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int projectCount = resultSet.getInt("project_count");
            MaxProjectsClient maxProjectsClient = new MaxProjectsClient();
            maxProjectsClient.setName(name);
            maxProjectsClient.setProject_count(projectCount);
            mpc.add(maxProjectsClient);
        }
        return mpc;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() throws SQLException {
        String sql = getSql(new File(
                "/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/find_max_salary_worker.sql"));
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int salary = resultSet.getInt("salary");
            MaxSalaryWorker maxSalaryWorker = new MaxSalaryWorker();
            maxSalaryWorker.setSalary(salary);
            maxSalaryWorker.setName(name);
            msw.add(maxSalaryWorker);
        }
        return msw;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() throws SQLException {
        String sql =
                getSql(new File("/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/find_youngest_eldest_workers.sql"));
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()) {
            String type = resultSet.getString("type");
            String name = resultSet.getString("name");
            int birthday = resultSet.getInt("birthday");
            YoungestEldestWorker youngestEldestWorker = new YoungestEldestWorker();
            youngestEldestWorker.setBirthday(birthday);
            youngestEldestWorker.setName(name);
            youngestEldestWorker.setType(type);
            yew.add(youngestEldestWorker);
        }
        return yew;
    }
    public List<LongestProject> findLongestProject() throws SQLException {
        String sql = getSql(new File("/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/find_longest_project.sql"));
        ResultSet resultSet = getResultSet(sql);
        while (resultSet.next()){
            LongestProject longestProject = new LongestProject();
            String name = resultSet.getString("name");
            int mounthCount = resultSet.getInt("month_count");
            longestProject.setName(name);
            longestProject.setMounth_count(mounthCount);
            lp.add(longestProject);

        }
        return lp;
    }
    public List<ProjectPrices> findProjectPrices() throws SQLException {
        String sql = getSql(new File("/Users/mac/IdeaProjects/HomoworkSQl/src/main/resources/print_project_prices.sql"));
        ResultSet r = getResultSet(sql);
        while (r.next()){
            String name = r.getString("name");
            int price = r.getInt("price");
            ProjectPrices projectPrices = new ProjectPrices();
            projectPrices.setName(name);
            projectPrices.setPrice(price);
            pj.add(projectPrices);
        }
        return pj;
    }

    private ResultSet getResultSet(String sql) throws SQLException {
        Connection connection = Database.getInstance().getConnection();
        Statement statement = connection.createStatement();
        return statement.executeQuery(sql);
    }

    private String getSql(File url) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(url)) {
            int c;
            while ((c = reader.read()) != -1) {

                result.append((char) c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString();
    }
}
