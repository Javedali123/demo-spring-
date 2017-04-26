package blog.services;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

public interface NotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
