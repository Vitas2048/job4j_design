package ru.job4j.ood.dip.report;

import java.util.ArrayList;
import java.util.List;

public class Reports {
    private final List<Report> reports = new ArrayList<>();

    public static void main(String[] args) {
        Report bug = new ReportBug();
        Report log = new ReportLog();
        Reports reports1 = new Reports();
        reports1.add(bug);
        reports1.add(log);
        reports1.add(bug);
        reports1.add(log);
        for (Report report : reports1.get()) {
            report.report();
        }
    }

    public void add(Report report) {
        reports.add(report);
    }

    public List<Report> get() {
        return new ArrayList<>(reports);
    }

}

