package org.homeTask;

public class chocolate implements sweets {
    String chocolateName;
    int chocweight;
     int chocquan;
    public int getChocquan() {
        return chocquan;
    }

    public void setChocquan(int chocquan) {
        this.chocquan = chocquan;
    }

    public String getChocolateName(){
        return chocolateName;
    }
    public void setChocolateName(String chocname){
        this.chocolateName=chocname;
    }
    @Override
    public int getWeight(){
        return chocweight;
    }
    @Override
    public void setWeight(int chocweight)
    {
        this.chocweight=chocweight;
    }
}
