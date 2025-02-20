package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberOutputView implements DrawNumberView{

    private DrawNumberController controller;
  
    @Override
    public void setController(final DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
       
    }

    @Override
    public void result(DrawResult res) {
  
        System.out.println("Draw result: " + res);
    }

    
}
