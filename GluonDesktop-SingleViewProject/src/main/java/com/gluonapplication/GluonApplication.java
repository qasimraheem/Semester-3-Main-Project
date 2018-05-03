package com.gluonapplication;

import com.gluonhq.particle.application.ParticleApplication;
import javafx.scene.Scene;
import static org.controlsfx.control.action.ActionMap.actions;

public class GluonApplication extends ParticleApplication {

    public GluonApplication() {
        super("Gluon Desktop Application");
    }

    @Override
    public void postInit(Scene scene) {
        scene.getStylesheets().add(GluonApplication.class.getResource("style.css").toExternalForm());

        setTitle("Gluon Desktop Application");

        getParticle().buildMenu("File -> [signin,---, exit]", "Help -> [about]");
        
        getParticle().getToolBarActions().addAll(actions("signin"));
    }
}