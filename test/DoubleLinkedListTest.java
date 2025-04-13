import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

    SoftAssertions softly = new SoftAssertions();

    @Test
    public void put() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.put(1);
        list.put(2);

        softly.assertThat(list.size()).isEqualTo(2);
        softly.assertThat(list.contains(1)).isTrue();
        softly.assertThat(list.contains(2)).isTrue();
        softly.assertThat(list.contains(3)).isFalse();

        softly.assertThat(list.head.data).isEqualTo(1);
        softly.assertThat(list.head.next.data).isEqualTo(2);
        softly.assertAll();
    }

    @Test
    public void remove() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        list.put(1);
        list.put(2);
        list.put(3);

        list.remove();

        softly.assertThat(list.size()).isEqualTo(2);
        softly.assertThat(list.contains(1)).isFalse();
        softly.assertThat(list.contains(2)).isTrue();

        list.remove();

        softly.assertThat(list.size()).isEqualTo(1);
        softly.assertThat(list.contains(2)).isFalse();
        softly.assertThat(list.contains(3)).isTrue();

        list.remove();

        softly.assertThat(list.size()).isEqualTo(0);
        softly.assertThat(list.isEmpty()).isTrue();
        softly.assertThat(list.contains(3)).isFalse();
    }

}