import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class CommandeLine {

    private String command;
    private String path;
    private File fr;

    private Scanner sc;


    public CommandeLine(String command) {
        this.command = command;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the path: ");
        this.path = sc.nextLine();

        createFile();
    }

    public CommandeLine(String command, String path) {
        this.command = command;
        this.path = path;

       createFile();
    }

    public void createFile() {
        try {
            fr = new File(path);
        } catch (NullPointerException e) {
            throw new NullPointerException("Path is null");
        }
    }


    public void execute() {
        if(command.equals("ls"))
        {
            try {
                File[] files= fr.listFiles();
                for(File f: files)
                    System.out.println(f.getName()+" "+fileType(f) + " " + filePrevelages(f));

            } catch (NullPointerException e) {
                System.out.println("Path is null");
                throw new NullPointerException("File not found");
            }
        }
    }

    public String fileType(File fr) {
        if(fr.isDirectory())
            return "<DIR>";
        else
            return "<FILE>";
    }

    public String filePrevelages(File fr) {
        if(fr.canRead() && fr.canWrite() && fr.canExecute())
            return "rwx";
        else if(fr.canRead() && fr.canWrite())
            return "rw-";
        else if(fr.canRead() && fr.canExecute())
            return "r-x";
        else if(fr.canWrite() && fr.canExecute())
            return "-wx";
        else if(fr.canRead())
            return "r--";
        else if(fr.canWrite())
            return "-w-";
        else if(fr.canExecute())
            return "--x";
        else
            return "---";
    }
}
