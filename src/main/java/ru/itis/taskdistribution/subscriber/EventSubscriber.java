package ru.itis.taskdistribution.subscriber;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.itis.taskdistribution.services.DistributionService;

@Component
public class EventSubscriber {

    @Scheduled(fixedDelay = 10000)
    public void updateInformationFromManagerAndDistributeTask() {
        DistributionService service = new DistributionService();
    //    UpdateInformationCommand command = new UpdateInformationCommand();
       // service.distributeTasks();
    }

}
