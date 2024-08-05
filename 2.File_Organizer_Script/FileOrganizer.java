import java.io.File;
import java.io.IOException;

public class FileOrganizer {
    public static void main(String[] args) {
        // Specified the directory to organize
        String directoryPath = "C:\\Users\\vicky\\OneDrive\\Desktop\\Fusiontech\\2.File_Organizer_Script\\directory";

        // Calling the method to organize files
        organizeFiles(directoryPath);
    }

    public static void organizeFiles(String directoryPath) {
        File directory = new File(directoryPath);

        // Checking if the directory exists
        if (!directory.exists()) {
            System.out.println("The specified directory does not exist.");
            return;
        }

        // Checking if it's a directory
        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        // Processing files in the directory
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    // Organizing the file based on its type
                    organizeFile(file, directoryPath);
                }
            }
        }
    }

    public static void organizeFile(File file, String directoryPath) {
        // Get the file extension
        String fileName = file.getName();
        String fileExtension = "";

        int i = fileName.lastIndexOf('.');
        if (i > 0) {
            fileExtension = fileName.substring(i + 1);
        }

        // Defining the subdirectory name based on the file extension
        String subdirectoryName = "";
        switch (fileExtension.toLowerCase()) {
            case "txt":
                subdirectoryName = "TextFiles";
                break;
            case "jpg":
            case "jpeg":
            case "png":
                subdirectoryName = "Images";
                break;
            case "pdf":
                subdirectoryName = "PDFs";
                break;
            // Add more cases as needed
            default:
                subdirectoryName = "Others";
                break;
        }

        // Create the subdirectory if it doesn't exist
        File subdirectory = new File(directoryPath + File.separator + subdirectoryName);
        if (!subdirectory.exists()) {
            subdirectory.mkdir();
        }

        // Move the file to the subdirectory
        File newFile = new File(subdirectory.getPath() + File.separator + file.getName());
        if (file.renameTo(newFile)) {
            System.out.println("Moved " + file.getName() + " to " + subdirectoryName + " folder.");
        } else {
            System.out.println("Failed to move " + file.getName() + ".");
        }
    }
}
