package com.tyler.adapter;

/**
 * @author ：Tyler Zhang
 * @date ：Created in 2020-02-14 20:27
 */
public class NoteBooke {
    private ThreePlugIn plug;

    public NoteBooke(ThreePlugIn plug) {
        this.plug = plug;
    }

    //使用插座充电
    public void charge(){
        plug.powerOfThree();
    }

    public static void main(String[] args) {

        GBTwoPlug twoPlug = new GBTwoPlug();
        ThreePlugIn threePlug = new TwoPlugAdapter(twoPlug);
        NoteBooke noteBooke = new NoteBooke(threePlug);
        noteBooke.charge();

        ThreePlugIn threePlug2 = new TwoPlugAdapterByExtends();
        NoteBooke noteBooke2 = new NoteBooke(threePlug2);
        noteBooke2.charge();
    }
}
