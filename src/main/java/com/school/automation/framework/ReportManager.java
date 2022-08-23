package com.school.automation.framework;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    public static File reportOutputDirectory;

    public static void createReport(){
        reportOutputDirectory = new File("reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        String projectName = "School Management QA Report";

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.addClassifications("Application", "School Management");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
        Reportable result = reportBuilder.generateReports();
    }
}
