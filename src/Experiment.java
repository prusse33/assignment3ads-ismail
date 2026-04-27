import java.util.Arrays;

public class Experiment {

    private Sorter sorter;
    private Searcher searcher;

    public Experiment() {
        sorter=new Sorter();
        searcher=new Searcher();
    }

    public long measureSortTime(int[] arr,String type) {

        int[] copy=Arrays.copyOf(arr,arr.length);

        long start=System.nanoTime();

        if(type.equals("selection"))
            sorter.basicSort(copy);
        else
            sorter.advancedSort(copy);

        long end=System.nanoTime();

        return end-start;
    }

    public long measureSearchTime(int[] arr,int target) {

        long start=System.nanoTime();

        searcher.search(arr,target);

        long end=System.nanoTime();

        return end-start;
    }

    public void runAllExperiments() {

        int[] sizes={10,100,1000};

        for(int size:sizes) {

            int[] arr=sorter.generateRandomArray(size);

            sorter.advancedSort(arr);

            int target=arr[size/2];

            System.out.println("Size: "+size);

            System.out.println(
                    "Selection Sort: "
                            +measureSortTime(arr,"selection")
                            +" ns");

            System.out.println(
                    "Quick Sort: "
                            +measureSortTime(arr,"quick")
                            +" ns");

            System.out.println(
                    "Binary Search: "
                            +measureSearchTime(arr,target)
                            +" ns");

            System.out.println();
        }
    }
}