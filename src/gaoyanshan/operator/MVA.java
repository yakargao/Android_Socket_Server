package gaoyanshan.operator;

import java.awt.*;

public class MVA extends BaseOperator{
    private Robot robot;
    @Override
    public String exe(String cmdBody) throws Exception {
        robot=new Robot();
        String[] pointXY=cmdBody.split(",");
        int x=0,y=0;
        float a=Float.parseFloat(pointXY[0]);
        float b=Float.parseFloat(pointXY[1]);
        if(a<=1 && b<=1){
            x= (int) (Toolkit.getDefaultToolkit().getScreenSize().width*a);
            y= (int) (Toolkit.getDefaultToolkit().getScreenSize().height*b);
        }
        else {
            x= (int) a;
            y= (int) b;
        }
        robot.mouseMove(x,y);
        return "mva";
    }
}
