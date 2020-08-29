package util;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.Notifications;
import com.intellij.openapi.ui.MessageType;

public class NotifyUtil {

    public static void doNotify(String title,String content){
        NotificationGroup notificationGroup = new NotificationGroup(title, NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(content, MessageType.INFO);
        Notifications.Bus.notify(notification);
    }
}
