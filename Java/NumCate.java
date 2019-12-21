public class NumCate {
    private Integer cate[] = new Integer[11];
    public NumCate() {
        for(int i=0;i<11;i++) {
            cate[i] = 0;
        }
    }
    public void Diver(int n) {
        this.cate[n/10]++;
    }
    public void Print() {
        for(int elem : this.cate) {
            System.out.println(elem);
        }
    }
    public static void main(String args[]) {
        NumCate numcate = new NumCate();
        numcate.Diver(62);
        numcate.Print();
    }
}