import io.restassured.response.Response;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MockitoExample {
    public static void main(String[] args){
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
        System.out.println(mockedList.size());

        LinkedList mockedLinkedList = mock(LinkedList.class);
        when(mockedLinkedList.get(0)).thenReturn("first");
//        when(mockedLinkedList.get(anyInt())).thenReturn("element");
        System.out.println(mockedLinkedList.get(0));
        System.out.println(mockedLinkedList.get(999)); //Will return null
    }
}
