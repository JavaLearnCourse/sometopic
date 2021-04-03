package lesson1;

import java.io.File;
import java.io.FilenameFilter;


public class DemoFile {

    public static void main(String[] args) {
        File f = new File("b.txt");
        System.out.println("Absolute Path " + f.getAbsolutePath());
        System.out.println("Relative Path " + f.getPath());
        System.out.println("Total Space " + f.getTotalSpace());
        System.out.println("Usable Space " + f.getUsableSpace());
        f.delete();


        File catalog = new File("./");
        FilenameFilter filter = new Filter(".png");
        String [] fileList = catalog.list(filter);
        for (String s: fileList){
            System.out.println(s);
        }



    }
}

class Filter implements FilenameFilter {

   private String suffix;

    public Filter(String suffix){
        this.suffix = suffix;
    }
    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(suffix);
    }
}
