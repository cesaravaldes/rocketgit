package com.rocketgit;

import javafx.application.Platform;
import javafx.event.ActionEvent;

public class MainController {

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
