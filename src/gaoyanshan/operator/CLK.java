package gaoyanshan.operator;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CLK extends BaseOperator {
    private Robot robot;
    @Override
    public String exe(String cmdBody) throws Exception {
        robot=new Robot();
        switch (cmdBody)
        {
            case "left": //鼠标左键按下再释放
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.delay(100);
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                break;
            case "right"://鼠标右键按下再释放
                robot.mousePress(KeyEvent.BUTTON3_MASK);
                robot.delay(100);
                robot.mouseRelease(KeyEvent.BUTTON3_MASK);
                break;
            case "left_press": //鼠标左键按下，不释放，配合mov或者mva指令可实现拖动
                robot.mousePress(KeyEvent.BUTTON1_MASK);
                robot.delay(100);
                break;
            case "left_release"://鼠标左键释放，clk:left_press配合其他指令操作后，需要调用clk:left_release释放
                robot.mouseRelease(KeyEvent.BUTTON1_MASK);
                robot.delay(100);
                break;
            case "right_press":  //鼠标右键按下，不释放
                robot.mousePress(KeyEvent.BUTTON3_MASK);
                robot.delay(100);
                break;
            case "right_release": //鼠标右键释放
                robot.mouseRelease(KeyEvent.BUTTON3_MASK);
                robot.delay(100);
                break;
        }
        return "clk";
    }
}
