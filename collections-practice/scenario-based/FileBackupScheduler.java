import java.util.PriorityQueue;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String message) {
        super(message);
    }
}

class BackupTask implements Comparable<BackupTask> {

    private String folderPath;
    private int priority; 

    public BackupTask(String folderPath, int priority) throws InvalidBackupPathException {
        if (folderPath == null || folderPath.isEmpty()) {
            throw new InvalidBackupPathException("Backup path cannot be empty");
        }
        this.folderPath = folderPath;
        this.priority = priority;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BackupTask other) {
        return Integer.compare(other.priority, this.priority);
    }

    public void execute() {
        System.out.println("📂 Backing up folder: " + folderPath +
                " | Priority: " + priority);
    }
}

public class FileBackupScheduler {

    public static void main(String[] args) {
        PriorityQueue<BackupTask> backupQueue = new PriorityQueue<>();

        try {
            backupQueue.add(new BackupTask("/system/config", 5));  
            backupQueue.add(new BackupTask("/user/documents", 3));
            backupQueue.add(new BackupTask("/downloads", 1));
            backupQueue.add(new BackupTask("", 4));

        } catch (InvalidBackupPathException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nExecuting backup tasks (by priority):");

        while (!backupQueue.isEmpty()) {
            BackupTask task = backupQueue.poll();
            task.execute();
        }
    }
}