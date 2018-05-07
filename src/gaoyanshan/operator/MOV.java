package gaoyanshan.operator;

import java.awt.*;

public class MOV extends BaseOperator {
    private Robot robot;
    @Override
    public String exe(String cmdBody) throws Exception {

        robot=new Robot();
        String[] pointXY=cmdBody.split(",");
        int x=Integer.parseInt(pointXY[0]);
        int y=Integer.parseInt(pointXY[1]);
        Point point =MouseInfo.getPointerInfo().getLocation();
        robot.mouseMove(point.x+x,point.y+y);
        return "mov";
    }
}
