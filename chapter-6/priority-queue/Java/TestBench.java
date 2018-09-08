public class TestBench {
    public static Event[] initEventArray(int length) {
        Event[] array = new Event[length];
        for (int i = 0; i < length; i++) {
            array[i] = new Event(i);
        }
        return array;
    }

    public static PriorityQueue initPriorityQueue(Event[] array) {
        return new PriorityQueue(array);
    }

    public static void testGetMax(PriorityQueue priorityQueue) {
        System.out.println("Testing getMaximum()...");
        System.out.println("Queue: " + priorityQueue.toString());         
        System.out.println("Max: " + priorityQueue.getMaximum().toString());
        System.out.println();
    }

    public static void testExtractMax(PriorityQueue priorityQueue) {
        System.out.println("Testing extractMaximum()...");
        System.out.println("Original Queue: " + priorityQueue.toString());
        System.out.println("Extracting max...");
        priorityQueue.extractMaximum();
        System.out.println("New Queue: " + priorityQueue.toString());
        System.out.println();
    }

    public static void testIncreaseKey(PriorityQueue priorityQueue) {
        System.out.println("Testing increaseKey()...");
        System.out.println("Original Queue: " + priorityQueue.toString());
        System.out.println("increasingKey(heapSize - 1)...");
        priorityQueue.increaseKey(priorityQueue.getHeapSize() - 1, 10);
        System.out.println("New Queue: " + priorityQueue.toString());
        System.out.println();
    }

    public static void testInsert(PriorityQueue priorityQueue) {
        System.out.println("Testing insert()...");
        System.out.println("Original Queue: " + priorityQueue.toString());
        System.out.println("inserting event with key 11...");
        priorityQueue.insert(new Event(11));
        System.out.println("New Queue: " + priorityQueue.toString());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Initializing eventArray...");
        Event[] eventArray = initEventArray(10);
        System.out.println("Instantiating priorityQueue...");
        PriorityQueue priorityQueue = new PriorityQueue(eventArray);
        
        System.out.println("Testing begins...");
        System.out.println();
        testGetMax(priorityQueue);
        testExtractMax(priorityQueue);
        testIncreaseKey(priorityQueue);
        testInsert(priorityQueue);
        System.out.println("Testing finished.");
    }
}
