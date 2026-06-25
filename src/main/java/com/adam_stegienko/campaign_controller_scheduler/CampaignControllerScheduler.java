package com.adam_stegienko.campaign_controller_scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CampaignControllerScheduler {

  public static void main(String[] args) {
    SpringApplication.run(CampaignControllerScheduler.class, args);
  }

}
