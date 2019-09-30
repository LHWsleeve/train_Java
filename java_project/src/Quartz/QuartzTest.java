package Quartz;
import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * quarta学习
 */
public class QuartzTest {

  public void run() throws Exception {


    // 1.创建 scheduler的工厂
    SchedulerFactory sf = new StdSchedulerFactory();
    //2.从工厂中获取调度器
    Scheduler sched = sf.getScheduler();

    System.out.println("------- Initialization Complete -----------");



    //3，创建jobDetail
    JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();
    //时间
    Date runTime = evenSecondDateAfterNow();

    // 4.触发器
    Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

    // 5.注册任务和触发器
    sched.scheduleJob(job, trigger);
    System.out.println(job.getKey() + " will run at: " + runTime);

    // 启动
    sched.start();

    try {
      // 5秒后停止
      Thread.sleep(5L * 1000L);
      // executing...
    } catch (Exception e) {
      //
    }

    // shut down the scheduler
    sched.shutdown(true);
  }

  public static void main(String[] args) throws Exception {

    QuartzTest example = new QuartzTest();
    example.run();

  }

}
