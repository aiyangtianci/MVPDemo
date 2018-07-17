package com.example.mvpdemo.utils.builder_design;

/**
 * Created by aiyang on 2018/7/16.
 */

public class MacbookBuilder extends Builder {
    private Computer mComputer;

    public MacbookBuilder() {
    }

    public MacbookBuilder(Computer mComputer) {
        this.mComputer = mComputer;
    }

    @Override
    public void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    public void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    public void buildOS() {
        mComputer.setOS();
    }

    @Override
    public Computer create() {
        return mComputer;
    }

    //链式简化版

    public MacbookBuilder setBoard(String board) {
        mComputer.setBoard(board);
        return this;
    }
    public MacbookBuilder setDisplay(String display) {
        mComputer.setDisplay(display);
        return this;
    }

    public MacbookBuilder setColor(String color){
        mComputer.setmColor(color);
        return this;
    }

    public MacbookBuilder setBuildOS(){
        mComputer.setOS();
        return this;
    }

}
