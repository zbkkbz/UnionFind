/**
 * @author ZBK
 * @date 2019/7/30 - 0:04
 */

/**
 * @program: UnionFind
 *
 * @description: UnionFind implement by array VersionV1
 *
 * @author: Zbk
 *
 * @create: 2019-07-30 00:04
 **/
public class UnionFind1 implements UF {

    //存放每个数据所属集合的编号
    private int[] id;

    public UnionFind1(int size){

        //先放入元素,不涉及合并操作
        //之后实现unionEmlement,用户调用这个接口才进行合并
        id = new int[size];

        for (int i=0;i<id.length;i++)
            //每个元素对应的集合编号都不一样
            //第0个元素对应集合编号0,第一个元素对应集合编号1,第二个对于2,一次类推
            //这样就表示每一个元素所属不同集合,没有任何两个元素相连
            id[i] = i;

    }

    @Override
    public int getSize(){
        return id.length;
    }

    //查找元素对应的集合编号--时间复杂度O(1)
    private int find(int p){
        if (p<0||p>=id.length)
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }

    //查看元素q,p是否属于同一个集合---由于find是O(1),所以isConnected也是O(1)
    @Override
    public boolean isConnected(int p,int q){
        return find(p)==find(q);
    }


    @Override
    public void unionElements(int p ,int q){
        int pID = find(p);
        int qID = find(q);

        //如果本身pId和qId相等,那么他们本身就是相连的了
        if (pID==qID)
            return;

        //如果pid和qid本身不相等,那么改为相等
        for (int i=0;i<id.length;i++)
            if (id[i]==pID)
                id[i]=qID;
    }
}
