package com.example.demo.common.thread;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 判断所有线程是否执行结束
 *
 * @author fangjiulin
 * @date 2024/1/17 23:30
 */
public class CheckAllThreadIsDone {
    public static boolean checkAllThreadIsDone(List<Future<String>> list) {
        int done = 0;
        int taskSize = list.size();
        while (done < taskSize) {
            done = 0;
            for (Future<String> t : list) {
                if (isdone(t)) {
                    done++;
                    continue;
                }
            }
        }
        return true;
    }

    private static Boolean isdone(Future t) {
        if (t == null || t.isCancelled() || t.isDone()) {
            return true;
        }
        return false;
    }

}
