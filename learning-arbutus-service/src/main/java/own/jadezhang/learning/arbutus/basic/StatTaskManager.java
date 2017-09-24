package own.jadezhang.learning.arbutus.basic;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Zhang Junwei on 2017/5/31.
 */
public class StatTaskManager implements IScheduleTaskDealSingle<String> {
    private static final Logger logger = LoggerFactory.getLogger(StatTaskManager.class);
    /**
     * 执行单个任务
     * @param s Object
     * @param ownSign 当前环境名称
     * @throws Exception
     */
    @Override
    public boolean execute(String s, String ownSign) throws Exception {
        logger.debug("#############execute "+s);
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
    @Override
    public List<String> selectTasks(String taskParameter, String ownSign, int taskQueueNum, List<TaskItemDefine> taskQueueList, int eachFetchDataNum) throws Exception {
        List<String> tasks= new ArrayList<String>();
        for (TaskItemDefine taskItemDefine : taskQueueList) {
            tasks.add("itemId:"+taskItemDefine.getTaskItemId()+" parameter:"+taskItemDefine.getParameter());
        }
        logger.info("task size: {}",tasks.size());
        return tasks;
    }

    @Override
    public Comparator<String> getComparator() {
        return null;
    }
}
