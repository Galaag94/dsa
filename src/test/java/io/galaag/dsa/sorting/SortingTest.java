package io.galaag.dsa.sorting;

import org.apache.commons.logging.LogFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SortingTest {

    private static final Logger LOG = LoggerFactory.getLogger(SortingTest.class);

    private Sorting sorting;

    @BeforeEach
    public void init() {
        sorting = new Sorting();
    }

    @ParameterizedTest(name = "Should sort array of integers using insertion sort algorithm")
    @MethodSource("providerInsertionSort")
    void testInsertionSort(int[] arrayToSort, boolean descendingOrder, Comparator<Integer> comparator) {
        var actualResult = sorting.insertionSort(arrayToSort, descendingOrder);
        LOG.info("Sorted array: {}", actualResult);

        assertThat(actualResult).isSortedAccordingTo(comparator);
    }

    private static Stream<Arguments> providerInsertionSort() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, false, Comparator.naturalOrder()),
                Arguments.of(new int[]{2, 4, 5, 6, 8}, false, Comparator.naturalOrder()),
                Arguments.of(new int[]{1}, false, Comparator.naturalOrder()),
                Arguments.of(new int[] {2, 3, 5 ,7 , 8 }, true, Comparator.reverseOrder())
        );
    }
}