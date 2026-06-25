package com.adam_stegienko.campaign_controller_scheduler;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.adam_stegienko.campaign_controller_scheduler.services.CcApiRestClient;
import com.adam_stegienko.campaign_controller_scheduler.services.GoogleAdsApiClient;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yaml")
class CampaignControllerSchedulerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CcApiRestClient ccApiRestClient;

    @MockBean
    private GoogleAdsApiClient googleAdsApiClient;

    @MockBean
    private RabbitTemplate rabbitTemplate;

    @BeforeEach
    void setup() {
        Mockito.when(ccApiRestClient.getPlannerBooks()).thenReturn(List.of());
        Mockito.when(googleAdsApiClient.getCampaignStatus(Mockito.anyString())).thenReturn(List.of());
    }

    @Test
    void shouldReturnCampaignControllerApp() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk());
    }
}
