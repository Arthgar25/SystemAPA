package com.example.systemapa.View;
import javafx.scene.control.Button;

public abstract class QuickButton extends Button {
    public QuickButton(String icon) {
        super(icon);
        this.setOnAction((e) -> addAction());
    }
    protected abstract void addAction();
}
