package com.stuxnet.education.elevenplusexam.builders;

import com.stuxnet.education.elevenplusexam.constants.ElevenPlusExamEnum;

import java.util.Optional;

/**
 * Created by pankajpardasani on 21/05/2017.
 */
public class MenuBarBuilderMain {

    private com.vaadin.ui.MenuBar menuBar;

    private MenuBarBuilderMain(MenuBarBuilder builder) {
        menuBar = builder.menubar;
    }

    public com.vaadin.ui.MenuBar getVaadinMenuBar() {
        return this.menuBar;
    }

    public static class MenuBarBuilder {
        private final com.vaadin.ui.MenuBar menubar;

        public MenuBarBuilder() {
            menubar = new com.vaadin.ui.MenuBar();
        }

        public MenuBarBuilder addMenuItem(ElevenPlusExamEnum caption) {
            this.menubar.addItem(caption.toString(), null);

            return this;
        }

        public MenuBarBuilder addMenuSubItem(ElevenPlusExamEnum parentItemName, String subItemCaption) {
            Optional<com.vaadin.ui.MenuBar.MenuItem> parentMenuItem = this.menubar.getItems().stream()
                    .filter(item -> item.getText().equalsIgnoreCase(parentItemName.toString())).findFirst();
            parentMenuItem.ifPresent(item -> item.addItem(subItemCaption.toString(), null));

            return this;
        }

        public MenuBarBuilderMain build() {
            return new MenuBarBuilderMain(this);
        }
    }
}
