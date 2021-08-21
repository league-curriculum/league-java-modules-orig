package _03_intro_to_authenticated_APIs;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import _03_intro_to_authenticated_APIs.data_transfer_objects.ApiExampleWrapper;


class NewsApiTest {

    NewsApi newsApi;

    @BeforeEach
    void setUp() {
        newsApi = new NewsApi();
    }

    @Test
    void itShouldGetNewsStoryByTopic() {
        //given
        String topic = "olympics";      // Legit topic; should work
        String topicFalse = "";         // Invalid topic; should throw exception

        //when
        ApiExampleWrapper data = newsApi.getNewsStoryByTopic(topic);
        
        //then
        assertTrue(data != null);
        
        try {
            newsApi.getNewsStoryByTopic(topicFalse);
            
            // Should not get here
            assertTrue(false);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void itShouldFindStory(){
        //given
        String topic = "olympics";

        //when
        String story = newsApi.findStory(topic);

        //then
        //System.out.println(story);
        assertTrue(story.toLowerCase().contains(topic.toLowerCase()));
    }
}
