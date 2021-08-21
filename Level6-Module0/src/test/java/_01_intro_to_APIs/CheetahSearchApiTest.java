package _01_intro_to_APIs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import _01_intro_to_APIs.data_transfer_objects.Result;
import reactor.core.publisher.Mono;

class CheetahSearchApiTest {

    CheetahSearchApi cheetahSearchApi;

    @Mock
    WebClient webClientMock;

    @SuppressWarnings("rawtypes")
    @Mock
    WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @SuppressWarnings("rawtypes")
    @Mock
    WebClient.RequestHeadersSpec requestHeadersSpecMock;

    @Mock
    WebClient.ResponseSpec responseSpecMock;

    @Mock
    Mono<Result[]> resultMonoMock;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        cheetahSearchApi = new CheetahSearchApi();
        cheetahSearchApi.setWebClient(webClientMock);
    }

    @SuppressWarnings("unchecked")
    @Test
    void itShouldGetBookByTopic() {
        //given
        String topic = "Cows";

        Result result = new Result();
        Result[] expectedResults = {result};

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Result[].class))
                .thenReturn(resultMonoMock);
        when(resultMonoMock.block())
                .thenReturn(expectedResults);

        //when
        Result[] actualResults = cheetahSearchApi.getBookByTopic(topic);

        //then
        verify(webClientMock, times(1)).get();
        assertEquals(expectedResults, actualResults);
    }

    @SuppressWarnings("unchecked")
    @Test
    void itShouldFindBook() {
        //given
        String topic = "Cows";
        String bookTitle = "Rise of the Ruminants";
        String bookLink = "www.cowtruth.com";

        Result result = new Result();
        result.setTitle(bookTitle);
        result.setLink(bookLink);
        Result[] expectedResults = {result};

        when(webClientMock.get())
                .thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri((Function<UriBuilder, URI>) any()))
                .thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve())
                .thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(Result[].class))
                .thenReturn(resultMonoMock);
        when(resultMonoMock.block())
                .thenReturn(expectedResults);

        String expectedBook =
                bookTitle + " -\n"
                        + bookLink;
        //when
        String actualBook = cheetahSearchApi.findBook(topic);

        //then
        verify(webClientMock, times(1)).get();
        assertEquals(expectedBook, actualBook);
    }

}