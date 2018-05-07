package gaoyanshan.operator;

import gaoyanshan.bean.FileData;
import gaoyanshan.jsonBean.Entity2json;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Connect extends  BaseOperator{
    @Override
    public String exe(String cmdBody) throws Exception {
        String json = null;
        List<FileData> fileDataList = new ArrayList<FileData>();
        File file=new File(cmdBody);
        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);
        FileSystemView sys = FileSystemView.getFileSystemView();
        File[] files = sys.getRoots();
        files = File.listRoots();
        for(File mfile:files){
            if(mfile.isHidden()==true){
                FileData fileData=new FileData();
                fileData.setFilename(mfile.getName());
                fileData.setFilePath(mfile.getCanonicalPath());
                fileData.setParentPath(mfile.getParent());
                fileData.setLevel(mfile.getCanonicalPath().split("\\\\").length);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//给时间格式，例如：2018-03-16 09:50:23
                fileData.setFileModifileDate(dateFormat.format(new Date(mfile.lastModified())));//取得文件最后修改时间，并按格式转为字符串
                if(!mfile.isDirectory())
                {
                    fileData.setFileSizeStr(formatSize(mfile));
                    fileData.setIsDirectory(0);
                }
                else{
                    fileData.setFileSizeStr(0+"");
                    fileData.setIsDirectory(1);
                }
                fileDataList.add(fileData);
            }
            else{

            }
        }
        json=new Entity2json().beanListToJSONStr(fileDataList);
        System.out.println(json);
        return "{ \"FileData\": "+json+"}";
    }

    private String formatSize(File mfile) {

        String  fileDatum=mfile.length()+"";
        double KB = 1024.0;
        double MB = KB * 1024.0;
        double GB = MB * 1024.0;
        if (Double.parseDouble(fileDatum) > GB) {
            return String.format("%.3fGB", Double.parseDouble(fileDatum)/GB);
        } else if (Double.parseDouble(fileDatum) > MB) {
            return String.format("%.2fMB", Double.parseDouble(fileDatum)/MB);
        } else if (Double.parseDouble(fileDatum) > KB) {
            return String.format("%.1fKB", Double.parseDouble(fileDatum)/KB);
        } else
            return String.format("%.4fK",Double.parseDouble(fileDatum));
    }
}
