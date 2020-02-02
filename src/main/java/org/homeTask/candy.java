package org.homeTask;

public class candy implements sweets {
   String candyName;
  int candyweight;

    public String getCandyName() {
        return candyName;
    }

    public void setCandyName(String candyName) {
        this.candyName = candyName;
    }

    public int getCandyquan() {
        return candyquan;
    }

    public void setCandyquan(int candyquan) {
        this.candyquan = candyquan;
    }

    int candyquan;

    @Override
    public int getWeight() {
        return candyweight;
    }

    @Override
    public void setWeight(int x) {
        this.candyweight=x;
    }
}
