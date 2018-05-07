package gaoyanshan.operator;


import java.awt.*;
import java.io.File;

public class Open extends BaseOperator{

    @Override
    public String exe(String cmdBody) throws Exception {
        Desktop desktop = Desktop.getDesktop();
        File file=new File(cmdBody);
        desktop.open(file);
        return "open\n";
    }

}
