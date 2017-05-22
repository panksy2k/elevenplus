package com.stuxnet.education.elevenplusexam.component;

import com.stuxnet.education.elevenplusexam.builders.MenuBarBuilderMain;
import com.stuxnet.education.elevenplusexam.constants.ElevenPlusExamConstants;
import com.vaadin.ui.VerticalLayout;

import static com.stuxnet.education.elevenplusexam.constants.ElevenPlusExamEnum.PERFORMANCE;
import static com.stuxnet.education.elevenplusexam.constants.ElevenPlusExamEnum.STUDENT;

/**
 * Created by pankajpardasani on 21/05/2017.
 */
public class ElevenPlusMenuBar extends VerticalLayout {

    private static MenuBarBuilderMain elevenPlusMenuBarBuilder;

    static {
        elevenPlusMenuBarBuilder =
                new MenuBarBuilderMain.MenuBarBuilder()
                        .addMenuItem(STUDENT)
                        .addMenuItem(PERFORMANCE)
                        .addMenuSubItem(STUDENT, ElevenPlusExamConstants.STUDENT_ADD_NEW)
                        .addMenuSubItem(STUDENT, ElevenPlusExamConstants.STUDENT_CHANGE_DETAILS)
                        .addMenuSubItem(STUDENT, ElevenPlusExamConstants.STUDENT_SEARCH)
                        .build();
    }

    public ElevenPlusMenuBar() {
        setWidth("100%");
        //setWidth(100, Unit.PERCENTAGE);

        addComponent(elevenPlusMenuBarBuilder.getVaadinMenuBar());
    }
}
