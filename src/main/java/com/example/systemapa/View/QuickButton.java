package com.example.systemapa.View;
import javafx.scene.control.Button;

public abstract class QuickButton extends Button {
    public QuickButton(String icon) {
        super(icon);
        this.setStyle("-fx-background-color: #333333; -fx-text-fill: #ffffff; -fx-cursor: hand; -fx-background-radius: 4px;");
        this.setOnAction((e) -> addAction());
    }
    protected abstract void addAction();
}
