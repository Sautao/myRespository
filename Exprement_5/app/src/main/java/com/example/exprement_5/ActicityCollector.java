package com.example.exprement_5;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

class ActicityCollector {
    private static List<Activity> activities = new ArrayList<>();

    static void addActivity(Activity activity) {
        activities.add(activity);
    }

    static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    static void finshAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                //遍历activitys集合结束所有activity
                activity.finish();
            }
        }
        //移除集合
        activities.clear();
    }
}
