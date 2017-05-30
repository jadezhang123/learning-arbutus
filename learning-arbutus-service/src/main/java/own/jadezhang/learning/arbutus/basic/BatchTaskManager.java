package own.jadezhang.learning.arbutus.basic;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import own.jadezhang.learning.arbutus.domain.auth.AuthUser;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Zhang Junwei on 2017/5/27.
 */
public class BatchTaskManager implements IScheduleTaskDealSingle<AuthUser> {
    @Override
    public boolean execute(AuthUser authUser, String s) throws Exception {
        System.out.println("################execute.....");
        return true;
    }

    @Override
    public List<AuthUser> selectTasks(String s, String s1, int i, List<TaskItemDefine> list, int i1) throws Exception {
        ArrayList<AuthUser> authUsers = new ArrayList<>();
        authUsers.add(new AuthUser());
        return authUsers;
    }

    @Override
    public Comparator<AuthUser> getComparator() {
        return new Comparator<AuthUser>() {
            @Override
            public int compare(AuthUser o1, AuthUser o2) {
                return o1.getId().compareTo(o2.getId());
            }
        };
    }
}
