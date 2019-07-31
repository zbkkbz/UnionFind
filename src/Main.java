import java.util.Random;

public class Main {


    private static double testUF(UF uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i=0;i<m;i++){
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime-startTime)/1000000000.0;
    }


    public static void main(String[] args) {
        // write your code here

        int size = 10000000;//千万级别
        int m = 10000000;//千万级别
/*
        UnionFind1 unionFind1 = new UnionFind1(size);
        System.out.println("UnionFind1"+testUF(unionFind1, m));

        UnionFind2 unionFind2 = new UnionFind2(size);
        System.out.println("UnionFind2"+testUF(unionFind2, m));
*/

        UnionFind3 unionFind3 = new UnionFind3(size);
        System.out.println("UnionFind3"+testUF(unionFind3, m));

        UnionFind4 unionFind4 = new UnionFind4(size);
        System.out.println("UnionFind4"+testUF(unionFind4, m));

        UnionFind5 unionFind5 = new UnionFind5(size);
        System.out.println("UnionFind5"+testUF(unionFind5, m));

        UnionFind6 unionFind6 = new UnionFind6(size);
        System.out.println("UnionFind6"+testUF(unionFind6, m));

    }
}