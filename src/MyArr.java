public class MyArr {
    private int[] arr;
    private int size;

    public MyArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

//    public boolean binaryFind(int value){
//        int low = 0;
//        int high = this.size - 1;
//        int mid;
//        while (low <= high) {
//            mid = (low + high) / 2;
//            if (value == this.arr[mid]) {
//                return true;
//            } else {
//                if (value < this.arr[mid]) {
//                    high = mid - 1;
//                } else {
//                    low = mid + 1;
//                }
//            }
//        }
//        return false;
//    }

    public int binaryFind(int search) {
        return recBinaryFind(search, 0, size-1);
    }

    private int recBinaryFind(int searchKey, int low, int high) {
        int curIn;
        curIn = (low + high ) / 2;
        if (arr[curIn] == searchKey)
            return curIn;
        else {
            if (low > high)
                throw new ArithmeticException("Binary search error");
            else {
                if (arr[curIn] < searchKey)
                    return recBinaryFind(searchKey, curIn + 1, high);
                else
                    return recBinaryFind(searchKey, low, curIn - 1);
            }
        }
    }


    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.arr[i]);
        }
    }

    public void delete(int value){
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i] == value) {
                break;
            }
        }

        for (int j = i; j < this.size - 1; j++){
            this.arr[j] = this.arr[j + 1];
        }
        this.size--;
    }

    public void insert(int value){
        int i;
        for(i = 0; i < this.size; i++) {
            if (this.arr[i]>value) {
                break;
            }
        }
        for (int j = this.size; j > i; j--){
            this.arr[j] = this.arr[j-1];
        }
        this.arr[i] = value;
        this.size++;
    }
}
