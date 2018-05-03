package com.gluonapplication.view;

import com.gluonhq.particle.annotation.ParticleView;
import com.gluonhq.particle.state.StateManager;
import com.gluonhq.particle.view.View;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javax.inject.Inject;

@ParticleView(name = "basic", isDefault = true)
public class BasicView implements View {
    
    @Inject private StateManager stateManager;

    private final VBox controls = new VBox(15);
    private Button button;

    @Override
    public void init() {
        Label label = new Label("Hello JavaFX World!");

        button = new Button();
        button.setOnAction(e -> label.setText("Hello JavaFX Universe!"));
        
        controls.getChildren().addAll(label, button);
        controls.setAlignment(Pos.CENTER);

        stateManager.setPersistenceMode(StateManager.PersistenceMode.USER);
        addUser(stateManager.getProperty("UserName").orElse("").toString());
    }

    @Override
    public Node getContent() {
        return controls;
    }
    
    public void addUser(String userName) {
        button.setText(userName.isEmpty() ? "Change the World!" : userName + ", change the World!");
        stateManager.setProperty("UserName", userName);
    }

}
