package com.stuxnet.education.elevenplusexam.ui;

import com.stuxnet.education.elevenplusexam.builders.MenuBarBuilderMain;
import com.stuxnet.education.elevenplusexam.component.ElevenPlusMenuBar;
import com.stuxnet.education.elevenplusexam.constants.ElevenPlusExamConstants;
import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;


import java.util.function.Function;

/**
 * Created by pankajpardasani on 21/05/2017.
 */

@SpringUI(path = "/student/add")
@Theme("valo")
public class StudentRegistrationUI extends UI {
    private final Function<String, TextField> textField = label -> new TextField(label);
    private final Function<String, TextArea> textArea = label -> new TextArea(label);
    private final Function<String, ListSelect> listSelect = label -> new ListSelect(label);

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        VerticalLayout mainContainer = getMainPanelWindow();

        mainContainer.addComponent(new ElevenPlusMenuBar());
        mainContainer.addComponent(getStudentRegistrationForm());
        mainContainer.setSizeFull();

        this.setContent(mainContainer);
    }

    private FormLayout getStudentRegistrationForm() {
        FormLayout studentFormLayout = new FormLayout();

        //ID, Name, Address, year of study, target schools, area of interest (mock exams, classes general, maths sessions, English sessions, VR sessions, special classes), parents workshop, current school address, special needs, ethenicity

        TextField studName = textField.apply("Student Name");
        studName.setIcon(VaadinIcons.USER);
        studName.setRequiredIndicatorVisible(true);
        studName.setMaxLength(100);
        studName.setPlaceholder("Student full name");

        TextArea address = textArea.apply("Address");
        address.setIcon(VaadinIcons.ROAD);

        TextField yos = textField.apply("Year of study");
        yos.setIcon(VaadinIcons.TROPHY);

        ListSelect ts = listSelect.apply("Target schools");
        Notification.show(ts.getSelectedItems().size() + " items.");

        studentFormLayout.addComponents(studName, address, yos, ts);

        return studentFormLayout;
    }

    private VerticalLayout getMainPanelWindow() {
        VerticalLayout mainwindow = new VerticalLayout();
        mainwindow.addStyleName("mypanelexample");
        mainwindow.setSizeUndefined();

        return mainwindow;
    }
}
