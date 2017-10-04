package com.yueserver.enity.noenity;

public class UserSkin {

    private int skin_one;
    private int skin_two;
    private int skin_three;
    private int skin_four;
    private int skin_five;
    private int skin_six;
    private int skin_seven;
    private int skin_eight;

    public int getSkin_one() {
        return skin_one;
    }

    public void setSkin_one(int skin_one) {
        this.skin_one = skin_one;
    }

    public int getSkin_two() {
        return skin_two;
    }

    public void setSkin_two(int skin_two) {
        this.skin_two = skin_two;
    }

    public int getSkin_three() {
        return skin_three;
    }

    public void setSkin_three(int skin_three) {
        this.skin_three = skin_three;
    }

    public int getSkin_four() {
        return skin_four;
    }

    public void setSkin_four(int skin_four) {
        this.skin_four = skin_four;
    }

    public int getSkin_five() {
        return skin_five;
    }

    public void setSkin_five(int skin_five) {
        this.skin_five = skin_five;
    }

    public int getSkin_six() {
        return skin_six;
    }

    public void setSkin_six(int skin_six) {
        this.skin_six = skin_six;
    }

    public int getSkin_seven() {
        return skin_seven;
    }

    public void setSkin_seven(int skin_seven) {
        this.skin_seven = skin_seven;
    }

    public int getSkin_eight() {
        return skin_eight;
    }

    public void setSkin_eight(int skin_eight) {
        this.skin_eight = skin_eight;
    }

    public int SkinNumbers() {
        int numbers = 0;
        if (skin_one == 1)
            numbers ++;
        if (skin_two == 1)
            numbers ++;
        if (skin_three == 1)
            numbers ++;
        if (skin_four == 1)
            numbers ++;
        if (skin_five == 1)
            numbers ++;
        if (skin_six == 1)
            numbers ++;
        if (skin_seven == 1)
            numbers ++;
        if (skin_eight == 1)
            numbers ++;
        return numbers;
    }

    @Override
    public String toString() {
        return "UserSkin{" +
                "skin_one=" + skin_one +
                ", skin_two=" + skin_two +
                ", skin_three=" + skin_three +
                ", skin_four=" + skin_four +
                ", skin_five=" + skin_five +
                ", skin_six=" + skin_six +
                ", skin_seven=" + skin_seven +
                ", skin_eight=" + skin_eight +
                '}';
    }
}
