package com.example.franky.resume_editor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.franky.resume_editor.module_class.BasicInfo;
import com.example.franky.resume_editor.module_class.DateUtils;
import com.example.franky.resume_editor.module_class.Education;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity {

    private BasicInfo basicInfo;
    private Education education;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fakeData();
        setupUI();
    }

    private void setupUI() {
        setContentView(R.layout.activity_main);

        setupBasicInfoUI();
        setupEducationUI();
    }

    private void setupBasicInfoUI() {
        ((TextView) findViewById(R.id.name)).setText(basicInfo.name);
        ((TextView) findViewById(R.id.email)).setText(basicInfo.email);
    }

    private void setupEducationUI() {
        ((TextView) findViewById(R.id.education_school)).setText(
                education.school + "(" + DateUtils.dateToString(education.startDate) + " ~ " +
                        DateUtils.dateToString(education.endDate));
        ((TextView) findViewById(R.id.education_courses)).setText(formatItems(education.courses));
    }

    private void fakeData() {
        basicInfo = new BasicInfo();
        basicInfo.name = "Ningning Ding";
        basicInfo.email = "dingnn001@gmail.com";

        education = new Education();
        education.school = "Cornell University";
        education.major = "Electrical and Computer Engineering";
        education.startDate = DateUtils.stringToDate("08/2013");
        education.endDate = DateUtils.stringToDate("05/2014");
        education.courses = new ArrayList<>();
        education.courses.add("Database");
        education.courses.add("Algorithms");
        education.courses.add("Networks");
    }

    public static String formatItems(List<String> items) {
        StringBuilder sb = new StringBuilder();
        for (String item: items) {
            sb.append(' ').append('-').append(' ').append(item).append('\n');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

}
