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
    /**
     * 执行单个任务
     * @param authUser Object
     * @param ownSign 当前环境名称
     * @throws Exception
     */
    @Override
    public boolean execute(AuthUser authUser, String ownSign) throws Exception {
        System.out.println("################execute.....");
        return true;
    }

    /**
     * 根据条件，查询当前调度服务器可处理的任务
     * @param taskParameter 任务的自定义参数
     * @param ownSign 当前环境名称
     * @param taskQueueNum 当前任务类型的任务队列数量
     * @param taskQueueList 当前调度服务器，分配到的可处理队列
     * @param eachFetchDataNum 每次获取数据的数量
     * @return
     * @throws Exception
     */
    public List<AuthUser> selectTasks(String taskParameter,String ownSign,int taskQueueNum,List<TaskItemDefine> taskQueueList,int eachFetchDataNum) throws Exception{
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
